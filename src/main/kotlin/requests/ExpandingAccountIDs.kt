package requests

import VStats
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.utils.io.*
import kotlinx.coroutines.*
import structures.Match
import structures.Player
import java.io.*
import kotlin.math.min

object ExpandingAccountIDs {
    private val queuedIDS = mutableListOf<String>()
    private val playerFolder = File("players")

    init
    {
    	playerFolder.mkdir()
        queuedIDS.add("ZXsH9z7aN9DvRpFf4blWQ9iJTtQvtXkXjP4-WyIFJSRZbtiS1ULd7Pz9ZpFp8-QTfS8xm-wg52rxrg")
        queuedIDS.addAll(playerFolder.list()?.toList() ?: listOf())
    }

    operator fun invoke() {
        for (i in 0..min(5, queuedIDS.size-1))
        {
            val puuid = queuedIDS.removeAt(0)
            CoroutineScope(Dispatchers.IO).launch {
                try
                {
                    makeRequest(puuid)
                }
                catch (e: Exception)
                {
                    println(e.message)
                    if (e.message == "Error: 429")
                    {
                        queuedIDS.add(puuid)
                        return@launch
                    }
                    queuedIDS.add(puuid)
                }
            }
        }
    }

    private suspend fun makeRequest(puuid: String) {
        val r1 = VStats.client.request(
            "https://europe.api.riotgames" +
                    ".com/lol/match/v5/matches/by-puuid/$puuid/ids?start=0&count=5"
        ) {
            header("X-Riot-Token", VStats.key)
        }
        if (r1.status.value != 200)
            throw Exception("Error: ${r1.status.value}")
        val matchIds = r1.body<Array<String>>()
        for (matchId in matchIds) {
            val r2 = VStats.client.request("https://europe.api.riotgames.com/lol/match/v5/matches/$matchId") {
                header("X-Riot-Token", VStats.key)
            }
            if (r2.status.value != 200)
                throw Exception("Error: ${r2.status.value}")
            val match = r2.body<Match>()
            for (participant in match.info.participants)
            {
                if (playerFolder.list()?.contains(participant.puuid) == true)
                {
                    val ois = ObjectInputStream(FileInputStream(File(playerFolder, participant.puuid)))
                    val p: Player = withContext(Dispatchers.IO) {
                        ois.readUnshared()
                    } as Player
                    if (p.summonerName != participant.summonerName)
                    {
                        p.previousNames.add(p.summonerName)
                        p.summonerName = participant.summonerName
                        save(p)
                    }
                    continue
                }
                val p = Player()
                p.puuid = participant.puuid
                p.summonerName = participant.summonerName
                save(p)
                queuedIDS.add(participant.puuid)
            }
        }

    }

    private fun save(player: Player)
    {
        CoroutineScope(Dispatchers.Default).launch {
            val oos = withContext(Dispatchers.IO) {
                ObjectOutputStream(FileOutputStream(File(playerFolder, player.puuid)))
            }
            withContext(Dispatchers.IO) {
                oos.writeUnshared(player)
            }
        }
    }
}
package requests

import VStats
import io.ktor.client.call.*
import io.ktor.client.request.*

object ExpandingAccountIDs {
    private val queuedIDS = mutableListOf<String>()

    operator fun invoke() {

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

        }

    }
}
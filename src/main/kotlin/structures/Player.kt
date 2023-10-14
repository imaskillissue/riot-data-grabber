package structures

import java.io.Serializable

class Player: Serializable {
	var puuid = ""
	var summonerName = ""
	var previousNames = mutableListOf<String>()
}
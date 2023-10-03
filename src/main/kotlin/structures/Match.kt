package structures

class Match {
    class Metadata {
        var dataVersion = ""
        var matchId = ""
        var participants = mutableListOf<String>()
    }

    class Info {
        var gameCreation = 0L
        var gameDuration = 0L
        var gameId = 0L
        var gameMode = ""
        var gameName = ""
        var gameStartTimestamp = 0L
        var gameType = ""
        var gameVersion = ""
        var mapId = 0L
        var participants = mutableListOf<Participant>()
        var platformId = ""
        var queueId = 0L
        var teams = mutableListOf<Team>()
    }

    class Participant {
        var allInPings = 0
        var assistMePings = 0
        var assists = 0
    }
}
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
        var gameEndTimestamp = 0L
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
        var tournamentCode = ""
    }

    class Ban {
        var championId = 0
        var pickTurn = 0
    }

    class ObjectiveInfo {
        var first = false
        var kills = 0
    }

    class Team {
        var bans = listOf<Ban>()
        var objectives = mapOf<String, ObjectiveInfo>()
        var teamId = 0
        var win = false
    }

    class PerkInfo {
        var startPerk = mapOf<String, Int>()
        var styles = mapOf<String, Any>()
    }

    class Participant {
        var allInPings = 0
        var assistMePings = 0
        var assists = 0
        var baitPings = 0
        var baronKills = 0
        var basicPings = 0
        var bountyLevel = 0
        var challenges = mapOf<String, Float>()
        var champExperience = 0
        var champLevel = 0
        var championId = 0
        var championName = ""
        var championTransform = 0
        var commandPings = 0
        var consumablesPurchased = 0
        var damageDealtToBuildings = 0
        var damageDealtToObjectives = 0
        var damageDealtToTurrets = 0
        var damageSelfMitigated = 0
        var dangerPings = 0
        var deaths = 0
        var detectorWardsPlaced = 0
        var doubleKills = 0
        var dragonKills = 0
        var eligibleForProgression = false
        var enemyMissingPings = 0
        var enemyVisionPings = 0
        var firstBloodAssist = false
        var firstBloodKill = false
        var firstTowerAssist = false
        var firstTowerKill = false
        var gameEndedInEarlySurrender = false
        var gameEndedInSurrender = false
        var getBackPings = 0
        var goldEarned = 0
        var goldSpent = 0
        var holdPings = 0
        var individualPosition = ""
        var inhibitorKills = 0
        var inhibitorTakedowns = 0
        var inhibitorsLost = 0
        var item0 = 0
        var item1 = 0
        var item2 = 0
        var item3 = 0
        var item4 = 0
        var item5 = 0
        var item6 = 0
        var itemsPurchased = 0
        var killingSprees = 0
        var kills = 0
        var lane = ""
        var largestCriticalStrike = 0
        var largestKillingSpree = 0
        var largestMultiKill = 0
        var longestTimeSpentLiving = 0
        var magicDamageDealt = 0
        var magicDamageDealtToChampions = 0
        var magicDamageTaken = 0
        var needVisionPings = 0
        var neutralMinionsKilled = 0
        var nexusKills = 0
        var nexusLost = 0
        var nexusTakedowns = 0
        var objectivesStolen = 0
        var objectivesStolenAssists = 0
        var onMyWayPings = 0
        var participantId = 0
        var pentaKills = 0
        var perks: Map<String, Any> = mapOf()
        var physicalDamageDealt = 0
        var physicalDamageDealtToChampions = 0
        var physicalDamageTaken = 0
        var placement = 0
        var playerAugment1 = 0
        var playerAugment2 = 0
        var playerAugment3 = 0
        var playerAugment4 = 0
        var playerSubteamId = 0
        var profileIcon = 0
        var pushPings = 0
        var puuid = ""
        var quadraKills = 0
        var riotIdName = ""
        var riotIdTagline = ""
        var role = ""
        var sightWardsBoughtInGame = 0
        var spell1Casts = 0
        var spell2Casts = 0
        var spell3Casts = 0
        var spell4Casts = 0
        var subteamPlacement = 0
        var summoner1Casts = 0
        var summoner1Id = 0
        var summoner2Casts = 0
        var summoner2Id = 0
        var summonerId = ""
        var summonerLevel = 0
        var summonerName = ""
        var teamEarlySurrendered = false
        var teamId = 0
        var teamPosition = ""
        var timeCCingOthers = 0
        var timePlayed = 0
        var totalAllyJungleMinionsKilled = 0
        var totalDamageDealt = 0
        var totalDamageDealtToChampions = 0
        var totalDamageShieldedOnTeammates = 0
        var totalDamageTaken = 0
        var totalEnemyJungleMinionsKilled = 0
        var totalHeal = 0
        var totalHealsOnTeammates = 0
        var totalMinionsKilled = 0
        var totalTimeCCDealt = 0
        var totalTimeSpentDead = 0
        var totalUnitsHealed = 0
        var tripleKills = 0
        var trueDamageDealt = 0
        var trueDamageDealtToChampions = 0
        var trueDamageTaken = 0
        var turretKills = 0
        var turretTakedowns = 0
        var turretsLost = 0
        var unrealKills = 0
        var visionClearedPings = 0
        var visionScore = 0
        var visionWardsBoughtInGame = 0
        var wardsKilled = 0
        var wardsPlaced = 0
        var win = false
    }

    var metadata: Match.Metadata = Metadata()
    var info = Info()
}
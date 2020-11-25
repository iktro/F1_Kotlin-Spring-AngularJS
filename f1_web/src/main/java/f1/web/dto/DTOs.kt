package f1.web.dto

import f1.core.entities.Pilot
import f1.core.entities.Season
import f1.core.entities.Team
import f1.core.entities.Track

data class PilotDTO(
        var firstName: String,
        var lastName: String,
        var team: Team,
        var isRetired: Boolean = false,
        var championshipTitle: Int = 0
)

data class TeamDTO(
        var name: String,
        var championshipTitle: Int = 0
)

data class SeasonDTO(
        var year: Long,
        var isOver: Boolean = false,
        var numberOfRaces: Int = 0
)

data class ChampionshipDTO(
        var team: Team,
        var pilot: Pilot,
        var season: Season,
        var track: Track,
        var pointScored: Int = 0
)

data class TrackDTO(
        var name: String,
        var countryCode: String, //TODO improve this
        var distance: Double,
        var lapsRequired: Int
)
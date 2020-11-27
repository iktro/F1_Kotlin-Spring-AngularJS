package f1.web.dto

import f1.core.entities.Pilot
import f1.core.entities.Season
import f1.core.entities.Team
import f1.core.entities.Track

data class PilotDTO(
        var firstName: String = "",
        var lastName: String = "",
        var team: Team? = null,
        var isRetired: Boolean = false,
        var championshipTitle: Int = 0
)

data class TeamDTO(
        var name: String = "",
        var championshipTitle: Int = 0
)

data class SeasonDTO(
        var year: Long = 1950,
        var isOver: Boolean = false,
        var numberOfRaces: Int = 0
)

data class ChampionshipDTO(
        var team: Team? = null,
        var pilot: Pilot? = null,
        var season: Season? = null,
        var track: Track? = null,
        var pointScored: Int = 0
)

data class TrackDTO(
        var name: String = "",
        var countryCode: String = "", //TODO improve this
        var distance: Double = .0,
        var lapsRequired: Int = 60
)
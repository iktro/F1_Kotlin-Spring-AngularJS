package f1.core.entities

import javax.persistence.*

@Entity
data class Pilot(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
        var firstName: String,
        var lastName: String,
        @OneToOne var team: Team,
        var isRetired: Boolean = false,
        var championshipTitle: Int = 0
)

@Entity
data class Team(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long?,
        var name: String,
        var championshipTitle: Int = 0
)

@Entity
data class Season(
        @Id var year: Long,
        var isOver: Boolean = false,
        var numberOfRaces: Int = 0
)

@Entity
data class Championship(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long?,
        @OneToOne var team: Team,
        @OneToOne var pilot: Pilot,
        @OneToOne var season: Season,
        @OneToOne var track: Track,
        var pointScored: Int = 0
)

@Entity
data class Track(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long?,
        var name: String,
        var countryCode: String, //TODO improve this
        var distance: Double,
        var lapsRequired: Int
)
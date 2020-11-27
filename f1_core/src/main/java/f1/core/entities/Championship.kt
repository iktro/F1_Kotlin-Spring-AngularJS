package f1.core.entities

import javax.persistence.*

@Entity
data class Championship(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long?,
        @OneToOne var team: Team,
        @OneToOne var pilot: Pilot,
        @OneToOne var season: Season,
        @OneToOne var track: Track,
        var pointScored: Int = 0
)
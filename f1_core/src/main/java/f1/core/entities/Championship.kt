package f1.core.entities

import javax.persistence.*

@Entity
data class Championship(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
        @OneToOne var team: Team? = null,
        @OneToOne var pilot: Pilot? = null,
        @OneToOne var season: Season? = null,
        @OneToOne var track: Track? = null,
        var pointScored: Int = 0
)
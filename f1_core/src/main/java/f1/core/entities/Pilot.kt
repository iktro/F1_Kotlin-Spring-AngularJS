package f1.core.entities

import javax.persistence.*

@Entity
data class Pilot(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
        var firstName: String,
        var lastName: String,
        @OneToOne var team: Team,
        var isRetired: Boolean = false,
        var championshipTitle: Int = 0
)
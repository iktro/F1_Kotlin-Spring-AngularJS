package f1.core.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Team(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
        var name: String = "",
        var championshipTitle: Int = 0
)
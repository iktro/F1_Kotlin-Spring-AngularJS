package f1.core.entities

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Season(
        @Id val year: Long,
        var isOver: Boolean = false,
        var numberOfRaces: Int = 0
)
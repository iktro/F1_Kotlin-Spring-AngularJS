package f1.core.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Track(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
        var name: String = "",
        var countryCode: String = "",
        var distance: Double = 0.0,
        var lapsRequired: Int = 50
)
package f1.core.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Track(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long?,
        var name: String,
        var countryCode: String,
        var distance: Double,
        var lapsRequired: Int
)
package f1.core.dao

import f1.core.entities.Pilot
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PilotDAO : JpaRepository<Pilot, Long> {

    @Query
    fun findAllByRetiredIsFalse(): List<Pilot>
}
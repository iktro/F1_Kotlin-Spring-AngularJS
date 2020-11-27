package f1.core.dao

import f1.core.entities.Pilot
import org.springframework.data.jpa.repository.JpaRepository

interface PilotDAO : JpaRepository<Pilot, Long> {

    fun findAllByIsRetiredTrue(): List<Pilot>

    fun findAllByIsRetiredFalse(): List<Pilot>
}
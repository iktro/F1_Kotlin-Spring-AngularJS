package f1.core.service

import f1.core.dao.PilotDAO
import f1.core.entities.Pilot
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
open class PilotService(private var pilotDAO: PilotDAO) {

    fun findAll(): List<Pilot> = pilotDAO.findAll()

    fun findAllCurrentPilots(): List<Pilot> = pilotDAO.findAllByIsRetiredFalse()

    fun findAllRetiredPilots(): List<Pilot> = pilotDAO.findAllByIsRetiredTrue()

    fun save(pilot: Pilot) = pilotDAO.save(pilot)

    fun findOneByID(pilotId: Long): Optional<Pilot> = pilotDAO.findById(pilotId)

    fun deleteAll() = pilotDAO.deleteAll()

    fun deleteOneById(id: Long) = pilotDAO.deleteById(id)

}
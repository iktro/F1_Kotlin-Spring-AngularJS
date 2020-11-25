package f1.core.service

import f1.core.dao.PilotDAO
import f1.core.entities.Pilot
import org.springframework.stereotype.Service

@Service
class PilotService(private val pilotDAO: PilotDAO) {

    fun findAll(): List<Pilot> = pilotDAO.findAll()

    fun findAllCurrentPilots(): List<Pilot> = pilotDAO.findAllByRetiredIsFalse()

    fun savePilot(pilot: Pilot) = pilotDAO.save(pilot)

    fun count(): Long = pilotDAO.count()

    fun deleteAll() = pilotDAO.deleteAll()

    fun deleteOneById(id: Long) = pilotDAO.deleteById(id)

}
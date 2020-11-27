package f1.core.service

import f1.core.dao.ChampionshipDAO
import f1.core.entities.Championship
import f1.core.entities.Pilot
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
open class ChampionshipService(private var championshipDAO: ChampionshipDAO) {

    fun findAll(): List<Championship> = championshipDAO.findAll()

    fun findAllBySeason(seasonYear: Int): List<Pilot> = championshipDAO.findAllPilotsInSeason(seasonYear)

    fun findPilotScoreBySeason(seasonYear: Int, pilotId: Int) = championshipDAO.findAllPilotsScoreInChampionship(seasonYear, pilotId)

    fun save(championship: Championship): Championship = championshipDAO.save(championship)

    fun count(): Long = championshipDAO.count()

    fun deleteAll() = championshipDAO.deleteAll()

    fun deleteOneById(id: Long) = championshipDAO.deleteById(id)
}
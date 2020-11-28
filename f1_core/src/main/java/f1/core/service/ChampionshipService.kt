package f1.core.service

import f1.core.dao.ChampionshipDAO
import f1.core.entities.Championship
import f1.core.entities.Pilot
import f1.core.entities.Team
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
open class ChampionshipService(private var championshipDAO: ChampionshipDAO) {

    fun findAllPilotsInSeason(season: Long): List<Pilot> =
            championshipDAO.findAllPilotsInSeason(season)

    fun getPilotScoreForSeason(season: Long, pilot: Pilot) =
            championshipDAO.getPilotScoreForSeason(season, pilot)

    fun getPilotTeamForSeason(season: Long, pilot: Pilot): Team =
            championshipDAO.getPilotTeamForSeason(season, pilot)[0]

    fun findAllTeamsInSeason(season: Long): List<Team> =
            championshipDAO.findAllTeamsInSeason(season)

    fun getTeamScoreForSeason(season: Long, team: Team) =
            championshipDAO.getTeamScoreForSeason(season, team)

    fun getTracksDuringSeason(season: Long) =
            championshipDAO.getTracksDuringSeason(season)

    fun findPilotsForARace(season: Long, trackId: Long): List<Championship> =
            championshipDAO.findPilotScoreForARace(season, trackId)

    fun save(championship: Championship): Championship =
            championshipDAO.save(championship)

    fun deleteAll() = championshipDAO.deleteAll()

    fun deleteOneById(id: Long) = championshipDAO.deleteById(id)
}
package f1.core.service

import f1.core.dao.TeamDAO
import f1.core.entities.Team

class TeamService(private val teamDAO: TeamDAO) {

    fun findAll(): List<Team> = teamDAO.findAll()

    fun saveTeam(team: Team) = teamDAO.save(team)

    fun count(): Long = teamDAO.count()

    fun deleteAll() = teamDAO.deleteAll()

    fun deleteOneById(id: Long) = teamDAO.deleteById(id)
}
package f1.core.service

import f1.core.dao.TeamDAO
import f1.core.entities.Team
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
open class TeamService(private var teamDAO: TeamDAO) {

    fun findAll(): List<Team> = teamDAO.findAll()

    fun save(team: Team) = teamDAO.save(team)

    fun count(): Long = teamDAO.count()

    fun deleteAll() = teamDAO.deleteAll()

    fun deleteOneById(id: Long) = teamDAO.deleteById(id)
}
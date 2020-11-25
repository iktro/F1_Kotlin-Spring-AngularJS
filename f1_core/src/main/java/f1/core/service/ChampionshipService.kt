package f1.core.service

import f1.core.dao.ChampionshipDAO
import f1.core.entities.Championship

class ChampionshipService(private val championshipDAO: ChampionshipDAO) {

    fun findAll(): List<Championship> = championshipDAO.findAll()

    fun saveChampionship(championship: Championship) = championshipDAO.save(championship)

    fun count(): Long = championshipDAO.count()

    fun deleteAll() = championshipDAO.deleteAll()

    fun deleteOneById(id: Long) = championshipDAO.deleteById(id)
}
package f1.core.service

import f1.core.dao.SeasonDAO
import f1.core.entities.Season

class SeasonService(private val seasonDAO: SeasonDAO) {

    fun findAll(): List<Season> = seasonDAO.findAll()

    fun saveTeam(season: Season) = seasonDAO.save(season)

    fun count(): Long = seasonDAO.count()

    fun deleteAll() = seasonDAO.deleteAll()

    fun deleteOneById(id: Long) = seasonDAO.deleteById(id)

}
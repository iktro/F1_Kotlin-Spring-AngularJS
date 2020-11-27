package f1.core.service

import f1.core.dao.SeasonDAO
import f1.core.entities.Season
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
open class SeasonService(private var seasonDAO: SeasonDAO) {

    fun findAll(): List<Season> = seasonDAO.findAll()

    fun save(season: Season) = seasonDAO.save(season)

    fun count(): Long = seasonDAO.count()

    fun deleteAll() = seasonDAO.deleteAll()

    fun deleteOneById(id: Long) = seasonDAO.deleteById(id)

}
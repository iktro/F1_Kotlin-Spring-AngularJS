package f1.core.service

import f1.core.dao.TrackDAO
import f1.core.entities.Track
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
open class TrackService(private var trackDAO: TrackDAO) {

    fun findAll(): List<Track> = trackDAO.findAll()

    fun save(track: Track) = trackDAO.save(track)

    fun count(): Long = trackDAO.count()

    fun deleteAll() = trackDAO.deleteAll()

    fun deleteOneById(id: Long) = trackDAO.deleteById(id)

}
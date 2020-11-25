package f1.core.service

import f1.core.dao.TrackDAO
import f1.core.entities.Track

class TrackService(private val trackDAO: TrackDAO) {

    fun findAll(): List<Track> = trackDAO.findAll()

    fun saveTrack(track: Track) = trackDAO.save(track)

    fun count(): Long = trackDAO.count()

    fun deleteAll() = trackDAO.deleteAll()

    fun deleteOneById(id: Long) = trackDAO.deleteById(id)

}
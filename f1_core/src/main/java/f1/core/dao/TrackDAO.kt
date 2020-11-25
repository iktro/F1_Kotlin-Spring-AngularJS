package f1.core.dao

import f1.core.entities.Track
import org.springframework.data.jpa.repository.JpaRepository

interface TrackDAO : JpaRepository<Track, Long>
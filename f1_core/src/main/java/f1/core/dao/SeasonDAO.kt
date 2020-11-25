package f1.core.dao

import f1.core.entities.Season
import org.springframework.data.jpa.repository.JpaRepository

interface SeasonDAO : JpaRepository<Season, Long>
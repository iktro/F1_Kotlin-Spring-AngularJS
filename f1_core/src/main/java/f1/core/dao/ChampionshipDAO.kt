package f1.core.dao

import f1.core.entities.Championship
import org.springframework.data.jpa.repository.JpaRepository

interface ChampionshipDAO : JpaRepository<Championship, Long>
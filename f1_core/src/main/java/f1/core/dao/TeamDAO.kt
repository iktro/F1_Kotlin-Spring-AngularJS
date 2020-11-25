package f1.core.dao

import f1.core.entities.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamDAO : JpaRepository<Team, Long>
package f1.core.dao

import f1.core.entities.Championship
import f1.core.entities.Pilot
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ChampionshipDAO : JpaRepository<Championship, Long> {

    @Query("SELECT distinct c.pilot FROM Championship c WHERE c.season = :year")
    fun findAllPilotsInSeason(@Param("year") year: Int): List<Pilot>

    @Query("SELECT SUM(result.pointScored) FROM Championship result WHERE result.season=:year and result.pilot.id=:pilotId")
    fun findAllPilotsScoreInChampionship(@Param("year") year: Int, @Param("pilotId") pilotId: Int): Int

    @Query("SELECT distinct c.pilot FROM Championship c WHERE c.season =:year and c.track = :trackId")
    fun findPilotScoreForARace(@Param("year") season: Int, @Param("trackId") trackId: Int): List<Championship>

}
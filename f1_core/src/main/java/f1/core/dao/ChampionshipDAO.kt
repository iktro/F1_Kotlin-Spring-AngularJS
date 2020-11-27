package f1.core.dao

import f1.core.entities.Championship
import f1.core.entities.Pilot
import f1.core.entities.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ChampionshipDAO : JpaRepository<Championship, Long> {

    @Query("select distinct c.pilot FROM Championship c " +
            " Where c.season = (select s from Season s WHERE s.year = :year)")
    fun findAllPilotsInSeason(@Param("year") year: Long): List<Pilot>

    @Query("select SUM(c.pointScored) FROM Championship c " +
            "where c.pilot = :pilot and c.season = (select s from Season s WHERE s.year = :year)")
    fun getPilotScoreForSeason(@Param("year") season: Long, @Param("pilot") pilot: Pilot): Int

    @Query("select distinct c.team FROM Championship c " +
            " Where c.season = (select s from Season s WHERE s.year = :year)")
    fun findAllTeamsInSeason(@Param("year") year: Long): List<Team>

    @Query("select SUM(c.pointScored) FROM Championship c " +
            "where c.team = :team and c.season = (select s from Season s WHERE s.year = :year)")
    fun getTeamScoreForSeason(@Param("year") season: Long, @Param("team") team: Team): Int

}
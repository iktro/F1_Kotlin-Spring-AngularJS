package f1.core.dao

import f1.core.entities.Championship
import f1.core.entities.Pilot
import f1.core.entities.Team
import f1.core.entities.Track
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

    @Query("select c.team FROM Championship c " +
            "where c.pilot = :pilot and c.season = (select s from Season s WHERE s.year = :year)")
    fun getPilotTeamForSeason(@Param("year") season: Long, @Param("pilot") pilot: Pilot): List<Team>

    @Query("select distinct c.team FROM Championship c " +
            " Where c.season = (select s from Season s WHERE s.year = :year)")
    fun findAllTeamsInSeason(@Param("year") year: Long): List<Team>

    @Query("select SUM(c.pointScored) FROM Championship c " +
            "where c.team = :team and c.season = (select s from Season s WHERE s.year = :year)")
    fun getTeamScoreForSeason(@Param("year") season: Long, @Param("team") team: Team): Int

    @Query("select distinct c.track FROM Championship c " +
            " WHERE c.season = (select s from Season s WHERE s.year = :year)")
    fun getTracksDuringSeason(@Param("year") season: Long): List<Track>

    @Query("select c FROM Championship c " +
            "WHERE c.season = (select s from Season s WHERE s.year = :year) " +
            "and c.track = (select t from Track t where t.id = :track)")
    fun findPilotScoreForARace(@Param("year") season: Long, @Param("track") trackId: Long): List<Championship>

}
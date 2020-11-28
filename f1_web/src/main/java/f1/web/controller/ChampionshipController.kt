package f1.web.controller

import f1.core.entities.Championship
import f1.core.entities.Track
import f1.core.service.ChampionshipService
import f1.web.dto.ChampionshipDTO
import org.springframework.stereotype.Controller
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import kotlin.streams.toList

@Controller
@Path("/championship")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class ChampionshipController(private val championshipService: ChampionshipService) : RestController {

    @GET
    @Path("/pilots/{year}")
    fun getAllPilotsPointsInSeason(@PathParam("year") season: Long): List<ChampionshipDTO> {
        val pilots = championshipService.findAllPilotsInSeason(season)
        val currentChampDTO = mutableListOf<ChampionshipDTO>()
        for (pilot in pilots) {
            currentChampDTO += ChampionshipDTO(
                    team = championshipService.getPilotTeamForSeason(season, pilot),
                    pilot = pilot,
                    pointScored = championshipService.getPilotScoreForSeason(season, pilot)
            )
        }
        currentChampDTO.sortBy { it.pointScored }
        currentChampDTO.reverse()
        return currentChampDTO
    }

    @GET
    @Path("/teams/{year}")
    fun getAllTeamsPointsInSeason(@PathParam("year") season: Long): List<ChampionshipDTO> {
        val teams = championshipService.findAllTeamsInSeason(season)
        val currentChampDTO = mutableListOf<ChampionshipDTO>()
        for (team in teams) {
            currentChampDTO += ChampionshipDTO(team = team, pointScored = championshipService.getTeamScoreForSeason(season, team))
        }
        currentChampDTO.sortBy { it.pointScored }
        currentChampDTO.reverse()
        return currentChampDTO
    }

    @GET
    @Path("/tracks/{year}")
    fun getResultsForARace(@PathParam("year") season: Long): List<Track> =
            championshipService.getTracksDuringSeason(season)

    @GET
    @Path("/tracksResult/{year}/{trackId}")
    fun getResultsForARace(@PathParam("year") season: Long,
                           @PathParam("trackId") trackId: Long): List<ChampionshipDTO> =
            championshipService.findPilotsForARace(season, trackId)
                    .stream().map(this::championshipToDTO).toList().reversed()

    private fun championshipToDTO(championship: Championship): ChampionshipDTO {
        val championshipDTO = ChampionshipDTO()
        championshipDTO.pilot = championship.pilot
        championshipDTO.pointScored = championship.pointScored
        championshipDTO.season = championship.season
        championshipDTO.team = championship.team
        championshipDTO.track = championship.track
        return championshipDTO
    }

}
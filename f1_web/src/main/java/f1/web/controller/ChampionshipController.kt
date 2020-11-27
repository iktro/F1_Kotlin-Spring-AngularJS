package f1.web.controller

import f1.core.service.ChampionshipService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/championship")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class ChampionshipController(private val championshipService: ChampionshipService) : RestController {

    @GET
    @Path("/season/{year}")
    fun getAllPilotsInSeason(@PathParam("year") season: Int) {
        championshipService.findAllBySeason(season)
    }

    @GET
    @Path("season/{year}/{id}")
    fun getPilotScoreInSeason(@PathParam("year") season: Int,
                              @PathParam("id") pilotId: Int) =
            championshipService.findPilotScoreBySeason(season, pilotId)


}
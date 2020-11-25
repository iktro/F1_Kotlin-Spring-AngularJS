package f1.web.controller

import f1.core.service.ChampionshipService
import javax.ws.rs.Consumes
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/championship")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class ChampionshipController(private val championshipService: ChampionshipService) : RestController {
}
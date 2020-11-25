package f1.web.controller

import f1.core.service.SeasonService
import javax.ws.rs.Consumes
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/season")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class SeasonController(private val seasonService: SeasonService) : RestController {


}
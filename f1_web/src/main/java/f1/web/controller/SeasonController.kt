package f1.web.controller

import f1.core.entities.Season
import f1.core.service.SeasonService
import f1.web.dto.SeasonDTO
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import kotlin.streams.toList

@Path("/seasons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class SeasonController(private val seasonService: SeasonService) : RestController {

    @GET
    @Path("/list")
    fun getAllSeasons() = seasonService.findAll().stream().map(this::seasonToDTO).toList()

    private fun seasonToDTO(season: Season): SeasonDTO {
        val seasonDTO = SeasonDTO()
        seasonDTO.year = season.year
        seasonDTO.numberOfRaces = season.numberOfRaces
        seasonDTO.isOver = season.isOver
        return seasonDTO
    }
}
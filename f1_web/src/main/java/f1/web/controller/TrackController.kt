package f1.web.controller

import f1.core.entities.Track
import f1.core.service.TrackService
import f1.web.dto.TrackDTO
import org.springframework.stereotype.Controller
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import kotlin.streams.toList

@Controller
@Path("/track")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class TrackController(private val trackService: TrackService) : RestController {

    @GET
    @Path("/list")
    fun getAllTeams() = trackService.findAll().stream().map(this::trackToDTO).toList()

    private fun trackToDTO(track: Track): TrackDTO {
        val trackDTO = TrackDTO()
        trackDTO.name = track.name
        trackDTO.distance = track.distance
        trackDTO.lapsRequired = track.lapsRequired
        trackDTO.countryCode = track.countryCode
        return trackDTO
    }
}
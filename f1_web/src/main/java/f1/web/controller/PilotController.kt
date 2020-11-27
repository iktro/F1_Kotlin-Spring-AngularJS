package f1.web.controller

import f1.core.entities.Pilot
import f1.core.service.PilotService
import f1.web.dto.PilotDTO
import org.springframework.stereotype.Controller
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import kotlin.streams.toList

@Controller
@Path("/pilots")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class PilotController(private val pilotService: PilotService) : RestController {

    @GET
    @Path("/all")
    fun getAllPilots() = pilotService.findAll().stream().map(this::pilotToDTO).toList()

    @GET
    @Path("/allActive")
    fun getAllActivePilots() = pilotService.findAllCurrentPilots().stream().map(this::pilotToDTO).toList()

    @POST
    @Path("/newPilot")
    fun saveNewPilot(newPilot: Pilot): Pilot = pilotService.save(newPilot)

    private fun pilotToDTO(pilot: Pilot): PilotDTO {
        val pilotDTO = PilotDTO()
        pilotDTO.firstName = pilot.firstName
        pilotDTO.lastName = pilot.lastName
        pilotDTO.championshipTitle = pilot.championshipTitle
        pilotDTO.team = pilot.team
        pilotDTO.isRetired = pilot.isRetired
        return pilotDTO
    }

}
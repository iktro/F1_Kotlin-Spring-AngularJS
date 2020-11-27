package f1.web.controller

import f1.core.entities.Team
import f1.core.service.TeamService
import f1.web.dto.TeamDTO
import org.springframework.stereotype.Controller
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import kotlin.streams.toList

@Controller
@Path("/teams")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class TeamController(private val teamService: TeamService) : RestController {

    @GET
    @Path("/list")
    fun getAllTeams() = teamService.findAll().stream().map(this::teamToDTO).toList()

    private fun teamToDTO(team: Team): TeamDTO {
        val teamDTO = TeamDTO()
        teamDTO.name = team.name
        teamDTO.championshipTitle = team.championshipTitle
        return teamDTO
    }

}
package f1.app;

import f1.core.entities.*;
import f1.core.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("f1.core.config");
        final TeamService teamService = context.getBean(TeamService.class);
        final PilotService pilotService = context.getBean(PilotService.class);
        final TrackService trackService = context.getBean(TrackService.class);
        final SeasonService seasonService = context.getBean(SeasonService.class);
        final ChampionshipService championshipService = context.getBean(ChampionshipService.class);
        cleanDB(teamService, pilotService, trackService, championshipService);
        final Map<String, Team> teams = registerTeam(teamService);
        final Map<String, Season> seasons = registerSeason(seasonService);
        final Map<String, Track> tracks = registerTrack(trackService);
        final Map<String, Pilot> pilots = registerPilot(pilotService, teams);
        registrerChampionship(championshipService, teams, pilots, tracks, seasons);
    }

    private static void cleanDB(final TeamService teamService, final PilotService pilotService, final TrackService trackService, final ChampionshipService championshipService) {
        championshipService.deleteAll();
        trackService.deleteAll();
        pilotService.deleteAll();
        teamService.deleteAll();
    }

    private static Map<String, Team> registerTeam(final TeamService teamService) {
        Map<String, Team> teams = new HashMap<>();
        teams.put("mercedes", createTeam("Mercedes", 7, teamService));
        teams.put("ferrari", createTeam("Ferrari", 16, teamService));
        teams.put("red bull", createTeam("Red Bull", 4, teamService));
        teams.put("mclaren", createTeam("McLaren", 8, teamService));
        teams.put("renault", createTeam("Renault", 2, teamService));
        teams.put("alpha tauri", createTeam("Alpha Tauri", 0, teamService));
        teams.put("racing point", createTeam("Racing Point", 0, teamService));
        teams.put("alfa romeo", createTeam("Alfa Romeo", 0, teamService));
        teams.put("haas", createTeam("Haas", 0, teamService));
        teams.put("williams", createTeam("Williams", 0, teamService));
        teams.put("force india", createTeam("Force India", 0, teamService));
        teams.put("sauber", createTeam("Sauber", 0, teamService));
        return teams;
    }


    private static Team createTeam(String teamName, int championshipTitle, final TeamService teamService) {
        System.out.println("Registring " + teamName);
        Team team = new Team();
        team.setName(teamName);
        team.setChampionshipTitle(championshipTitle);
        teamService.save(team);
        return team;
    }

    private static Map<String, Season> registerSeason(final SeasonService seasonService) {
        Map<String, Season> seasons = new HashMap<>();
        seasons.put("2018", createSeason(2018, true, 21, seasonService));
        seasons.put("2019", createSeason(2018, true, 21, seasonService));
        seasons.put("2020", createSeason(2018, false, 17, seasonService));

        return seasons;
    }

    private static Season createSeason(int year, Boolean isOver, int numberOfRaces, SeasonService seasonService) {
        Season season = new Season(year, isOver, numberOfRaces);
        seasonService.save(season);
        return season;
    }

    private static Map<String, Track> registerTrack(final TrackService trackService) {
        Map<String, Track> tracks = new HashMap<>();
        tracks.put("spielberg", createTrack("Spielberg", "AUT", trackService));
        tracks.put("hungaroring", createTrack("Hungaroring", "HUN", trackService));
        tracks.put("silverstone", createTrack("Silverstone", "GB", trackService));
        tracks.put("barcelone", createTrack("Barcelone", "ESP", trackService));
        tracks.put("spa-francorchamps", createTrack("Spa-Francorchamps", "BEL", trackService));
        tracks.put("monza", createTrack("Monza", "ITA", trackService));
        tracks.put("mugello", createTrack("Mugello", "ITA", trackService));
        tracks.put("sotchi", createTrack("Sotchi", "RU", trackService));
        tracks.put("nürburgring", createTrack("Nürburgring", "DE", trackService));
        tracks.put("algarve", createTrack("Algarve", "PO", trackService));
        tracks.put("emilie-romagne", createTrack("Emilie-Romagne", "ITA", trackService));
        tracks.put("istanbul", createTrack("Istanbul", "TUR", trackService));
        tracks.put("sakhir", createTrack("Sakhir", "", trackService));
        tracks.put("yas marina", createTrack("Yas Marina", "UAE", trackService));
        return tracks;
    }

    private static Track createTrack(String name, String country, final TrackService trackService) {
        System.out.println("Registring " + name);
        Track track = new Track();
        track.setName(name);
        track.setCountryCode(country);
        trackService.save(track);
        return track;
    }

    private static Map<String, Pilot> registerPilot(final PilotService pilotService, final Map<String, Team> teams) {
        Map<String, Pilot> pilots = new HashMap<>();
        pilots.put("ricciardo", createPilote("Daniel Ricciardo", teams.get("renault"), 0, false, pilotService));
        pilots.put("norris", createPilote("Lando Norris", teams.get("mclaren"), 0, false, pilotService));
        pilots.put("vettel", createPilote("Sebastian Vettel", teams.get("ferrari"), 4, false, pilotService));
        pilots.put("latifi", createPilote("Nicholas Latifi", teams.get("williams"), 0, false, pilotService));
        pilots.put("räikkönen", createPilote("Kimi Räikkönen", teams.get("alfa romeo"), 1, false, pilotService));
        pilots.put("grosjean", createPilote("Romain Grosjean", teams.get("haas"), 0, false, pilotService));
        pilots.put("gasly", createPilote("Pierre Gasly", teams.get("alpha tauri"), 0, false, pilotService));
        pilots.put("pérez", createPilote("Sergio Pérez", teams.get("racing point"), 0, false, pilotService));
        pilots.put("leclerc", createPilote("Charles Leclerc", teams.get("ferrari"), 0, false, pilotService));
        pilots.put("stroll", createPilote("Lance Stroll", teams.get("racing point"), 0, false, pilotService));
        pilots.put("magnussen", createPilote("Kevin Magnussen", teams.get("haas"), 0, false, pilotService));
        pilots.put("albon", createPilote("Alexander Albon", teams.get("red bull"), 0, false, pilotService));
        pilots.put("kvyat", createPilote("Daniil Kvyat", teams.get("alpha tauri"), 0, false, pilotService));
        pilots.put("ocon", createPilote("Esteban Ocon ", teams.get("renault"), 0, false, pilotService));
        pilots.put("verstappen", createPilote("Max Verstappen", teams.get("red bull"), 0, false, pilotService));
        pilots.put("hamilton", createPilote("Lewis Hamilton", teams.get("mercedes"), 7, false, pilotService));
        pilots.put("sainz", createPilote("Carlos Sainz", teams.get("mclaren"), 0, false, pilotService));
        pilots.put("russell", createPilote("George Russell", teams.get("williams"), 0, false, pilotService));
        pilots.put("kubica", createPilote("Robert Kubica", teams.get("williams"), 0, false, pilotService));
        pilots.put("bottas", createPilote("Valtteri Bottas", teams.get("mercedes"), 0, false, pilotService));
        pilots.put("giovinazzi", createPilote("Antonio Giovinazzi", teams.get("alfa romeo"), 0, false, pilotService));
        pilots.put("hülkenberg", createPilote("Nico Hülkenberg", teams.get("racing point"), 0, false, pilotService));
        pilots.put("alonso", createPilote("Fernando Alonso", teams.get("mclaren"), 2, true, pilotService));
        pilots.put("vandoorne", createPilote("Stoffel Vandoorne", teams.get("mclaren"), 0, false, pilotService));
        pilots.put("ericsson", createPilote("Marcus Ericsson", teams.get("sauber"), 0, false, pilotService));
        pilots.put("hartley", createPilote("Brendon Hartley", teams.get("alpha tauri"), 0, false, pilotService));
        pilots.put("sirotkin", createPilote("Sergey Sirotkin", teams.get("williams"), 0, false, pilotService));
        return pilots;
    }

    private static Pilot createPilote(String name, final Team team, int championshipTitle, Boolean isRetired, final PilotService pilotService) {
        System.out.println("Registring " + name);
        Pilot pilot = new Pilot();
        String[] fullName = name.split(" ");
        pilot.setFirstName(fullName[0]);
        pilot.setLastName(fullName[1]);
        pilot.setTeam(team);
        pilot.setChampionshipTitle(championshipTitle);
        pilot.setRetired(isRetired);
        pilotService.save(pilot);
        return pilot;
    }

    private static Map<String, Championship> registrerChampionship(final ChampionshipService championshipService, final Map<String, Team> teams, final Map<String, Pilot> pilots, final Map<String, Track> tracks, final Map<String, Season> seasons) {
        Map<String, Championship> championships = new HashMap<>();
        createChampionship(seasons.get("2020"), teams.get("mercedes"), pilots.get("bottas"), tracks.get("spielberg"), 25, championshipService);
        createChampionship(seasons.get("2020"), teams.get("ferrari"), pilots.get("leclerc"), tracks.get("spielberg"), 18, championshipService);
        createChampionship(seasons.get("2020"), teams.get("mclaren"), pilots.get("norris"), tracks.get("spielberg"), 16, championshipService);
        createChampionship(seasons.get("2020"), teams.get("mercedes"), pilots.get("hamilton"), tracks.get("spielberg"), 12, championshipService);
        createChampionship(seasons.get("2020"), teams.get("mclaren"), pilots.get("sainz"), tracks.get("spielberg"), 10, championshipService);
        createChampionship(seasons.get("2020"), teams.get("racing point"), pilots.get("pérez"), tracks.get("spielberg"), 8, championshipService);
        createChampionship(seasons.get("2020"), teams.get("alpha tauri"), pilots.get("gasly"), tracks.get("spielberg"), 6, championshipService);
        createChampionship(seasons.get("2020"), teams.get("renault"), pilots.get("ocon"), tracks.get("spielberg"), 4, championshipService);
        createChampionship(seasons.get("2020"), teams.get("alfa romeo"), pilots.get("giovinazzi"), tracks.get("spielberg"), 2, championshipService);
        createChampionship(seasons.get("2020"), teams.get("ferrari"), pilots.get("vettel"), tracks.get("spielberg"), 1, championshipService);
        createChampionship(seasons.get("2020"), teams.get("williams"), pilots.get("latifi"), tracks.get("spielberg"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("alpha tauri"), pilots.get("kvyat"), tracks.get("spielberg"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("red bull"), pilots.get("albon"), tracks.get("spielberg"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("alfa romeo"), pilots.get("räikkönen"), tracks.get("spielberg"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("williams"), pilots.get("russell"), tracks.get("spielberg"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("haas"), pilots.get("grosjean"), tracks.get("spielberg"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("haas"), pilots.get("magnussen"), tracks.get("spielberg"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("racing point"), pilots.get("stroll"), tracks.get("spielberg"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("renault"), pilots.get("ricciardo"), tracks.get("spielberg"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("red bull"), pilots.get("verstappen"), tracks.get("spielberg"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("mercedes"), pilots.get("hamilton"), tracks.get("hungaroring"), 26, championshipService);
        createChampionship(seasons.get("2020"), teams.get("red bull"), pilots.get("verstappen"), tracks.get("hungaroring"), 18, championshipService);
        createChampionship(seasons.get("2020"), teams.get("mercedes"), pilots.get("bottas"), tracks.get("hungaroring"), 15, championshipService);
        createChampionship(seasons.get("2020"), teams.get("racing point"), pilots.get("stroll"), tracks.get("hungaroring"), 12, championshipService);
        createChampionship(seasons.get("2020"), teams.get("red bull"), pilots.get("albon"), tracks.get("hungaroring"), 10, championshipService);
        createChampionship(seasons.get("2020"), teams.get("ferrari"), pilots.get("vettel"), tracks.get("hungaroring"), 8, championshipService);
        createChampionship(seasons.get("2020"), teams.get("racing point"), pilots.get("pérez"), tracks.get("hungaroring"), 6, championshipService);
        createChampionship(seasons.get("2020"), teams.get("renault"), pilots.get("ricciardo"), tracks.get("hungaroring"), 4, championshipService);
        createChampionship(seasons.get("2020"), teams.get("mclaren"), pilots.get("sainz"), tracks.get("hungaroring"), 2, championshipService);
        createChampionship(seasons.get("2020"), teams.get("haas"), pilots.get("magnussen"), tracks.get("hungaroring"), 1, championshipService);
        createChampionship(seasons.get("2020"), teams.get("ferrari"), pilots.get("leclerc"), tracks.get("hungaroring"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("alpha tauri"), pilots.get("kvyat"), tracks.get("hungaroring"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("mclaren"), pilots.get("norris"), tracks.get("hungaroring"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("renault"), pilots.get("ocon"), tracks.get("hungaroring"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("alfa romeo"), pilots.get("räikkönen"), tracks.get("hungaroring"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("haas"), pilots.get("grosjean"), tracks.get("hungaroring"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("alfa romeo"), pilots.get("giovinazzi"), tracks.get("hungaroring"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("williams"), pilots.get("russell"), tracks.get("hungaroring"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("williams"), pilots.get("latifi"), tracks.get("hungaroring"), 0, championshipService);
        createChampionship(seasons.get("2020"), teams.get("alpha tauri"), pilots.get("gasly"), tracks.get("hungaroring"), 0, championshipService);

        createChampionship(seasons.get("2019"), teams.get("mercedes"), pilots.get("hamilton"), tracks.get("spa-francorchamps"), 413, championshipService);
        createChampionship(seasons.get("2019"), teams.get("mercedes"), pilots.get("bottas"), tracks.get("spa-francorchamps"), 326, championshipService);
        createChampionship(seasons.get("2019"), teams.get("red bull"), pilots.get("verstappen"), tracks.get("spa-francorchamps"), 278, championshipService);
        createChampionship(seasons.get("2019"), teams.get("ferrari"), pilots.get("leclerc"), tracks.get("spa-francorchamps"), 264, championshipService);
        createChampionship(seasons.get("2019"), teams.get("ferrari"), pilots.get("vettel"), tracks.get("spa-francorchamps"), 240, championshipService);
        createChampionship(seasons.get("2019"), teams.get("mclaren"), pilots.get("sainz"), tracks.get("spa-francorchamps"), 96, championshipService);
        createChampionship(seasons.get("2019"), teams.get("alpha tauri"), pilots.get("gasly"), tracks.get("spa-francorchamps"), 95, championshipService);
        createChampionship(seasons.get("2019"), teams.get("red bull"), pilots.get("albon"), tracks.get("spa-francorchamps"), 92, championshipService);
        createChampionship(seasons.get("2019"), teams.get("renault"), pilots.get("ricciardo"), tracks.get("spa-francorchamps"), 54, championshipService);
        createChampionship(seasons.get("2019"), teams.get("racing point"), pilots.get("pérez"), tracks.get("spa-francorchamps"), 52, championshipService);
        createChampionship(seasons.get("2019"), teams.get("mclaren"), pilots.get("norris"), tracks.get("spa-francorchamps"), 49, championshipService);
        createChampionship(seasons.get("2019"), teams.get("alfa romeo"), pilots.get("räikkönen"), tracks.get("spa-francorchamps"), 43, championshipService);
        createChampionship(seasons.get("2019"), teams.get("alpha tauri"), pilots.get("kvyat"), tracks.get("spa-francorchamps"), 37, championshipService);
        createChampionship(seasons.get("2019"), teams.get("renault"), pilots.get("hülkenberg"), tracks.get("spa-francorchamps"), 37, championshipService);
        createChampionship(seasons.get("2019"), teams.get("racing point"), pilots.get("stroll"), tracks.get("spa-francorchamps"), 21, championshipService);
        createChampionship(seasons.get("2019"), teams.get("haas"), pilots.get("magnussen"), tracks.get("spa-francorchamps"), 20, championshipService);
        createChampionship(seasons.get("2019"), teams.get("alfa romeo"), pilots.get("giovinazzi"), tracks.get("spa-francorchamps"), 14, championshipService);
        createChampionship(seasons.get("2019"), teams.get("haas"), pilots.get("grosjean"), tracks.get("spa-francorchamps"), 8, championshipService);
        createChampionship(seasons.get("2019"), teams.get("williams"), pilots.get("kubica"), tracks.get("spa-francorchamps"), 1, championshipService);
        createChampionship(seasons.get("2019"), teams.get("williams"), pilots.get("latifi"), tracks.get("spa-francorchamps"), 0, championshipService);

        createChampionship(seasons.get("2018"), teams.get("mercedes"), pilots.get("hamilton"), tracks.get("spa-francorchamps"), 408, championshipService);
        createChampionship(seasons.get("2018"), teams.get("ferrari"), pilots.get("vettel"), tracks.get("spa-francorchamps"), 320, championshipService);
        createChampionship(seasons.get("2018"), teams.get("ferrari"), pilots.get("räikkönen"), tracks.get("spa-francorchamps"), 251, championshipService);
        createChampionship(seasons.get("2018"), teams.get("red bull"), pilots.get("verstappen"), tracks.get("spa-francorchamps"), 249, championshipService);
        createChampionship(seasons.get("2018"), teams.get("mercedes"), pilots.get("bottas"), tracks.get("spa-francorchamps"), 247, championshipService);
        createChampionship(seasons.get("2018"), teams.get("red bull"), pilots.get("ricciardo"), tracks.get("spa-francorchamps"), 170, championshipService);
        createChampionship(seasons.get("2018"), teams.get("renault"), pilots.get("hülkenberg"), tracks.get("spa-francorchamps"), 69, championshipService);
        createChampionship(seasons.get("2018"), teams.get("force india"), pilots.get("pérez"), tracks.get("spa-francorchamps"), 62, championshipService);
        createChampionship(seasons.get("2018"), teams.get("haas"), pilots.get("magnussen"), tracks.get("spa-francorchamps"), 56, championshipService);
        createChampionship(seasons.get("2018"), teams.get("renault"), pilots.get("sainz"), tracks.get("spa-francorchamps"), 53, championshipService);
        createChampionship(seasons.get("2018"), teams.get("mclaren"), pilots.get("alonso"), tracks.get("spa-francorchamps"), 50, championshipService);
        createChampionship(seasons.get("2018"), teams.get("force india"), pilots.get("ocon"), tracks.get("spa-francorchamps"), 49, championshipService);
        createChampionship(seasons.get("2018"), teams.get("sauber"), pilots.get("leclerc"), tracks.get("spa-francorchamps"), 39, championshipService);
        createChampionship(seasons.get("2018"), teams.get("haas"), pilots.get("grosjean"), tracks.get("spa-francorchamps"), 37, championshipService);
        createChampionship(seasons.get("2018"), teams.get("alpha tauri"), pilots.get("gasly"), tracks.get("spa-francorchamps"), 29, championshipService);
        createChampionship(seasons.get("2018"), teams.get("mclaren"), pilots.get("vandoorne"), tracks.get("spa-francorchamps"), 12, championshipService);
        createChampionship(seasons.get("2018"), teams.get("sauber"), pilots.get("ericsson"), tracks.get("spa-francorchamps"), 9, championshipService);
        createChampionship(seasons.get("2018"), teams.get("williams"), pilots.get("stroll"), tracks.get("spa-francorchamps"), 6, championshipService);
        createChampionship(seasons.get("2018"), teams.get("alpha tauri"), pilots.get("hartley"), tracks.get("spa-francorchamps"), 4, championshipService);
        createChampionship(seasons.get("2018"), teams.get("racing point"), pilots.get("sirotkin"), tracks.get("spa-francorchamps"), 1, championshipService);
        return championships;
    }

    private static Championship createChampionship(Season season, final Team team, final Pilot pilot, final Track track, int pointScored, final ChampionshipService championshipService) {
        System.out.println("Registring" + season + team + pilot + track);
        Championship championship = new Championship();
        championship.setSeason(season);
        championship.setTeam(team);
        championship.setPilot(pilot);
        championship.setTrack(track);
        championship.setPointScored(pointScored);
        championshipService.save(championship);
        return championship;
    }
}
package nl.hu.bep.webservices;


import nl.hu.bep.PersistensieManager.AppManager;
import nl.hu.bep.jacksonrequest.MoveRequest;
import nl.hu.bep.jacksonrequest.UpdateSnakeRequest;
import nl.hu.bep.model.Games;
import nl.hu.bep.model.Snake;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/games")
public class GamesResource {

    @GET
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGameIDs() {
        return Response.ok(Games.getAlleGamesIDs()).build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameDetailtsByID(@PathParam("id") String id) {
        return Response.ok(Games.getGameDetailtsByID(id)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response DeleteGame(@PathParam("id") String id){
        Games found = AppManager.getAppManager().getAlleGames().stream().filter(ids -> ids.getId().equals(id)).findAny().orElse(null);
        AppManager.getAppManager().deleteGame(found);
        return Response.ok().build();
    }
}

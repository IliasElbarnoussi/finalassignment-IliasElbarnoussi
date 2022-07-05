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
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;



@Path("/games")
public class GamesResource {

//    public Snake getSnake() {
//        return snake1;
//    }



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
        Games.deleteGame(found);
        return Response.ok().build();
    }

//    @POST
//    @Path("/start")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response startBattle() {
//        return Response.ok().build();
//    }
//
//    @POST
//    @Path("/end")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response endBattle() {
//        return Response.ok().build();
//    }
//
//    @POST
//    @Path("/move")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response moveBattleSnake(MoveRequest moveRequest) {
//        System.out.println(moveRequest.you.get("head"));
//
//        LinkedHashMap you = (LinkedHashMap) moveRequest.you.get("head");
//
//        System.out.println(you.get("x"));
//        System.out.println(you.get("y"));
//
//        System.out.println(moveRequest.you.getClass().getSimpleName());
//        moveResponse moveResponse = new moveResponse("up", "Going up!");
//        return Response.ok(moveResponse).build();
//    }
//
//    @PUT
//    @Path("/update")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateBattleSnake(UpdateSnakeRequest updateSnakeRequest) {
//        Snake.getSnakeByAuthor("ilias").setColor(updateSnakeRequest.color);
//        Snake.getSnakeByAuthor("ilias").setHead(updateSnakeRequest.head);
//        Snake.getSnakeByAuthor("ilias").setTail(updateSnakeRequest.tail);
////        System.out.println(getSnake().getHead());
//        return Response.ok(Snake.getSnakeByAuthor("ilias")).build();
//    }


}

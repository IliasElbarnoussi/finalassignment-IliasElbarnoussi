package nl.hu.bep.webservices;

import nl.hu.bep.jacksonrequest.MoveRequest;
import nl.hu.bep.jacksonrequest.StartEndRequest;
import nl.hu.bep.jacksonrequest.UpdateSnakeRequest;
import nl.hu.bep.model.Games;
import nl.hu.bep.model.Snake;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;

class moveResponse {
    public String move;
    public String shout;

    public moveResponse(String move, String shout) {
        this.move = move;
        this.shout = shout;
    }

    public void setMove(String move) {
        this.move = move;
    }
    public void setShout(String shout) {
        this.shout = shout;
    }

}

@Path("/snake")
public class SnakeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBattleSnake() {
        return Response.ok(Snake.getSnakeByAuthor("ilias")).build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBattleSnake(@Context SecurityContext sc) {
        System.out.println(sc.getUserPrincipal().getName());
        return Response.ok(Snake.getSnakeByAuthor(sc.getUserPrincipal().getName())).build();
    }

    @POST
    @Path("/start")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response startBattle(StartEndRequest startEndRequest) {
        HashMap game = startEndRequest.game;
        HashMap ruleset = (HashMap) game.get("ruleset");
        HashMap name = (HashMap) ruleset.get("name");

        System.out.println(name);
        return Response.ok().build();
    }

    @POST
    @Path("/end")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response endBattle() {
//        Games.getAlleGames().add(new Games())
        return Response.ok().build();
    }

    @POST
    @Path("/move")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response moveBattleSnake(MoveRequest moveRequest) {
        System.out.println(moveRequest.you.get("head"));

        LinkedHashMap you = (LinkedHashMap) moveRequest.you.get("head");

        moveResponse moveResponse = new moveResponse("up", "Going up!");

        int x = (int) you.get("x");
        int y = (int) you.get("y");

        if (x == 10) {
            moveResponse.setMove("up");
        }

        if (y == 10) {
            moveResponse.setMove("right");
        }

        if (y == 0) {
            moveResponse.setMove("left");
        }

        if (x == 0) {
            moveResponse.setMove("up");
        }


        if (x == 10 && y == 10) {
            moveResponse.setMove("left");
        }

        if (x == 0 && y == 0) {
            moveResponse.setMove("right");
        }

        ///
        if (x == 0 && y == 10) {
            moveResponse.setMove("left");
        }

        ///
        if (x == 10 && y == 0) {
            moveResponse.setMove("up");
        }

        return Response.ok(moveResponse).build();
    }

    @PUT
    @Path("/update")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBattleSnake(UpdateSnakeRequest updateSnakeRequest, @Context SecurityContext sc) {
        String username = sc.getUserPrincipal().getName();
        Snake.getSnakeByAuthor(username).setColor(updateSnakeRequest.color);
        Snake.getSnakeByAuthor(username).setHead(updateSnakeRequest.head);
        Snake.getSnakeByAuthor(username).setTail(updateSnakeRequest.tail);
//        System.out.println(getSnake().getHead());
        return Response.ok(Snake.getSnakeByAuthor(username)).build();
    }


}

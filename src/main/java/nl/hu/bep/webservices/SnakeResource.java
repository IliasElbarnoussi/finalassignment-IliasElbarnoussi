package nl.hu.bep.webservices;

import nl.hu.bep.jacksonrequest.MoveRequest;
import nl.hu.bep.jacksonrequest.UpdateSnakeRequest;
import nl.hu.bep.model.Games;
import nl.hu.bep.model.Snake;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

//    public Snake getSnake() {
//        return snake1;
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBattleSnake() {
        return Response.ok(Snake.getSnakeByAuthor("ilias")).build();
    }

    @POST
    @Path("/start")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response startBattle() {
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

        if (x == 10 && y == 10) {
            moveResponse.setMove("left");
        }

        return Response.ok(moveResponse).build();
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBattleSnake(UpdateSnakeRequest updateSnakeRequest) {
        Snake.getSnakeByAuthor("ilias").setColor(updateSnakeRequest.color);
        Snake.getSnakeByAuthor("ilias").setHead(updateSnakeRequest.head);
        Snake.getSnakeByAuthor("ilias").setTail(updateSnakeRequest.tail);
//        System.out.println(getSnake().getHead());
        return Response.ok(Snake.getSnakeByAuthor("ilias")).build();
    }


}

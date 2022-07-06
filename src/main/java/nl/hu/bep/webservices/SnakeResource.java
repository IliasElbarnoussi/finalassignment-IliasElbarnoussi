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
import java.util.*;

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

}

@Path("/snake")
public class SnakeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBattleSnake() {
        System.out.println("test");
        return Response.ok(Snake.getSnakeByAuthor("ilias")).build();
    }

    @GET
    @Path("/get")
    @RolesAllowed("user")
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
        System.out.println("=============START============");
        new Games((String) startEndRequest.game.get("id"));

        return Response.ok().build();
    }

    @POST
    @Path("/end")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response endBattle(StartEndRequest startEndRequest) {
        System.out.println("=============END============");

        LinkedHashMap head = (LinkedHashMap) startEndRequest.you.get("head");
        Games game = Games.getGameDetailtsByID((String) startEndRequest.game.get("id"));


        if (game != null) {
            game.setAantalBeurten(startEndRequest.turn);
            game.setGezondheid((Integer) startEndRequest.you.get("health"));
            game.setSnakeLengte((Integer) startEndRequest.you.get("length"));
            game.redenGameOver(head);

        }
        return Response.ok(game).build();
    }

    @POST
    @Path("/move")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response moveBattleSnake(MoveRequest moveRequest) {
        Games game = Games.getGameDetailtsByID((String) moveRequest.game.get("id"));
        moveResponse moveResponse = new moveResponse("up", "Going up!");

        ArrayList body = (ArrayList) moveRequest.you.get("body");
        LinkedHashMap head = (LinkedHashMap) moveRequest.you.get("head");

        int x = (int) head.get("x");
        int y = (int) head.get("y");

        ArrayList<String> mogelijkeRichtingen = new ArrayList<>(Arrays.asList("up", "down", "left", "right"));
        if (x == 10) {
            mogelijkeRichtingen.remove("right");
        }

        if (y == 10) {
            mogelijkeRichtingen.remove("up");
        }

        if (y == 0) {
            mogelijkeRichtingen.remove("down");
        }

        if (x == 0) {
            mogelijkeRichtingen.remove("left");
        }

        if (x == 10 && y == 10) {
            mogelijkeRichtingen.remove("right");
            mogelijkeRichtingen.remove("up");
        }

        if (x == 0 && y == 0) {
            mogelijkeRichtingen.remove("left");
            mogelijkeRichtingen.remove("down");
        }

        if (x == 0 && y == 10) {
            mogelijkeRichtingen.remove("left");
            mogelijkeRichtingen.remove("up");
        }

        if (x == 10 && y == 0) {
            mogelijkeRichtingen.remove("right");
            mogelijkeRichtingen.remove("down");
        }


        LinkedHashMap neck = (LinkedHashMap) body.get(1);

        int neck_x = (Integer) neck.get("x");
        int neck_y = (Integer) neck.get("y");

        int head_x = (Integer) head.get("x");
        int head_y = (Integer) head.get("y");


        if (neck_x < head_x) {
            mogelijkeRichtingen.remove("left");

        } else if (neck_x > head_x) {
            mogelijkeRichtingen.remove("right");

        } else if (neck_y < head_y) {
            mogelijkeRichtingen.remove("down");

        } else if (neck_y > head_y) {
            mogelijkeRichtingen.remove("up");
        }

        int choice = new Random().nextInt(mogelijkeRichtingen.size());
        String move = mogelijkeRichtingen.get(choice);

        moveResponse.setMove(move);
        game.aantalBochtjes(move);


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
        return Response.ok(Snake.getSnakeByAuthor(username)).build();
    }


}

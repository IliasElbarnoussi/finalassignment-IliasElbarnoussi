package nl.hu.bep.webservices;

import nl.hu.bep.jacksonrequest.MoveRequest;
import nl.hu.bep.model.Snake;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

class moveResponse {
    public String move;
    public String shout;

    public moveResponse(String move, String shout) {
        this.move = move;
        this.shout = shout;
    }
}

@Path("/snake")
public class SnakeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBattleSnake() {
        Snake snake = new Snake();

        return Response.ok(snake).build();
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
        return Response.ok().build();
    }

    @POST
    @Path("/move")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response moveBattleSnake(MoveRequest moveRequest) {
        System.out.println(moveRequest);
        moveResponse moveResponse = new moveResponse("up", "Going up!");
        return Response.ok(moveResponse).build();
    }


}

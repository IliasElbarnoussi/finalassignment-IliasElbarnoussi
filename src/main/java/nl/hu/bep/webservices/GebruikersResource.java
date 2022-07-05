package nl.hu.bep.webservices;

import nl.hu.bep.security.MyUser;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.HashMap;

@Path("/user")
public class GebruikersResource {

    @GET
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@Context SecurityContext sc) {
        MyUser myUser = MyUser.getUserByUsername(sc.getUserPrincipal().getName());
        HashMap myUserData = new HashMap<>();

        myUserData.put("username", myUser.getName());
        myUserData.put("role", myUser.getRole());

        return Response.ok(myUserData).build();
    }
}

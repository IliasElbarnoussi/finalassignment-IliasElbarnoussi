package nl.hu.bep.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.hu.bep.jacksonrequest.LoginRequest;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap;
import java.util.Calendar;

@Path("/auth")
public class AuthenticationResource {
    final static public Key key = MacProvider.generateKey();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(LoginRequest loginRequest) {
        try {
            String role = MyUser.validateLogin(loginRequest.username, loginRequest.password);
            if (role == null) throw new IllegalArgumentException("no user found!");
            String token = createToken(loginRequest.username, role);
            System.out.println(token);

            return Response.ok(new AbstractMap.SimpleEntry("JWT", token)).build();
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("catch");
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    private String createToken(String username, String role) {
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE, 30);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration.getTime())
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }
}

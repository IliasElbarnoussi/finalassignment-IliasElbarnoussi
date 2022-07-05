package nl.hu.bep.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("nl.hu.bep.webservices", "nl.hu.bep.setup", "nl.hu.bep.security"); //"nl.hu.bep.security"
//        packages("nl.hu.bep.webservices");
        register(RolesAllowedDynamicFeature.class);
    }
}

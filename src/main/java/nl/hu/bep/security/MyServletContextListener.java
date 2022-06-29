package nl.hu.bep.security;

import nl.hu.bep.model.Games;
import nl.hu.bep.model.Snake;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("initializing application");
        Snake snake = new Snake("1", "ilias", "#888888", "default", "default", "0.0.1-beta");
        HashMap tijdelijk = new HashMap<>();
        Games game = new Games("altijd-dezelfde", 12, tijdelijk, "muur-geraakt", 7);
    }



    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("terminating application");
//        try {
//            PersistenceManager.saveAppToAzure();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Schedulers.shutdownNow();
//        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO, Duration.ZERO).block();
    }




}

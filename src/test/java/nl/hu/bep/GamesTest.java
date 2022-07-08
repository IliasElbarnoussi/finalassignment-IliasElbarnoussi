package nl.hu.bep;

import nl.hu.bep.PersistensieManager.AppManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import nl.hu.bep.model.Games;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

public class GamesTest {
    private ArrayList<Games> AlleGames = new ArrayList<>();
    private Games game;
    @BeforeEach
    public void setup(){
        game = new Games("unieke-ID");
        AlleGames.add(game);

    }


    @Test
    void deleteGame() {
        AlleGames.remove(game);
        assertTrue(true, String.valueOf(AlleGames.isEmpty()));
    }

    @Test
    void getId() {
        assertEquals("unieke-ID", game.getId());
    }

    @Test
    void setId() {
        game.setId("nieuwID");
        assertEquals("nieuwID", game.getId());
    }

    @Test
    void getTurn() {
        assertEquals(0,game.getAantalBeurten());
    }

    @Test
    void setTurn() {
        game.setAantalBeurten(22);
        assertEquals(22, game.getAantalBeurten());
    }

    @Test
    void setRedenEinde() {
        game.setRedenEinde("Dood door muur");
        assertEquals("Dood door muur", game.getRedenEinde());
    }





    @Test
    void TestVeranderGameID() {
        game.setId("Een-Ander-Uniek-ID");
        assertEquals("Een-Ander-Uniek-ID", game.getId());
    }


//    @Test
//    void setMapname() {
//        game.setMapname("standaard");
//        assertEquals("standaard", game.getMapname());
//    }

}

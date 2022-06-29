package nl.hu.bep.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Games {
    private String id;
    private int aantalBeurten;
    private HashMap<String, Integer> meestBezochtePlek;
    private String redenEinde;
    private int aantalBochtjesLinksaf;

    private static ArrayList<Games> alleGames = new ArrayList<>();

    public Games(String id, int aantalBeurten, HashMap meestBezochtePlek, String redenEinde, int aantalBochtjesLinksaf) {
        this.id = id;
        this.aantalBeurten = aantalBeurten;
        this.meestBezochtePlek = meestBezochtePlek;
        this.redenEinde = redenEinde;
        this.aantalBochtjesLinksaf = aantalBochtjesLinksaf;

        getAlleGames().add(this);
    }

    public static ArrayList<String> getAlleGamesIDs(){
        ArrayList<String> alleGameIDs = new ArrayList<>();
        for (Games game : getAlleGames()) {
            alleGameIDs.add(game.getId());
        }
        return alleGameIDs;
    }

    public static Games getGameDetailtsByID(String gameID) {
        for (Games game : getAlleGames()) {
            if (game.getId().equals(gameID))
                return game;
        }
        return null;
    }

    public static void deleteGame(Games id){
        getAlleGames().remove(id);
    }


//    public static void deleteGame(String gameID) {
//        for (Games game : getAlleGames()) {
//            if (game.getId().equals(gameID))
//                getAlleGames().remove(game);
//        }
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAantalBeurten() {
        return aantalBeurten;
    }

    public void setAantalBeurten(int aantalBeurten) {
        this.aantalBeurten = aantalBeurten;
    }

    public HashMap getMeestBezochtePlek() {
        return meestBezochtePlek;
    }

    public void setMeestBezochtePlek(HashMap meestBezochtePlek) {
        this.meestBezochtePlek = meestBezochtePlek;
    }

    public String getRedenEinde() {
        return redenEinde;
    }

    public void setRedenEinde(String redenEinde) {
        this.redenEinde = redenEinde;
    }

    public int getAantalBochtjesLinksaf() {
        return aantalBochtjesLinksaf;
    }

    public void setAantalBochtjesLinksaf(int aantalBochtjesLinksaf) {
        this.aantalBochtjesLinksaf = aantalBochtjesLinksaf;
    }

    public static ArrayList<Games> getAlleGames() {
        return alleGames;
    }

    public static void setAlleGames(ArrayList<Games> alleGames) {
        Games.alleGames = alleGames;
    }

}

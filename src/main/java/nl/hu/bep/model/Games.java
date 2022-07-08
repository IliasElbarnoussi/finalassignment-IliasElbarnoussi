package nl.hu.bep.model;

import nl.hu.bep.PersistensieManager.AppManager;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Games implements Serializable {
    private String id;
    private int gezondheid;
    private int aantalBeurten;
    private String redenEinde;
    private int snakeLengte;
    private int bochtNaarLinks = 0;
    private int bochtNaarRechts = 0;
    private int bochtNaarBoven = 0;
    private int bochtNaarBeneden = 0;


    public Games(String id) {
        this.id = id;
        if(!AppManager.getAppManager().getAlleGames().contains(this)) AppManager.getAppManager().getAlleGames().add(this);

    }

    @Override
    public boolean equals(Object obj) {
        boolean resultaat = obj instanceof Games;
        resultaat = resultaat && ((Games) obj).id.equals(id);
        return resultaat;
    }

    public static ArrayList<String> getAlleGamesIDs(){
        ArrayList<String> alleGameIDs = new ArrayList<>();
        for (Games game : AppManager.getAppManager().getAlleGames()) {
            alleGameIDs.add(game.getId());
        }
        return alleGameIDs;
    }



    public static Games getGameDetailtsByID(String gameID) {
        for (Games game : AppManager.getAppManager().getAlleGames()) {
            if (game.getId().equals(gameID))
                return game;
        }
        return null;
    }

    public void aantalBochtjes(String bocht) {
        switch(bocht) {
            case "up":
                bochtNaarBoven++;
                break;
            case "down":
                bochtNaarBeneden++;
                break;
            case "left":
                bochtNaarLinks++;
                break;
            case "right":
                bochtNaarRechts++;
                break;
        }
    }

    public void redenGameOver(HashMap head) {
        int x = (Integer) head.get("x");
        int y = (Integer) head.get("y");

        if (x == 11 || y == 11) {
            setRedenEinde("Muur geraakt!");;
        } else {
            setRedenEinde("Eigen staart geraakt!");
        }
    }


//    public static void deleteGame(String gameID) {
//        for (Games game : getAlleGames()) {
//            if (game.getId().equals(gameID))
//                getAlleGames().remove(game);
//        }
//    }


    public int getSnakeLengte() {
        return snakeLengte;
    }

    public void setSnakeLengte(int snakeLengte) {
        this.snakeLengte = snakeLengte;
    }


    public int getBochtNaarLinks() {
        return bochtNaarLinks;
    }

    public void setBochtNaarLinks(int bochtNaarLinks) {
        this.bochtNaarLinks = bochtNaarLinks;
    }

    public int getBochtNaarRechts() {
        return bochtNaarRechts;
    }

    public void setBochtNaarRechts(int bochtNaarRechts) {
        this.bochtNaarRechts = bochtNaarRechts;
    }

    public int getBochtNaarBoven() {
        return bochtNaarBoven;
    }

    public void setBochtNaarBoven(int bochtNaarBoven) {
        this.bochtNaarBoven = bochtNaarBoven;
    }

    public int getBochtNaarBeneden() {
        return bochtNaarBeneden;
    }

    public void setBochtNaarBeneden(int bochtNaarBeneden) {
        this.bochtNaarBeneden = bochtNaarBeneden;
    }

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

    public int getGezondheid() {
        return gezondheid;
    }

    public void setGezondheid(int gezondheid) {
        this.gezondheid = gezondheid;
    }

    public String getRedenEinde() {
        return redenEinde;
    }

    public void setRedenEinde(String redenEinde) {
        this.redenEinde = redenEinde;
    }

}

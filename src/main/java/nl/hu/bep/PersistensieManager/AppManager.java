package nl.hu.bep.PersistensieManager;

import nl.hu.bep.model.Games;
import nl.hu.bep.model.Snake;
import nl.hu.bep.security.MyUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppManager implements Serializable {
    public static AppManager myAppManager = new AppManager();

    private List<MyUser> AlleUsers = new ArrayList<>();
    private ArrayList<Snake> alleSnakes = new ArrayList<>();
    private ArrayList<Games> AlleGames = new ArrayList<>();


    public ArrayList<Games> getAlleGames() {
        return AlleGames;
    }

    public static void deleteGame(Games id){
        AppManager.getAppManager().getAlleGames().remove(id);
    }

    public void setAlleGames(ArrayList<Games> alleGames) {
        AlleGames = alleGames;
    }

    public List<MyUser> getAlleUsers() {
        return AlleUsers;
    }


    public void setAlleUsers(List<MyUser> alleUsers) {
        AlleUsers = alleUsers;
    }


    public ArrayList<Snake> getAlleSnakes() {
        return alleSnakes;
    }

    public void setAlleSnakes(ArrayList<Snake> alleSnakes) {
        this.alleSnakes = alleSnakes;
    }



    public static void setAppManager(AppManager am) {
        myAppManager = am;
    }
    public static AppManager getAppManager() {
        return myAppManager;
    }

}


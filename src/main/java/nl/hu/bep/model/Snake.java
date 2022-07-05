package nl.hu.bep.model;

import nl.hu.bep.PersistensieManager.AppManager;
import nl.hu.bep.security.MyUser;

import java.io.Serializable;
import java.util.ArrayList;

public class Snake implements Serializable {
    private String apiversion;
    private String author;
    private String color;
    private String head;
    private String tail;
    private String version;

    private ArrayList<Games> mijnGames = new ArrayList<>();
    
    public Snake(String apiversion, String author, String color, String head, String tail, String version) {
        this.apiversion = apiversion;
        this.author = author;
        this.color = color;
        this.head = head;
        this.tail = tail;
        this.version = version;

        if(!AppManager.getAppManager().getAlleSnakes().contains(this)) AppManager.getAppManager().getAlleSnakes().add(this);

    }

    @Override
    public boolean equals(Object obj) {
        boolean resultaat = obj instanceof Snake;

        resultaat = resultaat && ((Snake) obj).apiversion.equals(apiversion);
        resultaat = resultaat && ((Snake) obj).author.equals(author);
        resultaat = resultaat && ((Snake) obj).color.equals(color);
        resultaat = resultaat && ((Snake) obj).head.equals(head);
        resultaat = resultaat && ((Snake) obj).tail.equals(tail);
        resultaat = resultaat && ((Snake) obj).version.equals(version);

        return resultaat;
    }



    public static Snake getSnakeByAuthor(String author) {
        for (Snake snake : AppManager.getAppManager().getAlleSnakes()) {
            if (snake.getAuthor().equals(author)) {
                return snake;
            }
        }
        return null;
    }


    public String getApiversion() {
        return apiversion;
    }

    public void setApiversion(String apiversion) {
        this.apiversion = apiversion;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}

package nl.hu.bep.model;

import java.util.ArrayList;

public class Snake {
    private String apiversion;
    private String author;
    private String color;
    private String head;
    private String tail;
    private String version;

    private static ArrayList<Snake> alleSnakes = new ArrayList<>();

    
    public Snake(String apiversion, String author, String color, String head, String tail, String version) {
        this.apiversion = apiversion;
        this.author = author;
        this.color = color;
        this.head = head;
        this.tail = tail;
        this.version = version;

        getAlleSnakes().add(this);

    }

    public static Snake getSnakeByAuthor(String author) {
        for (Snake snake : getAlleSnakes()) {
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

    public static ArrayList<Snake> getAlleSnakes() {
        return alleSnakes;
    }

    public void setAlleSnakes(ArrayList<Snake> alleSnakes) {
        this.alleSnakes = alleSnakes;
    }
}

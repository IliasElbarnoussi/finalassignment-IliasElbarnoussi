package nl.hu.bep.model;

public class Snake {
    private String apiversion;
    private String author;
    private String color;
    private String head;
    private String tail;
    private String version;

//    constructor params
//    String apiversion, String author, String color, String head, String tail, String version
    public Snake() {
//        hardcoded data
        this.apiversion = "1";
        this.author = "ilias";
        this.color = "#888888";
        this.head = "default";
        this.tail = "default";
        this.version = "0.0.1-beta";

//        this.apiversion = apiversion;
//        this.author = author;
//        this.color = color;
//        this.head = head;
//        this.tail = tail;
//        this.version = version;
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

package nl.hu.bep;

import nl.hu.bep.model.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeTest {
    private Snake snake;

    @BeforeEach
    public void setup(){
        snake = new Snake("1", "ilias", "#ffffff", "default", "default", "0.0.1-beta");
    }

    @Test
    void TestGetAPIVersie() {
        assertEquals("1", snake.getApiversion());
    }

    @Test
    void TestSetAPIVersie() {
        snake.setApiversion("2");
        assertEquals("2", snake.getApiversion());
    }

    @Test
    void getAuthor() {
        assertEquals("ilias", snake.getAuthor());
    }

    @Test
    void setAuthor() {
        snake.setAuthor("iliasElbarnoussi");
        assertEquals("iliasElbarnoussi", snake.getAuthor());
    }

    @Test
    void getColor() {
        assertEquals("#ffffff", snake.getColor());
    }

    @Test
    void setColor() {
        snake.setColor("#77777");
        assertEquals("#77777", snake.getColor());
    }

    @Test
    void getHead() {
        assertEquals("default", snake.getHead());
    }

    @Test
    void setHead() {
        snake.setHead("beluga");
        assertEquals("beluga", snake.getHead());
    }

    @Test
    void getTail() {
        assertEquals("default", snake.getTail());
    }

    @Test
    void setTail() {
        snake.setTail("round-bum");
        assertEquals("round-bum", snake.getTail());
    }

    @Test
    void getVersion() {
        assertEquals("0.0.1-beta", snake.getVersion());
    }

    @Test
    void setVersion() {
        snake.setVersion("0.0.2-beta");
        assertEquals("0.0.2-beta", snake.getVersion());

    }
}

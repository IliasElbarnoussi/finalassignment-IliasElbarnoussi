package nl.hu.bep.jacksonrequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoveRequest {
    public HashMap<String, Object> game;
    public int turn;
    public HashMap<String, Object> board;
    public HashMap<String, Object> you;
}

package entity;

import java.util.List;
import java.util.Map;

public class Match {
    private  Board board;
    Map<String,Map.Entry<Player,Integer> >players;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Map<String, Map.Entry<Player, Integer>> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Map.Entry<Player, Integer>> players) {
        this.players = players;
    }

    public Match(Board board, Map<String, Map.Entry<Player, Integer>> players) {
        this.board = board;
        this.players = players;
    }
}

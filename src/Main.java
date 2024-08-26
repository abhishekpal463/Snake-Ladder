import entity.*;
import service.MatchManager;
import service.implementation.MatchManagerImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int noOfSnakes = sc.nextInt();
        List<Snake> snakes = new ArrayList<>();
        for(int i=0;i<noOfSnakes;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            Snake s = new Snake(start,end);
            snakes.add(s);
        }

        int noOfLadder = sc.nextInt();
        List<Ladder> ladders = new ArrayList<>();
        for(int i=0;i<noOfLadder;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            Ladder l = new Ladder(start,end);
            ladders.add(l);
        }

        int noOfPlayers = sc.nextInt();
        Map<String,Map.Entry<Player,Integer>> players = new HashMap<>();
        for(int i=0;i<noOfPlayers;i++){
            String name = sc.next();

            Player p = new Player(name);
            Map.Entry<Player,Integer> mp = new AbstractMap.SimpleEntry(p,0);
            players.put(name,mp);
        }

        Board board = new Board(size,snakes,ladders);
        Match match = new Match(board,players);
        MatchManager matchManager = new MatchManagerImpl();
        matchManager.start(match);

    }
}
package service.implementation;

import entity.*;
import service.MatchManager;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MatchManagerImpl implements MatchManager {

    @Override
    public void start(Match game) {
        Map<String, Map.Entry<Player,Integer> > players = game.getPlayers();
        Board board = game.getBoard();

        List<Ladder> ladders = board.getLadders();
        List<Snake> snakes = board.getSnakes();

        boolean flag = true;
        String Winner="";
        while (flag) {
            for(String key : players.keySet()){
                Map.Entry<Player, Integer> mp = players.get(key);

                // throwing dice
                int dice = throwDice();

                //fetching players the details
                Player p = mp.getKey();
                int position = mp.getValue();
                String name = p.getName();
                int newPosition = position+dice;

                newPosition = useLadder(ladders,newPosition);
                newPosition = useSnake(snakes,newPosition);

                if(newPosition<=100) {
                    System.out.println(name + " rolled a " + dice + " and move from " + position + " to " + newPosition);
                    Map.Entry newEntry = new AbstractMap.SimpleEntry(p, newPosition);
                    players.put(key, newEntry);

                    if (newPosition >= 100) {
                        flag = false;
                        Winner = name;
                        break;
                    }
                }
            }
        }

        System.out.println(Winner + " wins the game");

    }

    int throwDice(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    int useLadder(List<Ladder>ladders,int position) {
        for(Ladder ladder:ladders){
            if(ladder.getStart()==position){
                position=ladder.getEnd();
                System.out.println("Hhhhhhhhhhhhhhhh Ladder the game");
                break;
            }
        }
        return position;
    }

    int useSnake(List<Snake>snakes,int position) {
        for(Snake snake:snakes){
            if(snake.getStart()==position){
                position=snake.getEnd();
                System.out.println("Hhhhhhhhhhhhhhhh snake the game");
                break;
            }
        }
        return position;
    }
}

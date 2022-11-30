import java.util.ArrayList;

public class Game {
    protected ArrayList<Player>  players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }
    public Player regPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
    public int round(String name1, String name2) {
        Player player1 = regPlayer(name1);
        Player player2 = regPlayer(name2);

        if (player1 == null) {
            throw new NotRegisteredException(" Игрок " + name1 + " не зарегистрирован ");
        }
        if (player2 == null) {
            throw new NotRegisteredException(" Игрок " + name2 + " не зарегистрирован ");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }

    }
}

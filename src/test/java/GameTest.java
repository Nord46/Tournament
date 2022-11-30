import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Kolya", 3);
    Player player2 = new Player(2, "Vasya", 5);
    Player player3 = new Player(3, "Anna", 7);
    Player player4 = new Player(4, "Lana", 6);

    @Test
    public void firstPlayerWin() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 1;
        int actual = game.round("Anna", "Lana");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void playersEqual() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Vasya", "Vasya");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 2;
        int actual = game.round("Kolya", "Lana");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void unregisteredFirstPlayer() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Maksim", "Anna");
        });

    }

    @Test
    public void unregisteredSecondPlayer() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vasya", "Kristina");
        });

    }

}

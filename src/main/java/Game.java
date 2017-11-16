
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players;
    boolean[] barrels = new boolean[90];

    private void startGame(BufferedReader reader) throws IOException {
        players = new ArrayList<>(2);
        players.add(new Human());
        players.add(new Computer(reader));
        int barrel;
        while (true) {
            barrel = takeBarrel();
            for (Player player : players) {
                player.deleteField(barrel, reader);
                if (player.isWin() || player.isHasError())
                    return;
            }
        }
    }

    private int takeBarrel() {
        int barrel = 0;
        while (true) {
            barrel = (int) (Math.random() * 90 + 1);
            if (!barrels[barrel]) {
                barrels[barrel] = true;
                return barrel;
            }
        }
    }

    private boolean isRepeat(BufferedReader reader) throws IOException {
        String answer;
        while (true) {
            System.out.println("Do you want to play again? Input 'y' or 'n':");
            answer = reader.readLine();
            if (answer.equals("y"))
                return true;
            else if (answer.equals("n"))
                return false;
        }
    }

    public void run() throws IOException {
        boolean repeat = true;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            while (repeat) {
                startGame(reader);
                repeat = isRepeat(reader);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

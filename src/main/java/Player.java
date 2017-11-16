import java.io.BufferedReader;
import java.io.IOException;

public abstract class Player {
    Card card;
    boolean hasError = false;

    public Player() {
        card = new Card();
    }

    abstract void deleteField(int barrelValue, BufferedReader reader) throws IOException;

    abstract boolean isWin();

    abstract boolean isHasError();
}

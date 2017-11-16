import java.io.BufferedReader;
import java.io.IOException;

public class Human extends Player {

    public Human() {
    }

    @Override
    public void deleteField(int barrelValue, BufferedReader reader) throws IOException {
        String ans;
        System.out.println("Value of barrel is: " + barrelValue);
        card.printCard();
        while (true) {
            System.out.println("Input 'y' if you have this and 'n' if haven't:");
            ans = reader.readLine();
            if (ans.equals("y") || ans.equals("n")) break;
        }
        if ((ans.equals("y") && !card.deleteField(barrelValue))
                || (ans.equals("n") && card.deleteField(barrelValue)))
            hasError = true;
    }

    @Override
    boolean isWin() {
        if (card.isEmpty()) {
            System.out.println("You are win!");
            return true;
        } else
            return false;
    }

    @Override
    boolean isHasError() {
        if (hasError)
            System.out.println("You make a mistake. You are loser.");
        return hasError;
    }
}

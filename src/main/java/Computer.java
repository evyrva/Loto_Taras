
import java.io.BufferedReader;
import java.io.IOException;

public class Computer extends Player {
    double probabilityError;

    public Computer(BufferedReader reader) {
        double probabilityError = 0;
        try{
            System.out.println("Input probability of computers error (from 0 to 100)");
            probabilityError = Double.valueOf(reader.readLine())/100D;
        } catch (IOException e){
            e.printStackTrace();
        }
        this.probabilityError = probabilityError;
    }

    @Override
    void deleteField(int barrelValue, BufferedReader reader) throws IOException {
        double rand = Math.random();
        if (rand<=probabilityError){
            hasError = true;
        } else
            card.deleteField(barrelValue);
    }

    @Override
    boolean isWin() {
        if (card.isEmpty()){
            System.out.println("Computer is winner");
            return true;
        } else
            return false;
    }

    @Override
    boolean isHasError() {
        if (hasError)
            System.out.println("Computer makes a mistake. You are winner.");
        return hasError;
    }


}

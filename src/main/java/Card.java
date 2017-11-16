
import java.util.Arrays;

public class Card {
    private int rows = 3, columns = 9, countOfEmptyFields = 4;
    private int[][] fields;

    public Card() {
        fields = createFields();
    }

    public Card(int rows, int columns, int countOfEmptyFields) {
        this.rows = rows;
        this.columns = columns;
        this.countOfEmptyFields = countOfEmptyFields;
        fields = createFields();
    }

    private int[][] createFields(){
        int[][] table = new int[rows][columns];
        int countEmptyFields = countOfEmptyFields;
        int[] emptyFields = new int[countEmptyFields];
        boolean[] valueFields = new boolean[90];
        int randomValue;
        for (int i = 0; i < rows; i++) {
            emptyFields = new int[countEmptyFields];
            int count = 0;
            while (count < countEmptyFields) {
                int randomField = (int) (Math.random() * columns + 1);
                if (!Arrays.toString(emptyFields).contains(randomField + "")) {
                    emptyFields[count] = randomField;
                    count++;
                }
            }
            for (int j = 0; j < columns; j++) {
                if(!Arrays.toString(emptyFields).contains((j+1)+"")){
                    while(true){
                        randomValue = (int) (Math.random()*90);
                        if (!valueFields[randomValue]){
                            valueFields[randomValue] = true;
                            break;
                        }
                    }
                    table[i][j] = randomValue;
                }
            }
        }
        return table;
    }

    public void printCard(){
        System.out.println("Your card:");
        for (int i = 0; i < (columns+1)*3; i++) {
            System.out.print("=");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print("||");
            for (int j = 0; j < columns; j++) {
                if (fields[i][j] == 0){
                    System.out.print("  |");
                } else if (fields[i][j] < 10){
                    System.out.print(" " + fields[i][j] + "|");
                } else{
                    System.out.print(fields[i][j] + "|");
                }
            }
            System.out.println("|");
        }
        for (int i = 0; i < (columns+1)*3; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public boolean deleteField(int gamerValue){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(fields[i][j] == gamerValue){
                    fields[i][j] = 0;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEmpty(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(fields[i][j] != 0)
                    return false;
            }
        }
        return true;
    }


}

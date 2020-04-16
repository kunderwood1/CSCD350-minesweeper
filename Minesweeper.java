import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
public class Minesweeper {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        PrintStream output = new PrintStream(new File(args[1]));
        Scanner fin = new Scanner(file);
        int numberOfFields = 1;
        while (fin.hasNext()) {
            output.println("Field #" + numberOfFields + ":");
            numberOfFields = numberOfFields + fieldBuilder(fin, output);
        }
    }
    private static int fieldBuilder(Scanner fin,PrintStream output) {
        String[] unfilteredRowColumns = fin.nextLine().trim().split(" ");

        System.out.println(Arrays.toString(unfilteredRowColumns));
        int[] rowsColumns = new int[2];
        rowsColumns[0] = Integer.parseInt(unfilteredRowColumns[0]);
        rowsColumns[1] = Integer.parseInt(unfilteredRowColumns[1]);
        if(rowsColumns[1]*rowsColumns[0]==0) {
            return 0;
        }

        String[][] field = new String[rowsColumns[0]][rowsColumns[1]];
        Object[][] hintField = new Object[rowsColumns[0]][rowsColumns[1]];
        for(int row = 0; row < rowsColumns[0]; row++) {
            String rowFromInput=fin.next();
            for(int column = 0; column < rowsColumns[1]; column++){
                field[row][column]= String.valueOf(rowFromInput.charAt(column));
            }
        }
        for(int row = 0; row < rowsColumns[0]; row++) {
            for(int column = 0; column < rowsColumns[1]; column++){
                if(field[row][column].equalsIgnoreCase(".")){
                    hintField[row][column]=0;
                }
                else
                    hintField[row][column]='*';
            }
        }
        for(int row = 0; row < rowsColumns[0]; row++) {
            for (int column = 0; column < rowsColumns[1]; column++) {
                hints(hintField,row, column);

            }
        }
        for(int row = 0; row < rowsColumns[0]; row++) {
            for(int column = 0; column < rowsColumns[1]; column++) {
                output.print(hintField[row][column]);
            }
            output.println();
        }
        output.println();
        fin.nextLine();
        return 1;
    }
    private static void hints(Object[][] hintField, int row, int column) {
        if(hintField[row][column].equals('*'))
            return;
        int tempHints = 0;
        try {
            if ((hintField[row + 1][column - 1].equals('*')))
                tempHints=tempHints+1;
        }catch (Exception ignored){}
        try{
            if((hintField[row + 1][column].equals('*')))
                tempHints=tempHints+1;
        }catch (Exception ignored){}
        try{
            if((hintField[row + 1][column+1].equals('*')))
                tempHints=tempHints+1;
        }catch (Exception ignored){}
        try{
            if((hintField[row][column-1].equals('*')))
                tempHints=tempHints+1;
        }catch (Exception ignored){}
        try{
            if((hintField[row][column+1].equals('*')))
                tempHints=tempHints+1;
        }catch (Exception ignored){}
        try{
            if((hintField[row -1][column-1].equals('*')))
                tempHints=tempHints+1;
        }catch (Exception ignored){}
        try{
            if((hintField[row -1][column].equals('*')))
                tempHints=tempHints+1;
        }catch (Exception ignored){}
        try{
            if((hintField[row -1][column+1].equals('*')))
                tempHints=tempHints+1;
        }catch (Exception ignored){}
        hintField[row][column]= tempHints;
        System.out.println(tempHints+":"+hintField[row][column]);
    }
}
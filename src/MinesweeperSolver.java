import java.io.PrintStream;
import java.util.Scanner;

public class MinesweeperSolver {

    private int fieldBuilder(final int numOfFields, final Scanner fin, final PrintStream output) {
        String[] unfilteredRowColumns = fin.nextLine().trim().split(" ");
        int[] rowsColumns = new int[2];
        rowsColumns[0] = Integer.parseInt(unfilteredRowColumns[0]);
        rowsColumns[1] = Integer.parseInt(unfilteredRowColumns[1]);

        if(rowsColumns[1]*rowsColumns[0]==0) {
            return 0;
        }
        output.println("Field #" + numOfFields + ":");

        String[][] field = new String[rowsColumns[0]][rowsColumns[1]];
        Object[][] hintField = new Object[rowsColumns[0]][rowsColumns[1]];
        for(int row = 0; row < rowsColumns[0]; row++) {
            String rowFromInput=fin.next();
            for(int column = 0; column < rowsColumns[1]; column++){
                field[row][column]= String.valueOf(rowFromInput.charAt(column));
            }//end of column for loop
        }//end of rows for loop
        for(int row = 0; row < rowsColumns[0]; row++) {
            for(int column = 0; column < rowsColumns[1]; column++){
                if(field[row][column].equalsIgnoreCase(".")){
                    hintField[row][column]=0;
                }
                else
                    hintField[row][column]='*';
            }//end of column for loop
        }//end of rows for loop
        for(int row = 0; row < rowsColumns[0]; row++) {
            for (int column = 0; column < rowsColumns[1]; column++) {
                hints(hintField,row, column);
            }//end of column for loop
        }//end of rows for loop
        for(int row = 0; row < rowsColumns[0]; row++) {
            for(int column = 0; column < rowsColumns[1]; column++) {
                output.print(hintField[row][column]);
            }//end of column for loop
            output.println();
        }//end of row for loop
        output.println();
        fin.nextLine();
        return 1;
    }

    private void hints(final Object[][] hintField, final int row, final int column) {
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
    }
}

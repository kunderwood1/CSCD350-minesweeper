import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
/*
author: Kevin Underwood
CSCD350 -Team assignment1
*/
public class kunderwood_Minesweeper {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        //File file = new File("mineMap.txt");
        PrintStream output = new PrintStream(new File(args[1]));
        //PrintStream output = new PrintStream(new File("output.txt"));
        Scanner fin = new Scanner(file);
        int numberOfFields = 1;
        while (fin.hasNext()) {
            numberOfFields = numberOfFields + fieldBuilder(numberOfFields,fin, output);
        }
    }


    private static int fieldBuilder(int numberOfFields,Scanner fin,PrintStream output) {
        String[] unfilteredRowColumns = fin.nextLine().trim().split(" ");
        int[] rowsColumns = new int[2];
        rowsColumns[0] = Integer.parseInt(unfilteredRowColumns[0]);
        rowsColumns[1] = Integer.parseInt(unfilteredRowColumns[1]);

        if(rowsColumns[1]*rowsColumns[0]==0) {
            return 0;
        }
        output.println("Field #" + numberOfFields + ":");

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
    }
}
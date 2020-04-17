import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class MinefieldBuilderDamien {


    public static void main(String[] args) throws IOException {

        int x = 0;
        int y = 0;

        try {

            File f = new File(args[0]); //this is the first line of text from Command line
            if(f.createNewFile()) {

                PrintWriter fileIn = new PrintWriter(f);

                Scanner kb = new Scanner(System.in);
                System.out.println("Num of Columns and rows? (input -> # #)");
                int[] dimensions = stringConversion(kb.nextLine().split(" ")); //gives us numbers.

                do {

                    if(dimensions[0] == 0 && dimensions[1] == 0) {
                        break;
                    }

                    System.out.println("What percentage of mines do you wish to have (0-100)?");
                    int percent = Integer.valueOf(kb.nextLine());

                    printMineField(dimensions,fileIn, percent);
                    dimensions = stringConversion(kb.nextLine().split(" ")); //gives us numbers.


                }while(dimensions[0] != 0 && dimensions[1] != 0); //end of do while loop

                fileIn.println("0 0");
                fileIn.close();
                kb.close();
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    private static void printMineField(final int[] dimensions, final PrintWriter fileIn,int percent) {

        char[][] temp_MineField = new char[dimensions[0]][dimensions[1]];
        initMineField(temp_MineField, calcNumOfMines(percent, dimensions));

        fileIn.println(dimensions[0] + " " + dimensions[1]);
        for(int i = 0; i<dimensions[0]; i++)
        {
            for(int j = 0; j<dimensions[1]; j++)
            {
                fileIn.print(temp_MineField[i][j]);
            }//end of j for loop
            fileIn.println();
        }//end of i for loop
    }


    private static void initMineField(char[][] array, int numOfMines) {
        for(int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[0].length; x++) {
                array[y][x] = '.';
            }//end of x for loop
        }//end of y for loop

        Random rng = new Random();
        for(int i = 0; i < numOfMines; i++) {
            int y = rng.nextInt(array.length);
            int x = rng.nextInt(array[0].length);

            array[y][x] = '*';
        }
    }


    private static int calcNumOfMines(int percent, int[] dimensions) {

        double numOfMines = 0.0;
        numOfMines = dimensions[0] * dimensions[1];
        numOfMines = numOfMines * (percent / 100.0);

        return (int)numOfMines;
    }


    private static int[] stringConversion(final String[] input) {

        int[] arr = new int[2];
        arr[0] = Integer.valueOf(input[0]);
        arr[1] = Integer.valueOf(input[1]);

        return arr;
    }

}

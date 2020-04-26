import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MinesweeperDamien {

    public static void main(String[] args) {
        try {
            File fin = new File(args[0]);
            File fout = new File(args[1]);
            Scanner fileIn = new Scanner(fin);
            PrintWriter newFile = new PrintWriter(fout);
            int[] dim = new int[2];
            dim = stringConversion(fileIn.nextLine().split(" "));
            int fieldNum = 0;

            do {

                char[][] noNumbersMinefield = parseFile(fileIn, dim);


                int count = 0;

                for(int y = 0; y < noNumbersMinefield.length; y++) {
                    for(int x = 0; x < noNumbersMinefield[0].length; x++) {
                        if(noNumbersMinefield[y][x] =='*') {
                            count++;
                        }
                    }
                }

                int[] mineY = new int[count];
                int[] mineX = new int[count];

                int locationCount = 0;
                for(int y = 0; y < noNumbersMinefield.length; y++) {
                    for(int x = 0; x < noNumbersMinefield[0].length; x++) {
                        if(noNumbersMinefield[y][x] =='*') {
                            mineY[locationCount] = y;
                            mineX[locationCount] = x;
                            locationCount++;
                        }
                    }//end of x for loop
                }//end of y for loop


                Object[][] cheatSheet = initCheatSheet(noNumbersMinefield, dim, mineY, mineX);
                printToFile(newFile, cheatSheet, fieldNum);
                fieldNum++;

                if(!fileIn.hasNext())
                    break;
                dim = stringConversion(fileIn.nextLine().split(" "));
            }while(dim[0] != 0 && dim[1] != 0);

            fileIn.close();
            newFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    private static void printToFile(PrintWriter newFile, Object[][] cheatSheet, int fieldNum) {
        newFile.println("Field #" + fieldNum +":");

        for(int i = 0; i<cheatSheet.length; i++)
        {
            for(int j = 0; j<cheatSheet[1].length; j++)
            {
                newFile.print(cheatSheet[i][j]);
            }//end of j for loop

            newFile.println();
        }//end of i for loop
        newFile.println();

    }


    private static Object[][] initCheatSheet(char[][] mineField, int[] dimensions, int[] mineY, int[] mineX) {
        int[][]temp_IntArray = initIntArray(dimensions, mineY, mineX, mineField);
        Object[][] temp_CheatSheet = new Object[dimensions[0]][dimensions[1]];
        for(int y = 0; y < dimensions[0]; y++) {
            for(int x = 0; x < dimensions[1]; x++) {

                if(checkForMines(y,x,mineY,mineX)) {
                    temp_CheatSheet[y][x] = '*';
                }
                else {
                    temp_CheatSheet[y][x] = temp_IntArray[y][x];
                }
            }//end of x for loop
        }//end of y for loop
        return temp_CheatSheet;
    }


    private static boolean checkForMines(int y, int x, int[] mineY, int[] mineX) {

        for(int i = 0; i < mineX.length; i++) {
            if(mineX[i] == x && mineY[i] == y)
                return true;
        }
        return false;
    }


    private static int[][] initIntArray(int[] dimensions, int[] mineY, int[] mineX, char[][] mineField) {
        int[][] temp_IntArray = new int[dimensions[0]][dimensions[1]];
        for(int y = 0; y < dimensions[0]; y++) {
            for(int x = 0; x < dimensions[1]; x++) {
                temp_IntArray[y][x] = 0;
            }
        }

        for(int i = 0; i < mineY.length; i++) {
            int y = mineY[i];
            int x = mineX[i];

            if(y-1 >= 0)
                if(mineField[y-1][x] != '*')
                    temp_IntArray[y-1][x]++;
            if(y+1 < dimensions[0])
                if(mineField[y+1][x] != '*')
                    temp_IntArray[y+1][x]++;
            if(x-1 >= 0)
                if(mineField[y][x-1] != '*')
                    temp_IntArray[y][x-1]++;
            if(x+1 < dimensions[1])
                if(mineField[y][x+1] != '*')
                    temp_IntArray[y][x+1]++;

            //Cross pattern checked for mines

            if(y-1 >= 0 && x-1 >= 0)
                if(mineField[y-1][x-1] != '*')
                    temp_IntArray[y-1][x-1]++;
            if(y-1 >= 0 && x+1 < dimensions[1])
                if(mineField[y-1][x+1] != '*')
                    temp_IntArray[y-1][x+1]++;
            if(y+1 < dimensions[0] && x-1 >= 0)
                if(mineField[y+1][x-1] != '*')
                    temp_IntArray[y+1][x-1]++;
            if(y+1 < dimensions[0] && x+1 < dimensions[1])
                if(mineField[y+1][x+1] != '*')
                    temp_IntArray[y+1][x+1]++;
            //x pattern checked for mines
        }//end of i for loop


        return temp_IntArray;
    }


    private static char[][] parseFile(Scanner fileIn, int[] dim) {
        char[][] temp_MineArray = new char[dim[0]][dim[1]];

        for(int y = 0; y < dim[0]; y++) {
            String temp_ToCharArray = fileIn.nextLine(); //gives us the string line
            char[] temp_CharArray = temp_ToCharArray.toCharArray();
            temp_MineArray[y] = temp_CharArray;
        }//end of y for loop

        return temp_MineArray;
    }


    private static int[] stringConversion(final String[] input) {
        int[] arr = new int[2];
        arr[0] = Integer.valueOf(input[0]);
        arr[1] = Integer.valueOf(input[1]);
        return arr;
    }


}




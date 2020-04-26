import java.io.*;
import java.util.Scanner;
/*
author: Kevin Underwood
CSCD350 -Team assignment1
*/
public class Official_Minesweeper_builder {
    public static void main(String[] args) {
        PrintStream output = null;
        try {
            output = new PrintStream(new File("mineMap.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Bad printstream in MINESBuilder");
            e.printStackTrace();
        }
        Scanner kb = new Scanner(System.in);
        int percentOfMines;
        int numberRows;
        int numberColumns;
        System.out.println("Please enter the number of Rows you want to have:");
        numberRows = kb.nextInt();
        System.out.println("Please enter the number of Columns you want to have:");
        numberColumns=kb.nextInt();
        System.out.println("What is the percentage of mines you want to have?(0-100)");
        percentOfMines =kb.nextInt();
        while(numberRows > 0 && numberColumns >0){
            assert output != null;
            output.println(numberColumns+" "+numberRows);
            for (int column = 0; column < numberColumns; column++){
                for(int row=0;row<numberRows;row++) {
                    char c;
                    if((int)(Math.random() * 100) < percentOfMines) {
                        c='*';
                    }else
                        c='.';
                    output.print(c);
                }
                output.println();
            }
            System.out.println("Please enter the number of Rows you want to have:");
            numberRows = kb.nextInt();

            System.out.println("Please enter the number of Columns you want to have:");
            numberColumns=kb.nextInt();

            System.out.println("What is the percentage of mines you want to have?(0-100)");
            percentOfMines =kb.nextInt();
        }
        if(numberRows == 0 && numberColumns ==0){
            output.println(numberRows+" "+numberColumns);
        }
    }
}
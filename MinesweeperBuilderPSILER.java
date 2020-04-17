package minesweeperBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MinesweeperBuilderPSILER {

	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("mineField.txt");
		PrintStream output = new PrintStream(file);
		
		Scanner sc = new Scanner(System.in);
		
		int minePct, x, y;
		System.out.println("Welcome to MinesweeperBuilder. When rows = 0 and columns = 0, the program will terminate. \r\n"
				+ "The program uses percentage as a basis, it is not precise unless you create very large minefields.");
		do {
		System.out.print("How many rows: ");
		x = sc.nextInt();
		System.out.print("How many columns: ");
		y = sc.nextInt();
		if (x == 0 && y == 0)
			break;
		System.out.print("What percentage of mines: ");
		minePct = sc.nextInt();	
		output.println(y + " " + x);
		for (int a = 0; a < y; a ++)
		{
			for (int b = 0; b < x; b++)
			{
				
				if ((int)(Math.random()*100)<minePct)
					output.print('*');
				else
					output.print('.');
			}
			output.println();
		}
		
		
		}while (x != 0 && y != 0);
		
		sc.close();
		output.close();
	}


	
}

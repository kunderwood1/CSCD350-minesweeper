package minesweeper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MinesweeperPSiler {

	public static void main(String[] args) throws FileNotFoundException
	{
		long startTime = System.nanoTime();
		File file = new File(args[0]);

		int fieldCount = 0;
		Scanner sc = new Scanner(file);
		
		while (sc.hasNext())
		{
			if (sc.hasNextInt())
				{
					fieldCount ++;
					fieldCreator(sc, fieldCount);
				}
		}
			
		sc.close();
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
	}//end main

	private static void fieldCreator(Scanner sc, int fieldCount) {

		String[] toNums = sc.nextLine().split(" ");
		int[] nums = new int[2];
		nums[0] = Integer.parseInt(toNums[0]);
		nums[1] = Integer.parseInt(toNums[1]);
		
		if (nums[0]*nums[1]==0)
			return;
		
		int[][] field = new int[nums[0]][nums[1]];
		for (int y = 0; y < nums[0]; y ++)
		{
			String mineLine = sc.next();
			for(int x = 0; x < nums[1]; x ++)
			{
				String myChar = Character.toString(mineLine.charAt(x));
				
				if (myChar.contains("*"))//contains is a bad method to use here
				{
					field[y][x] = -1;
				}			
			}
		}//end for loop that fills array
		if (sc.hasNext())
			sc.nextLine();
		String[][]fullField = fillField(field);
		System.out.println("Field #" + fieldCount + ":");
		for (int y = 0; y < field.length; y ++)
			System.out.println(Arrays.toString(fullField[y]).trim());
		System.out.println();
	}

	private static String[][] fillField(int[][] field) {

		String[][]filledField = new String[field.length][field[0].length];
		
		for (int y = 0; y<field[0].length; y++)
		{
			for (int x = 0; x<field.length; x ++)
			{
				filledField[x][y] = fillGrid(field, x, y);
			}
		}

		return filledField;
	}

	private static String fillGrid(int[][] field, int x, int y) {
		int mineCount = 0;

		if (field.length==1 && field[0].length == 1)//checks if grid is 1*1
		{
			if (field[x][y]==-1)
				return "*";
		}
		
		else if (field[0].length==1)// if array is a vertical column
		{
			if (field[x][y]==-1)
				return "*";
			if (x == 0)
				{
				if (field[x+1][y]==-1)
					mineCount++;
				}
			else if (x == field.length-1)
				{
				if (field[x-1][y] == -1)
					mineCount++;
				}
			else
			{
				if (field[x+1][y] == -1)
					mineCount++;
				if (field[x-1][y] == -1)
					mineCount++;
			}
				
		}
		
		else if (field.length == 1)//this checks for horizontal lines
		{
			if (field[x][y] == -1)
				return "*";
			if (y==0)
			{
				if (field[x][y+1]==-1)
					mineCount++;
			}
			else if (y == field[0].length-1)
			{
				if (field[x][y-1]==-1)
					mineCount++;
			}
			else
			{
				if (field[x][y+1]==-1)
					mineCount++;
				if (field[x][y-1]==-1)
					mineCount++;
			}
		}

		else
		{
		if (field[x][y] == -1)
			return "*";
		else if (x == 0 && y == 0)
		{
			if (field[x][y+1] == -1)
				mineCount ++;
			if (field[x + 1][y] == -1)
				mineCount ++;
			if (field[x+1][y+1] == -1)
				mineCount ++;
		}//this checks the upper left hand corner
		else if (x == field.length-1 && y == 0)//this checks the upper right hand corner
		{
			if (field[x-1][y] == -1)
				mineCount ++;
			if (field[x][y+1]== -1)
				mineCount ++;
			if (field[x-1][y+1]==-1)
				mineCount ++;
		}
		else if (x == 0 && y == field[0].length-1)//this checks the lower left hand corner
		{
			if (field[x + 1][y] == -1)
				mineCount++;
			if (field[x][y-1] == -1)
				mineCount++;
			if (field[x+1][y-1] == -1)
				mineCount++;
		}
		else if (x == field.length-1 && y == field[0].length-1)//this checks the lower right hand corner
		{
			if (field[x-1][y]==-1)
				mineCount++;
			if (field[x][y-1]==-1)
				mineCount ++;
			if (field[x-1][y-1]==-1)
				mineCount ++;
		}
		else if (y == 0)//checks if number is on top row, must check surrounding five grids
		{
			if (field[x-1][y] == -1)
				mineCount ++;
			if (field[x-1][y+1] == -1)
				mineCount ++;
			if (field[x][y+1] == -1)
				mineCount ++;
			if (field[x+1][y+1] == -1)
				mineCount ++;
			if (field[x+1][y] == -1)
				mineCount ++;
		}
		else if (y == field[0].length-1)//checks if number is on bottom row
		{
			if (field[x-1][y] == -1)
				mineCount ++;
			if (field[x-1][y-1] == -1)
				mineCount ++;
			if (field[x][y-1] == -1)
				mineCount ++;
			if (field[x+1][y-1] == -1)
				mineCount ++;
			if (field[x+1][y] == -1)
				mineCount ++;
		}
		else if (x == 0)//checks if number is in lefthand column
		{
			if (field[x][y+1] == -1)
				mineCount ++;
			if (field[x+1][y+1] == -1)
				mineCount ++;
			if (field[x+1][y] == -1)
				mineCount ++;
			if (field[x+1][y-1] == -1)
				mineCount ++;
			if (field[x][y-1] == -1)
				mineCount ++;
		}
		else if (x == field.length-1)
		{
			if (field[x][y+1] == -1)
				mineCount ++;
			if (field[x-1][y+1] == -1)
				mineCount ++;
			if (field[x-1][y] == -1)
				mineCount ++;
			if (field[x-1][y-1] == -1)
				mineCount ++;
			if (field[x][y-1] == -1)
				mineCount ++;
		}
		else
		{
			if (field[x][y+1] == -1)
				mineCount ++;
			if (field[x-1][y+1] == -1)
				mineCount ++;
			if (field[x-1][y] == -1)
				mineCount ++;
			if (field[x-1][y-1] == -1)
				mineCount ++;
			if (field[x][y-1] == -1)
				mineCount ++;
			if (field[x+1][y+1] == -1)
				mineCount ++;
			if (field[x+1][y] == -1)
				mineCount ++;
			if (field[x+1][y-1] == -1)
				mineCount ++;
		}
		}
		return Integer.toString(mineCount);
	}
}

package assignment4;

import java.io.IOException;
import java.util.Scanner;

public class assignment4 {

	public static void main(String[] args) throws IOException {

		int board_size = 0;
		Scanner scan = new Scanner(System.in);
		

				try {
			

			System.out.println("Enter the size of the sudoku grid:");
			board_size = scan.nextInt();
			char[] symbols = new char[board_size];
			char[][] sudoku = new char[board_size][board_size];
			

			System.out.println("Enter the symbols for the sudoku game:");
			String symb=scan.next();
			if(symb.length()!=board_size)
				System.out.println("The number of symbols entered does not match the grid size");
			int k=0;
		    for(char s:symb.toCharArray())
				symbols[k++] = s;

			System.out.println("Enter the incomplete sudoke:");
		
			int i=0;
			while(i<board_size && scan.hasNext() ) 
			{
					String input=scan.next();
					matrixgeneration(input,board_size,i,sudoku);
					i++;
			}
			
			sudoku sku = new sudoku();
			if (sku.completesudoku(sudoku, symbols, sudoku.length)) {
				System.out.println("Solved Sudoku:");
				sku.print(sudoku, board_size);

			} else {
				System.out.println("No solution");
			}

		} catch (ArrayIndexOutOfBoundsException e1) {

			e1.printStackTrace();
			
		}finally {
			scan.close();

		}
	}

	/* The below logic has been developed in collaboration with B00824492*/
	
	private static void matrixgeneration(String input, int board_size, int i, char[][] sudoku) {
		
		// TODO Auto-generated method stub
		char[] lineinputs=new char[board_size];
		int j=0;
		for(char c:input.toCharArray())
		{
			lineinputs[j++]=c;
		}
		for(int k=0;k<board_size;k++)
		{
			sudoku[i][k]=lineinputs[k];
		}
	}

}

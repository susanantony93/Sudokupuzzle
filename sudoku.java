package assignment4;

public class sudoku {

	int size;
	char s[][] = new char[size][size];
	char[] symbol = new char[size];
	boolean cellempty = false;

	public boolean checkissafe(char s[][], char symbol, int size, int row, int col) {

		boolean safe = true;
		// for checking the columns
		for (int j = 0; j < size; j++) {
			if (s[row][j] == symbol) {
				safe = false;
				break;
			}

		}

		// for checking the columns
		for (int i = 0; i < size; i++) {
			if (s[i][col] == symbol) {
				safe = false;
				break;
			}

		}

		// for checking the box
		int sqrt = (int) Math.sqrt(size);
		int boxRowStartIndex = row - row % sqrt;
		int boxColStartIndex = col - col % sqrt;

		for (int i = boxRowStartIndex; i < boxRowStartIndex + sqrt; i++) {
			for (int j = boxColStartIndex; j < boxColStartIndex + sqrt; j++) {
				if (s[i][j] == symbol) {
					safe = false;
				}
			}
		}

		return safe;

	}

	public boolean completesudoku(char[][] s, char symbol[], int size) {
		int row = 0;
		int col = 0;
		boolean cellempty = false;
		outerloop: for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (s[i][j] == '.') {
					row = i;
					col = j;
					cellempty = true;
					break outerloop;
				}
			}
		}

		if (!cellempty)
			return true;

		for (int i = 0; i < size; i++) {
			if (checkissafe(s, symbol[i], size, row, col)) {
				s[row][col] = symbol[i];

				if (completesudoku(s, symbol, size)) {
					return true;
				} else
					s[row][col] = '.';
			}

		}
		return false;
	}

	public void print(char[][] s, int size) {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(s[i][j]);
			}
			System.out.print("\n");
		}

	}

}

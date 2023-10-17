package lab5;

import java.util.Arrays;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

	public TicTacToe(char[][] board) {
		super();
		this.board = board;
	}

	public boolean checkRows() {
		char c;
		int a;
		for (int i = 0; i < board.length; i++) {
			c = board[i][i];
			a = 0;
			for (int j = 0; j < board[i].length; j++) {
				if (c == board[i][j]) {
					a++;
				}
			}
			if (a == board.length) {
				return true;
			}

		}
		return false;
	}

	public boolean checkColumns() {
		char c;
		int a;
		for (int i = 0; i < board.length; i++) {
			c = board[i][i];
			a = 0;
			for (int j = 0; j < board[i].length; j++) {
				if (c == board[j][i]) {
					a++;
				}
			}
			if (a == board.length) {
				return true;
			}

		}
		return false;
	}

	public boolean checkDiagonals() {
		char c = board[board.length / 2][board[0].length / 2];
		int a = 0, b = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = i; j <= i; j++) {
				if (c == board[j][i]) {
					a++;
				}
				if (c == board[i][board.length - j - 1]) {
					b++;
				}
			}
			if (a == board.length || b == board.length) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] c = { { 'X', 'O', 'X' }, { 'O', 'X', 'X' }, { 'X', 'O', 'O' } };
		TicTacToe t = new TicTacToe(c);
		for (int i = 0; i < c.length; i++) {
			System.out.println(Arrays.toString(c[i]));
		}
		System.out.println("check row: " + t.checkRows());
		System.out.println("check column: " + t.checkColumns());
		System.out.println("check diagonals: " + t.checkDiagonals());

	}
}

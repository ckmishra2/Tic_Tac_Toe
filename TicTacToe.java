package wkshpr;

import java.util.Scanner;

public class TicTacToe {
	static char[] board = new char[10];
	static char playerLetter;
	static char computerLetter;

	public static void main(String[] args) {
		System.out.println("welcome to Tic Tac Toe GAME");
		board(); // calling the method board in main method
		chooseLetter();
		showBoard();
	}

	public static void board() {
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}

	}

	public static void chooseLetter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("please  select X  or O ");
		char userInput = sc.next().charAt(0); // allowing user to choose character using consol
		if (userInput == 'X') {
			playerLetter = userInput;
			computerLetter = 'O';
		} else if (userInput == 'O') {
			playerLetter = userInput;
			computerLetter = 'X';
		} else { // if user is entering wrong choice , default letter will be allocated
			System.out.println("wrong selection ! Now computer will assign letters.");
			computerLetter = 'X';
			playerLetter = 'O';
		}
		System.out.println("player letter is " + playerLetter);
		System.out.println("computer letter is " + computerLetter);
	}
	public static void showBoard() { // showing board status
		System.out.println(" " + board[1] + " |" + " " + board[2] + " |" + " " + board[3]);
		System.out.println("-----------");
		System.out.println(" " + board[4] + " |" + " " + board[5] + " |" + " " + board[6]);
		System.out.println("-----------");
		System.out.println(" " + board[7] + " |" + " " + board[8] + " |" + " " + board[9]);

	}

}

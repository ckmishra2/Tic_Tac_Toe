package wkshpr;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static char[] board = new char[10];
	static char playerLetter;
	static char computerLetter;
	static int count;
	static Scanner sc = new Scanner(System.in);
	static Random rm = new Random();

	public static void main(String[] args) {
		System.out.println("welcome to Tic Tac Toe GAME");
		board(); // calling the method board in main method
		chooseLetter();
		showBoard();
		play();
		showBoard();
		int toss = rm.nextInt(2) + 1;
		if (toss == 1) {
			System.out.println("player won the toss ! player will play first ");
			playerTurn();
		} else {
			System.out.println("Computer won the toss ! computer will play first ");
			computerTurn();
		}
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

	public static int isEmpty() {
		int count = 0;
		for (int i = 1; i <= 9; i++) {
			if (board[i] == ' ') {
				count++;
			}
		}
		return count;
	}
	public static void play() { // playing the next move 
	}
	public static void playerTurn() { 
		showBoard();
		boolean check = true;
		while (check) {
			count = isEmpty();
			if (count > 0) {
				System.out.println("Enter the place from 1 to 9 for your next move ");
				int place = sc.nextInt();
				if (place < 10 && place > 0) {
					if (board[place] == ' ') {
						board[place] = playerLetter;
						computerTurn();
						check = false;
					}

				}
			}
		}
	}

	public static void computerTurn() {
		boolean check = true;
		while (check) {
			count = isEmpty();
			if (count > 0) {
				int place = rm.nextInt(9) + 1;
				if (board[place] == ' ') {
					board[place] = computerLetter;
					playerTurn();
					check = false;
				} else {
					computerTurn();
				}

			} else {
				System.out.println("all 9 places are occupied !");
				check = false;
			}
		}
	}

}

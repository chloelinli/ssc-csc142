// Chloe Rushing
// 7/27/19
// This program is a guessing game in which the user wins when they guess the secret number within the limited number of guesses.

//package test;

import java.util.Scanner;

public class GuessMePractice {
	
	public static boolean playGame(Scanner console) {
		boolean guessed = false;
		System.out.println("Enter a range of numbers that you would like to use.");
		System.out.print("(Enter with one space between; must have at least 4 numbers in between) Ex. 0 10: ");
		
		int min = console.nextInt();
		int max = console.nextInt();
		int diff = max - min;
		while (diff < 4) {
			System.out.print("Invalid range. Please try again: ");
			min = console.nextInt();
			max = console.nextInt();
			diff = max - min;
		}
		int guessCount = 0;
		int numGuess = (max-min)/2;
		System.out.println("\nYour guess should be between " + min + " and " + max + ", inclusive.");
		System.out.println("You get a total of " + numGuess + " guesses.");
		int randomNum =  getRandomIntegerBetweenRange(min, max);
		System.out.print("Would you like to continue playing? ");
		String reply = console.next().toLowerCase();
		while (!reply.equals("y") && !reply.equals("yes") && !reply.equals("n") && ! reply.equals("no)")) {
			System.out.print("Invalid input. Please try again: ");
			reply = console.next().toLowerCase();
		}
		if (reply.equals("n") || reply.equals("no")) {
			guessed = true;
		}
		
		while (!guessed && (guessCount < numGuess) && (reply.equals("y") || reply.equals("yes"))) {
			guessCount++;
			System.out.print("\nGuess #" + guessCount + ": ");
			int guess = console.nextInt();
			while (guess < min || guess > max) {
				System.out.print("\nBeyond range. Please try again: ");
				guess = console.nextInt();
			}
			int hint = Math.abs((randomNum - guess));
			if (hint >= 1 && hint <= 2) {
				System.out.println("Warmer...Closer...You're getting there!");
			}
			else if (hint > (diff/10) && hint <= diff) {
				System.out.println("Yikes! Too far!");
			}
			else {
				if (guess != randomNum) {
					System.out.println("Not quite there yet!");
				}
			}
			if (guess == randomNum) {
				guessed = true;
				System.out.println("Congratulations, you found the magic number!");
			}
			else if (guessCount == numGuess && !guessed) {
				guessed = true;
				System.out.println("Sorry, you did not guess the number.");
			}
			else if (!guessed && guessCount < numGuess) {
				System.out.print("Would you like to continue the current game? ");
				reply = console.next().toLowerCase();
				while (!reply.equals("y") && !reply.equals("yes") && !reply.equals("n") && ! reply.equals("no)")) {
					System.out.print("Invalid input. Please try again: ");
					reply = console.next().toLowerCase();
				}
				if (reply.equals("n") || reply.equals("no")) {
					guessed = true;
				}
			}
		}
		return guessed;
	}
	
	public static int getRandomIntegerBetweenRange(double min, double max){
		int x = (int) ((Math.random()*((max-min)+1))+min);
		return x;
	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Hi -- Welcome to the Guessing Game.");
		System.out.println("To play you need to guess the magic number.");
		boolean result = playGame(console);
		String ans = "";
		
		while (result == true) {
			System.out.print("\nWould you like to play again? Yes or No? ");
			ans = console.next().toLowerCase();
			if (ans.length() == 1) {
				while (!ans.equals("y") && !ans.equals("n")) {
					System.out.print("Invalid input. Please try again: ");
					ans = console.next().toLowerCase();
				}
				if (ans.equals("y")) {
					System.out.println();
					result = playGame(console);
				}
				else if (ans.equals("n")) {
					result = false;
				}
			}
			else {
				while (!ans.equals("yes") && !ans.equals("no")) {
					System.out.print("Invalid input. Please try again: ");
					ans = console.next().toLowerCase();
				}
				if (ans.equals("yes")) {
					System.out.println();
					result = playGame(console);
				}
				else if (ans.equals("no")) {
					result = false;
				}
			}
		}
		
		System.out.println("\nThank you for playing this guessing game.");
	}
}
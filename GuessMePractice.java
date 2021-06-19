import java.util.*;

public class GuessMePractice {

	public static void main(String[] args) {
		// initialize scanner and prints
		Scanner console = new Scanner(System.in);
		System.out.println("Hi -- Welcome to the Guessing Game.");
		System.out.println("To play you need to guess the magic number.");

		// boolean for play - initially true for one game
		boolean play = true;

		// while play
		while (play) {
			// play game
			playGame(console);

			// ask for play
			System.out.print("\nWould you like to play again? [yes/no]: ");
			String keepPlay = console.next().toLowerCase();
			char[] keepArr = keepPlay.toCharArray();

			// while answer not y/n, loop
			while (keepArr[0] != 'y' && keepArr[0] != 'n') {
				System.out.print("Invalid input, please try again: ");
				keepPlay = console.next().toLowerCase();
				keepArr = keepPlay.toCharArray();
			}

			// if n boolean is false
			if (keepPlay.charAt(0) == 'n') {
				play = false;
				break;
			}
		}

		// print ty
		System.out.println("\nThank you for playing this guessing game.");
	}

	public static void playGame(Scanner console) {
		// boolean for correct
		boolean correct = false;

		// print statements for play
		System.out.println("Enter a range of numbers that you would like to use.");
		System.out.println("\tFormat: <#><space><#>");
		System.out.println("\tMust have at least 4 numbers within range. Ex: 0 10");

		// set range - check for invalid range
		int min = console.nextInt();
		int max = console.nextInt();
		int diff = max - min;
		while (diff < 4) {
			System.out.print("Invalid range, please try again. Valid format is <#><space><#>: ");
			min = console.nextInt();
			max = console.nextInt();
			diff = max - min;
		}

		// initialize answer, guess and prevGuess and things
		int guessCount = 0;
		int maxGuess = diff / 2;
		int answer = getRandomIntInRange(min, max);
		int currGuess = 0;
		int prevGuess = answer;

		// while not max guesses or not correct
		while (guessCount < maxGuess || !correct) {
			// get user guess
			System.out.println("\nYour guess should be between " + min + " and " + max + ", inclusive.");
			System.out.println("You have " + (maxGuess - guessCount) + " guess(es).");
			currGuess = console.nextInt();

			// if not in range loop for valid guess
			while (currGuess > max || currGuess < min) {
				System.out.print("Beyond range, please guess within " + min + " to " + max + ": ");
				currGuess = console.nextInt();
			}

			// count++
			guessCount++;

			// if correct change boolean
			if (currGuess == answer) {
				correct = true;
				break;
			}

			// else use prevGuess and print statements
			else {
				int dist = Math.abs(answer - currGuess);
				if (dist == 1) {
					System.out.println("Close!");
				} else if (dist < Math.abs(answer - prevGuess) && guessCount > 1) {
					System.out.println("Getting warmer!");
				} else if (dist + 1 == Math.abs(answer - prevGuess) && guessCount > 1) {
					System.out.println("Getting colder :(");
				} else {
					System.out.println("Not quite there.");
				}
			}
			if (guessCount == maxGuess) {
				break;
			}

			prevGuess = currGuess;
		}

		// if not correct print sorry
		if (!correct) {
			System.out.println("Sorry, you did not guess the number.");
		}
		// else print congrats
		else {
			System.out.println("Congratulations, you found the magic number!");
		}
	}

	public static int getRandomIntInRange(int min, int max) {
		return (int) Math.floor(Math.random()*(max-min+1)+min);
	}
}

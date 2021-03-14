// Chloe Rushing
// 8/11/19
// This program attempts to execute a conversation that might be carried
// out in a normal day, utilizing user input to accomplish this. It could
// end up super random, but hopefully it is close enough.

package test;

import java.util.*;

public class Chatbot {
	
	public static void main(String[] args) {
		// initializing useful methods and variables
		Scanner userInput = new Scanner(System.in);
		Random rand = new Random();
		
		// methods for conversation
		String userName = introduce(userInput, rand);
		conversation(userInput, rand, userName);
		System.out.println("Thanks for taking the time to chat with me! What an interesting conversation. Hope you liked the puns. Talk to you next time!");
	}
	
	public static String introduce(Scanner userInput, Random rand) {
		String name = chooseName(rand);
		System.out.println("Hey there, I'm " + name + ".");
		System.out.print("What would you prefer to go by? ");
		String userName = userInput.nextLine();
		userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
		return userName;
	}
	
	public static String chooseName(Random rand) {
		String[] names = {"Nancy", "Bob", "Sally", "Josh", "Emma", "Zach"};
		int nameIndex = rand.nextInt(names.length);
		return names[nameIndex];
	}
	
	public static void conversation(Scanner userInput, Random rand, String userName) {
		boolean endConvo = false;
		int n = rand.nextInt(4); // uses Random class to set conversation topic(s)
		String[] questions = new String[8];
		if (n == 0) {
			questions = generic();
		}
		else if (n == 1) {
			questions = fave();
		}
		else if (n == 2) {
			questions = extraRand();
		}
		else {
			questions = aboutUser();
		}
		System.out.println("These may get super random, so try to keep up muahaha.");
		int i = 0;
		String q = "";
		String extra = "";
		while (!endConvo && i < (questions.length)) {
			System.out.println();
			System.out.println(questions[i]);
			String user = userInput.nextLine();
			if (user.toLowerCase().contains("science") || user.toLowerCase().contains("scientist") || user.toLowerCase().contains("chemistry") || user.toLowerCase().contains("chemist")) {
				if (i == 1) {
					System.out.println(puns(0));
					String anAns = userInput.next();
					if (anAns.equals("K") || anAns.equals("k")) {
						System.out.println("Yay you understood what I meant. Haha moving on then.\n");
					}
					else {
						System.out.println("Aww you didn't get the joke. Ah well, guess that means we're moving on heh.\n");
					}
				}
			}
			else if (questions[i].contains("pretend to be")) {
				System.out.println("Hah that's fun. I pretended to be a potato. Actually, I do that all the time. " + userName + ", I hope we can be potatoes together sometimes. You know, " + puns(7));
			}
			else if (questions[i].contains("boba milk tea")) {
				if (user.equals("no") || user.toLowerCase().contains("never")) {
					System.out.println("Yikes. That's too bad, because you be missing that " + puns(1) + ". Get it, get it?");
				}
				q = questions[i];
			}
			else if (questions[i].contains("Coffee or tea?")) {
				if (user.toLowerCase().contains("tea")) {
					System.out.println("I love this joke. " + puns(4));
				}
				else if (user.toLowerCase().contains("coffee")) {
					System.out.println("Yes, another coffee appreciator. " + puns(5));
				}
				q = questions[i];
			}
			else if (questions[i].contains("whole day off")) {
				System.out.println("That sounds great. I would probably just binge watch anime.");
			}
			else if (questions[i].contains("bucket list")) {
				if (user.toLowerCase().contains("yes")) {
					q = questions[i] + " yes";
				}
				else if (user.toLowerCase().contains("no")) {
					q = questions[i] + " no";
				}
			}
			else if (questions[i].contains("artist or musician")) {
				q = questions[i] + " " + user;
			}
			else if (questions[i].contains("lucky number")) {
				System.out.println("Interesting. Apparently my lucky number is 6, but 7 has always worked out for me.");
			}
			else if (questions[i].contains("majoring")) {
				q = questions[i];
				extra = user;
			}
			else if (questions[i].contains("class or subject")) {
				if (user.toLowerCase().contains("math")) {
					System.out.println("Ooo here's my chance haha. " + puns(2));
				}
			}
			else if (questions[i].contains("chocolate")) {
				System.out.println(puns(6));
			}
			int x = rand.nextInt(questions.length);
			if (x == 5 || x == 2) {
				System.out.print("\nWould you like to end this conversation, and talk another time? ");
				boolean answer = answer(userInput);
				if (answer) {
					endConvo = true;
				}
				else {
					user = userInput.nextLine();
				}
			}
			i++;
		}
		System.out.println();
		if (q.contains("boba milk tea") || q.contains("or tea?")) {
			System.out.println(userName + ", my friend. That's it. We need to get together again and get a drink next time. Maybe some boba. Maybe some tea. Heh. Heh. " + puns(1));
		}
		else if (q.contains("artist or musician")) {
			System.out.println("You know, if I wasn't so broke I would totally buy you tickets to a concert.");
		}
		else if (q.contains("majoring")) {
			System.out.println("Well, " + userName + ", I hope that " + extra + " works out for you. Good luck!");
		}
		else if (q.contains("bucket list")) {
			int index = q.lastIndexOf(' ');
			String word = q.substring(index+1);
			if (word.equals("yes")) {
				System.out.println("Now let's see what we can do about that bucket list you said you had...");
			}
			else {
				System.out.println("C'mon, we should put together a bucket list for you so that you can feel like you experienced life more. Mhm, mhm.");
			}
		}
	}
	
	public static String[] generic() {
		String[] questions = new String[8];
		questions[0] = "Are you currently in school?";
		questions[1] = "What are you majoring, or planning on majoring, in?";
		questions[2] = "What made you decide to go for that?";
		questions[3] = "What kind of work do you or would you like to do?";
		questions[4] = "Well, I hope you enjoy what you go into. Now, do you have plans for the future? I won't pry any further hehe.";
		questions[5] = "What is your favorite animal? I...I don't have one anymore, at the moment.";
		questions[6] = "Are you allergic to anything, or any animal?";
		questions[7] = "Was this  really weird conversation? Don't worry, I won't be upset.";
		return questions;
	}
	
	public static String[] fave() {
		String[] questions = new String[8];
		questions[0] = "Do you enjoy participating or watching sports more?";
		questions[1] = "What was or is your favorite class or subject in school?";
		questions[2] = "What did you like about it?";
		questions[3] = "Coffee or tea? I drink both, but I'm more of a fan of tea.";
		questions[4] = "Favorite kind then. I enjoy most any tea, but I'm a huge fan of soy iced lattes at the moment.";
		questions[5] = "What's your favorite hobby?";
		questions[6] = "Favorite or lucky number?";
		questions[7] = "When guessing the \"secret\" number, do you prefer going first or last? Really goes either way, so.";
		return questions;
	}
	
	public static String[] extraRand() {
		String[] questions = new String[8];
		questions[0] = "I honestly don't understand selfies sometimes. What's so great about them?";
		questions[1] = "If you could hang out with any scientist for a day, who would it be?";
		questions[2] = "Do you like boba milk tea?";
		questions[3] = "If you could have a whole day off, no responsibilities, what would you do?";
		questions[4] = "Now what about a whole week? Would you take a vacation? Haha.";
		questions[5] = "If you got to go to a concert of the artist or musician of your choice, who would it be?";
		questions[6] = "I want chocolate now. How about you?";
		questions[7] = "Was there ever anything that you knew about once, and then it became popular all of a sudden? For me, it was SnapChat. So annoying.";
		return questions;
	}
	
	public static String[] aboutUser() {
		String[] questions = new String[8];
		questions[0] = "How many siblings do you have?";
		questions[1] = "When you were younger, what did you pretend to be?";
		questions[2] = "Gelato or ice cream?";
		questions[3] = "Which flavor? I love, love, love caramel anything.";
		questions[4] = "Do you have a bucket list?";
		questions[5] = "I used to be an extremely avid reader as a child. How much do you enjoy reading?";
		questions[6] = "Honestly, the only good part about rainy days for me is that I can curl up someplace warm and read and drink tea. What do you think?";
		questions[7] = "Do you have any pet peeves? Is me asking one of them haha.";
		return questions;
	}
	
	public static boolean answer(Scanner userInput) {
		boolean answer = false;
		String ans = userInput.next();
		ans = ans.toLowerCase();
		while (!ans.equals("yes") && !ans.equals("no") && !ans.equals("y") && !ans.equals("n")) {
			System.out.print("Invalid option. Please try again: ");
			ans = userInput.next();
			ans = ans.toLowerCase();
		}
		if (ans.length() == 1) {
			if (ans.equals("y")) {
				answer = true;
			}
			else {
				answer = false;
			}
		}
		else {
			if (ans.charAt(0) == 'y') {
				answer = true;
			}
			else {
				answer = false;
			}
		}
		return answer;
	}
	
	public static String puns(int n) {
		String[] puns = new String[8];
		// science pun
		puns[0] = "Oy, science puns are especially fantastic. Wanna hear a Potassium joke?";
		puns[1] = "positiviTEA";
		puns[2] = "Why should you worry about the math teacher holding graph paper?\n\tShe's definitely plotting something";
		puns[3] = "owl by myself";
		puns[4] = "How long does it take to brew Chinese tea?\n\tOolong time.";
		puns[5] = "I love you a latte now.";
		puns[6] = "You won’t believe it, but the price of chocolate has skyrocketed. The other day, I bought a galaxy, a milky way and a mars, it was unbelievably astronomical.";
		puns[7] = "potato puns are a-peeling though.";
		return puns[n];
	}
}
package fixedCalculator;
// This program is meant to perform simple mathematical calculations
// However, it has several bugs... (a dozen, more or less)
// Your job is to debug the program so that it works as intended

import java.util.Scanner;

public class FixedCalculator {

	public static void main(String[] args) { // main method
		boolean done = false;
		Scanner console = new Scanner(System.in);
		while (!done){
			displayMenu();
			String selection = getUsersSelection(console);
			done = processSelection(selection, console);
		}
		System.out.println("Thank you for using this program");
	}

	private static boolean processSelection(String selection, Scanner console) { // analyzes input of "E", "U", or "H" from getUsersSelection
		boolean done = false;
		if (!selection.equalsIgnoreCase("E")){ // "E" for Exit
			if (selection.equalsIgnoreCase("U")){ // "U" for Use program
				caluculateResults(console);
			}
			else if (selection.equalsIgnoreCase("A")) {
				advancedExpressions(console);
			}
			else if (selection.equalsIgnoreCase("H")){ // "H" for Help
				//nothing to do here...let the code loop around one more time
			}
			else {
				System.out.println("Incorrect entry...try again!\n");
			}
		}
		else {
			done = true;
		}
		return done;
	}

	private static void caluculateResults(Scanner console) {
		/* calculator method; simplifying expressions,
		does not accept regular expressions
		that don't require equals sign */
		displayCalculatorInstructions();
		double operand1 = console.nextDouble();
		char operator = console.next().charAt(0);
		double operand2 = console.nextDouble();
		double result = 0.0;
		boolean isOperatorValid = true;
		if (operator == '+'){
			result = operand1 + operand2;
		}
		else if (operator == '-'){
			result = operand1 - operand2;
		}
		else if (operator == '*'){
			result = operand1 * operand2;
		}
		else if (operator == '/'){
			if (operand2 != 0.0){
				result = operand1 / operand2;
			}
			else {
				result = Double.NaN; // Not a Number; e.g. 1/0, Math.sqrt(-n)
			}
		}
		else if (operator == '^'){
			result = Math.pow(operand1, operand2);
		}
		else {
			isOperatorValid = false;
		}
		if (isOperatorValid){
			String equals = "" + result;
			equals = equals.substring(equals.indexOf("."));
			if (equals.length() <= 5) {
				System.out.println(operand1 + " " + operator + " " + operand2 + " = " + result + "\n");
			}
			else {
				System.out.print(operand1 + " " + operator + " " + operand2 + " = ");
				System.out.printf("%.5f%n", result);
			}
			System.out.println("Would you like to use this program again?");
		}
		else { // if operator is not "+", "-", "*", "/", or "^"
			System.out.println("Expression not accepted. Would you like to try again?\n");
		}
	}

	private static void displayCalculatorInstructions() { // instructions for how to use "calculator"
		System.out.println();
		System.out.println("Enter a mathematical expression to evaluate");
		System.out.println("Valid operations are: +, -, *, /, ^ for power");
		System.out.println("Expression are entered with spaces between the values and operator");
		System.out.println("Here is the valid format:");
		System.out.println("\t<value><space><operator><space><value>");
		System.out.print("Your expression:\n");
	}
	
	private static String getUsersSelection(Scanner console) { // selection of "H", "U", or "E"; go to processSelection method
		String selection = console.next();
		return selection;
	}

	private static void displayMenu() { // menu for using program/calculator
		System.out.println("Enter one these options:");
		System.out.println("\tU for Using calculator");
		System.out.println("\tA for Advanced options");
		System.out.println("\tH for Help");
		System.out.println("\tE for Exiting this program");
		System.out.print("Your selection: ");
	}
	
	public static void advancedExpressions(Scanner console) {
		/* allows user to input expressions such as square roots,
		absolute value, and greater than/less/than/equal to */
		displayAdvancedInstructions();
		String advanced = console.next();
		if (advanced.toLowerCase().equals("type")) {
			advancedTypes(console);
		}
		else if (advanced.toLowerCase().equals("operation")) {
			advancedOperations(console);
		}
		else {
			System.out.println("Incorrect entry...try again!\n");
		}
		System.out.println("Would you like to use this program again?\n");
	}
	
	public static void advancedTypes(Scanner console) {
		displayTypeInstructions();
		String type = console.next(); // types are sqrt, abs
		double value = console.nextDouble();
		double result = 0.0;
		if (type.toLowerCase().equals("sqrt")) { // sqrt of positive number
			if (value > 0.0) {
				result = Math.sqrt(value); // positive sqrt
				String equals = "" + result;
				equals = equals.substring(equals.indexOf("."));
				if (equals.length() <= 5) {
					System.out.println("Square root of " + value + " = " + result + ", -" + result);
				}
				else {
					System.out.print("Square root of " + value + " = ");
					System.out.printf("%.5f", result);
					System.out.print(", -");
					System.out.printf("%.5f%n", result);
				}
			}
			else if (value == 0.0) {
				System.out.println("Square root of 0.0 = 0.0");
			}
			else if (value < 0.0) { // sqrt of negative number
				System.out.println("Imaginary number, cannot take square root");
			}
		}
		else if (type.toLowerCase().equals("abs")) {
			result = Math.abs(value);
			System.out.println("Absolute value of " + value + " = " + result);
		}
		else {
			System.out.println("Expression not accepted. Would you like to try again?\n");
		}
	}
	
	public static void advancedOperations(Scanner console) {
		displayOperInstructions();
		double value1 = console.nextDouble();
		String operator = console.next(); // operators are <, >, <=, >=, =
		double value2 = console.nextDouble();
		if (operator.equals("<")){
			System.out.print(value1 + " " + operator + " " + value2 + " is ");
			if (value1 < value2) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}
		else if (operator.equals(">")){
			System.out.print(value1 + " " + operator + " " + value2 + " is ");
			if (value1 > value2) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}
		else if (operator.equals("<=")){
			System.out.print(value1 + " " + operator + " " + value2 + " is ");
			if (value1 <= value2) {
				System.out.println("true");
			}
			else {
				System.out.println("false");				
			}
		}
		else if (operator.equals(">=")){
			System.out.print(value1 + " " + operator + " " + value2 + " is ");
			if (value1 >= value2) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}
		else if (operator.equals("=")){
			System.out.print(value1 + " " + operator + " " + value2 + " is ");
			if (value1 == value2) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}
		else {
			System.out.println("Expression not accepted. Would you like to try again?\n");
		}
	}
	
	public static void displayAdvancedInstructions() { // instructions for how to use advanced "calculator"
		System.out.println();
		System.out.println("Enter the type of expression to evaluate");
		System.out.println("Valid options are: Type, Operation");
		System.out.print("Your choice: ");
	}
	
	public static void displayTypeInstructions() { // instructions for how to input with type
		System.out.println("\nValid types are: Sqrt, Abs");
		System.out.println("Expressions are entered with spaces between the type and value");
		System.out.println("Here is the valid format:");
		System.out.println("\t<type><space><value>");
		System.out.println("\tEx. Sqrt 4 = 2.0, -2.0");
		System.out.println("Your expression:");
	}
	
	public static void displayOperInstructions() { // instructions for how to input with greater/less than, etc
		System.out.println("\nValid operations are: >, <, >=, <=, =");
		System.out.println("Expression are entered with spaces between the values and operator");
		System.out.println("Here is the valid format:");
		System.out.println("\t<value><space><operator><space><value>");
		System.out.println("\tEx. 2 < 3 is true");
		System.out.println("Your expression:");
	}
}

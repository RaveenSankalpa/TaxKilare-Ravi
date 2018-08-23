package Tax;

import java.util.Optional;
import java.util.Scanner;

public class TaxKilareUI {

	private static final String MAIN_MENU_TEXT = "Welcome to Tax Management System of XYZ \n Please select one of the following options : \n \n 1.Calculate Tax \n 2.Search Tax \n 3.Exit\n";
	private static boolean isNextTerm = true;

	private static TaxOperation taxOps = new TaxOperation();
	private static Scanner scanner;

	// Singleton method for instantiate Scanner object
	public static Scanner getScanner() {
		if (scanner == null)
			scanner = new Scanner(System.in);
		return scanner;
	}

	public static void displayMainMenu() {
		printOutput(MAIN_MENU_TEXT);

		int option = getInputNumber("Chooce your option : ", new Scanner(System.in));

		switch (option) {
		case 1:

			while (isNextTerm) {

				int empId = getInputNumber("Enter the Employee ID : ", getScanner());

				while (Integer.toString(empId).length() != 4) {
					printErrorOutput("Employee id should contains 4 digits !");
					empId = getInputNumber(" Enter the Employee ID : ", getScanner());
				}

				double annualIncome = getInputDouble(" Enter the Annual Income : ", getScanner());

				taxOps.doTaxCalculation(empId, annualIncome);

				String result = getInputText(" \\n Do you want to add another customer Annual Income? [Y/N]: ",
						scanner);

				isNextTerm = result.equalsIgnoreCase("y") ? true : false;
			}
			displayMainMenu();
			break;

		case 2:
			// search tax
			break;
		case 3:
			// exit program
			break;
		default:
			printOutput("\n System Error : Invalid input for main menu option ! \n");
			displayMainMenu();
			break;
		}

	}

	public static void printOutput(String outPut) {
		System.out.println(outPut);
	}
	
	public static void printErrorOutput(String error) {
		System.out.println(error);
	}

	public static String getInputText(String lableTxt, Scanner scanner) {
		System.out.print(lableTxt);
		if(scanner == null )
			System.out.println("Scanner is null");
		String inputStr = scanner.nextLine();
		return inputStr;
	}

	public static int getInputNumber(String lableTxt, Scanner scanner) {
		System.out.print(lableTxt);
		int inputNum = scanner.nextInt();
		return inputNum;
	}

	public static double getInputDouble(String lableTxt, Scanner scanner) {
		System.out.print(lableTxt);
		double inputDbl = scanner.nextDouble();
		return inputDbl;
	}

}

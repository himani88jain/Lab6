import java.util.Scanner;
import java.util.Random;

public class RollDice {
	static int count = 0;

	public static void main(String ars[]) {
		System.out.println("Welcome to Grand Circus Casino!!");
		displayOutput();
		while (doYouWantToContinue() == true) {
			displayOutput();
		}
		System.out.println("Good Bye.. Come back again in our Casino!!");
	}

	/* Asking for how many sides should a die have */
	public static int getNumberOfSides() {
		System.out.println("How many sides should each die have?");
		Scanner scnr = new Scanner(System.in);
		int sides = scnr.nextInt();
		return sides;
	}

	/* Generating random numbers of dice */
	public static int generateRandomDieRoll(int sides) {

		Random r = new Random();
		int chance = Math.abs(r.nextInt() % sides);
		if (chance == 0)
			chance = sides;
		return chance;

	}

	/* Shwoing the output to user */
	public static void displayOutput() {
		int sides = getNumberOfSides();
		count++;
		int random1 = generateRandomDieRoll(sides);
		int random2 = generateRandomDieRoll(sides);
		System.out.println("Roll " + count + ":\n" + random1 + " " + random2);

		/* Special cases */
		if (sides == 6) {
			if ((random1 + random2) == 2)
				System.out.println("Its a snake eye");
			if ((random1 + random2 == 12))
				System.out.println("Its a box car");
			if ((random1 + random2 == 3) || (random1 + random2 == 2) || (random1 + random2 == 12))
				System.out.println("Its a crap");
		}

	}

	/* Asking if user want to roll again */
	public static boolean doYouWantToContinue() {
		System.out.println("Do you want to roll again(y/n)");
		Scanner scnr = new Scanner(System.in);
		boolean response = scnr.next().equalsIgnoreCase("y");
		return response;
	}

}

import java.util.Scanner;

public class MorseCodeTranslator {
	static Scanner input = new Scanner(System.in);

	static String seq = "";

	static String[] English = {"a", "b", "c", "d","e","f", "g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," "};
	static String[] Morse = {".-", "-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","  "};

	public static void main(String[] args) {
		boolean playAgain = true;
		String anotherOne = "";
		do {
			System.out.println("Enter your phrase, english or morse, I understand both: ");
			String phrase = input.nextLine();
			phrase.toLowerCase();
			if (isEnglish(phrase)==1) {
				translateToMorse(phrase, English, Morse);
			} else if (isEnglish(phrase)==2) {
				translateToEnglish(phrase, Morse, English);
			} else {
				System.out.println("Please enter Morse or English, not a combination. Not sure what you meant buddeh.");
			}

			do {
				System.out.println();
				System.out.println("Another one? yes/no (please only enter yes or no)");

				anotherOne = input.nextLine();
			} while (!anotherOne.equalsIgnoreCase("yes") && !anotherOne.equalsIgnoreCase("no"));
			if (anotherOne.equalsIgnoreCase("yes")) playAgain = true;
			if (anotherOne.equalsIgnoreCase("no")) playAgain = false; System.out.println("BYE!");
		} while(playAgain);


	}

	// translate english to morse
	public static void translateToMorse(String phrase, String[] English, String[] Morse) {
		String seq = "";
		for (int i=0; i<phrase.length(); i++) {
			for (int j=0; j<English.length; j++) {
				if (English[j].equals(phrase.charAt(i) +"")) {
					seq += Morse[j];
				}
			}
			System.out.print(seq);
			seq = "";
		}	
	}

	//translate morse to english
	public static void translateToEnglish(String phrase, String[] Morse, String[] English) {
		String seq = "";
		String[] result = phrase.split(" ");
		for (int i=0; i<result.length; i++) {
			for (int j=0; j<Morse.length; j++) {
				if (Morse[j].equals(result[i])) {
					seq += English[j];
				}
			}
			System.out.print(seq + " ");
			seq = "";
		}
	}

	//check if statement is english or more
	public static int isEnglish(String phrase) {
		int checkType = 0;
			if (phrase != null && phrase.length() > 0 && phrase.charAt(0) > 0x60 && phrase.charAt(0) < 0x7b) {
				checkType = 1;
			} else if (phrase.contains("-") && phrase.contains(".") && (phrase.charAt(0)=='-' || phrase.charAt(0)=='.') || phrase.charAt(0)==' ') {
				checkType = 2;
			} else {
				checkType = 0;
			}
		return checkType;
	}
}

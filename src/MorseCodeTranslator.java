import java.util.Scanner;

public class MorseCodeTranslator {
	static Scanner input = new Scanner(System.in);
	
	String userInput;
	static String seq = "";
	static String[][] EnglishAndMorse = { {"a", ".-"}, {"b", "-..."}, {"c", "-.-."}, {"d", "-.."}, {"e", "."},
								  {"f", "..-."}, {"g", "--."}, {"h", "...."}, {"i", ".."}, {"j", ".---"},
								  {"k", "-.-"}, {"l", ".-.."}, {"m", "--"}, {"n", "-."}, {"o", "---"},
								  {"p", ".--."}, {"q","--.-" }, {"r", ".-."}, {"s", "..."}, {"t", "-"},
								  {"u", "..-"}, {"v", "...-"}, {"w", ".--"}, {"x", "-..-"}, {"y", "-.--"},
								  {"z", "--.."}, {" ", "  "}};

	static String[] English = {"a", "b", "c", "d","e","f", "g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," "};
	static String[] Morse = {".-", "-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","  "};
	
	public static void main(String[] args) {
		System.out.println("Enter your phrase, english or morse, I understand both mawfucka: ");
		String phrase = input.nextLine();
		phrase.toLowerCase();
		translate(phrase, Morse, English);
		
	}
	
	public static void translate(String phrase, String[] original, String[] translated) {
		String seq = "";
		for (int i=0; i<phrase.length(); i++) {
			for (int j=0; j<original.length; j++) {
				if (original[j].equals(phrase.charAt(i) +"")) {
					seq += translated[j];
	
				}
			}
			System.out.print(seq + " ");
			seq = "";
		}	
	}
}
		
//		for (int i=0; i<phrase.length(); i++) {
//				for (int j=0; j<EnglishAndMorse.length; j++) {
//					if (EnglishAndMorse[j][0].equals(phrase.charAt(i) + "")) {
//						seq += EnglishAndMorse[j][1];
//					}
//					
//					
//				}
//				System.out.print(seq + " ");
//				seq = "";
//			}




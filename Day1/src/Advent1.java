import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Advent1 {
	public static void main(String args[]) throws FileNotFoundException {
		
		int openingBrackets = 0;
		int closingBrackets = 0;
		
		String rawString = "";
		
		System.out.println("Starting");
		
		// READ INPUT FILE
		try {
			FileReader input = new FileReader("../input.txt");
			Scanner inScanner = new Scanner(input);
			
			
			// COUNT OPENING AND CLOSING BRACKET
			while (inScanner.hasNext()) {
				rawString += inScanner.next();								
			}
		} catch (Exception e) {
				System.out.println(e);
				
		} // end try catch							
		
		// SUBTRACT OPENING FROM CLOSING AND PRINT
		char brackets[] = rawString.toCharArray();
		
		for (int i=0; i < brackets.length; i++) {
			if (brackets[i] == '(')
				openingBrackets++;
			
			if (brackets[i] == ')')
				closingBrackets++;
			
		}
		
		System.out.println("Santa is on floor " + (openingBrackets - closingBrackets));
		
		
	} // end main
} // end class

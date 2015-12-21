import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Advent2 {
	
	
	public static int getArea(int length, int width, int height) {		
		return (( 2*length*width ) + ( 2*length*height ) + ( 2*width*height ));		
	} // end get area
	
	public static int getSlack(int length, int width, int height) {		
		
		int lw = length * width;
		int hw = height * width;
		int lh = length * height;
	
		
		return Math.min(Math.min(lw, hw), lh);
							
	} // end get slack
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		int totalArea = 0;
		
		try {
			FileReader inFile = new FileReader("../input.txt");
			Scanner inScanner = new Scanner(inFile);
					//.useDelimiter("[\\r\\n|x]");
			//inScanner.useDelimiter("[\\r\\n|x]");
			
			int length = 0;
			int width = 0;
			int height = 0;
			
			while (inScanner.hasNext()) {
				
				String line = inScanner.next();
				String dimensions[] = line.split("x");
				
				length = Integer.decode(dimensions[0]);
				width = Integer.decode(dimensions[1]);
				height = Integer.decode(dimensions[2]);
								
				System.out.println("Length: " + length + "\tWidth: " + width + "\tHeight: " + height);				
				totalArea += getArea(length, width, height) + getSlack(length, width, height); 
				
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} // end try catch
		
		
		System.out.println("Total Wrapping paper = " + totalArea);
		
	} // end main
} // end class

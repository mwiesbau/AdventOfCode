import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Advent3 {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader inputFile = new FileReader("input.txt");
		Scanner inputScanner = new Scanner(inputFile);

		String inputString = "";
		while (inputScanner.hasNext()) {
			inputString+=inputScanner.next();
		}

		char charArray[] = inputString.toCharArray();		
		int santaHousesVisited[][] = new int[4200][4200];
		int elfHousesVisited[][] = new int[4200][4200];
		int atLeastOnce = 0;

		int indexSantaK = 2100; //column
		int indexSantaN = 2100; // row

		int indexElfK = 2100; //column
		int indexElfN = 2100; // row

		santaHousesVisited[indexSantaK][indexSantaN] = 1;
		elfHousesVisited[indexElfK][indexElfN] = 1;
		for (int i = 0; i < charArray.length; i++) {			
			if (i % 2 == 0) {
				if (charArray[i] == '^') {
					indexSantaK-=1;
					santaHousesVisited[indexSantaK][indexSantaN]++;
				} // end if

				if (charArray[i] == 'v') {							
					indexSantaK+=1;
					santaHousesVisited[indexSantaK][indexSantaN]++;
				} // end if

				if (charArray[i] == '<') {
					indexSantaN-=1;
					santaHousesVisited[indexSantaK][indexSantaN]++;
				} // end if								

				if (charArray[i] == '>') {
					indexSantaN+=1;
					santaHousesVisited[indexSantaK][indexSantaN]++;
				} // end if
			} else {
				if (charArray[i] == '^') {
					indexElfK-=1;
					elfHousesVisited[indexElfK][indexElfN]++;
				} // end if

				if (charArray[i] == 'v') {							
					indexElfK+=1;
					elfHousesVisited[indexElfK][indexElfN]++;
				} // end if

				if (charArray[i] == '<') {
					indexElfN-=1;
					elfHousesVisited[indexElfK][indexElfN]++;
				} // end if								

				if (charArray[i] == '>') {
					indexElfN+=1;
					elfHousesVisited[indexElfK][indexElfN]++;
				} // end if
			} // end else								
		} // end for


		for (int i = 0; i < santaHousesVisited.length; i++) {
			for (int j = 0; j < santaHousesVisited[i].length; j++) {

				if (santaHousesVisited[i][j] > 0 || elfHousesVisited[i][j] > 0) 
					atLeastOnce++;

			} // end for j 
		} // end for i


		System.out.println("Part A - at Least one present = " + atLeastOnce);

	} // end main
} // end class
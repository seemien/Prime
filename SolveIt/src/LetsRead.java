	
	/*Seemien Ahmed
	 * CSC-201: Assignment 3
	 * The following program reads from the text file to the screen 
	 * 
	 */
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;
	
	public class LetsRead {
	
		public static void main(String[] args) {
			System.out.println("Enter a file name: ");
			// Scanner keyboard=new Scanner(System.in);
			String exp = "out.text";
			Scanner inputStream = null;
			System.out.println("The file " + exp + "\n contains following lines with solutions:\n");
			try {
				inputStream = new Scanner(new File(exp));
	
			} catch (FileNotFoundException e) {
				System.out.println("Error opening File " + exp);
				System.exit(0);
			}
			while (inputStream.hasNextLine()) {
				String line = inputStream.nextLine();
				System.out.println();
				System.out.println(line);
				System.out.println();
				System.out.println("Solution to Expression is: " + (ExpressionSolver.solve(line)));
				System.out.println();
			}
			inputStream.close();
	
		}
	
	}

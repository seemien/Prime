	
	/*Seemien Ahmed
	 * CSC-201: Assignment 3
	 * The following program reads from the user to the text file 
	 * Writes as many expressions as the user needs
	 * 
	 * 
	 */
	import java.io.FileNotFoundException;
	import java.io.PrintWriter;
	import java.util.Scanner;
	
	//The program writes to a text file
	public class LetsWrite {
	
		public static void main(String[] args) {
			int n;
			String exp = "out.text";
			PrintWriter outputStream = null;// {
	
			try {
				outputStream = new PrintWriter(exp);
	
			} catch (FileNotFoundException e) {
				System.out.println("Error opening the file " + exp);
				System.exit(0);
			}
			{
				Scanner keyboard = new Scanner(System.in);
	
				System.out.println("Enter Your Expression, add a zero at the end including zero to bracketed expression ");
	
				for (int count = 1; count <= 5; count++) {
					String line = keyboard.nextLine();
					outputStream.println(line);
				}
				outputStream.close();
				System.out.println("The lines were written to " + exp);
	
			}
		}
	
	}

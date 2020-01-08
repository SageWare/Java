import java.util.Scanner;

public class AgeConverter {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int age;
		int conversion;

		System.out.println("Please enter your age: ");
		age = scan.nextInt(); // Read user input

		conversion = age * 365;
		System.out.println("You have been alive for " + conversion + " days.");

		scan.close();
	}
}

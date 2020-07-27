import java.util.*;
import java.io.*;
public class WeddingPlan{
	private String name;
	private String userName;
	private String location;
	private String decoration;
	private String catering;
	private int estimatedBudget;
	static int planNumber = 0;
	{
		planNumber += 1;
	}

	public WeddingPlan(){
		this.name = setName();
		this.userName = setUserName();
		this.location = setLocation();
		this.decoration = setDecoration();
		this.catering = setCatering();
		this.estimatedBudget = setBudget();
	}

	private String setName(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a name for this wedding plan: ");
		String uName = scanner.nextLine();
		return uName;
	}

	private String setUserName(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your username as given to you by the administrator (your password will be used in a separate program): ");
		String uuName = scanner.nextLine();
		return uuName;
	}

	private String setLocation(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter details of the location for this wedding plan:");
		String uLocation = scanner.nextLine();
		return uLocation;
	}

	private String setDecoration(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter any and all details pertaining to decoration for this wedding plan: ");
		String uDecoration = scanner.nextLine();
		return uDecoration;
	}

	private String setCatering(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter any and all catering details for this wedding plan: ");
		String uCatering = scanner.nextLine();
		return uCatering;
	}

	private int setBudget(){
		Scanner scanner = new Scanner(System.in);
		int uBudget = 0;
		boolean catchNonInt;
		do{
			System.out.println("Enter your estimated budget as an integer (i.e. no decimal points): ");
			try {
				catchNonInt = false;
				uBudget = scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.next();
				catchNonInt = true;
				System.out.println("Enter an integer value.");
			}
		} while (catchNonInt == true);
		scanner.nextLine();
		return uBudget;
	}

	String getPlanName() {
		return name;
	}

	int getBudget() {
		return estimatedBudget;
	}

	int getPlanNumber() {
		return planNumber;
	}

	String getPlanLocation() {
		return location;
	}

	String getPlanDecoration() {
		return decoration;
	}

	String getPlanCatering() {
		return catering;
	}

	String getPlanUsername() {
		return userName;
	}
}

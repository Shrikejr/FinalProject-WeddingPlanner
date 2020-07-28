import java.io.IOException;
import java.util.*;

public class GenericSession{
	private transient int userType;

	public GenericSession(){
	}

	void setUserType() throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome!");
		do {
			try { 
				System.out.println("1) Customer");
				System.out.println("2) IT Administrator");
				System.out.println("3) Shut Down");
				System.out.println("Please select what type of user you are (enter number): ");
				int userType = Integer.parseInt(scanner.nextLine());

				switch (userType) {
				case 1:
					UserSession newUS = new UserSession();
					break;
				case 2:
					AdminSession newAS = new AdminSession();
					break;
				case 3:
					System.out.println("Goodbye!");
					System.exit(0);
				default:
					System.out.println("That is not a valid number.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid User Input. Please enter a value from 0 to 3.");
				continue;
			}
		} while (userType != 3);
		scanner.close();
	}
}

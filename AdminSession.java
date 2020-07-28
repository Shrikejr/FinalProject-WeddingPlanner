import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class AdminSession extends GenericSession{
	ArrayList<UserRegister> customerList = new ArrayList<UserRegister>();
	ArrayList<String> customerNameList = new ArrayList<>();

	public AdminSession() {
		showUserOptions();
	}
	void showUserOptions(){
		Scanner scanner = new Scanner(System.in);
		int options = 0;
		do {
			try {
				System.out.println("Welcome!");
				System.out.println("\n");
				System.out.println("1) Add New User/Customer");
				System.out.println("2) View Existing Customers");
				System.out.println("3) Close");
				System.out.println("Please Enter an Option:");
				options = scanner.nextInt();
				switch (options) {
				case 1:
					UserRegister newUser = new UserRegister();
					customerList.add(newUser);
					customerNameList.add(newUser.getFirstName() + " " + newUser.getLastName());
					break;
				case 2:
					showCustomerListOptions();
					break;
				case 3:
					break;
				default:
					System.out.println("That is not a valid number.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid User Input. Please enter a value from 0 to 3.");
				continue;
			}
		} while (options != 3);
	}
	void showCustomerListOptions() {
		int customerOptions = 0;
		Scanner scanner = new Scanner(System.in);
		if (customerNameList.size() == 0) {
			System.out.println("You currently have no users added to your directory.");
		} else {
			do {
				try {
					for (int i = 0; i < customerNameList.size();i++) { 		      
						System.out.println((i + 1) + ") " + customerNameList.get(i));
					}
					System.out.println("Press 0 to exit.");
					customerOptions = scanner.nextInt();
					if ((customerOptions <= (customerNameList.size())) && customerOptions != 0) {
						System.out.println(customerList.get(customerOptions - 1));
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid User Input. Please press 0 to exit.");
					continue;
				}  
			} while (customerOptions != 0);
		}
	}


}

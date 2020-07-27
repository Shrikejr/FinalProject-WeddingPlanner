import java.util.*;
public class UserRegister extends PersonRegister {
	int randomLoginNo = (int)(Math.random() * 99 + 1);
	private String firstName;
	private String lastName;
	private String userMobile;
	private String userDOB;
	private String userAddress;
	static int userNumber = 0;
	{
		userNumber += 1;
	}
	//construct new user
	public UserRegister(){
		this.userType = "user";
		this.firstName = setUserFirstName();
		this.lastName = setUserLastName();
		this.userMobile = setPhoneNumber();
		this.userDOB = setUserDOB();
		this.userAddress = setUserAddress();
		String loginName = firstName.toLowerCase() + lastName.toLowerCase() + randomLoginNo;
		System.out.println("The username for this user will be " + loginName);
		//call method for random password
		this.password = randPassword(defaultPassLength);
		System.out.println("The password for this user will be " + password);
	}
	private String setUserFirstName(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the user's first name.");
		String uFN = scanner.nextLine();
		return uFN;
	}
	private String setUserLastName(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the user's last name.");
		String uLN = scanner.nextLine();
		return uLN;		
	}
		
	private String setUserAddress(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the user's mailing address.");
		String uAddress = scanner.nextLine();
		return uAddress;
	}

	private String setUserDOB(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the user's DOB in MM/DD/YYYY format.");
		String uDOB = scanner.nextLine();
		//someday I will do regex in java-- today is not that day.
		try {
			return uDOB.substring(0, 10);
		} catch(StringIndexOutOfBoundsException e) {
			return uDOB;
		}
	}

	private String setPhoneNumber(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the user's phone number in 999-999-9999 format.");
		String uPhoneNumber = scanner.nextLine();
		//see last comment.
		try {
			return uPhoneNumber.substring(0, 10);
		} catch(StringIndexOutOfBoundsException e) {
			return uPhoneNumber;
		}
	}

	private String randPassword(int passLength){
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		char[] password = new char[passLength];
		for (int i=0; i < passLength; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String toString() {
		return firstName + " " + lastName + "\n" + userDOB + "\n" + userMobile + "\n" + userAddress;
	}


}

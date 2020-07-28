import java.io.*;
import java.util.*;
public class UserSession extends GenericSession {
	private String[][] userPlanDatabase = new String[6][5];
  private int options;
	public UserSession() throws IOException{
		showUserOptions();
	}
	void showUserOptions() throws IOException{
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				System.out.println("Welcome!");
				System.out.println("\n");
				System.out.println("1) Create New Plan (" + (5 - countFilled(userPlanDatabase) + " Remaining Slots)"));
				System.out.println("2) View Existing Plans");
				System.out.println("3) Save Current Plans");
				System.out.println("4) Load Previous Plans from File");
				System.out.println("5) Close (Notify Receptionist)");
				System.out.println("Please Enter an Option:");
				int options = scanner.nextInt();
				switch (options) {
				case 1:
					if (countFilled(userPlanDatabase) < 5) {
						WeddingPlan aWedding = new WeddingPlan();
						addEmUp(userPlanDatabase, aWedding);
					} else {
						System.out.println("All slots full, consult receptionist or planner.");
					}
					break;
				case 2:
					System.out.println("\n");
					printTheStuffExt(userPlanDatabase);
					break;
				case 3:
					savePlans(userPlanDatabase);
          break;
				case 4:
          loadPlans(userPlanDatabase);
          break;
				case 5:
					break;
				default:
					System.out.println("That is not a valid number.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid User Input. Please enter a value from 0 to 5.");
				continue;
			}
		} while (options != 5);
		scanner.close();
	}
	public void addEmUp(String[][] usersDatabase, WeddingPlan toAdd){
		usersDatabase[0][toAdd.getPlanNumber()-1] = toAdd.getPlanUsername();
		usersDatabase[1][toAdd.getPlanNumber()-1] = toAdd.getPlanName();
		usersDatabase[2][toAdd.getPlanNumber()-1] = toAdd.getPlanLocation();
		usersDatabase[3][toAdd.getPlanNumber()-1] = toAdd.getPlanDecoration();
		usersDatabase[4][toAdd.getPlanNumber()-1] = toAdd.getPlanCatering();
		usersDatabase[5][toAdd.getPlanNumber()-1] = Integer.toString(toAdd.getBudget());
	}
	public static void printTheStuff(String[][] usersDatabase){
		//just print the first row
		int counter = 1;
		for(int i=1; i<2; i++){
			for(int j=0; j<usersDatabase[0].length; j++){
				if (usersDatabase[i][j] != null) {
					System.out.print(counter + ") " + usersDatabase[i][j] + "\n");
				} else {
					System.out.print("---" + "\n");
				}        
				counter++;
			} 

		}
		System.out.println("");
	}

	public static void printTheStuffExt(String[][] usersDatabase){
		for(int i=0; i<countFilled(usersDatabase) + 1; i++){
			for(int j=0; j<6; j++){
				if (usersDatabase[j][i] != null) {
					System.out.print(usersDatabase[j][i]);
				}
        System.out.println(" ");
			}
		}
    System.out.println("\n");
	}

	static public int countFilled(String[][] usersDatabase){
		int countOfFilled = 0;
		for(int i=1; i<2; i++){
			for(int j=0; j<usersDatabase[0].length; j++){
				if (usersDatabase[i][j] != null) {
					countOfFilled = countOfFilled + 1;
				}
			} 
		}
		return countOfFilled;
	}
	
	public static void savePlans(String[][] usersDatabase) throws IOException {
		try {
			FileWriter planList = new FileWriter("planlist.txt");
      BufferedWriter outputWriter = new BufferedWriter(planList);
		for(int i=0; i<usersDatabase.length; i++){
			for(int j=0; j<usersDatabase[0].length; j++){
				if (usersDatabase[i][j] != null) {
					outputWriter.write(usersDatabase[i][j]);
          outputWriter.flush();
				}
        outputWriter.write(" ");
        outputWriter.flush();
			}
        outputWriter.write("\n");
        outputWriter.flush();

		}
				System.out.println("File created!");
    } catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

  public static void loadPlans(String[][] usersDatabase) throws IOException{
    Scanner sc = new Scanner(new BufferedReader(new FileReader("planlist.txt")));
    while(sc.hasNextLine()) {
         for (int i=0; i<7; i++) {
            String[] line = sc.nextLine().trim().split(" ");
            for (int j=0; j<6; j++) {
               usersDatabase[i][j] = line[j];
            }
         }
      }
      System.out.println(Arrays.deepToString(usersDatabase));

  }

}

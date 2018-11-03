package University;
import java.util.Scanner;

public class UniversityApp {
	public static void main(String[] args) {
		int userType;
		System.out.println("Welcome to the University App.");
		System.out.println("Enter 1 if you are a student and 2 if you are a professor");
		Scanner sc = new Scanner(System.in);
		do{
			userType = sc.nextInt();
			switch(userType) {
				case 1: do{
							System.out.println("Please enter your Student ID: ");
							// read student.txt
							if(//id not in student)
								System.out.println("Please enter a valid Student ID.");
							else
								//student function
								break;
						} while ();
				
				case 2: do{
							System.out.println("Please enter your Professor ID: ");
							// read prof.txt
							if(//id not in prof)
								System.out.println("Please enter a valid Professor ID.");
							else
								//prof function
							break;
						} while ();
					
				default: System.out.println("Please enter a valid choice.");
			}
		} while (userType > 2 || userType < 1);
	}
	
	public void studFunc() {
		
	}
	
	public void profFunc() {
		
	}
}

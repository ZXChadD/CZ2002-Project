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
		Scanner sc = new Scanner(System.in);
		Student stud = new Student(0, null, null, null, null, null);
		System.out.println("List of actions:");
		System.out.println("1: Register for a course");
		System.out.println("2: Check availability for a tutorial/lab group");
		System.out.println("3: Print transcript");
		System.out.println("4: Exit");
		System.out.println("Please enter your choice: ");
		do {
			int studChoice = sc.nextInt();
			switch(studChoice)
			case 1: 
				stud.regCourse(course, courseCount, courseSlot);
				break;
			case 2:
				stud.checkAvail(course, courseCount);
				break;
			case 3:
				stud.printTranscript();
				break;
			case 4:
				System.out.println("Thank you for using the app");
				break;
			default:
				System.out.println("Please enter a valid action.");
		}while(studChoice>4 || studChoice<1)
	}
	
	public void profFunc() {
		Scanner sc = new Scanner(System.in);
		Professor prof = new Professor(0, null, null, null, null, null, null);
		System.out.println("List of actions:");
		System.out.println("1: Add a student");
		System.out.println("2: Add a course");
		System.out.println("3: Print student list");
		System.out.println("4: Enter course assessment component weightage");
		System.out.println("5: Enter coursework mark");
		System.out.println("6: Enter exam mark");
		System.out.println("7: Print course statistics");
		System.out.println("8: Exit");
		System.out.println("Please enter your choice: ");
		do {
			int profChoice = sc.nextInt();
			switch(profChoice)
			case 1: 
				prof.addStud(stud, count);
				break;
			case 2:
				prof.addCourse();
				break;
			case 3:
				prof.printStud();
				break;
			case 4:
				prof.weightage();
				break;
			case 5:
				prof.cwMark();
				break;
			case 6:
				prof.examMark();
				break;
			case 7:
				prof.printStats();
				break;
			case 8:
				System.out.println("Thank you for using the app");
				break;
			default:
				System.out.println("Please enter a valid action.");
		}while(profChoice>8 || profChoice<1)
	}
}

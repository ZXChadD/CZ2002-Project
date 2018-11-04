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
							int studId = sc.nextInt();
							// read student.txt
							if(//id not in student)
								System.out.println("Please enter a valid Student ID.");
							else
								//student function(studId)
								break;
						} while ();
				
				case 2: do{
							System.out.println("Please enter your Professor ID: ");
							int profId = sc.nextInt();
							// read prof.txt
							if(//id not in prof)
								System.out.println("Please enter a valid Professor ID.");
							else
								//prof function(profId)
								break;
						} while ();
					
				default: System.out.println("Please enter a valid choice.");
			}
		} while (userType > 2 || userType < 1);
	}
	
	public void studFunc(int studId) {
		int studChoice;
		Scanner sc = new Scanner(System.in);
		//find same id in student.txt
		//copy whole line to create new student object
		Student stud = new Student(0, null, null, null, null, null);
		System.out.println("List of actions:");
		System.out.println("1: Register for a course");
		System.out.println("2: Check availability for a tutorial/lab group");
		System.out.println("3: Print transcript");
		System.out.println("4: Exit");
		System.out.println("Please enter your choice: ");
		Course[] course = new Course[10];
		//for(a=0;a<10;a++)
		//read course.txt and input each line into course[a]
		do {
			studChoice = sc.nextInt();
			switch(studChoice) {
			case 1: 
				stud.regCourse(course, a);
				break;
			case 2:
				stud.checkAvail(course, a);
				break;
			case 3:
				stud.printTranscript(course, a);
				break;
			case 4:
				System.out.println("Thank you for using the app");
				break;
			default:
				System.out.println("Please enter a valid action.");
		}
		}while(studChoice!=4);
	}
	
	public void profFunc(int profId) {
		int profChoice;
		Scanner sc = new Scanner(System.in);
		//find same id in professor.txt
		//copy whole line to create new professor object
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
		Course[] course = new Course[10];
		//for(a=0;a<10;a++)
		//read course.txt and input each line into course[a]
		Student[] student = new Student[20];
		//for(b=0;b<10;b++)
				//read student.txt and input each line into student[b]
		Professor[] professor = new Professor[5];
		//for(c=0;c<10;c++)
				//read course.txt and input each line into professor[c]
		do {
			profChoice = sc.nextInt();
			switch(profChoice) {
			case 1: 
				Student newStud = prof.addStud(student, b);
				//write newStud to student.txt
				break;
			case 2:
				Course newCourse = prof.addCourse(course, a, professor, c);
				//write newCourse to course.txt
				break;
			case 3:
				prof.printStud(student, b, course, a);
				break;
			case 4:
				prof.weightage(course, a);
				//write weightage to ???.txt
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
			}
		}while(profChoice != 8);
	}
}

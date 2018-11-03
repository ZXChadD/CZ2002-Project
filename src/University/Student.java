package University;
import java.util.Scanner;

public class Student
{
	private int studId;
	private String studFName, studLName, studEmail, faculty, phoneNo;
	
	public Student(int studId, String studFName, String studLName, String studEmail, String phoneNo, String faculty)
	{
		this.studId = studId;
		this.studFName = studFName;
		this.studLName = studLName;
		this.studEmail = studEmail;
		this.phoneNo = phoneNo;
		this.faculty = faculty;
	}

	public void regCourse(Course[] course, int courseCount, int courseSlot)
	{
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course ID: ");
		int courseChoice = sc.nextInt();
		for(i=0;i<courseCount;i++)
		{
			if(course[i].getCourseId()==courseChoice)
			{
				//if(lec slot < max slot)
					//if student id exist
						System.out.println("You are already registered for this course.");
					else
						//if(lab is available)
							//choose lab group
							//if(lab slot < max slot)
								//add student id to lab
								//choose tut group
								//if(tut slot < max slot)
									//add student id to tut
								else
									System.out.println("No more vacancies.");
							else
								System.out.println("No more vacancies.");
						//else if(tut is available)
						//choose tut group
							//if(tut slot < max slot)
								//add student id to tut slot
							else
								System.out.println("No more vacancies.");	
				else
					System.out.println("No more vacancies. ");
			}
		}
		if(i>=courseCount)
			System.out.println("Please enter a valid Course ID.");
	}
	
	public void checkAvail(Course[] course, int courseCount)
	{
		int i;
		System.out.println("Enter Course ID.");
		Scanner sc = new Scanner(System.in);
		int courseChoice = sc.nextInt();
		for(i=0;i<courseCount;i++) {
			if(course[i].getCourseId()==courseChoice) {
				System.out.println("1. Tutorial group availability");
				System.out.println("2. Lab group availability");
				System.out.println("Enter your choice: ");
				int tutlabChoice = sc.nextInt();
				switch (tutlabChoice) {
				case 1:
					System.out.println("Enter a tutorial group (1 to 5).");
					int tutChoice = sc.nextInt();
					if(/*valid*/)
						System.out.println("Slots left: " + /* max slots - slot */ + "/" + /*max slots*/);
					else
						System.out.println("Please enter a valid tutorial group (1 to 3).");
				case 2:
					System.out.println("Enter a lab group (1 to 5).");
					int labChoice = sc.nextInt();
					if(/*valid*/)
						System.out.println("Slots left: " + /* max slots - slot */ + "/" + /*max slots*/);
					else
						System.out.println("Please enter a valid lab group (1 to 3).");
				default:
					System.out.println("Please enter 1 or 2.");
				}
			}
		}
		if(i>=courseCount)
			System.out.println("Please enter a valid Course ID.");
	}
	
	public void printTranscript()
	{
		
	}
	
	public int getStudId()
	{
		return studId;
	}
	
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	public String getStudName()
	{
		return studFName + " " + studLName;
	}
	
	public String getStudEmail()
	{
		return studEmail;
	}
	
	public String getFaculty()
	{
		return faculty;
	}
}

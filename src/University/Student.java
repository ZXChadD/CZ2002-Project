package University;

import java.util.Scanner;

public class Student
{
	private int studId;
	private String studFName, studLName, studEmail, phoneNo, faculty;
	Marks[] mark = new Marks[10];
	
	public Student(int studId, String studFName, String studLName, String studEmail, String phoneNo, String faculty)
	{
		this.studId = studId;
		this.studFName = studFName;
		this.studLName = studLName;
		this.studEmail = studEmail;
		this.phoneNo = phoneNo;
		this.faculty = faculty;
	}
	
	public int regCourse(Course[] course, int courseCount)
	{
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course ID: ");
		int courseChoice = sc.nextInt();
		for(i=0;i<courseCount;i++)
		{
			if(course[i].getCourseId()==courseChoice)
			{
				if(course[i].getSlots() > (course[i].lecGrp[0].studIds.length + course[i].lecGrp[1].studIds.length)) {
					for(int a=0;a<course[i].lecGrp[0].getSlots();a++)
						if(studId == course[i].lecGrp[0].studIds[a]) {
							System.out.println("You are already registered for this course.");
							break;
							}
					for(int b=0;b<course[i].lecGrp[0].getSlots();b++)
						if(studId == course[i].lecGrp[1].studIds[b]) {
							System.out.println("You are already registered for this course.");
							break;
							}
					System.out.println("Number of lecture groups for this course: " + course[i].getLec());
					System.out.println("Please enter lecture group of your choice: ");
					int lecgrpChoice = sc.nextInt();
					if(lecgrpChoice>course[i].getLec() || lecgrpChoice<1) {
						System.out.println("Please enter a valid group.");
						break;
					}
					else if(course[i].lecGrp[lecgrpChoice-1].studIds.length>=course[i].lecGrp[lecgrpChoice-1].getSlots()) {
						System.out.println("No more vacancies.");
						break;
						}
					else {
						System.out.println("Number of tutorial groups for this course: " + course[i].getTut());
						System.out.println("Please enter tutorial group of your choice: ");
						int tutgrpChoice = sc.nextInt();
						if(tutgrpChoice>course[i].getTut() || tutgrpChoice<1) {
							System.out.println("Please enter a valid group.");
							break;
						}
						else if(course[i].tutGrp[tutgrpChoice-1].studIds.length>=course[i].tutGrp[tutgrpChoice-1].getSlots()) {
							System.out.println("No more vacancies.");
							break;
							}
						else {
							System.out.println("Number of lab groups for this course: " + course[i].getLab());
							System.out.println("Please enter lab group of your choice: ");
							int labgrpChoice = sc.nextInt();
							if(labgrpChoice>course[i].getLab() || labgrpChoice<1) {
								System.out.println("Please enter a valid group.");
								break;
							}
							else if(course[i].labGrp[labgrpChoice-1].studIds.length>=course[i].labGrp[labgrpChoice-1].getSlots()) {
								System.out.println("No more vacancies.");
								break;
								}
							else {
								int x = course[i].lecGrp[lecgrpChoice].studIds.length;
								course[i].lecGrp[lecgrpChoice].studIds[x] = studId;
								int y = course[i].tutGrp[tutgrpChoice].studIds.length;
								course[i].tutGrp[tutgrpChoice].studIds[y] = studId;
								int z = course[i].labGrp[labgrpChoice].studIds.length;
								course[i].labGrp[labgrpChoice].studIds[z] = studId;
								return i;
								}
							}
						}
					}
				else
					System.out.println("No more vacancies. ");
			}
		}
		if(i>=courseCount)
			System.out.println("Please enter a valid Course ID.");
		return -1;
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
					System.out.println("Number of tutorial groups for this course: " + course[i].getTut());
					System.out.println("Enter a tutorial group: ");
					int tutChoice = sc.nextInt();
					if(tutChoice>course[i].getTut() || tutChoice<1)
						System.out.println("Please enter a valid tutorial group.");
					else
						System.out.println("Slots left: " + (course[i].tutGrp[tutChoice-1].studIds.length) + "/" + course[i].tutGrp[tutChoice-1].getSlots());
					break;
						
				case 2:
					System.out.println("Number of lab groups for this course: " + course[i].getLab());
					System.out.println("Enter a lab group: ");
					int labChoice = sc.nextInt();
					if(labChoice>course[i].getLab() || labChoice<1)
						System.out.println("Please enter a valid lab group.");
					else
						System.out.println("Slots left: " + (course[i].labGrp[labChoice-1].studIds.length) + "/" + course[i].labGrp[labChoice-1].getSlots());
					break;

				default:
					System.out.println("Please enter 1 or 2.");
					break;
				}
				break;
			}
			i=0;
		}
		if(i>=courseCount) 
			System.out.println("Please enter a valid Course ID.");
	}
	
	public void printTranscript(Course[] course, int courseCount, Marks[] marks)
	{
		int k;
		System.out.println("Name: " + studFName + " " + studLName);
		System.out.println("Student ID: " + studId);
		System.out.println("Faculty: " + faculty);
		for(int i=0; i<courseCount; i++) {
			for(int j=0; j<course[i].lecGrp[0].studIds.length;j++) {
				if(studId == course[i].lecGrp[0].studIds[j]) {
					for(k=0; k<marks.length; k++) {
						if(course[i].getCourseId()==marks[k].getCourseId())
							break;
					}
					System.out.println("=============================================================");
					System.out.println("Course: " + course[i].getCourseName());
					System.out.println("Exam Mark: " + marks[k].getExam());
					System.out.println("Exam Percentage: " + course[i].exam.getPercentage()+"%");
					/*for(int l=0; l<course[i].coursework.length; l++) {
						System.out.println(course[i].coursework[l].getName() + " Mark: " + );
						System.out.println(course[i].coursework[l].getName() + " Percentage: " + course[i].coursework[l].getPercentage() +"%");
					}*/
					System.out.println("Coursework Mark: " + marks[k].getCoursework());
					System.out.println("Coursework Percentage: " + (100-course[i].exam.getPercentage()+"%"));
					marks[k].calcOverall();
					marks[k].calcGradesO();
					System.out.println("Total: " + marks[k].getOverall());
					System.out.println("Grade: " + marks[k].getGradeO());
				}
			}
			for(int j=0; j<course[i].lecGrp[1].studIds.length;j++) {
				if(studId == course[i].lecGrp[1].studIds[j]) {
					for(k=0; k<marks.length; k++) {
						if(course[i].getCourseId()==marks[k].getCourseId())
							break;
					}
					System.out.println("=============================================================");
					System.out.println("Course: " + course[i].getCourseName());
					System.out.println("Exam Mark: " + marks[k].getExam());
					System.out.println("Exam Percentage: " + course[i].exam.getPercentage()+"%");
					/*for(int l=0; l<course[i].coursework.length; l++) {
						System.out.println(course[i].coursework[l].getName() + " Mark: " + );
						System.out.println(course[i].coursework[l].getName() + " Percentage: " + course[i].coursework[l].getPercentage() +"%");
					}*/
					System.out.println("Coursework Mark: " + marks[k].getCoursework());
					System.out.println("Coursework Percentage: " + (100-course[i].exam.getPercentage()+"%"));
					marks[k].calcOverall();
					marks[k].calcGradesO();
					System.out.println("Total: " + marks[k].getOverall());
					System.out.println("Grade: " + marks[k].getGradeO());
				}
			}
		}
	
	}
	
	public int getStudId()
	{
		return studId;
	}
	
	public String getStudName()
	{
		return studFName + " " + studLName;
	}
	
	public String getStudEmail()
	{
		return studEmail;
	}
	
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	public String getFaculty()
	{
		return faculty;
	}
	
	public void setStudId(int studId) {
		this.studId = studId;
	}
	
	public void setStudFName(String studFName) {
		this.studFName = studFName;
	}
	
	public void setStudLName(String studLName) {
		this.studLName = studLName;
	}
	
	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}
	
	public void setStudPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public void setStudFaculty(String faculty) {
		this.faculty = faculty;
	}
}

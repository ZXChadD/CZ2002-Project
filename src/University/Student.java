package University;

import java.util.ArrayList;
import java.util.Scanner;

public class Student
{
	private int studId;
	private String studFName, studLName, studEmail, phoneNo, faculty;
	ArrayList<Marks> mark = new ArrayList<>();

	/**
	 *  Creates a student based on various attributes
	 **/
	public Student(int studId, String studFName, String studLName, String studEmail, String phoneNo, String faculty)
	{
		this.studId = studId;
		this.studFName = studFName;
		this.studLName = studLName;
		this.studEmail = studEmail;
		this.phoneNo = phoneNo;
		this.faculty = faculty;
	}
	
	public String[] regCourse(ArrayList<Course> course, int courseCount)
	{
		String[] ar = new String[5];
		ar[0]="0";
		int i;
		boolean valid = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course ID: ");
		int courseChoice = sc.nextInt();
		int totalSlots;
		for(i=0;i<courseCount;i++)
		{
			if(course.get(i).lecGrp.size()==1)
				totalSlots = course.get(i).lecGrp.get(0).studIds.size();
			else
				totalSlots = course.get(i).lecGrp.get(0).studIds.size()+course.get(i).lecGrp.get(1).studIds.size();
			if(course.get(i).getCourseId()==courseChoice)
			{
				if(course.get(i).getSlots() > totalSlots) {
					for(int b=0; b<course.get(i).lecGrp.size(); b++) {
						for(int a=0;a<course.get(i).lecGrp.get(b).studIds.size();a++) {
							if(course.get(i).lecGrp.get(b).studIds.size()>0) {
								if(studId == course.get(i).lecGrp.get(b).studIds.get(a)){
									System.out.println("You are already registered for this course.");
									valid = false;
									break;
									}
								}
							}
						}
					if(valid) {
						System.out.println("Number of lecture groups for this course: " + course.get(i).getLec());
						System.out.println("Please enter lecture group of your choice: ");
						int lecgrpChoice = sc.nextInt();
						if(lecgrpChoice>course.get(i).getLec() || lecgrpChoice<1) {
							System.out.println("Please enter a valid group.");
							break;
						}
						else if(course.get(i).lecGrp.get(lecgrpChoice-1).studIds.size()>=course.get(i).lecGrp.get(lecgrpChoice-1).getSlots()) {
							System.out.println("No more vacancies.");
							break;
							}
						else {
							if(course.get(i).tutGrp.size()>0 && course.get(i).labGrp.size()>0) {
								System.out.println("Number of tutorial groups for this course: " + course.get(i).getTut());
								System.out.println("Please enter tutorial group of your choice: ");
								int tutgrpChoice = sc.nextInt();
								if(tutgrpChoice>course.get(i).getTut() || tutgrpChoice<1) {
									System.out.println("Please enter a valid group.");
									break;
								}
								else if(course.get(i).tutGrp.get(tutgrpChoice-1).studIds.size()>=course.get(i).tutGrp.get(tutgrpChoice-1).getSlots()) {
									System.out.println("No more vacancies.");
									break;
									}
								else {
									System.out.println("Number of lab groups for this course: " + course.get(i).getLab());
									System.out.println("Please enter lab group of your choice: ");
									int labgrpChoice = sc.nextInt();
									if(labgrpChoice>course.get(i).getLab() || labgrpChoice<1) {
										System.out.println("Please enter a valid group.");
										break;
									}
									else if(course.get(i).labGrp.get(labgrpChoice-1).studIds.size()>=course.get(i).labGrp.get(labgrpChoice-1).getSlots()) {
										System.out.println("No more vacancies.");
										break;
										}
									else {
										int x = course.get(i).lecGrp.get(lecgrpChoice-1).studIds.size();
										course.get(i).lecGrp.get(lecgrpChoice-1).studIds.add(x, studId);
										int y = course.get(i).tutGrp.get(tutgrpChoice-1).studIds.size();
										course.get(i).tutGrp.get(tutgrpChoice-1).studIds.add(y, studId);
										int z = course.get(i).labGrp.get(labgrpChoice-1).studIds.size();
										course.get(i).labGrp.get(labgrpChoice-1).studIds.add(z, studId);
										ar[0] = "1";
										ar[1] = String.valueOf(i);
										ar[2] = String.valueOf(lecgrpChoice);
										ar[3] = String.valueOf(tutgrpChoice);
										ar[4] = String.valueOf(labgrpChoice);
										System.out.println("Course registered.");
										break;
										}
									}
								}
							else if(course.get(i).labGrp.size()==0 && course.get(i).tutGrp.size()>0) {
								System.out.println("Number of tutorial groups for this course: " + course.get(i).getTut());
								System.out.println("Please enter tutorial group of your choice: ");
								int tutgrpChoice = sc.nextInt();
								if(tutgrpChoice>course.get(i).getTut() || tutgrpChoice<1) {
									System.out.println("Please enter a valid group.");
									break;
								}
								else if(course.get(i).tutGrp.get(tutgrpChoice-1).studIds.size()>=course.get(i).tutGrp.get(tutgrpChoice-1).getSlots()) {
									System.out.println("No more vacancies.");
									break;
									}
								else {
									int x = course.get(i).lecGrp.get(lecgrpChoice-1).studIds.size();
									course.get(i).lecGrp.get(lecgrpChoice-1).studIds.add(x, studId);
									int y = course.get(i).tutGrp.get(tutgrpChoice-1).studIds.size();
									course.get(i).tutGrp.get(tutgrpChoice-1).studIds.add(y, studId);
									ar[0] = "1";
									ar[1] = String.valueOf(i);
									ar[2] = String.valueOf(lecgrpChoice);
									ar[3] = String.valueOf(tutgrpChoice);
									ar[4] = String.valueOf(0);
									System.out.println("Course registered.");
									break;
								}
							}
							else if(course.get(i).labGrp.size()>0 && course.get(i).tutGrp.size()==0) {
								System.out.println("Number of lab groups for this course: " + course.get(i).getLab());
								System.out.println("Please enter lab group of your choice: ");
								int labgrpChoice = sc.nextInt();
								if(labgrpChoice>course.get(i).getLab() || labgrpChoice<1) {
									System.out.println("Please enter a valid group.");
									break;
								}
								else if(course.get(i).labGrp.get(labgrpChoice-1).studIds.size()>=course.get(i).labGrp.get(labgrpChoice-1).getSlots()) {
									System.out.println("No more vacancies.");
									break;
									}
								else {
									int x = course.get(i).lecGrp.get(lecgrpChoice-1).studIds.size();
									course.get(i).lecGrp.get(lecgrpChoice-1).studIds.add(x, studId);
									int z = course.get(i).labGrp.get(labgrpChoice-1).studIds.size();
									course.get(i).labGrp.get(labgrpChoice-1).studIds.add(z, studId);
									ar[0] = "1";
									ar[1] = String.valueOf(i);
									ar[2] = String.valueOf(lecgrpChoice);
									ar[3] = String.valueOf(0);
									ar[4] = String.valueOf(labgrpChoice);
									System.out.println("Course registered.");
									break;
									}
							}
							else {
								int x = course.get(i).lecGrp.get(lecgrpChoice-1).studIds.size();
								course.get(i).lecGrp.get(lecgrpChoice-1).studIds.add(x, studId);
								ar[0] = "1";
								ar[1] = String.valueOf(i);
								ar[2] = String.valueOf(lecgrpChoice);
								ar[3] = String.valueOf(0);
								ar[4] = String.valueOf(0);
								System.out.println("Course registered.");
								break;
							}
							}
						}
					}
					else
						System.out.println("No more vacancies. ");
				}
			}
		if(courseChoice>courseCount)
			System.out.println("Please enter a valid Course ID.");
		System.out.println("=================================================");
		return ar;
	}
	
	public void checkAvail(ArrayList<Course> course, int courseCount)
	{
		int i;
		System.out.println("Enter Course ID.");
		Scanner sc = new Scanner(System.in);
		int courseChoice = sc.nextInt();
		for(i=0;i<courseCount;i++) {
			if(course.get(i).getCourseId()==courseChoice) {
				System.out.println("1. Tutorial group availability");
				System.out.println("2. Lab group availability");
				System.out.println("Enter your choice: ");
				int tutlabChoice = sc.nextInt();
				switch (tutlabChoice) {
				case 1:
					System.out.println("Number of tutorial groups for this course: " + course.get(i).getTut());
					System.out.println("Enter a tutorial group: ");
					int tutChoice = sc.nextInt();
					if(tutChoice>course.get(i).getTut() || tutChoice<1)
						System.out.println("Please enter a valid tutorial group.");
					else
						System.out.println("Slots left: " + (course.get(i).tutGrp.get(tutChoice-1).getSlots() - course.get(i).tutGrp.get(tutChoice-1).studIds.size()) + "/" + course.get(i).tutGrp.get(tutChoice-1).getSlots());
					break;
						
				case 2:
					System.out.println("Number of lab groups for this course: " + course.get(i).getLab());
					System.out.println("Enter a lab group: ");
					int labChoice = sc.nextInt();
					if(labChoice>course.get(i).getLab() || labChoice<1)
						System.out.println("Please enter a valid lab group.");
					else
						System.out.println("Slots left: " + (course.get(i).labGrp.get(labChoice-1).getSlots() - course.get(i).labGrp.get(labChoice-1).studIds.size()) + "/" + course.get(i).labGrp.get(labChoice-1).getSlots());
					break;

				default:
					System.out.println("Please enter 1 or 2.");
					break;
				}
				break;
			}
		}
		if(i>=courseCount) 
			System.out.println("Please enter a valid Course ID.");
		System.out.println("=================================================");
	}
	
	public void printTranscript(ArrayList<Course> course, int courseCount, ArrayList<Marks> marks)
	{
		int k;
		System.out.println("Name: " + studFName + " " + studLName);
		System.out.println("Student ID: " + studId);
		System.out.println("Faculty: " + faculty);
		for(int i=0; i<courseCount; i++) {
			for(int l=0; l<course.get(i).lecGrp.size();l++) {
				for(int j=0; j<course.get(i).lecGrp.get(l).studIds.size();j++) {
					if(studId == course.get(i).lecGrp.get(l).studIds.get(j)) {
						for(k=0; k<marks.size(); k++) {
							if(course.get(i).getCourseId()==marks.get(k).getCourseId())
								break;
						}
						System.out.println("=============================================================");
						System.out.println("Course: " + course.get(i).getCourseName());
						System.out.println("Exam Mark: " + marks.get(k).getExam());
						System.out.println("Exam Percentage: " + course.get(i).exam.getPercentage()+"%");
						/*for(int l=0; l<course[i].coursework.length; l++) {
							System.out.println(course[i].coursework[l].getName() + " Mark: " + );
							System.out.println(course[i].coursework[l].getName() + " Percentage: " + course[i].coursework[l].getPercentage() +"%");
						}*/
						System.out.println("Coursework Mark: " + marks.get(k).getCoursework());
						System.out.println("Coursework Percentage: " + (100-course.get(i).exam.getPercentage()+"%"));
						marks.get(k).calcOverall();
						marks.get(k).calcGradesO();
						System.out.println("Total: " + marks.get(k).getOverall());
						System.out.println("Grade: " + marks.get(k).getGradeO());
					}
				}
			}
		}
		System.out.println("=================================================");
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

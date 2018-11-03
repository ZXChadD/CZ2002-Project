package University;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Professor
{
	private int profId;
	private String profFName, profLName, profEmail, officeRm, faculty, phoneNo;
	Scanner input = new Scanner(System.in);
	LectureGroup[] lecGrp = new LectureGroup[2];
	LabGroup[] labGrp = new LabGroup[3];
	TutorialGroup[] tutGrp = new TutorialGroup[5];
	
	public Professor(int profId, String profFName, String profLName, String profEmail, String phoneNo, String officeRm, String faculty)
	{
		this.profId = profId;
		this.profFName = profFName.toUpperCase();
		this.profLName = profLName.toUpperCase();
		this.profEmail = profEmail;
		this.phoneNo = phoneNo;
		this.officeRm = officeRm;
		this.faculty = faculty;
	}
	
	public void addStud(Student[] stud, int count)
	{
		System.out.println("=================================================");
		
		try
		{
			int studId = -1;
			String studFName = null, studLName = null, studEmail = null, faculty = null, phoneNo = null;
			int i;
			boolean valid = false;
			
			while(valid == false)
			{
				System.out.print("Student ID: ");
				studId = input.nextInt();
				if(studId >= 1 && studId <= 99)
				{
					valid = true;
					for(i = 0; i < count; i++)
					{
						if(studId == stud[i].getStudId())
						{
							valid = false;
							if(studId >= 10)
								System.out.println("Invalid Student ID! Student ID #" + studId + " already exists!");
							else
								System.out.println("Invalid Student ID! Student ID #0" + studId + " already exists!");
							break;
						}
					}
				}
				else
				{
					System.out.println("Invalid Student ID! Student ID must be from #01 to #99.");
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("First Name: ");
				studFName = input.next();
				if(!studFName.matches("[a-zA-Z]+"))
				{
					System.out.println("Invalid Student Name! Student Name must contain only Alphabets.");
					studFName = null;
				}
				if(studFName != null)
				{
					System.out.print("Last Name: ");
					studLName = input.next();
					if(!studLName.matches("[a-zA-Z]+"))
						System.out.println("Invalid Student Name! Student Name must contain only Alphabets.");
					else
					{
						studFName.toUpperCase();
						studLName.toUpperCase();
						valid = true;
					}
					
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Student E-Mail (_____@e.uni.edu.sg): ");
				studEmail = input.next();
				Pattern pattern = Pattern.compile("[A-Z0-9_]+@e.uni.edu.sg");
				Matcher mat = pattern.matcher(studEmail);
				if(!mat.matches())
				{
					System.out.println("Invalid E-Mail Address! E-Mail Address must be in this format: _____@e.uni.edu.sg");
					System.out.println("where _____ must contain only Uppercase Letters, Numbers or '_'(Underscores)");
					System.out.println("Example: MNSH_0001@e.uni.edu.sg");
				}
				else
					valid = true;
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Phone Number: ");
				phoneNo = input.next();
				if(!phoneNo.matches("[0-9]+"))
					System.out.println("Invalid Phone Number! Phone Number must contain only Numbers.");
				else if(phoneNo.length() != 8)
					System.out.println("Invalid Phone Number! Phone Number must be exactly 8 digits.");
				else if(phoneNo.charAt(0) != '9' && phoneNo.charAt(0) != '8' && phoneNo.charAt(0) != '6')
					System.out.println("Invalid Phone Number! Phone Number must start with only '9', '8', or '6'.");
				else
					valid = true;
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Faculty (SCSE/MAE/EEE): ");
				faculty = input.next();
				if(!faculty.equals("SCSE") && !faculty.equals("MAE") && !faculty.equals("EEE"))
					System.out.println("Invalid Faculty! Faculty must only be one of the following: SCSE, MAE, or EEE");
				else
					valid = true;
			}
			
			if(valid == true)
			{
				stud[count] = new Student(studId, studFName, studLName, studEmail, phoneNo, faculty);
				count++;
				if(studId >= 10)
					System.out.println("Student #" + studId + " added!");
				else
					System.out.println("Student #0" + studId + " added!");
				System.out.println();
				System.out.println("Currently Available Students: ");
				for(i = 0; i < count; i++)
				{
					System.out.println();
					System.out.println("ID: " + stud[i].getStudId());
					System.out.println("Name: " + stud[i].getStudName());
					System.out.println("Faculty: " + stud[i].getFaculty());
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Invalid Student ID! Student ID must only contain Numbers.");
		}
		finally
		{
			System.out.println("=================================================");
		}
	}
	
	public void addCourse(Course[] course, int countC, Professor[] prof, int countP)
	{
		System.out.println("=================================================");
		
//		try
//		{
			int courseId = -1, slots = -1, lec = -1, lab = -1, tut = -1;
			String courseName = null; faculty = null;
			Professor p;
			int i = 0;
			boolean valid = false;
			
			while(valid == false)
			{
				System.out.print("Course ID: ");
				courseId = input.nextInt();
				if(courseId >= 1 && courseId <= 10)
				{
					valid = true;
					for(i = 0; i < countC; i++)
					{
						if(courseId == course[i].getCourseId())
						{
							valid = false;
							if(courseId == 10)
								System.out.println("Invalid Course ID! Course ID #" + courseId + " already exists!");
							else
								System.out.println("Invalid Course ID! Course ID #0" + courseId + " already exists!");
							break;
						}
					}
				}
				else
					System.out.println("Invalid Course ID! Course ID must be from #01 to #10.");
			}
			
			System.out.print("Course Name: ");
			courseName = input.next();
			courseName.toUpperCase();

			valid = false;
			while(valid == false)
			{
				System.out.print("Faculty (SCSE/MAE/EEE): ");
				faculty = input.next();
				if(!faculty.equals("SCSE") && !faculty.equals("MAE") && !faculty.equals("EEE"))
					System.out.println("Invalid Faculty! Faculty must only be one of the following: SCSE, MAE, or EEE");
				else
					valid = true;
			}

			valid = false;
			while(valid == false)
			{
				System.out.print("ID of Professor In-Charge: ");
				int profId = input.nextInt();
				if(profId >= 1 && profId <= 10)
				{
					for(i = 0; i < countP; i++)
					{
						if(profId == prof[i].getProfId())
						{
							valid = true;
							break;
						}
					}
					if(valid == false)
						System.out.println("Invalid Professor Id! Professor ID does not exist.");
				}
				else
					System.out.println("Invalid Professor ID! Professor ID must be from #01 to #10.");
			}
			p = prof[i];
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Number of Slots: ");
				slots = input.nextInt();
				if(slots < 1)
					System.out.println("Invalid Number of Slots! Each Course must have atleast 1 Slot.");
				else if(slots > 12)
					System.out.println("Invalid Number of Slots! Each Course must not have more than 15 Slots.");
				else
					valid = true;
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.println();
				System.out.print("Number of Lecture Groups: ");
				lec = input.nextInt();
				if(lec < 1)
					System.out.println("Invalid Number of Lecture Groups! Each Course must have atleast 1 Lecture Group.");
				else if(lec > 2)
					System.out.println("Invalid Number of Lecture Groups! Each Course must not have more than 2 Lecture Groups.");
				else
				{
					valid = true;
					for(i = 0; i < lec; i++)
					{
						int professorId = -1, slotId = -1;
						int j;
						boolean id = false;
						System.out.println();
						
						while(id == false)
						{
							System.out.print("Professor ID for Lecture #" + (i + 1) + ": " );
							professorId = input.nextInt();
							if(professorId >= 1 && professorId <= 10)
							{
								for(j = 0; j < countP; j++)
								{
									if(professorId == prof[j].getProfId())
									{
										id = true;
										break;
									}
								}
								if(id == false)
									System.out.println("Invalid Professor ID! Professor ID does not exist.");
							}
							else
								System.out.println("Invalid Professor ID! Professor ID must be from #01 to #10.");
						}
	
						id = false;
						while(id == false)
						{
							System.out.print("Number of Slots for Lecture #" + (i + 1) + ": ");
							slotId = input.nextInt();
							if(slotId < 1)
								System.out.println("Invalid Number of Slots! Each Lecture Group must have atleast 1 Slot.");
							else if(slotId > 6)
								System.out.println("Invalid Number of Slots! Each Lecture Group must not have more than 8 Slots.");
							else
								id = true;
						}

						lecGrp[i] = new LectureGroup(professorId, slotId);
						System.out.println("Lecture #" + (i + 1) + " added!");
					}
					
					int temp = 0;
					for(i = 0; i < lec; i++)
						temp += lecGrp[i].getSlots();
					if(temp != slots)
					{
						System.out.println();
						System.out.println("Number of Slots did not tally! Please re-enter the Number of Slots per Lecture Group more carefully this time.");
						valid = false;
					}
				}
			}

			valid = false;
			while(valid == false)
			{
				System.out.println();
				System.out.print("Number of Lab Groups: ");
				lab = input.nextInt();
				if(lab < 0)
					System.out.println("Invalid Number of Lab Groups! The Number of Lab Groups cannot be a Negative Value.");
				else if(lab > 3)
					System.out.println("Invalid Number of Lab Groups! Each Course must not have more than 3 Lab Groups.");
				else
				{
					valid = true;
					for(i = 0; i < lab; i++)
					{
						int professorId = -1, slotId = -1;
						int j;
						boolean id = false;
						System.out.println();
						
						while(id == false)
						{
							System.out.print("Professor ID for Lab #" + (i + 1) + ": " );
							professorId = input.nextInt();
							if(professorId >= 1 && professorId <= 10)
							{
								for(j = 0; j < countP; j++)
								{
									if(professorId == prof[j].getProfId())
									{
										id = true;
										break;
									}
								}
								if(id == false)
									System.out.println("Invalid Professor ID! Professor ID does not exist.");
							}
							else
								System.out.println("Invalid Professor ID! Professor ID must be from #01 to #10.");
						}
	
						id = false;
						while(id == false)
						{
							System.out.print("Number of Slots for Lab #" + (i + 1) + ": ");
							slotId = input.nextInt();
							if(slotId < 1)
								System.out.println("Invalid Number of Slots! Each Lab Group must have atleast 1 Slot.");
							else if(slotId > 4)
								System.out.println("Invalid Number of Slots! Each Lab Group must not have more than 5 Slots.");
							else
								id = true;
						}

						labGrp[i] = new LabGroup(professorId, slotId);
						System.out.println("Lab #" + (i + 1) + " added!");
					}
					int temp = 0;
					for(i = 0; i < lab; i++)
						temp += labGrp[i].getSlots();
					if(temp != slots)
					{
						System.out.println();
						System.out.println("Number of Slots did not tally! Please re-enter the Number of Slots per Lab Group more carefully this time.");
						valid = false;
					}					
				}
			}

			valid = false;
			while(valid == false)
			{
				System.out.println();
				System.out.print("Number of Tutorial Groups: ");
				tut = input.nextInt();
				if(tut < 0)
					System.out.println("Invalid Number of Tutorial Groups! The Number of Lab Groups cannot be a Negative Value.");
				else if(tut > 4)
					System.out.println("Invalid Number of Tutorial Groups! Each Course must not have more than 3 Tutorial Groups.");
				else
				{
					valid = true;
					for(i = 0; i < tut; i++)
					{
						int professorId = -1, slotId = -1;
						int j;
						boolean id = false;
						System.out.println();
						
						while(id == false)
						{
							System.out.print("Professor ID for Tutorial #" + (i + 1) + ": " );
							professorId = input.nextInt();
							if(professorId >= 1 && professorId <= 10)
							{
								for(j = 0; j < countP; j++)
								{
									if(professorId == prof[j].getProfId())
									{
										id = true;
										break;
									}
								}
								if(id == false)
									System.out.println("Invalid Professor ID! Professor ID does not exist.");
							}
							else
								System.out.println("Invalid Professor ID! Professor ID must be from #01 to #10.");
						}
	
						id = false;
						while(id == false)
						{
							System.out.print("Number of Slots for Tutorial #" + (i + 1) + ": ");
							slotId = input.nextInt();
							if(slotId < 1)
								System.out.println("Invalid Number of Slots! Each Tutorial Group must have atleast 1 Slot.");
							else if(slotId > 3)
								System.out.println("Invalid Number of Slots! Each Tutorial Group must not have more than 3 Slots.");
							else
								id = true;
						}

						tutGrp[i] = new TutorialGroup(professorId, slotId);
						System.out.println("Tutorial #" + (i + 1) + " added!");
					}
					int temp = 0;
					for(i = 0; i < tut; i++)
						temp += tutGrp[i].getSlots();
					if(temp != slots)
					{
						System.out.println();
						System.out.println("Number of Slots did not tally! Please re-enter the Number of Slots per Tutorial Group more carefully this time.");
						valid = false;
					}
				}
			}

			course[countC] = new Course(courseId, courseName, faculty, p, slots, lec, lab, tut);
			countC++;
			if(courseId == 10)
				System.out.println("Course #" + courseId + " added!");
			else
				System.out.println("Course #0" + courseId + " added!");
			System.out.println();
			System.out.println("Currently Available Courses: ");
			for(i = 0; i < countC; i++)
			{
				System.out.println();
				System.out.println("ID: " + course[i].getCourseId());
				System.out.println("Course Name: " + course[i].getCourseName());
				System.out.println("Professor In-Charge: " + p.getProfName());
				System.out.println("Faculty: " + course[i].getFaculty());
			}
//		}
//		catch(Exception e)
//		{
//			System.out.println("Invalid Input! Input must only contain Numbers.");
//		}
//		finally
//		{
//			System.out.println("=================================================");
//		}
	}
		
	public void printStud()
	{
		
	}
	
	public void weightage()
	{
		
	}
	
	public void cwMark()
	{
		
	}
	
	public void examMark()
	{
		
	}
	
	public void printStats()
	{
		
	}
	
	public int getProfId()
	{
		return profId;
	}
	
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	public String getProfName()
	{
		return ("PROF. " + profFName + " " + profLName);
	}
	
	public String getProfEmail()
	{
		return profEmail;
	}
	
	public String getOfficeRm()
	{
		return officeRm;
	}
	
	public String getFaculty()
	{
		return faculty;
	}
	
	public static void main(String args[])
	{
		int count = 3;
		Student[] testS = new Student[10];
		Professor[] testP = new Professor[10];
		Course[] testC = new Course[10];
		testS[0] = new Student(1, "Dexter","Leow", "dexter@gmail.com", "12345678", "SCSE");
		testS[1] = new Student(2, "Chadd", "Lim", "chadd@gmail.com", "23456789", "SCSE");
		testS[2] = new Student(30, "Akshaya", "Muthu", "akshaya@gmail.com", "34567890", "SCSE");
		testC[0] = new Course(1, "COURSE1", "SCSE", testP[0], 10, 2, 0, 0);
		testC[1] = new Course(2, "COURSE2", "SCSE", testP[0], 10, 2, 0, 0);
		testC[2] = new Course(3, "COURSE3", "SCSE", testP[0], 10, 2, 0, 0);
		testP[0] = new Professor(1, "MN", "Shaanmugam", "sh44n96@e.uni.edu.sg", "86601489", "S-B1-01", "SCSE");
		testP[1] = new Professor(2, "MN", "Shaanmugar", "sh44n94@e.uni.edu.sg", "86601488", "S-B1-02", "SCSE");
		testP[2] = new Professor(3, "MN", "Shaanmugan", "sh44n95@e.uni.edu.sg", "86601480", "S-B1-03", "SCSE");
		testP[1].addCourse(testC, count, testP, count);
	}
}

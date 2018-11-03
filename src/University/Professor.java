package University;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Professor
{
	private int profId, phoneNo;
	private String profName, profEmail, officeRm, faculty;
	Scanner input = new Scanner(System.in);
	
	public Professor(int profId, String profName, String profEmail, int phoneNo, String officeRm, String faculty)
	{
		this.profId = profId;
		this.profName = profName;
		this.profEmail = profEmail;
		this.phoneNo = phoneNo;
		this.officeRm = officeRm;
		this.faculty = faculty;
	}
	
	public void addStud(Student[] stud, int count)
	{
		System.out.println("=================================================");
		
		int studId = -1, phoneNo = -1;
		String studName = null, studEmail = null, faculty = null;
		int i;
		
		try
		{
			System.out.print("Student ID: ");
			studId = input.nextInt();
			if(studId >= 1 && studId <= 999)
			{
				for(i = 0; i < count; i++)
				{
					if(studId == stud[i].getStudId())
					{
						System.out.println("Student ID #" + studId + " already exists!");
						studId = -1;
						break;
					}
				}
			}
			else
			{
				System.out.println("Invalid Student ID! Student ID should be from #1 to #999.");
				studId = -1;
			}			
		} catch(Exception e)
		{
			System.out.println("Student Id must be an integer value!");
		}
		
		if(studId != -1)
		{
			String firstName, lastName;
			System.out.print("First Name: ");
			firstName = input.next();
			System.out.print("Last Name: ");
			lastName = input.next();
			if(studName.matches(".*\\d+.*"))
			{
				System.out.println("Invalid Student Name! Student Name should not contain any numbers.");
				studName = null;
			}
		}
		
//		if(studName != null)
//		{
//			System.out.print("Student E-Mail: ");
//			studEmail = input.next();
//			Pattern pattern = Pattern.compile("[A-Za-z0-9_] + @[]");
//			Matcher mat = pattern.matcher(studEmail);
//			if(mat.matches())
//			{
//				System.out.println("pass");
//			}
//			else
//			{
//				System.out.println("fail");
//			}
//		}
		
		System.out.print("Phone Number: ");
		phoneNo = input.nextInt();
		System.out.print("Faculty: ");
		faculty = input.next();
		System.out.println();
		
		stud[stud.length] = new Student(studId, studName, studEmail, phoneNo, faculty);
		System.out.println("Student #" + studId + " added!");
		
		System.out.println("=================================================");
	}
	
	public void addCourse()
	{
		
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
	
	public int getPhoneNo()
	{
		return phoneNo;
	}
	
	public String getProfName()
	{
		return profName;
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
		int count;
		Student[] test = new Student[10];
		Professor prof = new Professor(1, "Shaan", "sh44n96@gmail.com", 86601489, "01-01", "SCSE");
		test[0] = new Student(1, "Dexter", "dexter@gmail.com", 12345678, "SCSE");
		test[1] = new Student(2, "Chadd", "chadd@gmail.com", 23456789, "SCSE");
		test[2] = new Student(3, "Akshaya", "akshaya@gmail.com", 34567890, "SCSE");
		count = 3;
		prof.addStud(test, count);
	}
}

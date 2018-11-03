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
		String studFName = null, studLName = null, studEmail = null, faculty = null;
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
			System.out.print("First Name: ");
			studFName = input.next();
			if(!studFName.matches("[a-zA-Z]+"))
			{
				System.out.println("Invalid Student Name! Student Name should only contain alphabets.");
				studFName = null;
			}
			System.out.print("Last Name: ");
			studLName = input.next();
			if(!studLName.matches("[a-zA-Z]+"))
			{
				System.out.println("Invalid Student Name! Student Name should only contain alphabets.");
				studLName = null;
			}
		}
		
		if(studFName != null && studLName != null)
		{
			System.out.print("Student E-Mail: ");
			studEmail = input.next();
			Pattern pattern = Pattern.compile("[A-Z0-9_]+@e.uni.edu.sg");
			Matcher mat = pattern.matcher(studEmail);
			if(!mat.matches())
			{
				System.out.println("Invalid E-Mail Address! E-Mail Address should be in this format: _____@e.uni.edu.sg");
				System.out.println("where _____ should only contain Uppercase Letters, Numbers or '_'(Underscores)");
				System.out.println("Example: MNSH_0001@e.uni.edu.sg");
				studEmail = null;
			}
		}
		
		if(studEmail != null)
		{
			
		}
		System.out.print("Phone Number: ");
		phoneNo = input.nextInt();
		System.out.print("Faculty: ");
		faculty = input.next();
		System.out.println();
		
		stud[count] = new Student(studId, studFName, studLName, studEmail, phoneNo, faculty);
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
		test[0] = new Student(1, "Dexter","Leow", "dexter@gmail.com", 12345678, "SCSE");
		test[1] = new Student(2, "Chadd", "Lim", "chadd@gmail.com", 23456789, "SCSE");
		test[2] = new Student(3, "Akshaya", "Muthu", "akshaya@gmail.com", 34567890, "SCSE");
		count = 3;
		prof.addStud(test, count);
	}
}

package University;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Professor
{
	private int profId;
	private String profFName, profLName, profEmail, officeRm, faculty, phoneNo;
	Scanner input = new Scanner(System.in);
	
	public Professor(int profId, String profFName, String profLName, String profEmail, String phoneNo, String officeRm, String faculty)
	{
		this.profId = profId;
		this.profFName = profFName;
		this.profLName = profLName;
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
					valid = false;
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
						valid = true;
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
	
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	public String getProfName()
	{
		return (profFName + " " + profLName);
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
	
//	public static void main(String args[])
//	{
//		int count;
//		Student[] test = new Student[10];
//		Professor prof = new Professor(1, "MN", "Shaanmugam", "sh44n96@gmail.com", "86601489", "01-01", "SCSE");
//		test[0] = new Student(1, "Dexter","Leow", "dexter@gmail.com", "12345678", "SCSE");
//		test[1] = new Student(2, "Chadd", "Lim", "chadd@gmail.com", "23456789", "SCSE");
//		test[2] = new Student(30, "Akshaya", "Muthu", "akshaya@gmail.com", "34567890", "SCSE");
//		count = 3;
//		prof.addStud(test, count);
//	}
}

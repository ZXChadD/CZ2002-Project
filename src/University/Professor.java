package University;

public class Professor
{
	private int profId, phoneNo;
	private String profName, profEmail, officeRm, faculty;
	Student stud;
	
	public Professor(int profId, String profName, String profEmail, int phoneNo, String officeRm, String faculty)
	{
		this.profId = profId;
		this.profName = profName;
		this.profEmail = profEmail;
		this.phoneNo = phoneNo;
		this.officeRm = officeRm;
		this.faculty = faculty;
	}
	
	public void addStud()
	{
		
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
}

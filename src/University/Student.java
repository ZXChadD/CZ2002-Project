package University;

public class Student
{
	private int studId, phoneNo;
	private String studFName, studLName, studEmail, faculty;
	
	public Student(int studId, String studFName, String studLName, String studEmail, int phoneNo, String faculty)
	{
		this.studId = studId;
		this.studFName = studFName;
		this.studLName = studLName;
		this.studEmail = studEmail;
		this.phoneNo = phoneNo;
		this.faculty = faculty;
	}

	public void regCourse()
	{
		
	}
	
	public void checkAvail()
	{
		
	}
	
	public void printTranscript()
	{
		
	}
	
	public int getStudId()
	{
		return studId;
	}
	
	public int getPhoneNo()
	{
		return phoneNo;
	}
	
	public String getStudFName()
	{
		return studFName;
	}
	
	public String getStudLName()
	{
		return studLName;
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

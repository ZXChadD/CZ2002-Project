package University;

public class Student
{
	private int studId;
	private String studFName, studLName, studEmail, faculty, phoneNo;
	
	public Student(int studId, String studFName, String studLName, String studEmail, String phoneNo, String faculty)
	{
		this.studId = studId;
		this.studFName = studFName.toUpperCase();
		this.studLName = studLName.toUpperCase();
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

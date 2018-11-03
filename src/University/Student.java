package University;

public class Student
{
	private int studId, phoneNo;
	private String studName, studEmail, faculty;
	
	public Student(int studId, String studName, String studEmail, int phoneNo, String faculty)
	{
		this.studId = studId;
		this.studName = studName;
		this.studEmail = studEmail;
		this.phoneNo = phoneNo;
		this.faculty = faculty;
	}
	
	public int getStudId()
	{
		return studId;
	}
	
	public int getPhoneNo()
	{
		return phoneNo;
	}
	
	public String getStudName()
	{
		return studName;
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

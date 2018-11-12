package University;

public class User 
{
	protected int id;
	protected String fName, lName, email, phoneNo, faculty;
	
	public int getId()
	{
		return id;
	};
	
	public String getName()
	{
		return(fName + lName);
	};
	
	public String getEmail()
	{
		return email;
	};
	
	public String getPhoneNo()
	{
		return phoneNo;
	};
	
	public String getFaculty()
	{
		return faculty;
	};
	
	public void setFName(String fName)
	{
		this.fName = fName;
	}
	
	public void setLName(String lName)
	{
		this.lName = lName;
	}

	public void setId(int id)
	{
		this.id = id;
	};
	
	public void setEmail(String email)
	{
		this.email = email;
	};
	
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	};
	
	public void setFaculty(String faculty)
	{
		this.faculty = faculty;
	};
}

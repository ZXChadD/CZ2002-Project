package University;

public abstract class User
{
	protected int id;
	protected String fName, lName, email, phoneNo, faculty;

	/**
	 * Creates a user
	 * @param id id
	 * @param fName first name
	 * @param lName last name
	 * @param email email
	 * @param phoneNo phone number
	 * @param faculty faculty that the user belongs to
	 */
	
	public User(int id, String fName, String lName, String email, String phoneNo, String faculty)
	{
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.faculty = faculty;
	}
	
	public abstract String getName();
	
	public int getId()
	{
		return id;
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

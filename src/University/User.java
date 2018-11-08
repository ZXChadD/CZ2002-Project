package University;

public abstract class User 
{
	private int id;
	private String fName, lName, email, phoneNo, faculty;
	
	public abstract int getId();
	
	public abstract String getName();
	
	public abstract String getEmail();
	
	public abstract String getPhoneNo();
	
	public abstract String getFaculty();
	
	public abstract void setId(int studId);
	
	public abstract void setEmail(String studEmail);
	
	public abstract void setPhoneNo(String phoneNo);
	
	public abstract void setFaculty(String faculty);
}

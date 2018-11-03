package University;

public class Course
{
	private int courseId, slots, lec, lab, tut;
	private String courseName, faculty;
	
	public Course(int courseId, int slots, int lec, int lab, int tut)
	{
		this.courseId = courseId;
		this.slots = slots;
		this.lec = lec;
		this.lab = lab;
		this.tut = tut;
	}
	
	public int getCourseId()
	{
		return courseId;
	}
	
	public int getSlots()
	{
		return slots;
	}
	
	public int getLec()
	{
		return lec;
	}
	
	public int getLab()
	{
		return lab;
	}
	
	public int getTut()
	{
		return tut;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public String getFaculty()
	{
		return faculty;
	}
}

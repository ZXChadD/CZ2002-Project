package University;

public class Course
{
	private String courseName, Faculty;
	private int courseId, slots, lec, lab, tut;
	
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
}

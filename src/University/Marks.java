package University;

public class Marks
{
	private int courseId, exam, coursework;
	
	public Marks(int courseId)
	{
		this.courseId = courseId;
		this.exam = 0;
		this.coursework = 0;
	}
	
	public int getCourseId()
	{
		return courseId;
	}
	
	public int getOverall()
	{
		return (exam + coursework);
	}
	
	public int getExam()
	{
		return exam;
	}
	
	public int getCoursework()
	{
		return coursework;
	}
	
	public void setCoursework(int mark)
	{
		coursework = mark;
	}

	public void setExam(int mark)
	{
		exam = mark;
	}
}

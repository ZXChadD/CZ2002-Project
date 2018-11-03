package University;

public class Marks
{
	private int courseId, overall, exam, coursework;
	
	public Marks(int courseId, int overall, int exam, int coursework)
	{
		this.courseId = courseId;
		this.overall = overall;
		this.exam = exam;
		this.coursework = coursework;
	}
	
	public int getCourseId()
	{
		return courseId;
	}
	
	public int getOverall()
	{
		return overall;
	}
	
	public int getExam()
	{
		return exam;
	}
	
	public int getCoursework()
	{
		return coursework;
	}
}

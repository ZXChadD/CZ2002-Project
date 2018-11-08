/**
 * Represents a marking scheme for a course
 */

package University;

public class Marks
{
	private int courseId, coursework, exam, overall;
	private String gradeC, gradeE, gradeO;

	/**
	 * Create marking scheme for a course
	 * Coursework and exam components initialised to 0
	 * @param courseId course id
	 */
	public Marks(int courseId)
	{
		this.courseId = courseId;
		this.coursework = 0;
		this.exam = 0;
	}
	
	public int getCourseId()
	{
		return courseId;
	}
	
	public void setCoursework(int mark)
	{
		coursework = mark;
	}
	
	public int getCoursework()
	{
		return coursework;
	}
	
	public void setExam(int mark)
	{
		exam = mark;
	}
	
	public int getExam()
	{
		return exam;
	}
	
	public void calcOverall()
	{
		overall = coursework + exam;
	}
	
	public int getOverall()
	{
		return (overall);
	}
	
	public void setGradeC(String letter)
	{
		gradeC = letter;
	}
	
	public String getGradeC()
	{
		return gradeC;
	}
	
	public void setGradeE(String letter)
	{
		gradeE = letter;
	}
	
	public String getGradeE()
	{
		return gradeE;
	}

    /**
     * Calculate the grade a student obtains based on marks
     */
	
	public void calcGradesO()
	{
		if(overall >= 80)
			gradeO = "A";
		else if(overall >= 70)
			gradeO = "B";
		else if(overall >= 60)
			gradeO = "C";
		else if(overall >= 50)
			gradeO = "D";
		else
			gradeO = "F";
	}
	
	public String getGradeO()
	{
		return gradeO;
	}
}

package University;

public class Marks
{
	private int courseId, coursework, exam, overall;
	private char gradeC, gradeE, gradeO;
	
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
	
	public void setGradeC(char letter)
	{
		gradeC = letter;
	}
	
	public char getGradeC()
	{
		return gradeC;
	}
	
	public void setGradeE(char letter)
	{
		gradeE = letter;
	}
	
	public char getGradeE()
	{
		return gradeE;
	}
	
	public void calcGradesO()
	{
		if(overall >= 80)
			gradeO = 'A';
		else if(overall >= 70)
			gradeO = 'B';
		else if(overall >= 60)
			gradeO = 'C';
		else if(overall >= 50)
			gradeO = 'D';
		else
			gradeO = 'F';
	}
	
	public char getGradeO()
	{
		return gradeO;
	}
}

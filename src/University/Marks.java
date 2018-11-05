package University;

public class Marks
{
	private int courseId, exam, coursework, overall;
	private char gradeC, gradeE, gradeO;
	
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
		return (overall);
	}
	
	public void calcOverall()
	{
		overall = coursework + exam;
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
	
	public void calcGrades()
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
	
	public char getGradeC()
	{
		return gradeC;
	}

	public char getGradeE()
	{
		return gradeE;
	}

	public void setGradeC(char letter)
	{
		gradeC = letter;
	}

	public void setGradeE(char letter)
	{
		gradeE = letter;;
	}
	
	public char getGradeO()
	{
		return gradeO;
	}
}

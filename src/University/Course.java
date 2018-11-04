package University;

public class Course
{
	private int courseId, slots, lec, lab, tut;
	private String courseName, faculty;
	Professor p;
	LectureGroup[] lecGrp = new LectureGroup[2];
	LabGroup[] labGrp = new LabGroup[3];
	TutorialGroup[] tutGrp = new TutorialGroup[4];

	public Course(int courseId, String courseName, String faculty, Professor p, int slots, int lec, int lab, int tut)
	{
		this.courseId = courseId;
		this.courseName = courseName;
		this.faculty = faculty;
		this.p = p;
		this.slots = slots;
		this.lec = lec;
		this.lab = lab;
		this.tut = tut;
	}
	
	public int getCourseId()
	{
		return courseId;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public String getFaculty()
	{
		return faculty;
	}
	
	public Professor getProfessor()
	{
		return p;
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

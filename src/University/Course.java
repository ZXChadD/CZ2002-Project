package University;

public class Course
{
	private int courseId, profId, slots;
	private String courseName, faculty;
	LectureGroup[] lecGrp = new LectureGroup[2];
	LabGroup[] labGrp = new LabGroup[3];
	TutorialGroup[] tutGrp = new TutorialGroup[4];
	Exam exam;
	Coursework[] coursework = new Coursework[3];
	
	public Course(int courseId, String courseName, String faculty, int profId, int slots)
	{
		this.courseId = courseId;
		this.courseName = courseName;
		this.faculty = faculty;
		this.profId = profId;
		this.slots = slots;
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
	
	public int getProfId()
	{
		return profId;
	}
	
	public int getSlots()
	{
		return slots;
	}
	
	public int getLec()
	{
		return lecGrp.length;
	}
	
	public int getLab()
	{
		return labGrp.length;
	}
	
	public int getTut()
	{
		return tutGrp.length;
	}
}

package University;

import java.util.ArrayList;

public class Course
{
	private int courseId, profId, slots;
	private String courseName, faculty;
	ArrayList<LectureGroup> lecGrp = new ArrayList<>();
	ArrayList<LabGroup> labGrp = new ArrayList<>();
	ArrayList<TutorialGroup> tutGrp = new ArrayList<>();
	Exam exam;
	ArrayList<Coursework> coursework = new ArrayList<>();
	
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
		return lecGrp.size();
	}
	
	public int getLab()
	{
		return labGrp.size();
	}
	
	public int getTut()
	{
		return tutGrp.size();
	}
}

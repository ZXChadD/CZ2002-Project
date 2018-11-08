/**
 * Represent a course which a student can choose to be enrolled in
 * Student can be enrolled in multiple courses
 */

package University;

import java.util.ArrayList;

public class Course
{
	private int courseId, profId;
	private String courseName, faculty;

    /**
     *  The number of slots for a course
     */
	private int slots;

	ArrayList<LectureGroup> lecGrp = new ArrayList<>();
	ArrayList<LabGroup> labGrp = new ArrayList<>();
	ArrayList<TutorialGroup> tutGrp = new ArrayList<>();
	Exam exam;
	ArrayList<Coursework> coursework = new ArrayList<>();

    /**
     * Creates a new course
     * @param courseId course code
     * @param courseName name of the course
     * @param faculty faculty which this course belongs to
     * @param profId the id of the prof in-charged of the course
     * @param slots number of slots for this course
     */
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

/**
 * A component of course grades for students
 */
package University;

public class Exam
{
    /**
     * The weightage of this exam for a particular course
     */
	private int percentage;
	
    /**
     * Creates a new exam component with the given percentage
     * @param percentage weightage for the exam component
     */
	public Exam(int percentage)
	{
		this.percentage = percentage;
	}
	
    /**
     * Gets the weightage of this exam
     * @return the weightage
     */
	public int getPercentage()
	{
		return percentage;
	}
}

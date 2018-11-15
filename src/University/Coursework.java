/**
 * A component of course grades for students
 */
package University;

public class Coursework
{
    /**
     * The weightage of this coursework for a particular course
     */
	private int percentage;
	
    /**
     * Name of coursework
     */
	private String name;
	
    /**
     * Creates a new coursework component with the given percentage and name
     * @param percentage weightage for the coursework component
     * @param name name for the coursework component
     */
	public Coursework(int percentage, String name)
	{
		this.percentage = percentage;
		this.name = name;
	}
	
    /**
     * Gets the weightage of this coursework
     * @return the weightage
     */
	public int getPercentage()
	{
		return percentage;
	}
	
    /**
     * Gets the name of this coursework
     * @return the name
     */
	public String getName()
	{
		return name;
	}
}

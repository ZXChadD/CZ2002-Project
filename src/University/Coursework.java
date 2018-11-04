package University;

public class Coursework
{
	private int percentage;
	private String name;
	
	public Coursework(int percentage, String name)
	{
		this.percentage = percentage;
		this.name = name;
	}
	
	public int getPercentage()
	{
		return percentage;
	}
	
	public String getName()
	{
		return name;
	}
}

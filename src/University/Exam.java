package University;

public class Exam
{
	private double percentage;
	private int max;
	
	public Exam(double percentage, int max)
	{
		this.percentage = percentage;
		this.max = max;
	}
	
	public double getPercentage()
	{
		return percentage;
	}
	
	public int getMax()
	{
		return max;
	}
}

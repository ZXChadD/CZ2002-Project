package University;

public class TutorialGroup
{
	private int profId, slots;
	public int[] studIds = new int[3];
	
	public TutorialGroup(int profId, int slots)
	{
		this.profId = profId;
		this.slots = slots;
	}
	
	public int getProfId()
	{
		return profId;
	}
	
	public int getSlots()
	{
		return slots;
	}
}

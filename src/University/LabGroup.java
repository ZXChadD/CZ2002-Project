package University;

public class LabGroup
{
	private int profId, slots;
	private int[] studIds = new int[5];
	
	public LabGroup(int profId, int slots)
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

package University;

public class LectureGroup
{
	private int profId, slots;
	private int[] studIds = new int[8];
	
	public LectureGroup(int profId, int slots)
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

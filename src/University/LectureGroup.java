package University;

public class LectureGroup
{
	private int profId, slots;
	public int[] studIds = new int[6];
	
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

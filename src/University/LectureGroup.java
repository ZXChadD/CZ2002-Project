package University;

public class LectureGroup
{
	private int studId, lecId, profId, slots;
	
	public LectureGroup(int studId, int lecId, int profId, int slots)
	{
		this.studId = studId;
		this.lecId = lecId;
		this.profId = profId;
		this.slots = slots;
	}
	
	public int getStudId()
	{
		return studId;
	}
	
	public int getLecId()
	{
		return lecId;
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

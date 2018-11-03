package University;

public class TutorialGroup
{
	private int studId, tutId, profId, slots;
	
	public TutorialGroup(int studId, int tutId, int profId, int slots)
	{
		this.studId = studId;
		this.tutId = tutId;
		this.profId = profId;
		this.slots = slots;
	}
	
	public int getStudId()
	{
		return studId;
	}
	
	public int getTutId()
	{
		return tutId;
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

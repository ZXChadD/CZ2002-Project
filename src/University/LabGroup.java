package University;

public class LabGroup
{
	private int studId, labId, profId, slots;
	
	public LabGroup(int studId, int labId, int profId, int slots)
	{
		this.studId = studId;
		this.labId = labId;
		this.profId = profId;
		this.slots = slots;
	}
	
	public int getStudId()
	{
		return studId;
	}
	
	public int getLabId()
	{
		return labId;
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

package University;

import java.util.ArrayList;

public class LabGroup
{
	private int profId, slots;
	public ArrayList<Integer> studIds = new ArrayList<>();
	
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

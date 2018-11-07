package University;

import java.util.ArrayList;

public class TutorialGroup
{
	private int profId, slots;
	public ArrayList<Integer> studIds = new ArrayList<>();
	
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

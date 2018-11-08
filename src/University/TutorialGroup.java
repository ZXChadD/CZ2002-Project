/**
 * Represents a tutorial group which belongs to a course
 */
package University;

import java.util.ArrayList;

public class TutorialGroup
{
	private int profId, slots;
	public ArrayList<Integer> studIds = new ArrayList<>();

    /**
     * Creates a tutorial group
     * @param profId professor who is in-charged of this tutorial group
     * @param slots number of slots for this tutorial group
     */
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

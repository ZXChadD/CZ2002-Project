/**
 * Represents a lecture group which belongs to a course
 */
package University;

import java.util.ArrayList;

public class LectureGroup
{
	private int profId, slots;
	public ArrayList<Integer> studIds = new ArrayList<>();

	/**
	 * Creates a lab group
	 * @param profId professor who is in-charged of this lecture group
	 * @param slots number of slots for this lecture group
	 */
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

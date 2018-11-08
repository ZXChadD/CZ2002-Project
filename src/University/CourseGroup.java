package University;

import java.util.ArrayList;

public abstract class CourseGroup
{
	private int profId, slots;
	public ArrayList<Integer> studIds = new ArrayList<>();
	
	public abstract int getProfId();
	
	public abstract int getSlots();
}

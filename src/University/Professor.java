package University;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Professor extends User
{
	private String officeRm;
	Scanner input = new Scanner(System.in);
	
	/**
	 *  Creates a professor based on various attributes
	**/
	public Professor(int profId, String profFName, String profLName, String profEmail, String profPhoneNo, String officeRm, String profFaculty)
	{
		super(profId, profFName, profLName, profEmail, profPhoneNo, profFaculty);
		this.officeRm = officeRm;
	}

	/**
	 * Add a student
	 * @param stud all students
	 * @param countS total count of students
	 * @return count
	 */
	public int addStud(ArrayList<Student> stud, int countS)
	{
		System.out.println("=================================================");
		
		try
		{
			int studId = countS +1, i = 0;
			String studFName = null, studLName = null, studEmail = null, phoneNo = null, faculty = null, nric = null;
			boolean valid = false;
			
			while(valid == false)
			{
				System.out.print("NRIC: ");
				nric = input.next();
				Pattern patternNRIC = Pattern.compile("[A-Z]+[0-9]+[A-Z]");
				Matcher matNRIC = patternNRIC.matcher(nric);
				if(!matNRIC.matches())
				{
					System.out.println("Invalid NRIC! NRIC must be in this format: X_______X");
					System.out.println("where X is an Uppercase Letter and _______ is exactly 7 digits long");
					System.out.println("Example: S1234567A");
				}
				else
				{
					valid = true;
					for(i = 0; i < countS; i++)
					{
						if(nric.equals(stud.get(i).getNRIC()))
						{
							valid = false;
							System.out.println("Student already exists!");
							break;
						}
					}
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("First Name: ");
				studFName = input.next();
				if(!studFName.matches("[a-zA-Z]+"))
				{
					System.out.println("Invalid Student Name! Student Name must contain only Alphabets.");
					studFName = null;
				}
				if(studFName != null)
				{
					System.out.print("Last Name: ");
					studLName = input.next();
					if(!studLName.matches("[a-zA-Z]+"))
						System.out.println("Invalid Student Name! Student Name must contain only Alphabets.");
					else
					{
						studFName.toUpperCase();
						studLName.toUpperCase();
						valid = true;
					}
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Student E-Mail (_____@e.uni.edu.sg): ");
				studEmail = input.next();
				Pattern pattern = Pattern.compile("[A-Z0-9_]+@e.uni.edu.sg");
				Matcher mat = pattern.matcher(studEmail);
				if(!mat.matches())
				{
					System.out.println("Invalid E-Mail Address! E-Mail Address must be in this format: _____@e.uni.edu.sg");
					System.out.println("where _____ must contain only Uppercase Letters, Numbers or '_'(Underscores)");
					System.out.println("Example: MNSH_0001@e.uni.edu.sg");
				}
				else if(studEmail.length() <= 17)
					System.out.println("Invalid E-Mail Address! _____ must contain atleast 5 Characters");
				else
				{
					valid = true;
					for(i = 0; i < countS; i++)
					{
						if(studEmail.equals(stud.get(i).getEmail()))
						{
							valid = false;
							System.out.println("Invalid Student E-Mail Address! E-Mail Address already exists!");
							break;
						}
					}
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Phone Number: ");
				phoneNo = input.next();
				if(!phoneNo.matches("[0-9]+"))
					System.out.println("Invalid Phone Number! Phone Number must contain only Numbers.");
				else if(phoneNo.length() != 8)
					System.out.println("Invalid Phone Number! Phone Number must be exactly 8 digits.");
				else if(phoneNo.charAt(0) != '9' && phoneNo.charAt(0) != '8' && phoneNo.charAt(0) != '6')
					System.out.println("Invalid Phone Number! Phone Number must start with only '9', '8', or '6'.");
				else
				{
					valid = true;
					for(i = 0; i < countS; i++)
					{
						if(phoneNo.equals(stud.get(i).getPhoneNo()))
						{
							valid = false;
							System.out.println("Invalid Student Phone Number! Phone Number already exists!");
							break;
						}
					}
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Faculty (SCSE/MAE/EEE): ");
				faculty = input.next();
				if(!faculty.equals("SCSE") && !faculty.equals("MAE") && !faculty.equals("EEE"))
					System.out.println("Invalid Faculty! Faculty must only be one of the following: SCSE, MAE, or EEE");
				else
					valid = true;
			}
			
			Student tempStud = new Student(studId, studFName, studLName, studEmail, phoneNo, faculty, nric);
			stud.add(countS, tempStud);
			countS++;
			System.out.println("Student #" + studId + " added!");
			System.out.println("\nCurrently Available Students: ");
			for(i = 0; i < countS; i++)
			{
				System.out.println("\nID: " + stud.get(i).getId());
				System.out.println("Name: " + stud.get(i).getName());
				System.out.println("Faculty: " + stud.get(i).getFaculty());
				System.out.println("Phone Number: " + stud.get(i).getPhoneNo());
				System.out.println("E-Mail Address: " + stud.get(i).getEmail());
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("An Unexpected Error has Occurred!");
		}
		catch(Exception ex)
		{
			System.out.println("Invalid Input! Input must only contain Numbers when appropriate.");
		}
		finally
		{
			System.out.println("=================================================");
		}
		return countS-1;
	}

	/**
	 * Add a course
	 * @param course all courses
	 * @param countC course count
	 * @param prof professor id
	 * @param countP professor count
	 * @return array of details
	 */
	
	public String[] addCourse(ArrayList<Course> course, int countC, ArrayList<Professor> prof, int countP)
	{
		System.out.println("=================================================");
		String [] ar = new String[3];
		try
		{
			int courseId = countC + 1, profId = 0, slots = -1, lec = -1, lab = -1, tut = -1, i = 0;
			String courseName = null; faculty = null;
			boolean valid = false;
			
			while(valid == false)
			{
				System.out.print("Course Name(no space in between words, eg. DataStructure): ");
				courseName = input.next();
				valid = true;
				for(i = 0; i < countC; i++)
				{
					if (courseName.equals(course.get(i).getCourseName()))
					{
						valid = false;
						System.out.println("Course already exists!");
						break;
					}
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Faculty (SCSE/MAE/EEE): ");
				faculty = input.next();
				if(!faculty.equals("SCSE") && !faculty.equals("MAE") && !faculty.equals("EEE"))
					System.out.println("Invalid Faculty! Faculty must only be one of the following: SCSE, MAE, or EEE");
				else
					valid = true;
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("ID of Professor In-Charge (#1 - #10): ");
				profId = input.nextInt();
				if(profId >= 1 && profId <= 10)
				{
					for(i = 0; i < countP; i++)
					{
						if(profId == prof.get(i).getId())
						{
							valid = true;
							break;
						}
					}
					if(valid == false)
						System.out.println("Invalid Professor Id! Professor ID does not exist.");
				}
				else
					System.out.println("Invalid Professor ID! Professor ID must be from #1 to #10.");
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Number of Slots (1 - 16): ");
				slots = input.nextInt();
				if(slots < 1)
					System.out.println("Invalid Number of Slots! Each Course must have atleast 1 Slot.");
				else if(slots > 16)
					System.out.println("Invalid Number of Slots! Each Course must not have more than 16 Slots.");
				else
					valid = true;
			}
			Course tempC = new Course(courseId, courseName, faculty, profId, slots);
			course.add(countC, tempC);
			countC++;
			
			valid = false;
			while(valid == false)
			{
				System.out.print("\nNumber of Lecture Groups (1 - 2): ");
				lec = input.nextInt();
				if(lec < 1)
					System.out.println("Invalid Number of Lecture Groups! Each Course must have atleast 1 Lecture Group.");
				else if(lec > 2)
					System.out.println("Invalid Number of Lecture Groups! Each Course must not have more than 2 Lecture Groups.");
				else
				{
					valid = true;
					int professorId = 0, slotId = 0, j = 0;
					for(i = 0; i < lec; i++)
					{
						boolean id = false;
						
						while(id == false)
						{
							System.out.print("\nProfessor ID for Lecture #" + (i + 1) + ": " );
							professorId = input.nextInt();
							if(professorId >= 1 && professorId <= 10)
							{
								for(j = 0; j < countP; j++)
								{
									if(professorId == prof.get(j).getId())
									{
										id = true;
										break;
									}
								}
								if(id == false)
									System.out.println("Invalid Professor ID! Professor ID does not exist.");
							}
							else
								System.out.println("Invalid Professor ID! Professor ID must be from #1 to #10.");
						}
						
						if(i == (lec - 1))
							slotId = slots - (slotId * i);
						else
							slotId = slots / lec;
						LectureGroup tempLec = new LectureGroup(professorId, slotId);
						course.get(countC-1).lecGrp.add(i, tempLec);
						System.out.println("Number of Slots for Lecture #" + (i + 1) + ": " + slotId);
					}
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("\nNumber of Lab Groups (0 - 3): ");
				lab = input.nextInt();
				ar[0] = String.valueOf(lab);
				if(lab < 0)
					System.out.println("Invalid Number of Lab Groups! The Number of Lab Groups cannot be a Negative Value.");
				else if(lab > 3)
					System.out.println("Invalid Number of Lab Groups! Each Course must not have more than 3 Lab Groups.");
				else
				{
					valid = true;
					int professorId = 0, slotId = 0, j = 0;
					for(i = 0; i < lab; i++)
					{
						boolean id = false;
						
						while(id == false)
						{
							System.out.print("\nProfessor ID for Lab #" + (i + 1) + ": " );
							professorId = input.nextInt();
							if(professorId >= 1 && professorId <= 10)
							{
								for(j = 0; j < countP; j++)
								{
									if(professorId == prof.get(j).getId())
									{
										id = true;
										break;
									}
								}
								if(id == false)
									System.out.println("Invalid Professor ID! Professor ID does not exist.");
							}
							else
								System.out.println("Invalid Professor ID! Professor ID must be from #1 to #10.");
						}
						
						if(i == (lab - 1))
							slotId = slots - (slotId * i);
						else
							slotId = slots / lab;
						LabGroup tempLab = new LabGroup(professorId, slotId);
						course.get(countC-1).labGrp.add(i, tempLab);
						System.out.println("Number of Slots for Lab #" + (i + 1) + ": " + slotId);
					}
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("\nNumber of Tutorial Groups (0 - 4): ");
				tut = input.nextInt();
				ar[1] = String.valueOf(tut);
				if(tut < 0)
					System.out.println("Invalid Number of Tutorial Groups! The Number of Lab Groups cannot be a Negative Value.");
				else if(tut > 4)
					System.out.println("Invalid Number of Tutorial Groups! Each Course must not have more than 4 Tutorial Groups.");
				else
				{
					valid = true;
					int professorId = 0, slotId = 0, j = 0;
					for(i = 0; i < tut; i++)
					{
						boolean id = false;
						
						while(id == false)
						{
							System.out.print("\nProfessor ID for Tutorial #" + (i + 1) + ": " );
							professorId = input.nextInt();
							if(professorId >= 1 && professorId <= 10)
							{
								for(j = 0; j < countP; j++)
								{
									if(professorId == prof.get(j).getId())
									{
										id = true;
										break;
									}
								}
								if(id == false)
									System.out.println("Invalid Professor ID! Professor ID does not exist.");
							}
							else
								System.out.println("Invalid Professor ID! Professor ID must be from #1 to #10.");
						}
						
						if(i == (tut - 1))
							slotId = slots - (slotId * i);
						else
							slotId = slots / tut;
						TutorialGroup tempTut = new TutorialGroup(professorId, slotId);
						course.get(countC-1).tutGrp.add(i, tempTut);
						System.out.println("Number of Slots for Tutorial #" + (i + 1) + ": " + slotId);
					}
				}
			}
			
			System.out.println("\nCourse #" + courseId + " added!");
			System.out.println("\nCurrently Available Courses: ");
			for(i = 0; i < countC; i++)
			{
				System.out.println("\nID: " + course.get(i).getCourseId());
				System.out.println("Course Name: " + course.get(i).getCourseName());
				System.out.println("ID of Professor In-Charge: " + profId);
				System.out.println("Faculty: " + course.get(i).getFaculty());
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("An Unexpected Error has Occurred!");
		}
		catch(Exception ex)
		{
			System.out.println("Invalid Input! Input must only contain Numbers when appropriate.");
		}
		finally
		{
			System.out.println("=================================================");
		}
		ar[2] = String.valueOf(countC-1);
		return ar;
	}

	/**
	 * Print all students that are registered for a course based on lecture/tutorial/lab groups
	 * @param stud students
	 * @param countS student count
	 * @param course courses
	 * @param countC course count
	 */
	
	public void printStud(ArrayList<Student> stud, int countS, ArrayList<Course> course, int countC)
	{
		System.out.println("=================================================");
		
		try
		{
			int courseId = 0, i = 0, index = 0;
			boolean  valid = false;
			String temp = null;
			
			while(valid == false)
			{
				System.out.print("Course ID: ");
				courseId = input.nextInt();
				if(courseId >= 1 && courseId <= 10)
				{
					for(i = 0; i < countC; i++)
					{
						if(courseId == course.get(i).getCourseId())
						{
							valid = true;
							index = i;
							break;
						}
					}
					if(valid == false)
						System.out.println("Invalid Course ID! Course ID does not exist.");
				}
				else
					System.out.println("Invalid Course ID! Course ID must be from #1 to #10.");
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.println("");
				System.out.print("Print Student by Group (LEC/LAB/TUT): ");
				temp = input.next();
				
				if(temp.equals("LEC"))
				{
					valid = true;
					int tempId = 0, j = 0, k = 0;
					for(i = 0; i < course.get(index).getLec(); i++)
					{
						if(course.get(index).lecGrp.get(i) != null)
						{
							System.out.println("\nLecture #" + (i + 1) + " for Course #" + courseId + ": ");
							for(j = 0; j < course.get(index).lecGrp.get(i).studIds.size(); j++)
							{
								tempId = course.get(index).lecGrp.get(i).studIds.get(j);
								for(k = 0; k < countS; k++)
								{
									if(tempId == stud.get(k).getId())
									{
										System.out.println("\nStudent ID: " + tempId);
										System.out.println("Name: " + stud.get(k).getName());
										System.out.println("Faculty: " + stud.get(k).getFaculty());
										break;
									}
								}
							}
						}
					}
				}
				else if(temp.equals("LAB"))
				{
					valid = true;
					int tempId = 0, j = 0, k = 0;
					for(i = 0; i < course.get(index).getLab(); i++)
					{
						if(course.get(index).labGrp.get(i) != null)
						{
							System.out.println("\nLab #" + (i + 1) + " for Course #" + courseId + ": ");
							for(j = 0; j < course.get(index).labGrp.get(i).studIds.size(); j++)
							{
								tempId = course.get(index).labGrp.get(i).studIds.get(j);
								for(k = 0; k < countS; k++)
								{
									if(tempId == stud.get(k).getId())
									{
										System.out.println("\nStudent ID: " + tempId);
										System.out.println("Name: " + stud.get(k).getName());
										System.out.println("Faculty: " + stud.get(k).getFaculty());
										break;
									}
								}
							}
						}
					}
				}
				else if(temp.equals("TUT"))
				{
					valid = true;
					int tempId = 0, j = 0, k = 0;
					for(i = 0; i < course.get(index).getTut(); i++)
					{
						if(course.get(index).tutGrp.get(i) != null)
						{
							System.out.println("\nTutorial #" + (i + 1) + " for Course #" + courseId + ": ");
							for(j = 0; j < course.get(index).tutGrp.get(i).studIds.size(); j++)
							{
								tempId = course.get(index).tutGrp.get(i).studIds.get(j);
								for(k = 0; k < countS; k++)
								{
									if(tempId == stud.get(k).getId())
									{
										System.out.println("\nStudent ID: " + tempId);
										System.out.println("Name: " + stud.get(k).getName());
										System.out.println("Faculty: " + stud.get(k).getFaculty());
										break;
									}
								}
							}
						}
					}
				}
				else
					System.out.println("Invalid Group Name! Group must only be on of the following: LEC/LAB/TUT");
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("An Unexpected Error has Occurred!");
		}
		catch(Exception ex)
		{
			System.out.println("Invalid Input! Input must only contain Numbers when appropriate.");
		}
		finally
		{
			System.out.println("=================================================");
		}
	}

	/**
	 * Ensures the corectness of the weightage of exam/coursework components entered by the professor
	 * @param course courses
	 * @param countC course count
	 * @return array of details 
	 */
	
	public String[] weightage(ArrayList<Course> course, int countC)
	{
		System.out.println("=================================================");
		String[] ar = new String[2];
		try
		{
			int courseId = 0, i = 0, index = 0, cw = 0;
			boolean  valid = false;
			
			while(valid == false)
			{
				System.out.print("Course ID: ");
				courseId = input.nextInt();
				if(courseId >= 1 && courseId <= 10)
				{
					for(i = 0; i < countC; i++)
					{
						if(courseId == course.get(i).getCourseId())
						{
							valid = true;
							index = i;
							break;
						}
					}
					if(valid == false)
						System.out.println("Invalid Course ID! Course ID does not exist.");
				}
				else
					System.out.println("Invalid Course ID! Course ID must be from #1 to #10.");
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Number of Coursework Components: ");
				cw = input.nextInt();
				ar[0] = String.valueOf(cw);
				if(cw < 0)
					System.out.println("Invalid Number of Coursework Components! The Number of Coursework Components cannot be a Negative Value.");
				else if(cw > 3)
					System.out.println("Invalid Number of Coursework Components! Each Course must not have more than 3 Coursework Components.");
				else
					valid = true;
			}
			
			valid = false;
			while(valid == false)
			{
				int exam = 0, temp = 0;
				boolean valid2 = false;
				
				for(i = 0; i < cw; i++)
				{
					String name = null;
					int percent = 0;
					
					System.out.print("\nCoursework Component Name: ");
					name = input.next();
					
					valid2 = false;
					while(valid2 == false)
					{
						System.out.print("Weightage of " + name + " in Course #" + courseId + "(%): ");
						percent = input.nextInt();
						if(percent < 0)
							System.out.println("Invalid Weightage Percentage! The Weightage Percentage cannot be a Negative Value.");
						else if(percent > 100)
							System.out.println("Invalid Weightage Percentage! Each Coursework must not have more than 100% Weightage.");
						else
						{
							Coursework tempcw = new Coursework(percent, name);
							course.get(index).coursework.add(i, tempcw);
							System.out.println("Coursework Component '" + name + "' added for Course #" + courseId);
							valid2 = true;
						}
					}
				}
				
				valid2 = false;
				while(valid2 == false)
				{
					System.out.print("\nWeightage of Exam in Course #" + courseId + "(%): ");
					exam = input.nextInt();
					if(exam < 0)
						System.out.println("Invalid Weightage Percentage! The Weightage Percentage cannot be a Negative Value.");
					else if(exam > 100)
						System.out.println("Invalid Weightage Percentage! The Weightage of the Exam must not have more than 100% Weightage.");
					else
						valid2 = true;
				}
				course.get(index).exam = new Exam(exam);
				
				for(i = 0; i < cw; i++)
					temp += course.get(index).coursework.get(i).getPercentage();
				temp += course.get(index).exam.getPercentage();
				if(temp != 100)
				{
					System.out.println("\nTotal Weightage Percentage did not tally up to 100! \nPlease re-enter the Coursework Components in the Course again.");
					valid = false;
				}
				else
					valid = true;
			}
			
			System.out.println("\nCourse Assessment Components Weightage: ");
			System.out.println("\nCourse ID: " + courseId);
			System.out.println("Name: " + course.get(index).getCourseName());
			System.out.println("Exam (%): " + course.get(index).exam.getPercentage());
			for(i = 0; i < cw; i++)
				System.out.println(course.get(index).coursework.get(i).getName() + " (%): " + course.get(index).coursework.get(i).getPercentage());
			ar[1] = String.valueOf(index);
		}
		catch(NullPointerException e)
		{
			System.out.println("An Unexpected Error has Occurred!");
		}
		catch(Exception ex)
		{
			System.out.println("Invalid Input! Input must only contain Numbers when appropriate.");
		}
		finally
		{
			System.out.println("=================================================");
		}
		return ar;
	}

	/**
	 * Enter the marks for coursework components of a particular course
	 * @param stud students
	 * @param countS student count
	 * @param course courses
	 * @param countC course count
	 * @return marks
	 */
	
	public String[] cwMark(ArrayList<Student> stud, int countS, ArrayList<Course> course, int countC)
	{
		String [] ar = new String[1];
		ar[0] = "0";
		System.out.println("=================================================");
		
		try
		{
			int courseId = 0, indexC = 0, studentId = 0, indexS = 0, indexM = 0, ans = 0, full = 0, i = 0, j = 0, k = 0;
			boolean  valid = false;
			
			while(valid == false)
			{
				System.out.print("Student ID: ");
				studentId = input.nextInt();
				if(studentId >= 1 && studentId <= 99)
				{
					for(i = 0; i < countS; i++)
					{
						if(studentId == stud.get(i).getId())
						{
							valid = true;
							indexS = i;
							break;
						}
					}
					if(valid == false)
						System.out.println("Invalid Student ID! Student ID does not exist.");
				}
				else
					System.out.println("Invalid Student ID! Student ID must be from #1 to #99.");
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Course ID: ");
				courseId = input.nextInt();
				if(courseId >= 1 && courseId <= 10)
				{
					for(i = 0; i < countC; i++)
					{
						if(courseId == course.get(i).getCourseId())
						{
							for(j = 0; j < course.get(i).getLec(); j++)
							{
								if(course.get(i).lecGrp.get(j) != null)
								{
									for(k = 0; k < course.get(i).lecGrp.get(j).studIds.size(); k++)
									{
										if(course.get(i).lecGrp.get(j).studIds.get(k) == studentId)
										{
											valid = true;
											indexC = i;
											break;
										}
									}
								}
							}
						}
					}
					if(valid == false)
						System.out.println("Invalid Course ID! Student does not exist in the Course.");
				}
				else
					System.out.println("Invalid Course ID! Course ID must be from #1 to #10.");
			}
			
			if(course.get(indexC).coursework.size()>0)
			{
				for(i = 0; i < stud.get(indexS).mark.size(); i++)
				{
					if(stud.get(indexS).mark.get(i) != null)
					{
						if(stud.get(indexS).mark.get(i).getCourseId() == courseId)
						{
							indexM = i;
							break;
						}
					}
				}
				
				i = 0;
				while(i<course.get(indexC).coursework.size())
				{
					int marks = 0;
					System.out.println("\nCoursework Name: " + course.get(indexC).coursework.get(i).getName());
					valid = false;
					while(valid == false)
					{
						System.out.print("Marks: ");
						marks = input.nextInt();
						if(marks < 0)
							System.out.println("Invalid Marks! Marks cannot be a Negative Value.");
						else if(marks > 100)
							System.out.println("Invalid Marks! Marks must not be more than 100.");
						else
							valid = true;
					}
					int percent = course.get(indexC).coursework.get(i).getPercentage();
					full += percent;
					double marksTemp = (double)(marks) * (double)(percent) / (double)100;
					int finalMarks = (int)(marksTemp);
					ans += finalMarks;
					if(marks >= 80)
						stud.get(indexS).mark.get(indexM).setGradeC("A");
					else if(marks >= 70)
						stud.get(indexS).mark.get(indexM).setGradeC("B");
					else if(marks >= 60)
						stud.get(indexS).mark.get(indexM).setGradeC("C");
					else if(marks >= 50)
						stud.get(indexS).mark.get(indexM).setGradeC("D");
					else
						stud.get(indexS).mark.get(indexM).setGradeC("E");
					i++;
				}
				
				stud.get(indexS).mark.get(indexM).setCoursework(ans);
				System.out.println("\nCoursework Marks for Course#" + courseId + ": ");
				System.out.println("Total Coursework Component Marks: " + stud.get(indexS).mark.get(indexM).getCoursework() + "/" + full);
				ar[0] = "1";
			}
			else
				System.out.println("This course does not have coursework.");
		
		}
		catch(NullPointerException e)
		{
			System.out.println("An Unexpected Error has Occurred!");
		}
		catch(Exception ex)
		{
			System.out.println("Invalid Input! Input must only contain Numbers when appropriate.");
		}
		finally
		{
			System.out.println("=================================================");
		}
		return ar;
	}

	/**
	 * Enter the marks for the exam component of a particular course
	 * @param stud students
	 * @param countS student count
	 * @param course courses
	 * @param countC course count
	 */
	public void examMark(ArrayList<Student> stud, int countS, ArrayList<Course> course, int countC)
	{
		System.out.println("=================================================");
		
		try
		{
			int courseId = 0, indexC = 0, studentId = 0, indexS = 0, indexM = 0, marks = 0, i = 0, j = 0, k = 0;
			boolean  valid = false;
			
			while(valid == false)
			{
				System.out.print("Student ID: ");
				studentId = input.nextInt();
				if(studentId >= 1 && studentId <= 99)
				{
					for(i = 0; i < countS; i++)
					{
						if(studentId == stud.get(i).getId())
						{
							valid = true;
							indexS = i;
							break;
						}
					}
					if(valid == false)
						System.out.println("Invalid Student ID! Student ID does not exist.");
				}
				else
					System.out.println("Invalid Student ID! Student ID must be from #1 to #99.");
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Course ID: ");
				courseId = input.nextInt();
				if(courseId >= 1 && courseId <= 10)
				{
					for(i = 0; i < countC; i++)
					{
						if(courseId == course.get(i).getCourseId())
						{
							for(j = 0; j < course.get(i).getLec(); j++)
							{
								if(course.get(i).lecGrp.get(j) != null)
								{
									for(k = 0; k < course.get(i).lecGrp.get(j).studIds.size(); k++)
									{
										if(course.get(i).lecGrp.get(j).studIds.get(k) == studentId)
										{
											valid = true;
											indexC = i;
											break;
										}
									}
								}
							}
						}
					}
					if(valid == false)
						System.out.println("Invalid Course ID! Student does not exist in the Course.");
				}
				else
					System.out.println("Invalid Course ID! Course ID must be from #1 to #10.");
			}
			
			for(i = 0; i < stud.get(indexS).mark.size(); i++)
			{
				if(stud.get(indexS).mark.get(i) != null)
				{
					if(stud.get(indexS).mark.get(i).getCourseId() == courseId)
					{
						indexM = i;
						break;
					}
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("\nExam Marks: ");
				marks = input.nextInt();
				if(marks < 0)
					System.out.println("Invalid Marks! Marks cannot be a Negative Value.");
				else if(marks > 100)
					System.out.println("Invalid Marks! Marks must not be more than 100.");
				else
					valid = true;
			}
			
			if(marks >= 80)
				stud.get(indexS).mark.get(indexM).setGradeE("A");
			else if(marks >= 70)
				stud.get(indexS).mark.get(indexM).setGradeE("B");
			else if(marks >= 60)
				stud.get(indexS).mark.get(indexM).setGradeE("C");
			else if(marks >= 50)
				stud.get(indexS).mark.get(indexM).setGradeE("D");
			else
				stud.get(indexS).mark.get(indexM).setGradeE("E");
			
			int percent = course.get(indexC).exam.getPercentage();
			double marksTemp = (double)(marks) * (double)(percent) / (double)100;
			int finalMarks = (int)(marksTemp);
			
			stud.get(indexS).mark.get(indexM).setExam(finalMarks);
			System.out.println("\nExam Marks for Course#" + courseId + ": " + stud.get(indexS).mark.get(indexM).getExam() + "/" + percent);
		}
		catch(NullPointerException e)
		{
			System.out.println("An Unexpected Error has Occurred!");
		}
		catch(Exception ex)
		{
			System.out.println("Invalid Input! Input must only contain Numbers when appropriate.");
		}
		finally
		{
			System.out.println("=================================================");
		}
	}

	/**
	 * Prints the statistics of a chosen course
	 * @param course courses
	 * @param countC course count
	 * @param stud student id
	 * @param countS student count
	 */
	public void printStats(ArrayList<Course> course, int countC, ArrayList<Student> stud, int countS)
	{
		System.out.println("=================================================");
		
		try
		{
			int courseId = 0, indexC = 0, studentId = 0, indexS = 0, indexM = 0, i = 0, j = 0;
			int full = 0, a = 0, b = 0, c = 0, d = 0, f = 0;
			double ans = 0.0;
			String answer = null;
			boolean  valid = false;
			
			while(valid == false)
			{
				System.out.print("Course ID: ");
				courseId = input.nextInt();
				if(courseId >= 1 && courseId <= 10)
				{
					for(i = 0; i < countC; i++)
					{
						if(courseId == course.get(i).getCourseId())
						{
							valid = true;
							indexC = i;
							break;
						}
					}
					if(valid == false)
						System.out.println("Invalid Course ID! Course ID does not exist.");
				}
				else
					System.out.println("Invalid Course ID! Course ID must be from #1 to #10.");
			}
			
			System.out.println("");
			System.out.println("Print Course Statistics: ");
			
			int l;
			for(l = 0; l < course.get(indexC).getLec(); l++)
			{
				while(j<course.get(indexC).lecGrp.get(l).studIds.size())
				{
					studentId = course.get(indexC).lecGrp.get(l).studIds.get(j);
					for(i = 0; i < countS; i++)
					{
						if(studentId == stud.get(i).getId())
						{
							indexS = i;
							break;
						}
					}
					
					for(i = 0; i < stud.get(indexS).mark.size(); i++)
					{
						if(stud.get(indexS).mark.get(i).getCourseId() == courseId)
						{
							indexM = i;
							break;
						}
					}
					
					stud.get(indexS).mark.get(indexM).calcOverall();
					stud.get(indexS).mark.get(indexM).calcGradesO();
					full++;
					
					if(stud.get(indexS).mark.get(indexM).getGradeO() == "A")
						a++;
					else if(stud.get(indexS).mark.get(indexM).getGradeO() == "B")
						b++;
					else if(stud.get(indexS).mark.get(indexM).getGradeO() == "C")
						c++;
					else if(stud.get(indexS).mark.get(indexM).getGradeO() == "D")
						d++;
					else if(stud.get(indexS).mark.get(indexM).getGradeO() == "F")
						f++;
					j++;
				}
				j = 0;
			}
			
			System.out.println("\nGrade Percentage for Overall Marks: ");
			ans = (double)a / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("A: " + answer + "%");
			ans = (double)b / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("B: " + answer + "%");
			ans = (double)c / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("C: " + answer + "%");
			ans = (double)d / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("D: " + answer + "%");
			ans = (double)f / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("F: " + answer + "%");
			
			full = a = b = c = d = f = 0;
			for(l = 0; l < course.get(indexC).getLec(); l++)
			{
				while(j<course.get(indexC).lecGrp.get(l).studIds.size())
				{
					studentId = course.get(indexC).lecGrp.get(l).studIds.get(j);
					for(i = 0; i < countS; i++)
					{
						if(studentId == stud.get(i).getId())
						{
							indexS = i;
							break;
						}
					}
					
					for(i = 0; i < stud.get(indexS).mark.size(); i++)
					{
						if(stud.get(indexS).mark.get(i).getCourseId() == courseId)
						{
							indexM = i;
							break;
						}
					}
					
					full++;
					if(stud.get(indexS).mark.get(indexM).getGradeE().equals("A"))
						a++;
					else if(stud.get(indexS).mark.get(indexM).getGradeE().equals("B"))
						b++;
					else if(stud.get(indexS).mark.get(indexM).getGradeE().equals("C"))
						c++;
					else if(stud.get(indexS).mark.get(indexM).getGradeE().equals("D"))
						d++;
					else if(stud.get(indexS).mark.get(indexM).getGradeE().equals("E"))
						f++;
					j++;
				}
				j = 0;
			}
			
			System.out.println("\nGrade Percentage for Exam Marks Only: ");
			ans = (double)a / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("A: " + answer + "%");
			ans = (double)b / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("B: " + answer + "%");
			ans = (double)c / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("C: " + answer + "%");
			ans = (double)d / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("D: " + answer + "%");
			ans = (double)f / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("F: " + answer + "%");
			
			full = a = b = c = d = f = 0;
			for(l = 0; l < course.get(indexC).getLec(); l++)
			{
				while(j<course.get(indexC).lecGrp.get(l).studIds.size())
				{
					studentId = course.get(indexC).lecGrp.get(l).studIds.get(j);
					for(i = 0; i < countS; i++)
					{
						if(studentId == stud.get(i).getId())
						{
							indexS = i;
							break;
						}
					}
					
					for(i = 0; i < stud.get(indexS).mark.size(); i++)
					{
						if(stud.get(indexS).mark.get(i).getCourseId() == courseId)
						{
							indexM = i;
							break;
						}
					}
					
					full++;
					if(stud.get(indexS).mark.get(indexM).getGradeC().equals("A"))
						a++;
					else if(stud.get(indexS).mark.get(indexM).getGradeC().equals("B"))
						b++;
					else if(stud.get(indexS).mark.get(indexM).getGradeC().equals("C"))
						c++;
					else if(stud.get(indexS).mark.get(indexM).getGradeC().equals("D"))
						d++;
					else if(stud.get(indexS).mark.get(indexM).getGradeC().equals("E"))
						f++;
					j++;
				}
				j = 0;
			}
			
			System.out.println("\nGrade Percentage for Coursework Marks Only: ");
			ans = (double)a / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("A: " + answer + "%");
			ans = (double)b / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("B: " + answer + "%");
			ans = (double)c / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("C: " + answer + "%");
			ans = (double)d / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("D: " + answer + "%");
			ans = (double)f / (double)full * 100;
			answer = String.format("%.1f", ans);
			System.out.println("F: " + answer + "%");
		}
		catch(NullPointerException e)
		{
			System.out.println("An Unexpected Error has Occurred!");
		}
		catch(Exception ex)
		{
			System.out.println("Invalid Input! Input must only contain Numbers when appropriate.");
		}
		finally
		{
			System.out.println("=================================================");
		}
	}
	
	public String getName()
	{
		return ("Prof. " + fName + " " + lName);
	}
	
	public String getOfficeRm()
	{
		return officeRm;
	}
	
	public void setOfficeRm(String officeRm)
	{
		this.officeRm = officeRm;
	}
}

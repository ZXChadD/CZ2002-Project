package University;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Professor
{
	private int profId;
	private String profFName, profLName, profEmail, phoneNo, officeRm, faculty;
	Scanner input = new Scanner(System.in);
	
	public Professor(int profId, String profFName, String profLName, String profEmail, String phoneNo, String officeRm, String faculty)
	{
		this.profId = profId;
		this.profFName = profFName.toUpperCase();
		this.profLName = profLName.toUpperCase();
		this.profEmail = profEmail;
		this.phoneNo = phoneNo;
		this.officeRm = officeRm;
		this.faculty = faculty;
	}
	
	public void addStud(Student[] stud, int countS)
	{
		System.out.println("=================================================");
		
		try
		{
			int studId = 0, i = 0;
			String studFName = null, studLName = null, studEmail = null, phoneNo = null, faculty = null;
			boolean valid = false;
			
			while(valid == false)
			{
				System.out.print("Student ID (#1 - #99): ");
				studId = input.nextInt();
				if(studId >= 1 && studId <= 99)
				{
					valid = true;
					for(i = 0; i < countS; i++)
					{
						if(studId == stud[i].getStudId())
						{
							valid = false;
							System.out.println("Invalid Student ID! Student ID #" + studId + " already exists!");
							break;
						}
					}
				}
				else
					System.out.println("Invalid Student ID! Student ID must be from #1 to #99.");
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
						if(studEmail.equals(stud[i].getStudEmail()))
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
						if(phoneNo.equals(stud[i].getPhoneNo()))
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
			
			stud[countS] = new Student(studId, studFName, studLName, studEmail, phoneNo, faculty);
			countS++;
			System.out.println("Student #" + studId + " added!");
			System.out.println("\nCurrently Available Students: ");
			for(i = 0; i < countS; i++)
			{
				System.out.println("\nID: " + stud[i].getStudId());
				System.out.println("Name: " + stud[i].getStudName());
				System.out.println("Faculty: " + stud[i].getFaculty());
				System.out.println("Phone Number: " + stud[i].getPhoneNo());
				System.out.println("E-Mail Address: " + stud[i].getStudEmail());
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("An Unexpected Error has Occurred!");
		}
		catch(Exception ex)
		{
			System.out.println("Invalid Student ID! Student ID must only contain Numbers.");
		}
		finally
		{
			System.out.println("=================================================");
		}
	}
	
	public void addCourse(Course[] course, int countC, Professor[] prof, int countP)
	{
		System.out.println("=================================================");
		
		try
		{
			int courseId = 0, profId = 0, slots = -1, lec = -1, lab = -1, tut = -1, i = 0;
			String courseName = null; faculty = null;
			boolean valid = false;
			
			while(valid == false)
			{
				System.out.print("Course ID (#1 - #10): ");
				courseId = input.nextInt();
				if(courseId >= 1 && courseId <= 10)
				{
					valid = true;
					for(i = 0; i < countC; i++)
					{
						if(courseId == course[i].getCourseId())
						{
							valid = false;
							System.out.println("Invalid Course ID! Course ID #" + courseId + " already exists!");
							break;
						}
					}
				}
				else
					System.out.println("Invalid Course ID! Course ID must be from #1 to #10.");
			}
			
			System.out.print("Course Name: ");
			courseName = input.next();
			
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
						if(profId == prof[i].getProfId())
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
				System.out.print("Number of Slots (1 - 12): ");
				slots = input.nextInt();
				if(slots < 1)
					System.out.println("Invalid Number of Slots! Each Course must have atleast 1 Slot.");
				else if(slots > 12)
					System.out.println("Invalid Number of Slots! Each Course must not have more than 12 Slots.");
				else
					valid = true;
			}
			
			course[countC] = new Course(courseId, courseName, faculty, profId, slots);
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
					for(i = 0; i < lec; i++)
					{
						int professorId = 0, slotId = 0, j = 0;
						boolean id = false;
						
						while(id == false)
						{
							System.out.print("\nProfessor ID for Lecture #" + (i + 1) + ": " );
							professorId = input.nextInt();
							if(professorId >= 1 && professorId <= 10)
							{
								for(j = 0; j < countP; j++)
								{
									if(professorId == prof[j].getProfId())
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
						
						id = false;
						while(id == false)
						{
							System.out.print("Number of Slots for Lecture #" + (i + 1) + ": ");
							slotId = input.nextInt();
							if(slotId < 1)
								System.out.println("Invalid Number of Slots! Each Lecture Group must have atleast 1 Slot.");
							else if(slotId > 6)
								System.out.println("Invalid Number of Slots! Each Lecture Group must not have more than 6 Slots.");
							else
								id = true;
						}
						
						course[countC - 1].lecGrp[i] = new LectureGroup(professorId, slotId);
					}
					
					int temp = 0;
					for(i = 0; i < lec; i++)
						temp += course[countC - 1].lecGrp[i].getSlots();
					if(temp != slots)
					{
						System.out.println("\nNumber of Slots did not tally! Please re-enter the Number of Slots per Lecture Group again.");
						valid = false;
					}
					else
						System.out.println("\nLectures added!");
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("\nNumber of Lab Groups (0 - 3): ");
				lab = input.nextInt();
				if(lab < 0)
					System.out.println("Invalid Number of Lab Groups! The Number of Lab Groups cannot be a Negative Value.");
				else if(lab > 3)
					System.out.println("Invalid Number of Lab Groups! Each Course must not have more than 3 Lab Groups.");
				else
				{
					valid = true;
					for(i = 0; i < lab; i++)
					{
						int professorId = 0, slotId = 0, j = 0;
						boolean id = false;
						
						while(id == false)
						{
							System.out.print("\nProfessor ID for Lab #" + (i + 1) + ": " );
							professorId = input.nextInt();
							if(professorId >= 1 && professorId <= 10)
							{
								for(j = 0; j < countP; j++)
								{
									if(professorId == prof[j].getProfId())
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
						
						id = false;
						while(id == false)
						{
							System.out.print("Number of Slots for Lab #" + (i + 1) + ": ");
							slotId = input.nextInt();
							if(slotId < 1)
								System.out.println("Invalid Number of Slots! Each Lab Group must have atleast 1 Slot.");
							else if(slotId > 4)
								System.out.println("Invalid Number of Slots! Each Lab Group must not have more than 4 Slots.");
							else
								id = true;
						}
						
						course[countC - 1].labGrp[i] = new LabGroup(professorId, slotId);
					}
					
					if(lab != 0)
					{
						int temp = 0;
						for(i = 0; i < lab; i++)
							temp += course[countC - 1].labGrp[i].getSlots();
						if(temp != slots)
						{
							System.out.println("\nNumber of Slots did not tally! Please re-enter the Number of Slots per Lab Group again.");
							valid = false;
						}
						else
							System.out.println("\nLabs added!");
					}
				}
			}
			
			valid = false;
			while(valid == false)
			{
				System.out.print("\nNumber of Tutorial Groups (0 - 4): ");
				tut = input.nextInt();
				if(tut < 0)
					System.out.println("Invalid Number of Tutorial Groups! The Number of Lab Groups cannot be a Negative Value.");
				else if(tut > 4)
					System.out.println("Invalid Number of Tutorial Groups! Each Course must not have more than 4 Tutorial Groups.");
				else
				{
					valid = true;
					for(i = 0; i < tut; i++)
					{
						int professorId = 0, slotId = 0, j = 0;
						boolean id = false;
						
						while(id == false)
						{
							System.out.print("\nProfessor ID for Tutorial #" + (i + 1) + ": " );
							professorId = input.nextInt();
							if(professorId >= 1 && professorId <= 10)
							{
								for(j = 0; j < countP; j++)
								{
									if(professorId == prof[j].getProfId())
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
						
						id = false;
						while(id == false)
						{
							System.out.print("Number of Slots for Tutorial #" + (i + 1) + ": ");
							slotId = input.nextInt();
							if(slotId < 1)
								System.out.println("Invalid Number of Slots! Each Tutorial Group must have atleast 1 Slot.");
							else if(slotId > 3)
								System.out.println("Invalid Number of Slots! Each Tutorial Group must not have more than 3 Slots.");
							else
								id = true;
						}
						
						course[countC - 1].tutGrp[i] = new TutorialGroup(professorId, slotId);
					}
					
					if(tut != 0)
					{
						int temp = 0;
						for(i = 0; i < tut; i++)
							temp += course[countC - 1].tutGrp[i].getSlots();
						if(temp != slots)
						{
							System.out.println("\nNumber of Slots did not tally! Please re-enter the Number of Slots per Tutorial Group  again.");
							valid = false;
						}
						else
							System.out.println("\nTutorials added!");
					}
				}
			}

			System.out.println("\nCourse #" + courseId + " added!");
			System.out.println("\nCurrently Available Courses: ");
			for(i = 0; i < countC; i++)
			{
				System.out.println("\nID: " + course[i].getCourseId());
				System.out.println("Course Name: " + course[i].getCourseName());
				System.out.println("ID of Professor In-Charge: " + profId);
				System.out.println("Faculty: " + course[i].getFaculty());
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
	
	public void printStud(Student [] stud, int countS, Course[] course, int countC)
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
						if(courseId == course[i].getCourseId())
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
					for(i = 0; i < course[index].getLec(); i++)
					{
						if(course[index].lecGrp[i] != null)
						{
							System.out.println("\nLecture #" + (i + 1) + " for Course #" + courseId + ": ");
							for(j = 0; j < course[index].lecGrp[i].getSlots(); j++)
							{
								tempId = course[index].lecGrp[i].studIds[j];
								for(k = 0; k < countS; k++)
								{
									if(tempId == stud[k].getStudId())
									{
										System.out.println("\nStudent ID: " + tempId);
										System.out.println("Name: " + stud[k].getStudName());
										System.out.println("Faculty: " + stud[k].getFaculty());
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
					for(i = 0; i < course[index].getLab(); i++)
					{
						if(course[index].labGrp[i] != null)
						{
							System.out.println("\nLab #" + (i + 1) + " for Course #" + courseId + ": ");
							for(j = 0; j < course[index].labGrp[i].getSlots(); j++)
							{
								tempId = course[index].labGrp[i].studIds[j];
								for(k = 0; k < countS; k++)
								{
									if(tempId == stud[k].getStudId())
									{
										System.out.println("\nStudent ID: " + tempId);
										System.out.println("Name: " + stud[k].getStudName());
										System.out.println("Faculty: " + stud[k].getFaculty());
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
					for(i = 0; i < course[index].getTut(); i++)
					{
						if(course[index].tutGrp[i] != null)
						{
							System.out.println("\nTutorial #" + (i + 1) + " for Course #" + courseId + ": ");
							for(j = 0; j < course[index].tutGrp[i].getSlots(); j++)
							{
								tempId = course[index].tutGrp[i].studIds[j];
								for(k = 0; k < countS; k++)
								{
									if(tempId == stud[k].getStudId())
									{
										System.out.println("\nStudent ID: " + tempId);
										System.out.println("Name: " + stud[k].getStudName());
										System.out.println("Faculty: " + stud[k].getFaculty());
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
	
	public void weightage(Course[] course, int countC)
	{
		System.out.println("=================================================");
		
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
						if(courseId == course[i].getCourseId())
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
							course[index].coursework[i] = new Coursework(percent, name);
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
				course[index].exam = new Exam(exam);
				
				for(i = 0; i < cw; i++)
					temp += course[index].coursework[i].getPercentage();
				temp += course[index].exam.getPercentage();
				if(temp != 100)
				{
					System.out.println("\nTotal Weightage Percentage did not tally up to 100! Please re-enter the Coursework Components in the Course again.");
					valid = false;
				}
				else
					valid = true;
			}
			
			System.out.println("\nCourse Assessment Components Weightage: ");
			System.out.println("\nCourse ID: " + courseId);
			System.out.println("Name: " + course[index].getCourseName());
			System.out.println("Exam (%): " + course[index].exam.getPercentage());
			for(i = 0; i < cw; i++)
				System.out.println(course[index].coursework[i].getName() + " (%): " + course[index].coursework[i].getPercentage());
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
	
	public void cwMark(Student[] stud, int countS, Course[] course, int countC)
	{
		System.out.println("=================================================");
		
		try
		{
			int courseId = 0, indexC = 0, studentId = 0, indexS = 0, indexM = 0, ans = 0, full = 0, i = 0, j = 0, k = 0;
			boolean  valid = false;
			
			while(valid == false)
			{
				System.out.print("Course ID: ");
				courseId = input.nextInt();
				if(courseId >= 1 && courseId <= 10)
				{
					for(i = 0; i < countC; i++)
					{
						if(courseId == course[i].getCourseId())
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
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Student ID: ");
				studentId = input.nextInt();
				if(studentId >= 1 && studentId <= 99)
				{
					for(i = 0; i < countS; i++)
					{
						if(studentId == stud[i].getStudId())
						{
							for(j = 0; j < course[indexC].getLec(); j++)
							{
								for(k = 0; k < course[indexC].getLec(); k++)
								{
									if(course[indexC].lecGrp[j] != null)
									{
										if(course[indexC].lecGrp[j].studIds[k] == studentId)
										{
											valid = true;
											indexS = i;
											break;
										}
									}
								}
							}
						}
					}
					if(valid == false)
						System.out.println("Invalid Student ID! Student ID does not exist in the Course.");
				}
				else
					System.out.println("Invalid Student ID! Student ID must be from #1 to #99.");
			}
			
			for(i = 0; i < stud[indexS].mark.length; i++)
			{
				if(stud[indexS].mark[i] == null)
				{
					indexM = i;
					stud[indexS].mark[indexM] = new Marks(courseId);
					break;
				}
			}
			
			i = 0;
			while(course[indexC].coursework[i] != null)
			{
				int marks = 0;
				System.out.println("\nCoursework Name: " + course[indexC].coursework[i].getName());
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
				int percent = course[indexC].coursework[i].getPercentage();
				full += percent;
				double marksTemp = (double)(marks) * (double)(percent) / (double)100;
				int finalMarks = (int)(marksTemp);
				ans += finalMarks;
				i++;
				if(marks >= 80)
					stud[indexS].mark[indexM].setGradeC('A');
				else if(marks >= 70)
					stud[indexS].mark[indexM].setGradeC('B');
				else if(marks >= 60)
					stud[indexS].mark[indexM].setGradeC('C');
				else if(marks >= 50)
					stud[indexS].mark[indexM].setGradeC('D');
				else
					stud[indexS].mark[indexM].setGradeC('E');
			}
			
			stud[indexS].mark[indexM].setCoursework(ans);
			System.out.println("\nCoursework Marks for Course#" + courseId + ": ");
			System.out.println("Total Coursework Component Marks: " + stud[indexS].mark[indexM].getCoursework() + "/" + full);
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
	
	public void examMark(Student[] stud, int countS, Course[] course, int countC)
	{
		System.out.println("=================================================");
		
		try
		{
			int courseId = 0, indexC = 0, studentId = 0, indexS = 0, indexM = 0, marks = 0, i = 0, j = 0, k = 0;
			boolean  valid = false;
			
			while(valid == false)
			{
				System.out.print("Course ID: ");
				courseId = input.nextInt();
				if(courseId >= 1 && courseId <= 10)
				{
					for(i = 0; i < countC; i++)
					{
						if(courseId == course[i].getCourseId())
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
			
			valid = false;
			while(valid == false)
			{
				System.out.print("Student ID: ");
				studentId = input.nextInt();
				if(studentId >= 1 && studentId <= 99)
				{
					for(i = 0; i < countS; i++)
					{
						if(studentId == stud[i].getStudId())
						{
							for(j = 0; j < course[indexC].getLec(); j++)
							{
								for(k = 0; k < course[indexC].getLec(); k++)
								{
									if(course[indexC].lecGrp[j] != null)
									{
										if(course[indexC].lecGrp[j].studIds[k] == studentId)
										{
											valid = true;
											indexS = i;
											break;
										}
									}
								}
							}
						}
					}
					if(valid == false)
						System.out.println("Invalid Student ID! Student ID does not exist in the Course.");
				}
				else
					System.out.println("Invalid Student ID! Student ID must be from #1 to #99.");
			}
			
			for(i = 0; i < stud[indexS].mark.length; i++)
			{
				if(stud[indexS].mark[i] != null)
				{
					if(stud[indexS].mark[i].getCourseId() == courseId)
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
					stud[indexS].mark[indexM].setGradeE('A');
				else if(marks >= 70)
					stud[indexS].mark[indexM].setGradeE('B');
				else if(marks >= 60)
					stud[indexS].mark[indexM].setGradeE('C');
				else if(marks >= 50)
					stud[indexS].mark[indexM].setGradeE('D');
				else
					stud[indexS].mark[indexM].setGradeE('E');

			int percent = course[indexC].exam.getPercentage();
			double marksTemp = (double)(marks) * (double)(percent) / (double)100;
			int finalMarks = (int)(marksTemp);
			
			stud[indexS].mark[indexM].setExam(finalMarks);
			System.out.println("\nExam Marks for Course#" + courseId + ": " + stud[indexS].mark[indexM].getExam() + "/" + percent);
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
	
	public void printStats(Course[] course, int countC, Student[] stud, int countS)
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
						if(courseId == course[i].getCourseId())
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
			
			j = 0;
			studentId = course[indexC].lecGrp[0].studIds[j];
			while(studentId != 0)
			{
				for(i = 0; i < countS; i++)
				{
					if(studentId == stud[i].getStudId())
					{
						indexS = i;
						break;
					}
				}
				
				for(i = 0; i < stud[indexS].mark.length; i++)
				{
					if(stud[indexS].mark[i].getCourseId() == courseId)
					{
						indexM = i;
						break;
					}
				}
				
				stud[indexS].mark[indexM].calcOverall();
				stud[indexS].mark[indexM].calcGradesO();
				full++;
				
				if(stud[indexS].mark[indexM].getGradeO() == 'A')
					a++;
				else if(stud[indexS].mark[indexM].getGradeO() == 'B')
					b++;
				else if(stud[indexS].mark[indexM].getGradeO() == 'C')
					c++;
				else if(stud[indexS].mark[indexM].getGradeO() == 'D')
					d++;
				else if(stud[indexS].mark[indexM].getGradeO() == 'F')
					f++;
				
				j++;
				studentId = course[indexC].lecGrp[0].studIds[j];
			}
			
			j = 0;
			studentId = course[indexC].lecGrp[1].studIds[j];
			while(studentId != 0)
			{
				for(i = 0; i < countS; i++)
				{
					if(studentId == stud[i].getStudId())
					{
						indexS = i;
						break;
					}
				}
				
				for(i = 0; i < stud[indexS].mark.length; i++)
				{
					if(stud[indexS].mark[i].getCourseId() == courseId)
					{
						indexM = i;
						break;
					}
				}
				
				stud[indexS].mark[indexM].calcOverall();
				stud[indexS].mark[indexM].calcGradesO();
				full++;
				
				if(stud[indexS].mark[indexM].getGradeO() == 'A')
					a++;
				else if(stud[indexS].mark[indexM].getGradeO() == 'B')
					b++;
				else if(stud[indexS].mark[indexM].getGradeO() == 'C')
					c++;
				else if(stud[indexS].mark[indexM].getGradeO() == 'D')
					d++;
				else if(stud[indexS].mark[indexM].getGradeO() == 'F')
					f++;
				
				j++;
				studentId = course[indexC].lecGrp[1].studIds[j];
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
			
			j = 0;
			studentId = course[indexC].lecGrp[0].studIds[j];
			full = a = b = c = d = f = 0;
			while(studentId != 0)
			{
				for(i = 0; i < countS; i++)
				{
					if(studentId == stud[i].getStudId())
					{
						indexS = i;
						break;
					}
				}
				
				for(i = 0; i < stud[indexS].mark.length; i++)
				{
					if(stud[indexS].mark[i].getCourseId() == courseId)
					{
						indexM = i;
						break;
					}
				}
				
				full++;
				if(stud[indexS].mark[indexM].getGradeE() == 'A')
					a++;
				else if(stud[indexS].mark[indexM].getGradeE() == 'B')
					b++;
				else if(stud[indexS].mark[indexM].getGradeE() == 'C')
					c++;
				else if(stud[indexS].mark[indexM].getGradeE() == 'D')
					d++;
				else if(stud[indexS].mark[indexM].getGradeE() == 'F')
					f++;
				
				j++;
				studentId = course[indexC].lecGrp[0].studIds[j];
			}
			
			j = 0;
			studentId = course[indexC].lecGrp[1].studIds[0];
			while(studentId != 0)
			{
				for(i = 0; i < countS; i++)
				{
					if(studentId == stud[i].getStudId())
					{
						indexS = i;
						break;
					}
				}
				
				for(i = 0; i < stud[indexS].mark.length; i++)
				{
					if(stud[indexS].mark[i].getCourseId() == courseId)
					{
						indexM = i;
						break;
					}
				}
				
				full++;
				if(stud[indexS].mark[indexM].getGradeE() == 'A')
					a++;
				else if(stud[indexS].mark[indexM].getGradeE() == 'B')
					b++;
				else if(stud[indexS].mark[indexM].getGradeE() == 'C')
					c++;
				else if(stud[indexS].mark[indexM].getGradeE() == 'D')
					d++;
				else if(stud[indexS].mark[indexM].getGradeE() == 'F')
					f++;
				
				j++;
				studentId = course[indexC].lecGrp[1].studIds[j];
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
			
			j = 0;
			studentId = course[indexC].lecGrp[0].studIds[j];
			full = a = b = c = d = f = 0;
			while(studentId != 0)
			{
				for(i = 0; i < countS; i++)
				{
					if(studentId == stud[i].getStudId())
					{
						indexS = i;
						break;
					}
				}
				
				for(i = 0; i < stud[indexS].mark.length; i++)
				{
					if(stud[indexS].mark[i].getCourseId() == courseId)
					{
						indexM = i;
						break;
					}
				}
				
				full++;
				if(stud[indexS].mark[indexM].getGradeC() == 'A')
					a++;
				else if(stud[indexS].mark[indexM].getGradeC() == 'B')
					b++;
				else if(stud[indexS].mark[indexM].getGradeC() == 'C')
					c++;
				else if(stud[indexS].mark[indexM].getGradeC() == 'D')
					d++;
				else if(stud[indexS].mark[indexM].getGradeC() == 'F')
					f++;
				
				j++;
				studentId = course[indexC].lecGrp[0].studIds[j];
			}
			
			j = 0;
			studentId = course[indexC].lecGrp[1].studIds[0];
			while(studentId != 0)
			{
				for(i = 0; i < countS; i++)
				{
					if(studentId == stud[i].getStudId())
					{
						indexS = i;
						break;
					}
				}
				
				for(i = 0; i < stud[indexS].mark.length; i++)
				{
					if(stud[indexS].mark[i].getCourseId() == courseId)
					{
						indexM = i;
						break;
					}
				}
				
				full++;
				if(stud[indexS].mark[indexM].getGradeC() == 'A')
					a++;
				else if(stud[indexS].mark[indexM].getGradeC() == 'B')
					b++;
				else if(stud[indexS].mark[indexM].getGradeC() == 'C')
					c++;
				else if(stud[indexS].mark[indexM].getGradeC() == 'D')
					d++;
				else if(stud[indexS].mark[indexM].getGradeC() == 'F')
					f++;
				
				j++;
				studentId = course[indexC].lecGrp[1].studIds[j];
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
	
	public int getProfId()
	{
		return profId;
	}
	
	public String getProfName()
	{
		return ("PROF. " + profFName + " " + profLName);
	}
	
	public String getProfEmail()
	{
		return profEmail;
	}
	
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	public String getOfficeRm()
	{
		return officeRm;
	}
	
	public String getFaculty()
	{
		return faculty;
	}
	
	public static void main(String args[])
	{
		Student[] testS = new Student[10];
		Professor[] testP = new Professor[10];
		Course[] testC = new Course[10];
		int countS = 0, countC = 0;
		testP[0] = new Professor(1, "MN", "Shaanmugam", "SH44N96@e.uni.edu.sg", "86601489", "S-B1-01", "SCSE");
		testP[1] = new Professor(2, "MN", "Shaanmugar", "SH44N69@e.uni.edu.sg", "86601488", "S-B1-02", "SCSE");
		testP[0].addStud(testS, countS);
		countS++;
		testP[0].addStud(testS, countS);
		countS++;
		testP[0].addStud(testS, countS);
		countS++;
		testP[0].addCourse(testC, countC, testP, 2);
		countC++;
		testP[0].addCourse(testC, countC, testP, 2);
		countC++;
		testC[0].lecGrp[0].studIds[0] = 69;
		testC[0].labGrp[0].studIds[0] = 69;
		testC[0].tutGrp[0].studIds[0] = 69;
		testC[1].lecGrp[0].studIds[0] = 1;
		testC[1].lecGrp[0].studIds[1] = 69;
		testC[1].lecGrp[1].studIds[0] = 3;
		testC[1].tutGrp[0].studIds[0] = 69;
		testC[1].tutGrp[0].studIds[1] = 3;
		testC[1].tutGrp[0].studIds[2] = 1;
		testP[0].printStud(testS, countS, testC, countC);
		testP[0].printStud(testS, countS, testC, countC);
		testP[0].weightage(testC, countC);
		testP[0].weightage(testC, countC);
		testP[0].cwMark(testS, countS, testC, countC);
		testP[0].examMark(testS, countS, testC, countC);
		testP[0].examMark(testS, countS, testC, countC);
		testP[0].examMark(testS, countS, testC, countC);
		testP[0].examMark(testS, countS, testC, countC);
		testP[0].printStats(testC, countC, testS, countS);
		testP[0].printStats(testC, countC, testS, countS);
	}
}

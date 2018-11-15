package University;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UniversityApp
{
	public static void main(String[] args)
	{
		int userType;
		System.out.println("Welcome to the University App.");
		System.out.println("1: Student mode");
		System.out.println("2: Professor mode");
		System.out.println("3: Exit");
		Scanner sc = new Scanner(System.in);
		do{
			userType = sc.nextInt();
			boolean valid = false;
			boolean allow = false;
			switch(userType) {
				case 1: do{
							System.out.println("Please enter your Student ID: ");
							int studId = sc.nextInt();
							BufferedReader reader;
							try {
								reader = new BufferedReader(new FileReader("student.txt"));
								String line = reader.readLine();
								while (line != null) {
									String[] tokens = line.split(", ");
									int sId = Integer.parseInt(tokens[0]);
									String studFName = tokens[1];
									String studLName = tokens[2];
									String sEmail = tokens[3];
									String sPhoneNo = tokens[4];
									String sFaculty = tokens[5];
									if(sId == studId) {
										allow = true;
										break;
									}
									line = reader.readLine();
								}
								reader.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							if(!allow)
								System.out.println("Please enter a valid Student ID.");
							else
								studFunc(studId);
								valid = true;
						} while (!valid);
						break;
				
				case 2: do{
							System.out.println("Please enter your Professor ID: ");
							int profId = sc.nextInt();
							BufferedReader reader;
							try {
								reader = new BufferedReader(new FileReader("professor.txt"));
								String line = reader.readLine();
								while (line != null) {
									String[] tokens = line.split(", ");
									int pId = Integer.parseInt(tokens[0]);
									String profFName = tokens[1];
									String profLName = tokens[2];
									String pEmail = tokens[3];
									String pPhoneNo = tokens[4];
									String pOffice = tokens [5];
									String pFaculty = tokens[6];
									if(pId == profId) {
										allow = true;
										break;
									}
									line = reader.readLine();
								}
								reader.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							if(!allow)
								System.out.println("Please enter a valid Professor ID.");
							else
								profFunc(profId);
								valid = true;
						} while (!valid);
						break;
				case 3: System.out.println("Thank you for using the app");
						break;
					
				default: System.out.println("Please enter a valid choice.");
						break;
			}
		} while (userType != 3);
	}

	/**
	 * Controls the actions a student can carry out
	 * @param studId student id
	 */
	
	public static void studFunc(int studId)
	{
		int studChoice;
		Student stud = new Student(0, null, null, null, null, null, null);
		Scanner sc = new Scanner(System.in);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("student.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] tokens = line.split(", ");
				int sId = Integer.parseInt(tokens[0]);
				String studFName = tokens[1];
				String studLName = tokens[2];
				String sEmail = tokens[3];
				String sPhoneNo = tokens[4];
				String sFaculty = tokens[5];
				String snric = tokens[6];
				if(sId == studId) {
					stud.setId(sId);
					stud.setFName(studFName);
					stud.setLName(studLName);
					stud.setEmail(sEmail);
					stud.setPhoneNo(sPhoneNo);
					stud.setFaculty(sFaculty);
					stud.setNRIC(snric);
					break;
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Welcome " + stud.getName());
		ArrayList<Course> course = new ArrayList<>();
		ArrayList<Marks> marks = new ArrayList<>();
		do {
			System.out.println("List of actions:");
			System.out.println("1: Register for a course");
			System.out.println("2: Check availability for a tutorial/lab group");
			System.out.println("3: Print transcript");
			System.out.println("4: Exit");
			System.out.println("Please enter your choice: ");
			studChoice = sc.nextInt();
			int courseCount = 0;
			try {
				reader = new BufferedReader(new FileReader("course.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int pId = Integer.parseInt(tokens[1]);
					int slots = Integer.parseInt(tokens[2]);
					String courseName = tokens[3];
					String faculty = tokens[4];
					Course tempCourse  = new Course(cId, courseName, faculty, pId, slots);
					course.add(courseCount, tempCourse);
					courseCount++;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int m = 0;
			try {
				reader = new BufferedReader(new FileReader("eMarks.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int sId = Integer.parseInt(tokens[0]);
					int cId = Integer.parseInt(tokens[1]);
					int e = Integer.parseInt(tokens[2]);
					String gradeE = tokens[3];
					if(sId == studId) {
						Marks tempMarks = new Marks(cId);
						marks.add(m, tempMarks);
						marks.get(m).setExam(e);
						marks.get(m).setGradeE(gradeE);
						m++;
					}
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			m = 0;
			try {
				reader = new BufferedReader(new FileReader("cwMarks.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int sId = Integer.parseInt(tokens[0]);
					int cId = Integer.parseInt(tokens[1]);
					int cw = Integer.parseInt(tokens[2]);
					String gradeC = tokens[3];
					if(sId == studId) {
						marks.get(m).setCoursework(cw);
						marks.get(m).setGradeC(gradeC);
						m++;
					}
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader = new BufferedReader(new FileReader("lecturegroup.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int pId = Integer.parseInt(tokens[2]);
					int slots = Integer.parseInt(tokens[3]);
					LectureGroup tempLecGrp = new LectureGroup(pId, slots);
					course.get(cId-1).lecGrp.add(classNo-1, tempLecGrp);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader = new BufferedReader(new FileReader("tutorialgroup.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int pId = Integer.parseInt(tokens[2]);
					int slots = Integer.parseInt(tokens[3]);
					TutorialGroup tempTutGrp = new TutorialGroup(pId, slots);
					course.get(cId-1).tutGrp.add(classNo-1, tempTutGrp);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader = new BufferedReader(new FileReader("labgroup.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int pId = Integer.parseInt(tokens[2]);
					int slots = Integer.parseInt(tokens[3]);
					LabGroup tempLabGrp = new LabGroup(pId, slots);
					course.get(cId-1).labGrp.add(classNo-1, tempLabGrp);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int preclass = 0;
			int prec = 0;
			int s = 0;
			try {
				reader = new BufferedReader(new FileReader("lecgrplist.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int sId = Integer.parseInt(tokens[2]);
					if(prec!=cId || preclass!=classNo)
						s=0;
					course.get(cId-1).lecGrp.get(classNo-1).studIds.add(s, sId);
                    prec=cId;
                    preclass=classNo;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			preclass = 0;
			prec = 0;
			s = 0;
			try {
				reader = new BufferedReader(new FileReader("tutgrplist.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int sId = Integer.parseInt(tokens[2]);
					if(prec!=cId || preclass!=classNo)
						s=0;
					course.get(cId-1).tutGrp.get(classNo-1).studIds.add(s, sId);
                    prec=cId;
                    preclass=classNo;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			preclass = 0;
			prec = 0;
			s = 0;
			try {
				reader = new BufferedReader(new FileReader("labgrplist.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int sId = Integer.parseInt(tokens[2]);
					if(prec!=cId || preclass!=classNo)
						s=0;
					course.get(cId-1).labGrp.get(classNo-1).studIds.add(s, sId);
                    prec=cId;
                    preclass=classNo;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader = new BufferedReader(new FileReader("exam.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int eWeightage = Integer.parseInt(tokens[1]);
					course.get(cId-1).exam = new Exam(eWeightage);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int precId = 0;
			int cw = 0;
			try {
				reader = new BufferedReader(new FileReader("coursework.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int cwWeightage = Integer.parseInt(tokens[1]);
					String cwName = tokens[2];
					if(precId != cId) {
						cw = 0;
					}
					Coursework tempCoursework = new Coursework(cwWeightage, cwName);
					course.get(cId-1).coursework.add(cw, tempCoursework);
					cw++;
					precId = cId;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch(studChoice) {
			case 1: 
				String[] out = stud.regCourse(course, courseCount);
				int result = Integer.parseInt(out[0]);
				if(result == 1) {
					int output = Integer.parseInt(out[1]);
					int a = Integer.parseInt(out[2]);
					int b = Integer.parseInt(out[3]);
					int c = Integer.parseInt(out[4]);
					BufferedWriter bw = null;
					FileWriter fw = null;
					try {
						fw = new FileWriter("lecgrplist.txt", true);
						bw = new BufferedWriter(fw);
						bw.write((output+1) + ", " + (a) + ", " + stud.getId());
						bw.newLine();
						bw.flush();
						if(b>0) {
							fw = new FileWriter("tutgrplist.txt", true);
							bw = new BufferedWriter(fw);
							bw.write((output+1) + ", " + (b) + ", " + stud.getId());
							bw.newLine();
							bw.flush();
						}
						if (c>0) {
							fw = new FileWriter("labgrplist.txt", true);
							bw = new BufferedWriter(fw);
							bw.write((output+1) + ", " + (c) + ", " + stud.getId());
							bw.newLine();
							bw.flush();
						}
						if(course.get(output).coursework.size()>0) {
							fw = new FileWriter("cwMarks.txt", true);
							bw = new BufferedWriter(fw);
							bw.write(stud.getId() + ", " + (output+1) + ", " + "0, E");
							bw.newLine();
							bw.flush();
						}
						fw = new FileWriter("eMarks.txt", true);
						bw = new BufferedWriter(fw);
						bw.write(stud.getId() + ", " + (output+1) + ", " + "0, E");
						bw.newLine();
						bw.flush();
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							try {
								if (bw != null)
									bw.close();
								if (fw != null)
									fw.close();

							} catch (IOException ex) {
								ex.printStackTrace();
							}
						}
				}
				break;
			case 2:
				stud.checkAvail(course, courseCount);
				break;
			case 3:
				stud.printTranscript(course, courseCount, marks);
				break;
			case 4:
				System.out.println("Please press 3 again to exit the app");
				break;
			default:
				System.out.println("Please enter a valid action.");
				break;
		}
		}while(studChoice!=4);
	}

	/**
	 * Controls the actions which a professor can carry out
	 * @param profId professor id
	 */
	
	public static void profFunc(int profId)
	{
		int profChoice;
		Scanner sc = new Scanner(System.in);
		Professor prof = new Professor(0, null, null, null, null, null, null);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("professor.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] tokens = line.split(", ");
				int pId = Integer.parseInt(tokens[0]);
				String profFName = tokens[1];
				String profLName = tokens[2];
				String pEmail = tokens[3];
				String pPhoneNo = tokens[4];
				String pOfficeRm = tokens[5];
				String pFaculty = tokens[6];
				if(pId == profId) {
					prof.setId(pId);
					prof.setFName(profFName);
					prof.setLName(profLName);
					prof.setEmail(pEmail);
					prof.setPhoneNo(pPhoneNo);
					prof.setOfficeRm(pOfficeRm);
					prof.setFaculty(pFaculty);
					break;
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Welcome  " + prof.getName());
		ArrayList<Course> course = new ArrayList<>();
		ArrayList<Student> student = new ArrayList<>();
		ArrayList<Professor> professor = new ArrayList<>();
		do {
			System.out.println("List of actions:");
			System.out.println("1: Add a student");
			System.out.println("2: Add a course");
			System.out.println("3: Print student list");
			System.out.println("4: Enter course assessment component weightage");
			System.out.println("5: Enter coursework mark");
			System.out.println("6: Enter exam mark");
			System.out.println("7: Print course statistics");
			System.out.println("8: Exit");
			System.out.println("Please enter your choice: ");
			profChoice = sc.nextInt();
			int courseCount = 0;
			try {
				reader = new BufferedReader(new FileReader("course.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int pId = Integer.parseInt(tokens[1]);
					int slots = Integer.parseInt(tokens[2]);
					String courseName = tokens[3];
					String faculty = tokens[4];
					Course tempCourse  = new Course(cId, courseName, faculty, pId, slots);
					course.add(courseCount, tempCourse);
					courseCount++;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int studentCount = 0;
			try {
				reader = new BufferedReader(new FileReader("student.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int sId = Integer.parseInt(tokens[0]);
					String studFName = tokens[1];
					String studLName = tokens[2];
					String sEmail = tokens[3];
					String sPhoneNo = tokens[4];
					String sFaculty = tokens[5];
					String sNric = tokens[6];
					Student tempStudent  = new Student(sId, studFName, studLName, sEmail, sPhoneNo, sFaculty, sNric);
					student.add(studentCount, tempStudent);
					studentCount++;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int profCount = 0;
			try {
				reader = new BufferedReader(new FileReader("professor.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int pId = Integer.parseInt(tokens[0]);
					String profFName = tokens[1];
					String profLName = tokens[2];
					String pEmail = tokens[3];
					String pPhoneNo = tokens[4];
					String pOfficeRm = tokens[5];
					String pFaculty = tokens[6];
					Professor tempProf  = new Professor(pId, profFName, profLName, pEmail, pPhoneNo, pOfficeRm, pFaculty);
					professor.add(profCount, tempProf);
					profCount++;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader = new BufferedReader(new FileReader("lecturegroup.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int pId = Integer.parseInt(tokens[2]);
					int slots = Integer.parseInt(tokens[3]);
					LectureGroup tempLecGrp = new LectureGroup(pId, slots);
					course.get(cId-1).lecGrp.add(classNo-1, tempLecGrp);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader = new BufferedReader(new FileReader("tutorialgroup.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int pId = Integer.parseInt(tokens[2]);
					int slots = Integer.parseInt(tokens[3]);
					TutorialGroup tempTutGrp = new TutorialGroup(pId, slots);
					course.get(cId-1).tutGrp.add(classNo-1, tempTutGrp);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader = new BufferedReader(new FileReader("labgroup.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int pId = Integer.parseInt(tokens[2]);
					int slots = Integer.parseInt(tokens[3]);
					LabGroup tempLabGrp = new LabGroup(pId, slots);
					course.get(cId-1).labGrp.add(classNo-1, tempLabGrp);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int preclass = 0;
			int prec = 0;
			int s = 0;
			try {
				reader = new BufferedReader(new FileReader("lecgrplist.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int sId = Integer.parseInt(tokens[2]);
					if(prec!=cId || preclass!=classNo)
						s=0;
					course.get(cId-1).lecGrp.get(classNo-1).studIds.add(s, sId);
					prec=cId;
					preclass=classNo;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			preclass = 0;
			prec = 0;
			s = 0;
			try {
				reader = new BufferedReader(new FileReader("tutgrplist.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int sId = Integer.parseInt(tokens[2]);
					if(prec!=cId || preclass!=classNo)
						s=0;
					course.get(cId-1).tutGrp.get(classNo-1).studIds.add(s, sId);
                    prec=cId;
                    preclass=classNo;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			preclass = 0;
			prec = 0;
			s = 0;
			try {
				reader = new BufferedReader(new FileReader("labgrplist.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int classNo = Integer.parseInt(tokens[1]);
					int sId = Integer.parseInt(tokens[2]);
					if(prec!=cId || preclass!=classNo)
						s=0;
					course.get(cId-1).labGrp.get(classNo-1).studIds.add(s, sId);
                    prec=cId;
                    preclass=classNo;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader = new BufferedReader(new FileReader("exam.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int eWeightage = Integer.parseInt(tokens[1]);
					course.get(cId-1).exam = new Exam(eWeightage);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int precId = 0;
			int cw = 0;
			try {
				reader = new BufferedReader(new FileReader("coursework.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int cId = Integer.parseInt(tokens[0]);
					int cwWeightage = Integer.parseInt(tokens[1]);
					String cwName = tokens[2];
					if(precId != cId) {
						cw = 0;
					}
					Coursework tempCoursework = new Coursework(cwWeightage, cwName);
					course.get(cId-1).coursework.add(cw, tempCoursework);
					cw++;
					precId = cId;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int presId = 0;
			int c=0;
			try {
				reader = new BufferedReader(new FileReader("eMarks.txt"));
				String line = reader.readLine();
				for(int i=0; i<student.size();i++)
					student.get(i).mark.clear();
				while (line != null) {
					String[] tokens = line.split(", ");
					int sId = Integer.parseInt(tokens[0]);
					int cId = Integer.parseInt(tokens[1]);
					int exam = Integer.parseInt(tokens[2]);
					String gradeE = tokens[3];
					if(presId != sId)
						c=0;
					Marks tempMarks = new Marks(cId);
					student.get(sId-1).mark.add(c, tempMarks);
					student.get(sId-1).mark.get(c).setExam(exam);
					student.get(sId-1).mark.get(c).setGradeE(gradeE);
					c++;
					presId = sId;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			presId = 0;
			c=0;
			try {
				reader = new BufferedReader(new FileReader("cwMarks.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int sId = Integer.parseInt(tokens[0]);
					int cId = Integer.parseInt(tokens[1]);
					int coursework = Integer.parseInt(tokens[2]);
					String gradeC = tokens[3];
					if(presId != sId)
						c=0;
					student.get(sId-1).mark.get(c).setCoursework(coursework);
					student.get(sId-1).mark.get(c).setGradeC(gradeC);
					c++;
					presId=sId;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			switch(profChoice) {
			case 1: 
				int x = prof.addStud(student, studentCount);
				BufferedWriter bw = null;
				FileWriter fw = null;
				if(x>=0)
					try {
						int studId = student.get(x).getId();
						String studName = student.get(x).getName();
						String [] tokens = studName.split(" ");
						String studFName = tokens[0];
						String studLName = tokens[1];
						String email = student.get(x).getEmail();
						String phoneNo = student.get(x).getPhoneNo();
						String faculty = student.get(x).getFaculty();
						String nric = student.get(x).getNRIC();

						fw = new FileWriter("student.txt", true);
						bw = new BufferedWriter(fw);
						bw.write(studId + ", " + studFName + ", " + studLName + ", " + email + ", " + phoneNo + ", " + faculty + ", " + nric);
						bw.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							if (bw != null)
								bw.close();
							if (fw != null)
								fw.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				break;
			case 2:
				String[] addcourse = prof.addCourse(course, courseCount, professor, profCount);
				int l = Integer.parseInt(addcourse[0]);
				int t = Integer.parseInt(addcourse[1]);
				int y = Integer.parseInt(addcourse[2]);
				BufferedWriter bw2 = null;
				FileWriter fw2 = null;
				if(y>=0) {
					try {
						int cId = course.get(y).getCourseId();
						int pId = course.get(y).getProfId();
						int slots = course.get(y).getSlots();
						String cName = course.get(y).getCourseName();
						String cFac = course.get(y).getFaculty();

						fw2 = new FileWriter("course.txt", true);
						bw2 = new BufferedWriter(fw2);
						bw2.write(cId + ", " + pId + ", " + slots + ", " + cName + ", " + cFac);
						bw2.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							if (bw2 != null)
								bw2.close();
							if (fw2 != null)
								fw2.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					if(l>0) {
						for(int a=0; a<course.get(y).labGrp.size();a++) {
						try {
							int cId = course.get(y).getCourseId();
							int pId = course.get(y).labGrp.get(a).getProfId();
							int slots = course.get(y).labGrp.get(a).getSlots();
	
							fw2 = new FileWriter("labgroup.txt", true);
							bw2 = new BufferedWriter(fw2);
							bw2.write(cId + ", " + (a+1) + ", " + pId + ", " + slots);
							bw2.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							try {
								if (bw2 != null)
									bw2.close();
								if (fw2 != null)
									fw2.close();
							} catch (IOException ex) {
								ex.printStackTrace();
							}
						}
						}
					}
					if(course.get(y).lecGrp.size()>0) {
						for(int a=0; a<course.get(y).lecGrp.size();a++) {
							try {
								int cId = course.get(y).getCourseId();
								int pId = course.get(y).lecGrp.get(a).getProfId();
								int slots = course.get(y).lecGrp.get(a).getSlots();
	
								fw2 = new FileWriter("lecturegroup.txt", true);
								bw2 = new BufferedWriter(fw2);
								bw2.write(cId + ", " + (a+1) + ", " + pId + ", " + slots);
								bw2.newLine();
							} catch (IOException e) {
								e.printStackTrace();
							} finally {
								try {
									if (bw2 != null)
										bw2.close();
									if (fw2 != null)
										fw2.close();
								} catch (IOException ex) {
									ex.printStackTrace();
								}
							}
							}
					}
					if(t>0) {
						for(int a=0; a<course.get(y).tutGrp.size();a++) {
							try {
								int cId = course.get(y).getCourseId();
								int pId = course.get(y).tutGrp.get(a).getProfId();
								int slots = course.get(y).tutGrp.get(a).getSlots();
	
								fw2 = new FileWriter("tutorialgroup.txt", true);
								bw2 = new BufferedWriter(fw2);
								bw2.write(cId + ", " + (a+1) + ", " + pId + ", " + slots);
								bw2.newLine();
							} catch (IOException e) {
								e.printStackTrace();
							} finally {
								try {
									if (bw2 != null)
										bw2.close();
									if (fw2 != null)
										fw2.close();
								} catch (IOException ex) {
									ex.printStackTrace();
								}
							}
							}
					}
				}
				break;
			case 3:
				prof.printStud(student, studentCount, course, courseCount);
				break;
			case 4:
				String[] out = prof.weightage(course, courseCount);
				int cwC = Integer.parseInt(out[0]);
				int z = Integer.parseInt(out[1]);
				BufferedWriter bw3 = null;
				FileWriter fw3 = null;
				if(z>=0)
					try {
						if(cwC > 0) {
							int i = 0;
							fw3 = new FileWriter("coursework.txt", true);
							bw3 = new BufferedWriter(fw3);
							while(course.get(z).coursework.size() > i) {
								int cId = course.get(z).getCourseId();
								int cwWeightage = course.get(z).coursework.get(i).getPercentage();
								String cwName = course.get(z).coursework.get(i).getName();
		
								bw3.write(cId + ", " + cwWeightage + ", " + cwName);
								bw3.newLine();
								i++;
								bw3.flush();
							}
						}
						int cId = course.get(z).getCourseId();
						int eWeightage = course.get(z).exam.getPercentage();
						fw3 = new FileWriter("exam.txt", true);
						bw3 = new BufferedWriter(fw3);
						bw3.write(cId + ", " + eWeightage);
						bw3.newLine();
						
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							if (bw3 != null)
								bw3.close();
							if (fw3 != null)
								fw3.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				break;
			case 5:
				String[] cwString = prof.cwMark(student, studentCount, course, courseCount);
				int valid = Integer.parseInt(cwString[0]);
				if(valid==1) {
					BufferedWriter bw4 = null;
					FileWriter fw4 = null;
					try {
						fw4 = new FileWriter("cwMarks.txt");
						bw4 = new BufferedWriter(fw4);

						for(int studSize=0;studSize<student.size();studSize++)
							for(int markSize=0;markSize<student.get(studSize).mark.size();markSize++) {
								int a = student.get(studSize).getId();
								int b = student.get(studSize).mark.get(markSize).getCourseId();
								int e = student.get(studSize).mark.get(markSize).getCoursework();
								String f = student.get(studSize).mark.get(markSize).getGradeC();
								bw4.write(a + ", " + b + ", " + e + ", " + f);
								bw4.newLine();
							}
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							if (bw4 != null)
								bw4.close();
							if (fw4 != null)
								fw4.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}
				break;
			case 6:
				prof.examMark(student, studentCount, course, courseCount);
				BufferedWriter bw5 = null;
				FileWriter fw5 = null;
				try {
					fw5 = new FileWriter("eMarks.txt");
					bw5 = new BufferedWriter(fw5);
					
					for(int studSize=0;studSize<student.size();studSize++)
						for(int markSize=0;markSize<student.get(studSize).mark.size();markSize++) {
							int a = student.get(studSize).getId();
							int b = student.get(studSize).mark.get(markSize).getCourseId();
							int e = student.get(studSize).mark.get(markSize).getExam();
							String f = student.get(studSize).mark.get(markSize).getGradeE();
							bw5.write(a + ", " + b + ", " + e + ", " + f);
							bw5.newLine();
						}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (bw5 != null)
							bw5.close();
						if (fw5 != null)
							fw5.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				break;
			case 7:
				prof.printStats(course, courseCount, student, studentCount);
				break;
			case 8:
				System.out.println("Please press 3 again to exit the app");
				break;
			default:
				System.out.println("Please enter a valid action.");
				break;
			}
		}while(profChoice != 8);
	}
}

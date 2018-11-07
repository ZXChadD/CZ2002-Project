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
	
	public static void studFunc(int studId)
	{
		int studChoice;
		Student stud = new Student(0, null, null, null, null, null);
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
				if(sId == studId) {
					stud.setStudId(sId);
					stud.setStudFName(studFName);
					stud.setStudLName(studLName);
					stud.setStudEmail(sEmail);
					stud.setStudPhoneNo(sPhoneNo);
					stud.setStudFaculty(sFaculty);
					break;
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Welcome " + stud.getStudName());
		System.out.println("List of actions:");
		System.out.println("1: Register for a course");
		System.out.println("2: Check availability for a tutorial/lab group");
		System.out.println("3: Print transcript");
		System.out.println("4: Exit");
		ArrayList<Course> course = new ArrayList<>();
		ArrayList<Marks> marks = new ArrayList<>();
		do {
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
					course[courseCount] = new Course(cId, courseName, faculty, pId, slots);
					courseCount++;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int m = 0;
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
						marks[m] = new Marks(cId);
						marks[m].setCoursework(cw);
						marks[m].setGradeC(gradeC);
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
				reader = new BufferedReader(new FileReader("eMarks.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int sId = Integer.parseInt(tokens[0]);
					int cId = Integer.parseInt(tokens[1]);
					int e = Integer.parseInt(tokens[2]);
					String gradeE = tokens[3];
					if(sId == studId) {
						marks[m].setExam(e);
						marks[m].setGradeE(gradeE);
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
					course[cId-1].lecGrp[classNo-1] = new LectureGroup(pId, slots);
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
					course[cId-1].tutGrp[classNo-1] = new TutorialGroup (pId, slots);
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
					course[cId-1].labGrp[classNo-1] = new LabGroup(pId, slots);
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
					course[cId-1].lecGrp[classNo-1].studIds[s] = sId;
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
					course[cId-1].tutGrp[classNo-1].studIds[s] = sId;
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
					course[cId-1].labGrp[classNo-1].studIds[s] = sId;
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
					course[cId-1].exam = new Exam(eWeightage);
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
					course[cId-1].coursework[cw] = new Coursework(cwWeightage, cwName);
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
				int a,x;
				int output = stud.regCourse(course, courseCount);
				if(output >= 0) {
					BufferedWriter bw = null;
					FileWriter fw = null;
					try {
						for(a=0;a<=course[output].lecGrp.length;a++) {
							for(x=0;x<=course[output].lecGrp[a].studIds.length;x++) {
								if(course[output].lecGrp[a].studIds[x]==stud.getStudId()) {
									fw = new FileWriter("lecgrplist.txt", true);
									bw = new BufferedWriter(fw);
									bw.write((output+1) + ", " + (a+1) + ", " + stud.getStudId());
									bw.newLine();
									bw.flush();
									break;
								}
							}
						}
						for(a=0;a<=course[output].tutGrp.length;a++) {
							for(x=0;x<=course[output].tutGrp[a].studIds.length;x++) {
								if(course[output].tutGrp[a].studIds[x]==stud.getStudId()) {
									fw = new FileWriter("tutgrplist.txt", true);
									bw = new BufferedWriter(fw);
									bw.write((output+1) + ", " + (a+1) + ", " + stud.getStudId());
									bw.newLine();
									bw.flush();
									break;
								}
							}
						}
						for(a=0;a<=course[output].labGrp.length;a++) {
							for(x=0;x<=course[output].labGrp[a].studIds.length;x++) {
								if(course[output].labGrp[a].studIds[x]==stud.getStudId()) {
									fw = new FileWriter("labgrplist.txt", true);
									bw = new BufferedWriter(fw);
									bw.write((output+1) + ", " + (a+1) + ", " + stud.getStudId());
									bw.newLine();
									bw.flush();
									break;
								}
							}
						}
						System.out.println("Course registered");

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
				System.out.println("Thank you for using the app");
				System.out.println("Please press 3 again to exit the app");
				break;
			default:
				System.out.println("Please enter a valid action.");
				break;
		}
		}while(studChoice!=4);
	}
	
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
					prof.setProfId(pId);
					prof.setProfFName(profFName);
					prof.setProfLName(profLName);
					prof.setProfEmail(pEmail);
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
		System.out.println("Welcome  " + prof.getProfName());
		System.out.println("List of actions:");
		System.out.println("1: Add a student");
		System.out.println("2: Add a course");
		System.out.println("3: Print student list");
		System.out.println("4: Enter course assessment component weightage");
		System.out.println("5: Enter coursework mark");
		System.out.println("6: Enter exam mark");
		System.out.println("7: Print course statistics");
		System.out.println("8: Exit");
		ArrayList<Course> course = new ArrayList<>();
		ArrayList<Student> student = new ArrayList<>();
		ArrayList<Professor> prof = new ArrayList<>();
		do {
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
					course[courseCount] = new Course(cId, courseName, faculty, pId, slots);
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
					student[studentCount] = new Student(sId, studFName, studLName, sEmail, sPhoneNo, sFaculty);
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
					professor[profCount] = new Professor(pId, profFName, profLName, pEmail, pPhoneNo, pOfficeRm, pFaculty);
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
					course[cId-1].lecGrp[classNo-1] = new LectureGroup(pId, slots);
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
					course[cId-1].tutGrp[classNo-1] = new TutorialGroup (pId, slots);
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
					course[cId-1].labGrp[classNo-1] = new LabGroup(pId, slots);
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
					course[cId-1].lecGrp[classNo-1].studIds[s] = sId;
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
					course[cId-1].tutGrp[classNo-1].studIds[s] = sId;
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
					course[cId-1].labGrp[classNo-1].studIds[s] = sId;
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
					course[cId-1].exam = new Exam(eWeightage);
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
					course[cId-1].coursework[cw] = new Coursework(cwWeightage, cwName);
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
					student[sId-1].mark[c] = new Marks(cId);
					student[sId-1].mark[c].setCoursework(coursework);
					student[sId-1].mark[c].setGradeC(gradeC);
					c++;
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			presId = 0;
			c=0;
			try {
				reader = new BufferedReader(new FileReader("eMarks.txt"));
				String line = reader.readLine();
				while (line != null) {
					String[] tokens = line.split(", ");
					int sId = Integer.parseInt(tokens[0]);
					int cId = Integer.parseInt(tokens[1]);
					int exam = Integer.parseInt(tokens[2]);
					String gradeE = tokens[3];
					if(presId != sId)
						c=0;
					student[sId-1].mark[c].setExam(exam);
					student[sId-1].mark[c].setGradeE(gradeE);
					c++;
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
						int studId = student[x].getStudId();
						String studName = student[x].getStudName();
						String [] tokens = studName.split(" ");
						String studFName = tokens[0];
						String studLName = tokens[1];
						String email = student[x].getStudEmail();
						String phoneNo = student[x].getPhoneNo();
						String faculty = student[x].getFaculty();

						fw = new FileWriter("student.txt", true);
						bw = new BufferedWriter(fw);
						bw.write(studId + ", " + studFName + ", " + studLName + ", " + email + ", " + phoneNo + ", " + faculty);
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
						int cId = course[y].getCourseId();
						int pId = course[y].getProfId();
						int slots = course[y].getSlots();
						String cName = course[y].getCourseName();
						String cFac = course[y].getFaculty();

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
						for(int a=0; a<course[y].labGrp.length;a++) {
						try {
							System.out.println(course[y].labGrp.length);
							int cId = course[y].getCourseId();
							int pId = course[y].labGrp[a].getProfId();
							int slots = course[y].labGrp[a].getSlots();
	
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
					if(course[y].lecGrp.length>0) {
						for(int a=0; a<course[y].lecGrp.length;a++) {
							try {
								int cId = course[y].getCourseId();
								int pId = course[y].lecGrp[a].getProfId();
								int slots = course[y].lecGrp[a].getSlots();
	
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
						for(int a=0; a<course[y].tutGrp.length;a++) {
							try {
								int cId = course[y].getCourseId();
								int pId = course[y].tutGrp[a].getProfId();
								int slots = course[y].tutGrp[a].getSlots();
	
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
				int z = prof.weightage(course, courseCount);
				BufferedWriter bw3 = null;
				FileWriter fw3 = null;
				if(z>=0)
					try {
						int i = 0;
						fw3 = new FileWriter("coursework.txt", true);
						bw3 = new BufferedWriter(fw3);
						while(course[z].coursework[i]!=null) {
							int cId = course[z].getCourseId();
							int cwWeightage = course[z].coursework[i].getPercentage();
							String cwName = course[z].coursework[i].getName();
	
							bw3.write(cId + ", " + cwWeightage + ", " + cwName);
							bw3.newLine();
							i++;
							bw3.flush();
						}
						int cId = course[z].getCourseId();
						int eWeightage = course[z].exam.getPercentage();
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
				int s1 = Integer.parseInt(cwString[0]);
				int c1 = Integer.parseInt(cwString[1]);
				int i;
				BufferedWriter bw4 = null;
				FileWriter fw4 = null;
				try {
					int sId = student[s1].getStudId();
					int cId = course[c1].getCourseId();
					for(i=0;i<student[s1].mark.length;i++) {
						if(cId==student[s1].mark[i].getCourseId())
							break;
					}
					int cwMark = student[s1].mark[i].getCoursework();
					String cwGrade = student[s1].mark[i].getGradeC();
					
					fw4 = new FileWriter("cwMarks.txt", true);
					bw4 = new BufferedWriter(fw4);
					bw4.write(sId + ", "+ cId + ", " + cwMark + ", " + cwGrade);
					bw4.newLine();
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
				break;
			case 6:
				String[] eString = prof.examMark(student, studentCount, course, courseCount);
				int s2 = Integer.parseInt(eString[0]);
				int c2 = Integer.parseInt(eString[1]);
				int j;
				BufferedWriter bw5 = null;
				FileWriter fw5 = null;
				try {
					int sId = student[s2].getStudId();
					int cId = course[c2].getCourseId();
					for(j=0;j<student[s2].mark.length;j++) {
						if(cId==student[s2].mark[j].getCourseId())
							break;
					}
					int eMark = student[s2].mark[j].getExam();
					String eGrade = student[s2].mark[j].getGradeE();
					
					fw5 = new FileWriter("eMarks.txt", true);
					bw5 = new BufferedWriter(fw5);
					bw5.write(sId + ", "+ cId + ", " + eMark + ", " + eGrade);
					bw5.newLine();
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
				System.out.println("Thank you for using the app");
				System.out.println("Please press 3 again to exit the app");
				break;
			default:
				System.out.println("Please enter a valid action.");
				break;
			}
		}while(profChoice != 8);
	}
}

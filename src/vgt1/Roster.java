package vgt1;
/** This is the roster class as part of the assignment for VGT1.
 * This task is the performance assessment for C169, Scripting and
 * Programming - Applications, for WGU.
 */

/**
 * @author Aaron Echols
 *
 */

import java.util.ArrayList;

public class Roster {

	private static ArrayList<Student> classList = new ArrayList<>();
	private static String [] students = {"1,John,Smith,John1989@gmail.com,20,88,79,59", 
            "2,Suzan,Erickson,Erickson_1990@gmailcom,19,91,72,85",
            "3,Jack,Napoli,The_lawyer99yahoo.com,19,85,84,87",
            "4,Erin,Black,Erin.black@comcast.net,22,91,98,82",
            "5,Aaron,Echols,aaronly622@gmail.com,36,99,42,100"};
	
	public static void main(String[] args) {
		
		for (String s : students){
			// Extract all info from the student string
			String[] studentInfo = s.split(",");
			String studentID = studentInfo[0];
			String studentFirstName = studentInfo[1];
			String studentLastName = studentInfo[2];
			String studentEmail = studentInfo[3];
			int studentAge = Integer.parseInt(studentInfo[4]);
			int studentGrade1 = Integer.parseInt(studentInfo[5]);
			int studentGrade2 = Integer.parseInt(studentInfo[6]);
			int studentGrade3 = Integer.parseInt(studentInfo[7]);
			
			// Add the student string to an ArrayList of student objects
			add(studentID, studentFirstName, studentLastName, studentEmail, studentAge, studentGrade1, studentGrade2, studentGrade3);
		}
		
		print_all();
		print_invalid_emails();
		for (Student s : classList){
			print_average_grade(s.getStudentID());
		}
		remove("3");
		remove("3");
		
	}
	
	/**
	 * Add a student to the roster
	 * @param studentID Student ID (int)
	 * @param firstname First Name (String)
	 * @param lastname Last Name (String)
	 * @param emailaddress E-mail address (String)
	 * @param age Age (int)
	 * @param grade1 Grades 1 (int)
	 * @param grade2 Grades 2 (int)
	 * @param grade3 Grades 3 (int)
	 */
	public static void add(String studentID, String firstname, String lastname, String emailaddress, int age, int grade1, int grade2, int grade3){
		int[] grades = {grade1, grade2, grade3};
		Student student = new Student(studentID, firstname, lastname, emailaddress, age, grades);
		classList.add(student);
	}

	/**
	 * Remove a student from the roster
	 * @param studentID The student's ID number
	 */
	public static void remove(String studentID){
		for (int i = 0; i < classList.size(); i++){
			String checkID = classList.get(i).getStudentID();
			if (checkID.equals(studentID)){
				classList.remove(i);
				System.out.printf("The student with id number %s has been removed.\n", studentID);
				return;
			}
		}
		System.out.printf("The student with id number %s could not be found.\n", studentID);
	}
	
	/**
	 * Print the class roster with all information
	 */
	public static void print_all(){
		// Print each student's information
		for (Student s : classList){
			s.print();
		}
		System.out.print("\n");
	}
	
	/**
	 * Get a student's overall average
	 * @param studentID The student's ID number
	 */
	public static void print_average_grade(String studentID){
		Student s = lookup(studentID);
		if (s == null) {return;}
		double average = s.getAverage();
		System.out.printf("%s %s's grade average is %.2f.\n", s.getFirstName(), s.getLastName(), average);
	}
	
	/**
	 * Print all invalid e-mail addresses
	 */
	public static void print_invalid_emails(){
		ArrayList<String> invalidEmails = new ArrayList<>(); // create empty array list of invalid emails
		for (int i = 0; i < classList.size(); i++){ // go through entire roster
			if(!checkEmail(classList.get(i).getEmail())){ //check if the email is invalid
				invalidEmails.add(classList.get(i).getEmail()); //  if invalid, add to array list
			}
		}
		if (invalidEmails.size() > 0){ // if any invalid email addresses were found, print them out
			System.out.println("These email addresses are invalid:");
			for (String email : invalidEmails){ System.out.println(email); }
		}
		else{
			System.out.println("All email addresses appear to be valid.");
		}
		System.out.print("\n");
	}

	/**
	 * Check if an email address is valid
	 * @param email The e-mail address to check
	 * @return true if email is valid, false if it is invalid
	 */
	private static boolean checkEmail(String email){
		if (email.indexOf(" ") > -1){ return false;}
		if (email.indexOf("@") < 0){ return false;}
		if (email.indexOf(".") < 0 || email.indexOf("@") > email.lastIndexOf(".")){return false;}
		return true;
	}

	/**
	 * Lookup and return a student object by id number
	 * @param id The student's id number (String)
	 * @return The student object found by id number
	 */
	private static Student lookup(String id){
		for (int i = 0; i < classList.size(); i++){
			if (classList.get(i).getStudentID().equals(id)){
				return classList.get(i);
			}
		}
		return null;
	}
}

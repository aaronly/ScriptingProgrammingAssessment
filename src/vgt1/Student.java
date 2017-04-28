package vgt1;
import java.util.Arrays;

/** This is the student class as part of the assignment for VGT1.
 * This task is the performance assessment for C169, Scripting and
 * Programming - Applications, for WGU.
 */

/**
 * @author Aaron Echols
 *
 */
public class Student {

	// Instance variables
	private String studentID;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	private int[] grades;
	
	// Constructor
	public Student(String studentID, String firstName, String lastName, String email, int age, int[] grades){
		setStudentID(studentID);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setAge(age);
		setGrades(grades);
	}
	
	// Accessor Methods
	/**
	 * Get the student's ID number
	 * @return ID Number (String)
	 */
	public String getStudentID(){ return studentID; }
	/**
	 * Get the student's first name
	 * @return First Name (String)
	 */
	public String getFirstName(){ return firstName; }
	/**
	 * Get the student's last name
	 * @return Last Name (String)
	 */
	public String getLastName(){ return lastName; }
	/**
	 * Get the student's e-mail address
	 * @return E-mail Address (String)
	 */
	public String getEmail(){ return email; }
	/**
	 * Get the student's age
	 * @return Age (int)
	 */
	public int getAge(){ return age; }
	/**
	 * Get the student's grades
	 * @return Array of grades (int)
	 */
	public int[] getGrades() {return grades; }
	
	// Mutator Methods
	/**
	 * Set the student's ID number
	 * @param studentID ID Number (String)
	 */
	public void setStudentID(String studentID){
		this.studentID = studentID;
	}
	/**
	 * Set the student's first name
	 * @param firstName First Name (String)
	 */
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	/**
	 * Set the student's last name
	 * @param lastName Last Name (String)
	 */
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	/**
	 * Set the student's e-mail address
	 * @param email E-mail Address (String)
	 */
	public void setEmail(String email){
		this.email = email;
	}
	/**
	 * Set the student's age
	 * @param age Age (int)
	 */
	public void setAge(int age){
		this.age = age;
	}
	/**
	 * Set the student's grades
	 * @param grades Array of grades (int)
	 */
	public void setGrades(int[] grades){
		this.grades = grades;
	}

	// Print out student info
	public void print(){
		System.out.printf("%-2s\t"
				+ "Last Name: %-10s\t"
				+ "First Name: %-10s\t"
				+ "E-mail: %-30s\t"
				+ "Age: %2d\t\t"
				+ "Grades: ", getStudentID(), getLastName(), getFirstName(), getEmail(), getAge());
		System.out.println(Arrays.toString(getGrades()));
	}
	
	/**
	 * Get the average of all the grades a student has.
	 * @return The average of all student grades
	 */
	public double getAverage(){
		double sum = 0;
		for (int grade : grades){
			sum = sum + grade;
		}
		return sum / grades.length;
	}
}

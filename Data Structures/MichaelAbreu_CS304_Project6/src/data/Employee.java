package data;

import java.io.Serializable;

public class Employee implements Comparable<Employee>, Serializable{

	// Generated Serial Code (used for saving objects to file)
	private static final long serialVersionUID = -7023898709646394903L;
	
	private String name;
	private String job;
	private int id;
	private double wage;

	public Employee() {
		name = "New Employee";
		job = "None";
		wage = 0.0;
		id = 0;
	}

	public Employee(String name, String job, double wage) {
		this.name = name;
		this.job = job;
		this.wage = wage;
		id = 0;
	}
	
	public Employee(String name, String job, double wage, int id) {
		this.name = name;
		this.job = job;
		this.wage = wage;
		this.id = id;
	}

	// Getters
	//
	protected String getName() {
		return name;
	}

	protected String getJob() {
		return job;
	}

	protected int getID() {
		return id;
	}

	protected double getWage() {
		return wage;
	}

	// Setters
	//
	protected void setName(String name) {
		this.name = name;
	}

	protected void setJob(String job) {
		this.job = job;
	}

	protected void setID(int id) {
		this.id = id;
	}

	protected void setWage(double wage) {
		this.wage = wage;
	}

	// Methods
	//
	@Override
	public int compareTo(Employee target) {
		if (this.id == target.getID())
			return 0;
		else if (this.id > target.getID())
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() {
		String str = "Employee: " + id;
		str = str + "\n\tName: " + name;
		str = str + "\n\tJob:  " + job;
		str = str + "\n\tWage: $" + wage;
		return str;
	}

	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.setID(1);
		emp1.setName("Adrian Aguilar");
		emp1.setJob("Valet");
		emp1.setWage(7.0);

		Employee emp2 = new Employee("Michael Abreu", "Valet", 7.0);
		emp2.setID(2);

		System.out.println(emp1);
		System.out.println(emp2);

		System.out.println(emp1.compareTo(emp1));
	}
}

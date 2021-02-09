package com.tesfai.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private String name;
	private String department;
	private double salary;
	

	@Override
	public String toString() {
		return String.format("Name : %s, Dept : %s, Salary : %8.2f \n", name, department, salary);
	}
	
	
}

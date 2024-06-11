package ltts.com.model;

import java.util.Date;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;


@Entity

public class Employee {
	@Id
	private int empid;
	@NotNull
	private String ename;
	@NotNull
	private String email;
	private String department;
	private String location;
	private double salary;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "hiredate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull
	private Date hiredate;
	
	

	public Employee() {
		super();
	}



	public Employee(int empid, @NotNull String ename, @NotNull String email, String department, String location,
			double salary, @NotNull Date hiredate) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.email = email;
		this.department = department;
		this.location = location;
		this.salary = salary;
		this.hiredate = hiredate;
	}



	public int getEmpid() {
		return empid;
	}



	public void setEmpid(int empid) {
		this.empid = empid;
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public Date getHiredate() {
		return hiredate;
	}



	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}



	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", email=" + email + ", department=" + department
				+ ", location=" + location + ", salary=" + salary + ", hiredate=" + hiredate + "]";
	}
}

package ltts.com.dao;

import java.util.Date;
import java.util.List;

import ltts.com.model.Employee;
import ltts.com.model.admin;

public interface EMSDAO {
	
	public boolean addEmp(Employee emp);
	
	public List<Employee> showallemp();
	
	public int deletebyempid(int empid);

	Employee GetEmpData(int empid);

	boolean UpdateEmployeeData(Employee edata);

	Employee findbyid(int empid);

	List<Employee> findbyEname(String ename);

	List<Employee> findbyDepartment(String department);

	List<Employee> findbyLocation(String location);

	List<Employee> findbylowersalary(double salary);

	List<Employee> findbygreatersalary(double salary);

	List<Employee> findbydatebefore(Date hiredate);

	List<Employee> findbydateafter(Date hiredate);

	boolean addadmin(admin ad);

	boolean adminlogincheck(admin ad);
}

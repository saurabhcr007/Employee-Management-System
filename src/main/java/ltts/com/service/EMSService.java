package ltts.com.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ltts.com.model.Employee;
import ltts.com.model.admin;


@Service
public interface EMSService {
	
	public boolean addEmp(Employee emp);
	
	public List<Employee> showallemp();
	
	public int deletebyempid(int empid);
	
	public Employee GetEmpData(int empid);

	boolean UpdateEmployeeData(Employee edata);

	Employee findbyid(int empid);

	List<Employee> findbyEname(String ename);

	List<Employee> findbyDepartment(String department);

	List<Employee> findbyLocation(String location);

	List<Employee> findbylowersalary(double salary);

	List<Employee> findbygreatersalary(double salary);

	List<Employee> findbydatebefore(Date hiredate);

	List<Employee> findbydateafter(Date hiredate);

	boolean adminlogincheck(admin ad);
	
	
}

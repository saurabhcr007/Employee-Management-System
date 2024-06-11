package ltts.com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltts.com.dao.EMSDaoImpl;
import ltts.com.model.Employee;
import ltts.com.model.admin;

@Service
public class EMSServiceImpl implements EMSService{

	@Autowired
	private EMSDaoImpl dao;
	
	@Override
	public boolean addEmp(Employee emp) {
		// TODO Auto-generated method stub
		if(dao.addEmp(emp)) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Employee> showallemp() {
		// TODO Auto-generated method stub
		return dao.showallemp();
	}

	@Override
	public int deletebyempid(int empid) {
		// TODO Auto-generated method stub
		return dao.deletebyempid(empid);
	}
	
	@Override
	public Employee GetEmpData(int empid) {
		// TODO Auto-generated method stub
		return dao.GetEmpData(empid);
	}
	
	@Override
	public boolean UpdateEmployeeData(Employee edata) {
		
		return dao.UpdateEmployeeData(edata);
	}

	@Override
	public Employee findbyid(int empid) {
		// TODO Auto-generated method stub
		return dao.findbyid(empid);
	}

	@Override
	public List<Employee> findbyEname(String ename) {
		// TODO Auto-generated method stub
		return dao.findbyEname(ename);
	}

	@Override
	public List<Employee> findbyDepartment(String department) {
		// TODO Auto-generated method stub
		return dao.findbyDepartment(department);
	}

	@Override
	public List<Employee> findbyLocation(String location) {
		// TODO Auto-generated method stub
		return dao.findbyLocation(location);
	}
	
	@Override
	public List<Employee> findbylowersalary(double salary) {
		// TODO Auto-generated method stub
		return dao.findbylowersalary(salary);
	}

	@Override
	public List<Employee> findbygreatersalary(double salary) {
		// TODO Auto-generated method stub
		return dao.findbygreatersalary(salary);
	}
	
	@Override
	public List<Employee> findbydatebefore(Date hiredate) {
		// TODO Auto-generated method stub
		return dao.findbydatebefore(hiredate);
	}

	@Override
	public List<Employee> findbydateafter(Date hiredate) {
		// TODO Auto-generated method stub
		return dao.findbydateafter(hiredate);
	}

	public boolean addadmin(admin ad) {
		// TODO Auto-generated method stub
		if(dao.addadmin(ad)) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean adminlogincheck(admin ad) {
		// TODO Auto-generated method stub
		if(dao.adminlogincheck(ad)) {
			return true;
		}
		return false;
	}

}

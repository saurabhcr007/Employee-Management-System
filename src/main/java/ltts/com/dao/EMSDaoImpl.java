package ltts.com.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ltts.com.jpa.AdminJPARepository;
import ltts.com.jpa.EmployeeJPARepository;
import ltts.com.model.Employee;
import ltts.com.model.admin;


@Repository
public class EMSDaoImpl implements EMSDAO {
	
	@Autowired
	private EmployeeJPARepository Jpa;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AdminJPARepository adjpa;

	@Override
	public boolean addEmp(Employee emp) {
		if(Jpa.findByEmpid(emp.getEmpid())==null)
		{
			if (Jpa.save(emp)!=null) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public List<Employee> showallemp() {
		List<Employee> emp=(List<Employee>) Jpa.findAll();
		return emp;
	}
	
	@Override
	@Transactional
	public int deletebyempid(int empid) {
		// TODO Auto-generated method stub
		return Jpa.deleteByEmpid(empid);
	}
	
	@Override
	public Employee GetEmpData(int empid) {
		// TODO Auto-generated method stub
		return Jpa.findByEmpid(empid);
	}

	@Override
	public boolean UpdateEmployeeData(Employee edata) {
		
		if (Jpa.save(edata)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public Employee findbyid(int empid) {
		Employee Emp = Jpa.findByEmpid(empid);
		return Emp;
	}
	
	@Override
	public List<Employee> findbyEname(String ename) {
		return Jpa.findByEnameContaining(ename);
	}

	@Override
	public List<Employee> findbyDepartment(String department) {
		// TODO Auto-generated method stub
		return Jpa.findByDepartmentContaining(department);
	}

	@Override
	public List<Employee> findbyLocation(String location) {
		// TODO Auto-generated method stub
		return Jpa.findByLocation(location);
	}

	@Override
	public List<Employee> findbylowersalary(double salary) {
		// TODO Auto-generated method stub
		return Jpa.findBySalaryLessThanEqual(salary);
	}

	@Override
	public List<Employee> findbygreatersalary(double salary) {
		// TODO Auto-generated method stub
		return Jpa.findBySalaryGreaterThanEqual(salary);
	}

	@Override
	public List<Employee> findbydatebefore(Date hiredate) {
		// TODO Auto-generated method stub
		return Jpa.findByHiredateBefore(hiredate);
	}

	@Override
	public List<Employee> findbydateafter(Date hiredate) {
		// TODO Auto-generated method stub
		return Jpa.findByHiredateAfter(hiredate);
	}
	
	@Override
	public boolean addadmin(admin ad) {
		// TODO Auto-generated method stub
		if(adjpa.findByEmail(ad.getEmail())==null)
		{
			ad.setPassword(passwordEncoder.encode(ad.getPassword()));
			if (adjpa.save(ad)!=null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean adminlogincheck(admin ad) {
		// TODO Auto-generated method stub
		if(adjpa.findByEmail(ad.getEmail())==null)
		{
			admin adj=adjpa.findByEmail(ad.getEmail());
			if(ad.getPassword().equals(adj.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
}
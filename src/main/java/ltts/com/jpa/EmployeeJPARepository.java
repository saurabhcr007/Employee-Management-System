package ltts.com.jpa;


import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ltts.com.model.Employee;
@Repository
public interface EmployeeJPARepository extends CrudRepository<Employee, Integer> {

	public int deleteByEmpid(int empid);

	public Employee findByEmpid(int empid);

	public List<Employee> findByEnameContaining(String ename);

	public List<Employee> findByDepartmentContaining(String department);

	public List<Employee> findByLocation(String location);

	public List<Employee> findBySalaryLessThanEqual(double salary);

	public List<Employee> findBySalaryGreaterThanEqual(double salary);

	public List<Employee> findByHiredateBefore(Date hiredate);

	public List<Employee> findByHiredateAfter(Date hiredate);
}
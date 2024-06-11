package ltts.com.controller;


import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ltts.com.model.Employee;
import ltts.com.service.EMSServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin

@RestController
@RequestMapping("/EMS")
public class AppController {
	
	@Autowired
	private EMSServiceImpl service;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome to EMS web application";
	}
	@PostMapping("/addemployee")
	public String AddEmployee(@RequestBody Employee emp) {
		if(service.addEmp(emp)) {
			return "Successfull";
		}
		
		return "Data Exist";
	}
	
	@GetMapping("/showallemployee")
	public List<Employee> ShowAllEmployee() {
		
		return service.showallemp();
	}
	
	@GetMapping("/showbyid/{empid}")
	public ResponseEntity<Object> getEmployeebyId(@PathVariable(name="empid")int empid) {
		Employee emp=service.findbyid(empid);
		if(emp!=null) {
		return new ResponseEntity<>(emp,HttpStatus.OK);}
		else {
		String  errmassage="Employee with ID "+"\""+empid+"\""+" not found";
		return new ResponseEntity<>(errmassage,HttpStatus.NOT_FOUND);}
	}
//	@GetMapping("/showbyname/{ename}")
//	public ResponseEntity<Object> getEmployeebyname(@PathVariable(name="ename")String ename) {
//		List<Employee> emp=service.findbyEname(ename);
//		if(emp.size()!=0) {
//		return new ResponseEntity<>(emp,HttpStatus.OK);}
//		else {
//		String  errmassage="Employee with name "+"\""+ename+"\""+" not found";
//		return new ResponseEntity<>(errmassage,HttpStatus.NOT_FOUND);}
//	}
//	@GetMapping("/showbydepartment/{department}")
//	public ResponseEntity<Object> getEmployeebydepart(@PathVariable(name="department")String department) {
//		List<Employee> emp=service.findbyDepartment(department);
//		if(emp.size()!=0) {
//		return new ResponseEntity<>(emp,HttpStatus.OK);}
//		else {
//		String  errmassage="Employee with "+"\""+department+"\""+" Department not found";
//		return new ResponseEntity<>(errmassage,HttpStatus.NOT_FOUND);}
//	}
//	
//	@GetMapping("/showbylocation/{location}")
//	public ResponseEntity<Object> getEmployeebylocation(@PathVariable(name="location")String location) {
//		List<Employee> emp=service.findbyLocation(location);
//		if(emp.size()!=0) {
//		return new ResponseEntity<>(emp,HttpStatus.OK);}
//		else {
//		String  errmassage="No Employee In "+"\""+location+"\"";
//		return new ResponseEntity<>(errmassage,HttpStatus.NOT_FOUND);}
//	}
//	
//	@GetMapping("/showbysalarylesser/{salary}")
//	public ResponseEntity<Object> getEmployeebylessersalary(@PathVariable(name="salary")double salary) {
//		List<Employee> emp=service.findbylowersalary(salary);
//		if(emp.size()!=0) {
//		return new ResponseEntity<>(emp,HttpStatus.OK);}
//		else {
//		String  errmassage="No Employee having salary lesser than "+"\""+salary+"\"";
//		return new ResponseEntity<>(errmassage,HttpStatus.NOT_FOUND);}
//	}
//	
//	@GetMapping("/showbysalarygreater/{salary}")
//	public ResponseEntity<Object> getEmployeebygreatersalary(@PathVariable(name="salary")double salary) {
//		List<Employee> emp=service.findbygreatersalary(salary);
//		if(emp.size()!=0) {
//		return new ResponseEntity<>(emp,HttpStatus.OK);}
//		else {
//		String  errmassage="No Employee having salary Greater than "+"\""+salary+"\"";
//		return new ResponseEntity<>(errmassage,HttpStatus.NOT_FOUND);}
//	}
//	
//	@GetMapping("/showbbydatebefore")
//	public ResponseEntity<Object> getEmployeebybbeforedate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")Date  hiredate ) {
//		Date  current=new  Date();
//		if(current.before(hiredate)) {
//			String  errmassage="This date is  not yet come";
//			return new ResponseEntity<>(errmassage,HttpStatus.NOT_FOUND);
//		}
//		List<Employee> emp=service.findbydatebefore(hiredate);
//		if(emp.size()!=0) {
//		return new ResponseEntity<>(emp,HttpStatus.OK);}
//		else {
//		String  errmassage="No Employee hired before "+"\""+hiredate+"\"";
//		return new ResponseEntity<>(errmassage,HttpStatus.NOT_FOUND);}
//	}
//	
//	@GetMapping("/showbbydateafter")
//	public ResponseEntity<Object> getEmployeebyafterdate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")Date  hiredate ) {
//		Date  current=new  Date();
//		if(current.before(hiredate)) {
//			String  errmassage="This date is  not yet come";
//			return new ResponseEntity<>(errmassage,HttpStatus.NOT_FOUND);
//		}
//		List<Employee> emp=service.findbydateafter(hiredate);
//		if(emp.size()!=0) {
//		return new ResponseEntity<>(emp,HttpStatus.OK);}
//		else {
//		String  errmassage="No Employee hired after "+"\""+hiredate+"\"";
//		return new ResponseEntity<>(errmassage,HttpStatus.NOT_FOUND);
//		}
//	}
//	
	@DeleteMapping("/deleteemployee/{empid}")
	public String DeleteEmployee(@PathVariable(name="empid") int empid) {
		if(service.deletebyempid(empid)>0)
			return "deleted successfully";
		return "no data found";
	}
	
	@PutMapping("/updateemployee/{empid}")
	public String UpdateEmployee(@PathVariable(name="empid") int empid, @RequestBody Employee emp) {
		Employee edata=service.GetEmpData(empid);
		if(edata==null) {
			return "Invalid Employee ID or the Employee with this ID doesn't Exist";
		}
		edata=emp;
		edata.setEmpid(empid);
		if(service.UpdateEmployeeData(edata))
			return "update successfully";
		return "update unsuccessfull";
	}
}

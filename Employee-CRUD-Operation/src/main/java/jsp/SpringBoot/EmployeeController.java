package jsp.SpringBoot;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository er;
	
	
	// Saving to the Records
	@PostMapping("/employee")
	public String saveEmployee(@RequestBody Employee e) {
		er.save(e);
		return "Employee Saved Successfully";
	}
	
	// Get OR Fetch all the records
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		List<Employee> e = er.findAll();
		return e;
	}
	
	// Get OR Fetch Employee By Id
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Optional<Employee> opt = er.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			return null;
		}
	}
	
	// Update the Employee
	@PutMapping("/employee")
	public String updateEmployee(@RequestBody Employee e) {
		er.save(e);
		return "Employee is Updated";
	}
	
	// Delete Employee from the database
	@DeleteMapping("/employee/{id}")
	public String deleteEmplyee(@PathVariable int id) {
		Optional<Employee> opt = er.findById(id);
		if(opt.isPresent()) {
			er.delete(opt.get());
			return "Employee Deleted Successfully";
		}
		else {
			return "Employee id Not Found";
		}
	}

}











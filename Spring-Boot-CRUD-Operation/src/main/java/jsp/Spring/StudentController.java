package jsp.Spring;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private StudentRepository sr;
	
	@PostMapping("/student")
	public String saveStudent(@RequestBody Student s) {
		sr.save(s);
		return "Student Record Saved";
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		List<Student> s = sr.findAll();
		return s;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		Optional<Student> opt = sr.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			return null;
		}
	}
	
	@PutMapping("/student")
	public String updateStudent(@RequestBody Student s) {
		sr.save(s);
		return "Student Record is Updated";
	}
	
	@DeleteMapping("/student/{id}")
	public String deletStudentById(@PathVariable int id) {
		Optional<Student> opt = sr.findById(id);
		if(opt.isPresent()) {
			sr.delete(opt.get());
			return "Student Record is Deleted";
		}
		else {
			return "No Record Found";
		}
	}
}























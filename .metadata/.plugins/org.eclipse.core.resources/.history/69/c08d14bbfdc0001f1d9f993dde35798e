package jsp.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}

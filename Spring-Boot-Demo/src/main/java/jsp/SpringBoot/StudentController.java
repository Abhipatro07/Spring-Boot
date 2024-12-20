package jsp.SpringBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@GetMapping("/student")
	public void getStudent(@RequestParam int id , @RequestParam int age) {
		System.out.println("ID: " + id);
		System.out.println("Age: " + age);
		
	}

}

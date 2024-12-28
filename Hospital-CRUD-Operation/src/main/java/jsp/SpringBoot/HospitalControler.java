package jsp.SpringBoot;

import java.util.*;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/jsp")
public class HospitalControler {
	@Autowired
	private HospitalRepository hr;
	
	//save records
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saverecord(@RequestBody Hospital h){
		hr.save(h);
		ResponseStructure<Hospital> str = new ResponseStructure<Hospital>();
		str.setStatusCode(HttpStatus.CREATED.value());    
		str.setMeassage("Success");
		str.setData(h);
		return new ResponseEntity<ResponseStructure<Hospital>>(str , HttpStatus.CREATED);
	}
	
	// get OR fetch all the student record
	@GetMapping("/hospital")
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllRecord(){
		List<Hospital> h = hr.findAll();
		ResponseStructure<List<Hospital>> str = new ResponseStructure<List<Hospital>>();
		str.setStatusCode(HttpStatus.OK.value());
		str.setMeassage("Success");
		str.setData(h);
		return new ResponseEntity<ResponseStructure<List<Hospital>>>(str , HttpStatus.OK);
	}
	
	//get OR find the records by id
	@GetMapping("/hospital/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> getRecordById(@PathVariable int id){
		Optional<Hospital> opt = hr.findById(id);
		ResponseStructure<Hospital> str = new ResponseStructure<Hospital>();
		if(opt.isPresent()) {
			str.setStatusCode(HttpStatus.OK.value());
			str.setMeassage("Success");
			str.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Hospital>>(str , HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	// Update the Record
	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> upadaterecord(@RequestBody Hospital h){
		hr.save(h);
		ResponseStructure<Hospital> str = new ResponseStructure<Hospital>();
		str.setStatusCode(HttpStatus.OK.value());    
		str.setMeassage("Success");
		str.setData(h);
		return new ResponseEntity<ResponseStructure<Hospital>>(str , HttpStatus.OK);
	}
	
	// Delete the Record
	@DeleteMapping("/hospital/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> deleteRecord(@PathVariable int id){
		Optional<Hospital> opt = hr.findById(id);
		ResponseStructure<Hospital> str = new ResponseStructure<Hospital>();
		if(opt.isPresent()) {
			Hospital hospital = opt.get();
			hr.delete(hospital);
			str.setStatusCode(HttpStatus.OK.value());
			str.setMeassage("Deleted");
			str.setData(null);
			return new ResponseEntity<ResponseStructure<Hospital>>(str , HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
		
	}

}

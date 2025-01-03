package jsp.Spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Loan;
import jsp.Spring.Service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {
	@Autowired
	private LoanService loanservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Loan>> saveloan(@RequestBody Loan loan){
		return loanservice.saveLoan(loan);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Loan>>> getAllloan(){
		return loanservice.getAllLoan();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Loan>> getLoanById(@PathVariable int id){
		return loanservice.getLoanById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Loan>> deletLoan(@PathVariable int id){
		return loanservice.deleteLoan(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Loan>> updateLoan(@RequestBody Loan loan){
		return loanservice.updateLoan(loan);
	}

}

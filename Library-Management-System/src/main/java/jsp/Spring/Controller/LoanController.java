package jsp.Spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping()
	public ResponseEntity<ResponseStructure<Loan>> saveloan(@RequestBody Loan loan){
		return loanservice.saveLoan(loan);
	}

}

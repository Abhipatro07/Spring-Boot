package jsp.Spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.Spring.DAO.LoanDAO;
import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Loan;

@Service
public class LoanService {
	@Autowired
	private LoanDAO loanDao;
	
	
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(Loan loan){
		Loan receivedLoan = loanDao.saveLoan(loan);
		ResponseStructure<Loan> str = new ResponseStructure<Loan>();
		str.setStatusCode(HttpStatus.CREATED.value());
		str.setMessage("Created");
		str.setData(receivedLoan);
		
		return new ResponseEntity<ResponseStructure<Loan>>(str , HttpStatus.CREATED);
	}
}

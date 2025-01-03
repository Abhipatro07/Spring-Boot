package jsp.Spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jsp.Spring.DAO.LoanDAO;
import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Loan;
import jsp.Spring.Exception.IdNotFoundException;

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
	
	public ResponseEntity<ResponseStructure<List<Loan>>> getAllLoan(){
		List<Loan> getAllLoan = loanDao.getAllLoan();
		ResponseStructure<List<Loan>> str = new ResponseStructure<List<Loan>>();
		str.setStatusCode(HttpStatus.FOUND.value());
		str.setMessage("Found");
		str.setData(getAllLoan);
		return new ResponseEntity<ResponseStructure<List<Loan>>>(str , HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Loan>> getLoanById(int id){
		Optional<Loan> loan = loanDao.getLoanById(id);
		ResponseStructure<Loan> str = new ResponseStructure<Loan>();
		if(loan.isPresent()) {
			str.setStatusCode(HttpStatus.FOUND.value());
			str.setMessage("Found");
			str.setData(loan.get());
			return new ResponseEntity<ResponseStructure<Loan>>(str , HttpStatus.FOUND);
		}
		else {

			str.setStatusCode(HttpStatus.NOT_FOUND.value());
			str.setMessage("Not Found");
			str.setData(null);
			return new ResponseEntity<ResponseStructure<Loan>>(str , HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Loan>> deleteLoan(int id){
		Optional<Loan> loan = loanDao.getLoanById(id);
		ResponseStructure<Loan> str = new ResponseStructure<Loan>();
		if(loan.isPresent()) {
			str.setStatusCode(HttpStatus.OK.value());
			str.setMessage("Deleted the record");
			str.setData(null);
			return new ResponseEntity<ResponseStructure<Loan>>(str , HttpStatus.OK);
		}
		else {
			str.setStatusCode(HttpStatus.NOT_FOUND.value());
			str.setMessage("Id not Found");
			str.setData(null);
			return new ResponseEntity<ResponseStructure<Loan>>(str , HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Loan>> updateLoan(Loan loan){
		Loan updateLoan = loanDao.saveLoan(loan);
		ResponseStructure<Loan> str = new ResponseStructure<Loan>();
		str.setStatusCode(HttpStatus.OK.value());
		str.setMessage("Upadted Rescord");
		str.setData(updateLoan);
		return new ResponseEntity<ResponseStructure<Loan>>(str , HttpStatus.OK);
		
	}
}


















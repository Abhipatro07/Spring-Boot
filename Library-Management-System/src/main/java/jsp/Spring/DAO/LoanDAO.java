package jsp.Spring.DAO;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Loan;
import jsp.Spring.Repository.LoanRepository;

@Repository
public class LoanDAO {
	@Autowired
	private LoanRepository loanRepository;
	
	public Loan saveLoan(Loan loan) {
		return loanRepository.save(loan);
	}
	
	public List<Loan> getAllLoan(){
		List<Loan> getAllLoan = loanRepository.findAll();
		return getAllLoan;
	}
	
	public Optional<Loan> getLoanById(int id){
		Optional<Loan> loan = loanRepository.findById(id);
		if(loan.isPresent()) {
			return loan;
		}
		else {
			return null;
		}
	}
	
	public Optional<Loan> deleteLoan(int id){
		Optional<Loan> loan = loanRepository.findById(id);
		if(loan.isPresent()) {
			Loan deleteLoan = loan.get();
			loanRepository.delete(deleteLoan);
			return null;
		}
		else {
			return null;
		}
	}
	
	public Loan updateLoan(Loan loan) {
		return loanRepository.save(loan);
	}
}


















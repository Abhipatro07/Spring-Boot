package jsp.Spring.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.Spring.Entity.Loan;
import jsp.Spring.Repository.LoanRepository;

@Repository
public class LoanDAO {
	@Autowired
	private LoanRepository loanRepository;
	
	public Loan saveLoan(Loan loan) {
		return loanRepository.save(loan);
	}
}

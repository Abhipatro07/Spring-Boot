package jsp.Spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.Spring.DAO.AuthorDAO;
import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Author;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorDAO authorDao;
	
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(Author author){
		Author receievedAuthor = authorDao.saveAuthor(author);
		
		ResponseStructure<Author> str = new ResponseStructure<Author>();
		str.setStatusCode(HttpStatus.CREATED.value());
		str.setMessage("Created");		
		str.setData(receievedAuthor);
		
		return new ResponseEntity<ResponseStructure<Author>>(str , HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Author>>> getAllAuthor(){
		List<Author> getAllAuthors = authorDao.getAllAuthor();
		
		ResponseStructure<List<Author>> str = new ResponseStructure<List<Author>>();
		str.setStatusCode(HttpStatus.OK.value());
		str.setMessage(null);
		str.setData(getAllAuthors);
		
		return new ResponseEntity<ResponseStructure<List<Author>>>(str , HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<Author>> getAuthorById(int id){
		Optional<Author> getAuthorById = authorDao.getAuthorById(id);
		
		ResponseStructure<Author> str = new ResponseStructure<Author>();
		if(getAuthorById.isPresent()) {
			str.setStatusCode(HttpStatus.FOUND.value());
			str.setMessage("Found");		
			str.setData(getAuthorById.get());
			return new ResponseEntity<ResponseStructure<Author>>(str , HttpStatus.FOUND);
		}
		else {
			return null;
		}
		
	}

}

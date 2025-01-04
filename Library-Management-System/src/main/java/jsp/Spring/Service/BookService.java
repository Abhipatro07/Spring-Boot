package jsp.Spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.Spring.DAO.AuthorDAO;
import jsp.Spring.DAO.BookDAO;
import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Author;
import jsp.Spring.Entity.Book;

@Service
public class BookService {
	@Autowired
	private BookDAO bookDao;
	@Autowired
	private AuthorDAO authorDao;
	
	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book){
		Book receivedBook = bookDao.saveBook(book);
		
		int aid = receivedBook.getAuthor().getId();
		Optional<Author> author = authorDao.getAuthorById(aid);
		if(author.isPresent()) {
			receivedBook.setAuthor(author.get());
		}
		ResponseStructure<Book> str = new ResponseStructure<Book>();
		str.setStatusCode(HttpStatus.CREATED.value());
		str.setMessage("Ceated");
		str.setData(receivedBook);
		return new ResponseEntity<ResponseStructure<Book>>(str , HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBook (){
		List<Book> getAllBook = bookDao.getAllBook();
		ResponseStructure<List<Book>> str = new ResponseStructure<List<Book>>();
		str.setStatusCode(HttpStatus.FOUND.value());
		str.setMessage("Found");
		str.setData(getAllBook);
		return new ResponseEntity<ResponseStructure<List<Book>>>(str , HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Book>> getBookById(int id){
		Optional<Book> book = bookDao.getBookById(id);
		ResponseStructure<Book> str = new ResponseStructure<Book>();
		if(book.isPresent()) {
			str.setStatusCode(HttpStatus.FOUND.value());
			str.setMessage("Found");
			str.setData(book.get());
			return new ResponseEntity<ResponseStructure<Book>>(str , HttpStatus.FOUND);
		}
		else {
			str.setStatusCode(HttpStatus.NOT_FOUND.value());
			str.setMessage("Not Found");
			str.setData(null);
			return new ResponseEntity<ResponseStructure<Book>>(str , HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Book>> deleteBook(int id){
		Optional<Book> book = bookDao.getBookById(id);
		ResponseStructure<Book> str = new ResponseStructure<Book>();
		if(book.isPresent()) {
			bookDao.deleteBook(id);
			str.setStatusCode(HttpStatus.OK.value());
			str.setMessage("Book Deleted");
			str.setData(null);
			return new ResponseEntity<ResponseStructure<Book>>(str , HttpStatus.OK);
		}
		else {
			str.setStatusCode(HttpStatus.NOT_FOUND.value());
			str.setMessage("Id Not Found");
			str.setData(null);
			return new ResponseEntity<ResponseStructure<Book>>(str , HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Book>> upadteBook(Book book){
		Book updateBook = bookDao.saveBook(book);
		ResponseStructure<Book> str = new ResponseStructure<Book>();
		str.setStatusCode(HttpStatus.OK.value());
		str.setMessage("Upadted");
		str.setData(updateBook);
		return new ResponseEntity<ResponseStructure<Book>>(str , HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByGenre(String genre){
		List<Book> book = bookDao.getBookByGenre(genre);
		ResponseStructure<List<Book>> str = new ResponseStructure<List<Book>>();
		if(!book.isEmpty()) {
			str.setStatusCode(HttpStatus.FOUND.value());
			str.setMessage("Found");
			str.setData(book);
			return new ResponseEntity<ResponseStructure<List<Book>>>(str , HttpStatus.FOUND);
		}
		else {
			str.setStatusCode(HttpStatus.NOT_FOUND.value());
			str.setMessage("Not Found");
			str.setData(null);
			return new ResponseEntity<ResponseStructure<List<Book>>>(str , HttpStatus.NOT_FOUND);
		}
	}
}
















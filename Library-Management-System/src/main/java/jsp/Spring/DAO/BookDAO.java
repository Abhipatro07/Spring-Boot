package jsp.Spring.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Book;
import jsp.Spring.Exception.IdNotFoundException;
import jsp.Spring.Repository.BookRepository;

@Repository
public class BookDAO {
	@Autowired
	private BookRepository bookRepository;
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> getAllBook(){
		List<Book> getAllBook = bookRepository.findAll();
		return getAllBook;
	}
	
	public Optional<Book> getBookById(int id) {
		Optional<Book> book = bookRepository.findById(id);
		if(book.isPresent()) {
			return book;
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public Optional<Book> deleteBook (int id){
		Optional<Book> book =bookRepository.findById(id);
		if(book.isPresent()) {
			Book deleteBook = book.get();
			bookRepository.delete(deleteBook);
			return null;
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> getBookByGenre(String string){
		List<Book> book = bookRepository.getBookByGenre(string);
		if(!book.isEmpty()) {
			return book;
		}
		else {
			return null;
		}
	}
}










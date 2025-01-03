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
import jsp.Spring.Entity.Book;
import jsp.Spring.Service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookservice;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book){
		return bookservice.saveBook(book);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBook(){
		return bookservice.getAllBook();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Book>> getBookById(@PathVariable int id){
		return bookservice.getBookById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Book>> deleteBook(@PathVariable int id){
		return bookservice.deleteBook(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book){
		return bookservice.upadteBook(book);
	}
	
	@GetMapping("/genre/{genre}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBookByGenre(@PathVariable String genre){
		return bookservice.getBookByGenre(genre);
	}
}











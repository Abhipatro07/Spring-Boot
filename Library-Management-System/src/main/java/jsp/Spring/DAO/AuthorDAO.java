package jsp.Spring.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.Spring.Entity.Author;
import jsp.Spring.Exception.IdNotFoundException;
import jsp.Spring.Repository.AuthorRepository;

@Repository
public class AuthorDAO {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public List<Author> getAllAuthor() {
		List<Author> author = authorRepository.findAll();
		return author;
	}
	
	public Optional<Author> getAuthorById(int id) {
		Optional<Author> author = authorRepository.findById(id);
		if(author.isPresent()) {
			return author;
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public Optional<Author> deleteAuthor(int id) {
		Optional<Author> author = authorRepository.findById(id);
		if(author.isPresent()) {
			Author deletedAuthor = author.get();
			authorRepository.delete(deletedAuthor);
			return null;
		}
		else {
			throw new IdNotFoundException();
		}
	} 
	
	public Author updateAuthor(Author author) {
		return authorRepository.save(author);
	}
	

}












package jsp.Spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jsp.Spring.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("select b from Book b where b.genre = ?1")
	List<Book> getBookByGenre(String string);
	

}

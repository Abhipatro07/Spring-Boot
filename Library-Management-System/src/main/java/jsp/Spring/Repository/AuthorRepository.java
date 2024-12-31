package jsp.Spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jsp.Spring.Entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}

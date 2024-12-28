package jsp.SpringBoot;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	List<Hospital> findByHname(String hname);
}

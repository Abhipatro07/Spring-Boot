package jsp.SpringBoot;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	List<Hospital> findByHname(String hname);
	
	@Query("select h from Hospital h where h.noOfPatients>4000")
	List<Hospital> getHospitalName();
	
	@Query("select h from Hospital h where h.location = ?1 and h.hname = ?2")
	List<Hospital> getHospitalNameByLocation(String location , String hname);
	
	@Query("select h from Hospital h where h.hname = :h_name")
	List<Hospital> getHospitalByName(String h_name);
}

package jsp.Spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.Spring.DAO.MemberDAO;
import jsp.Spring.DTO.ResponseStructure;
import jsp.Spring.Entity.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDao;
	
	public ResponseEntity<ResponseStructure<Member>> saveMember(Member member){
		Member receievedMember = memberDao.saveMember(member);
		ResponseStructure<Member> str = new ResponseStructure<Member>();
		str.setStatusCode(HttpStatus.CREATED.value());
		str.setMessage("Created");		
		str.setData(receievedMember);
		return new ResponseEntity<ResponseStructure<Member>>(str , HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Member>>> getAllMember(){
		List<Member> getAllMember = memberDao.getAllMemeber();
		ResponseStructure<List<Member>> str = new ResponseStructure<List<Member>>();
		str.setStatusCode(HttpStatus.FOUND.value());
		str.setMessage("Seccess");
		str.setData(getAllMember);
		return new ResponseEntity<ResponseStructure<List<Member>>>(str , HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Member>> getMemberById(int id){
		Optional<Member> member = memberDao.getMemberById(id);
		ResponseStructure<Member> str = new ResponseStructure<Member>();
		if(member.isPresent()) {
			str.setStatusCode(HttpStatus.FOUND.value());
			str.setMessage("Found");
			str.setData(member.get());
			return new ResponseEntity<ResponseStructure<Member>>(str , HttpStatus.FOUND);
		}
		else {
			str.setStatusCode(HttpStatus.NOT_FOUND.value());
			str.setMessage("Not Found");
			str.setData(null);
			return new ResponseEntity<ResponseStructure<Member>>(str , HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Member>> deleteMember(int id){
		Optional<Member> deleteMember = memberDao.getMemberById(id);
		ResponseStructure<Member> str = new ResponseStructure<Member>();
		if(deleteMember.isPresent()) {
			memberDao.deleteMember(id);
			str.setStatusCode(HttpStatus.OK.value());
			str.setMessage("deleted");
			str.setData(null);
			return new ResponseEntity<ResponseStructure<Member>>(str , HttpStatus.OK);
		}
		else {
			str.setStatusCode(HttpStatus.NOT_FOUND.value());
			str.setMessage("Failed");
			str.setData(null);
			return new ResponseEntity<ResponseStructure<Member>>(str , HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Member>> updateMember(Member member){
		Member updatedMember = memberDao.updateMember(member);
		ResponseStructure<Member> str = new ResponseStructure<Member>();
		str.setStatusCode(HttpStatus.OK.value());
		str.setMessage("Updated");		
		str.setData(updatedMember);
		return new ResponseEntity<ResponseStructure<Member>>(str , HttpStatus.CREATED);
	}
	
}

















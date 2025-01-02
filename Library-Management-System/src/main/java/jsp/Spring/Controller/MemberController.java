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
import jsp.Spring.Entity.Member;
import jsp.Spring.Service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping()
	public ResponseEntity<ResponseStructure<Member>> saveMember(@RequestBody Member member){
		return memberService.saveMember(member);
	}
	
	@GetMapping("/allMember")
	public ResponseEntity<ResponseStructure<List<Member>>> getAllMember(){
		return memberService.getAllMember();
	}
	
	@GetMapping("/getMember/{id}")
	public ResponseEntity<ResponseStructure<Member>> getMemberById(@PathVariable int id){
		return memberService.getMemberById(id);
	}
	
	@DeleteMapping("/deleteMember/{id}")
	public ResponseEntity<ResponseStructure<Member>> deleteMember(@PathVariable int id){
		return memberService.deleteMember(id);
	}
	
	@PutMapping("/updateMember")
	public ResponseEntity<ResponseStructure<Member>> updateMember(@RequestBody Member member){
		return memberService.updateMember(member);
	}
}
















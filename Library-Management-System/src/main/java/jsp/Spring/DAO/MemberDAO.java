package jsp.Spring.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jsp.Spring.Entity.Member;
import jsp.Spring.Exception.IdNotFoundException;
import jsp.Spring.Repository.MemberRepository;

@Repository
public class MemberDAO {
	@Autowired
	private MemberRepository memberRepository;
	
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}
	
	public List<Member> getAllMemeber(){
		List<Member> getAllMember = memberRepository.findAll();
		return getAllMember;
	}
	
	public Optional<Member> getMemberById(int id) {
		Optional<Member> member = memberRepository.findById(id);
		if(member.isPresent()) {
			return member;
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public Optional<Member> deleteMember(int id){
		Optional<Member> member = memberRepository.findById(id);
		if(member.isPresent()) {
			Member deleteMember = member.get();
			memberRepository.delete(deleteMember);
			return null;
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public Member updateMember(Member member) {
		return memberRepository.save(member);
	}
}
















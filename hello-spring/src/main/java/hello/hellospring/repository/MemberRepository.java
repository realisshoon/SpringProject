package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);                 //회원이 저장소에 저장
    Optional<Member> findById(Long id);          //id랑 name을 찾아 올 수있음
    Optional<Member> findByName(String name);   //Optional: npe방지를 위해 사용
    List<Member> findAll();                     //지금까지 저장된 회원 리스트 모두를 반환

}

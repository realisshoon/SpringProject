package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore(); // 테스트 진행 후 repo를 clear 해줌 (join을 사용하기 때문에 중복문제가 해결 안됨)
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");        // hello 라는 이름 생성

        // when (무엇을 검증하는가?)
        Long saveId = memberService.join(member); // return: 저장한 id

        // then
        //  저정한 것이 리포지토리에 저장한게 맞아?
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    // 예외 flow
    // 중복회원 검증 로직
    @Test
    public void 중복_회원_예외(){
        //given (이름이 중복인 상황)
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");  //


        //when (join을  두 번)
        // 같은 이름이기 때문에 MemberService.validateDuplicateMember()에서 error 발생 해야함
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then
    }

    @Test
    void findMembers() {
        //given

        //when

        //then
    }

    @Test
    void findOne() {
        //given

        //when

        //then
    }
}
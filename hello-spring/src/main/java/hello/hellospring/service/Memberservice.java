package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 스프링에 올라올 때 service 애노테이션을 확인 후, memberserice를 스프링 컨테이너에 올려줌
@Service
public class Memberservice {
    // test코드에서 memorymemberrepository의 인스턴스를 하나로 만들기 위해 변경
    private final MemberRepository memberRepository;

    public Memberservice(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**회원 가입**/
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}

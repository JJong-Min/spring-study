package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 1. 회원이 저장소에 저장되는 기능
    Member save(Member member);
    //optional은 자바8에서 추가된 기능으로 null 반환시 null 그대로 반환하는 것보다 optional로 감싸서 반환하는 것을 선호
    // 2. id와 name으로 회원찾기 기능
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    // 3. 모든 회원 정보를 가져오는 것
    List<Member> findAll();

    }

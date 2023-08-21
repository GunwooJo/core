package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

  private static Map<Long, Member> store = new HashMap<>(); //HashMap은 동시성 이슈가 있다. ConcurrentHashMap 쓰자. https://applepick.tistory.com/124
  @Override
  public void save(Member member) { //오류처리는 예제 간략화를 위해 생략.
    store.put(member.getId(), member);
  }

  @Override
  public Member findById(Long memberId) {
    return store.get(memberId);
  }
}

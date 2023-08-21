package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
  OrderService orderService;
  MemberService memberService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    orderService = appConfig.orderService();
    memberService = appConfig.memberService();
  }

  @Test
  void createOrder() {
    //primitive type을 써도 된다. ex) long memberId=1; 근데 primitive 쓰면 null을 넣을 수 없음. 그래서 Wrapper 클래스를 쓰는 것임.
    Long memberId = 1L;
    Member member = new Member(memberId, "gunwoo", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "MacBook Pro", 2500000);

    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(250000);
  }
}

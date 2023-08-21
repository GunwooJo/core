package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

  RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
  void vip_o() {
    //given
    Member vipMember = new Member(1L, "memberA", Grade.VIP);
    //when
    int discount = rateDiscountPolicy.discount(vipMember, 10000);
    //then
    assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
  void vip_x() {
    Member notVip = new Member(1L, "notVipMem", Grade.BASIC);
    int discount = rateDiscountPolicy.discount(notVip, 10000);
    assertThat(discount).isEqualTo(0);
  }
}
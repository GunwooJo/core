package hello.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//이해를 위해 알면 좋으나 몰라도 개발에 지장은 없다. 나중에 또 살펴보자.
public class BeanDefinitionTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("빈 설정 메타정보 확인")
  void findApplicationBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for(String beanDefinitionName : beanDefinitionNames) {
      BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

      if(beanDefinition.getRole() == beanDefinition.ROLE_APPLICATION) {
        System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
      }
    }
  }
}

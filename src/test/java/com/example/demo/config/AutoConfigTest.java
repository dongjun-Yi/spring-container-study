package com.example.demo.config;

import com.example.demo.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AutoConfigTest {
    @Test
    @DisplayName("컴포넌트 스캔으로 스프링 컨테이너에 빈 등록 테스트")
    void componentScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);
        MemberService memberService = ac.getBean("memberServiceImpl", MemberService.class); // 컴포넌트 스캔에서 등록한 빈이름은 클래스의 일므에서 앞글자만 소문자로 하여 저장함.
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
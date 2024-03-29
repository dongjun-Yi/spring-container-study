package com.example.demo.config;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class SpringAppConfigTest {

    @Test
    @DisplayName("Spring 애너테이션을 이용한 회원 저장 테스트")
    void join() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
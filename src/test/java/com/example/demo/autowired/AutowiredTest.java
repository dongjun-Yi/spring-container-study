package com.example.demo.autowired;

import com.example.demo.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

public class AutowiredTest {

    @Test
    @DisplayName("Bean 등록 안되는 옵션 테스트")
    void autowiredTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    @Configuration
    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("member = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member = " + member);
        }


        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("member = " + member);
        }

    }
}

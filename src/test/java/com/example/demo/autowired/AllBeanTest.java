package com.example.demo.autowired;

import com.example.demo.config.AutoConfig;
import com.example.demo.discount.DiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class AllBeanTest {
    @Test
    @DisplayName("")
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class, DiscountService.class);
        DiscountService bean = ac.getBean(DiscountService.class);
        Map<String, DiscountPolicy> map = bean.getPolicyMap();
        for (String s : map.keySet()) {
            System.out.println("key = " + s + ", value = " + map.get(s));
        }
    }

    @Configuration
    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap) {
            this.policyMap = policyMap;
        }

        public Map<String, DiscountPolicy> getPolicyMap() {
            return policyMap;
        }
    }
}

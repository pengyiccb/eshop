package com.tfx0one.common.util;

import org.junit.Test;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/13.
 */
public class FunctionTest {

    @Test
    public void test1() {

        List<String> list = new ArrayList<>(Arrays.asList("1", "2"));
        List<String> l2 = list.parallelStream().map(e -> test2(e)).collect(Collectors.toList());

        System.out.println(l2);

    }

    public String test2(String a) {
        return a + "_";
    }

    @Test
    public void test3() {
        System.out.println("a".split("\\|"));
    }

    @Test
    public void test4() {
        SpelExpressionParser parser = new SpelExpressionParser();
        List list = parser.parseExpression("{1,2,3}").getValue(List.class);
//        list.forEach(System.out::println);

        Map<String, List<Integer>> map = (Map<String, List<Integer>>)parser.parseExpression("{1:{1,2,3},2:{2,3,4}}").getValue();
        System.out.println(map);

    }

    @Test
    public void test5() {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        System.out.println(new BCryptPasswordEncoder().matches("123456", "$2a$10$6Zh4dkX/vP1oTT6OzB4rWumibl33weSJcVXN6JGghxtzWasP/aSm2"));
        System.out.println(new BCryptPasswordEncoder().matches("123456", "$2a$10$BQqD/iGEiQeyCfHoDvx1xO0jU5TpPGkoP84r50oq1FD8EqJp3a3EW"));
    }
}

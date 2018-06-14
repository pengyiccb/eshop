package com.tfx0one.common.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
}

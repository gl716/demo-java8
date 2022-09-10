package com.leon.option;

import org.junit.Test;

import java.util.Optional;

/**
 * @author liang.guo
 * @since 2022年09月01日 14:32
 **/
public class OptionalTest {

    @Test
    public void test1() {
        A a = new A();
        String s1 = Optional.of(a).map(A::getS).map(String::toString).orElse("空对象");
        System.out.println(s1);
    }

    class A{
        String s;

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }
    }
}

package com.leon.stream;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author Leon
 * @since 2021年08月04日 8:55
 **/
public class StreamDemo {
    public static void main(String[] args) {
//        Random random = new Random();
//        random.ints().limit(10).sorted().forEach(System.out::println);
//
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        Integer i = 0;
        int j = 2;
        i.compareTo(j);

        Comparator<Integer> comparing = Comparator.comparing(Integer::intValue);
        Consumer<Integer> println = System.out::println;
        numbers.stream().sorted(comparing).forEach(println);
        numbers.forEach(println);
//
//        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
//
//        System.out.println("列表中最大的数 : " + stats.getMax());
//        System.out.println("列表中最小的数 : " + stats.getMin());
//        System.out.println("所有数之和 : " + stats.getSum());
//        System.out.println("平均数 : " + stats.getAverage());

//        List<String> lists = ImmutableList.of("null","345","null","345");
//        lists.stream().filter(x->x.equals("345")).map(x->x+"000").count();
//        //lists.stream().reduce("123", StringBuilder::append);
//        lists.stream().map(Object::toString).collect(Collectors.toList());
//        MyStringBuilder strings = lists.parallelStream().map(Object::toString) .collect(MyStringBuilder::new, MyStringBuilder::append, (l,r)->{
//            System.out.println("左边元素的id："+l.number);
//            System.out.println("右边元素的id："+r.number);
//            l.merger(r);
//        });
//        System.out.println(strings);
//        Map<String, Long> collect = lists.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//        System.out.println(collect);
//        lists.forEach(System.out::println);
//        StringBuilder sb = new StringBuilder();
//        testBiConsumer(StringBuilder::append, sb, "2");
//        System.out.println(sb.toString());
    }

    private static void testBiConsumer(BiConsumer<StringBuilder, String> b, StringBuilder s, String t){
        b.accept(s, t);
    }

    public static class MyStringBuilder{
        static int i = 0;
        StringBuilder sb = new StringBuilder();
        private int number = 0;
        public MyStringBuilder(){
            number = i ++;
            System.out.println("构造函数："+number);
        }

        public MyStringBuilder append(String s){
            sb.append(s);
            return this;
        }

        public MyStringBuilder merger(MyStringBuilder s){
            sb.append(s);
            return this;
        }

    }
}

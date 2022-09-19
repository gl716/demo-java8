package com.leon.com.leon.asse;

import cn.hutool.core.lang.Assert;

import java.util.HashMap;

/**
 * @author liang.guo
 * @since 2022年09月15日 14:17
 **/
public class AssertTest1 {
    public static void main(String[] args) {
//        String searchFromInstName = "";
//        Assert.isNull(searchFromInstName, "实例名[{}]已存在", "123");


        HashMap map = new HashMap();
//        map.put("a", null);
        map.remove("a");
        boolean a = map.containsKey("a");
        System.out.println(a);
    }
}

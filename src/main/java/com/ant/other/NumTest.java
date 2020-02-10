package com.ant.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xile.su on 2020/2/3
 */
public class NumTest {

    public static void main(String[] args) {
        int i = -210;
        int tmp = 0;
        while (i != 0) {
            System.out.println(i % 10);
            tmp = tmp * 10 + i % 10;
            i = i / 10;
            System.out.println(i);
            System.out.println(tmp);
            System.out.println("-------------");
        }

        String a="123";

    }
}

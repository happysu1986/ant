package com.ant.algo.sort;

import java.util.Arrays;

/**
 * Created by xile.su on 2019/12/26
 */
public class CommonUtil {

    public static void print(int[] array) {
        if (array == null) {
            System.out.print("null");
            return;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        if (array.length > 0) {
            Arrays.stream(array).forEach(i -> sb.append(i).append(","));
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}

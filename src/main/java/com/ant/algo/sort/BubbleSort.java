package com.ant.algo.sort;

import java.util.Arrays;

/**
 * Created by xile.su on 2019/12/25
 */
public class BubbleSort {

    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{2, 5, 1, 8, 3, 5, 3};
        sort(array1);
        CommonUtil.print(array1);
    }
}

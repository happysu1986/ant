package com.ant.algo.sort;

/**
 * Created by xile.su on 2019/12/30
 */
public class ShellSort {

    /**
     * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
     *
     * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位；
     *
     * 希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
     * 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     *
     * https://www.jianshu.com/p/40dcc3b83ddc
     * <pre>
     * [8,9,1,7,2,3,5,4,6,0]
     *        || step = 5
     * [8,3] [9,5] [1,4] [7,6] [2,0]
     * [3,5,1,6,0,8,9,4,7,2]
     *        || step = 2
     * [3,1,0,9,7] [5,6,8,4,2]
     * [0,2,1,4,3,5,7,6,9,8]
     *        || step =1
     * [0,2,1,4,3,5,7,6,9,8]
     * [0,1,2,3,4,5,6,7,8,9]
     * </pre>
     */
    public static void sort(int[] array) {
        int len = array.length;
        int step = len / 2;
        while (step > 0) {
            for (int i = step; i < len; i++) {
                int j = i - step;
                int value = array[i];
                for (; j >= 0; j = j - step) {
                    if (array[j] > value) {
                        array[j + step] = array[j];
                    } else {
                        break;
                    }
                }
                array[j + step] = value;
            }
            step = step / 2;
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{2, 5, 1, 8, 3, 5, 3};
        sort(array1);
        CommonUtil.print(array1);
    }
}

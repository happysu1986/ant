package com.ant.algo.sort;

/**
 * Created by xile.su on 2019/12/26
 */
public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{2, 5, 1, 8, 3, 5, 3};
        sort(array1);
        CommonUtil.print(array1);
    }
}

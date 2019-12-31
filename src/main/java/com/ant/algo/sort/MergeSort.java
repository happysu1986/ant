package com.ant.algo.sort;

/**
 * Created by xile.su on 2019/12/31
 */
public class MergeSort {

    /**
     * 归并排序
     */
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int min = (left + right) / 2;
        sort(array, left, min);
        sort(array, min + 1, right);
        merge(array, left, right, min);
    }

    public static void merge(int[] array, int left, int right, int min) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = min + 1;
        int index = 0;
        for (; i <= min && j <= right; ) {
            if (array[i] <= array[j]) {
                tmp[index++] = array[i];
                i++;
            } else {
                tmp[index++] = array[j];
                j++;
            }
        }
        for (; i <= min; i++) {
            tmp[index++] = array[i];
        }
        for (; j <= right; j++) {
            tmp[index++] = array[j];
        }
        for (index = 0; index < tmp.length; index++) {
            array[left + index] = tmp[index];
        }
    }


    public static void main(String[] args) {
        int[] array1 = new int[]{2, 5, 1, 8, 3, 5, 3};
        sort(array1);
        CommonUtil.print(array1);

        int[] array2 = new int[]{1, 2, 3, 4};
        sort(array2);
        CommonUtil.print(array2);
    }

}

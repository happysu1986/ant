package com.ant.algo.search;

/**
 * Created by xile.su on 2020/1/7
 */
public class Binary {

    public static int bsearch(int[] array, int element) {
        return bsearch(array, 0, array.length - 1, element);
    }

    public static int bsearch(int[] array, int left, int right, int element) {
        while (left <= right) {
            // 如果 left 和 right 比较大的话，两者之和就有可能会溢出
            // int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;
            if (array[mid] == element) {
                return mid;
            } else if (array[mid] > element) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素
     */
    public static int findFirstEquals(int[] array, int value) {
        int index = bsearch(array, value);
        if (index == -1) {
            return index;
        }
        while (index > 0 && array[index - 1] == array[index]) {
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
//        int[] array = new int[]{1, 4, 5, 7, 8, 10, 16, 20, 57, 99};
//        System.out.println(bsearch(array, 10));
//        System.out.println(bsearch(array, 1));
//        System.out.println(bsearch(array, 99));
//        System.out.println(bsearch(array, 9));
//        System.out.println(bsearch(array, 0));
//        System.out.println(bsearch(array, 100));
        int[] array2 = new int[]{1, 1, 1, 2, 3, 6, 8};
        System.out.println(findFirstEquals(array2, 1));
        System.out.println(findFirstEquals(array2, 3));
        System.out.println(findFirstEquals(array2, 8));
        System.out.println(findFirstEquals(array2, 7));
    }
}

package com.ant.algo.sort;

/**
 * Created by xile.su on 2019/12/31
 */
public class QuickSort {

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        int index = partition(array, p, r);
        sort(array, p, index - 1);
        sort(array, index + 1, r);
    }

    /**
     * 这里的处理有点类似选择排序。
     * pivot = A[r]
     * 我们通过游标 i 把 A[l…r-1] 分成两部分。
     * A[l…i-1] 的元素都是小于 pivot 的，我们暂且叫它“已处理区间”，
     * A[i…r-1] 是“未处理区间”。
     * 我们每次都从未处理的区间 A[i…r-1] 中取一个元素 A[j]，与 pivot 对比，
     * 如果小于 pivot，则将其加入到已处理区间的尾部，也就是 A[i] 的位置。
     */
    public static int partition(int[] array, int l, int r) {
        int i = l;
        int element = array[r];
        for (int j = l; j < r; j++) {
            if (array[j] < element) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = array[i];
                    array[i++] = array[j];
                    array[j] = tmp;
                }
            }
        }
        int tmp = array[i];
        array[i] = array[r];
        array[r] = tmp;
        return i;
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

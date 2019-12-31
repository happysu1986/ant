package com.ant.algo.sort;

/**
 * Created by xile.su on 2019/12/31
 */
public class FindMaxK {

    /**
     * O(n) 时间复杂度内求无序数组中的第 K 大元素。比如，4， 2， 5， 12， 3 这样一组数据，第 3 大元素就是 4
     *
     * 第一次分区查找，我们需要对大小为 n 的数组执行分区操作，需要遍历 n 个元素。
     * 第二次分区查找，我们只需要对大小为 n/2 的数组执行分区操作，需要遍历 n/2 个元素。
     * 依次类推，分区遍历元素的个数分别为、n/2、n/4、n/8、n/16.……直到区间缩小为 1。
     * 如果我们把每次分区遍历的元素个数加起来，就是：n+n/2+n/4+n/8+…+1。
     * 这是一个等比数列求和，最后的和等于 2n-1。
     * 所以，上述解决思路的时间复杂度就为 O(n)。
     */
    public static int getMaxK(int[] array, int k) {
        if (array.length < k) {
            throw new RuntimeException();
        }
        return getMaxK(array, 0, array.length - 1, k);
    }

    public static int getMaxK(int[] array, int left, int right, int k) {
        int index = partition(array, left, right);
        if (index + 1 == k) {
            return array[index];
        } else if (index + 1 < k) {
            return getMaxK(array, index + 1, right, k);
        } else {
            return getMaxK(array, left, index - 1, k);
        }
    }

    /**
     * 这里的处理有点类似选择排序。
     * 我们通过游标 i 把 A[left…right-1] 分成两部分。
     * A[left…i-1] 的元素都是小于 element 的，我们暂且叫它“已处理区间”，
     * A[i…right-1] 是“未处理区间”。
     * 我们每次都从未处理的区间 A[i…right-1] 中取一个元素 A[j]，与 element 对比，
     * 如果小于 element，则将其加入到已处理区间的尾部，也就是 A[i] 的位置。
     */
    public static int partition(int[] array, int left, int right) {
        int element = array[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (array[j] > element) {
                if (i == j) {
                    i++;
                } else {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i++] = temp;
                }
            }
        }
        int tmp = array[i];
        array[i] = array[right];
        array[right] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{4, 2, 5, 12, 3};
        System.out.println(getMaxK(array1, 3));

        int[] array2 = new int[]{2, 5, 1, 8, 3, 5, 3};
        System.out.println(getMaxK(array2, 1));
    }

}

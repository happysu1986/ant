package com.ant.algo.sort;

import java.util.Random;

/**
 * Created by xile.su on 2020/2/1
 */
public class HeapSort {
    /**
     * 第一种是在堆中插入一个元素的思路。
     * 尽管数组中包含 n 个数据，但是我们可以假设，起初堆中只包含一个数据，就是下标为 1 的数据。
     * 然后，我们调用前面讲的插入操作，将下标从 2 到 n 的数据依次插入到堆中。
     * 这样我们就将包含 n 个数据的数组，组织成了堆。
     * <p>
     * 堆元素是从数组下标0开始
     * 下标 i 的左子节点是 2(i+1)-1
     * 下标 i 的右子节点是 2(i+1)
     * 下标 i 的父节点是 (i-1)/2
     * </p>
     */
    public static void buildHeap1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            heapify1(array, i);
        }
    }

    private static void heapify1(int[] array, int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            int parent = array[parentIndex];
            int cur = array[index];
            if (parent >= cur) {
                break;
            }
            swap(array, parentIndex, index);
            index = parentIndex;
        }
    }

    /**
     * 从第一个非叶子节点开始从上往下堆化
     * <p>
     * 下标从 1 开始时第一个叶子节点是 n/2 + 1
     * 下标从 0 开始时第一个叶子节点是 n/2
     *
     * 其中 n 是 节点数量
     * 下标从 0 开始时 n = 数组长度
     * 下标从 1 开始时 n = 数组长度 - 1
     * </p>
     * * <p>
     * 堆元素是从数组下标0开始
     * 下标 i 的左子节点是 2(i+1)-1
     * 下标 i 的右子节点是 2(i+1)
     * 下标 i 的父节点是 (i-1)/2
     * </p>
     */
    public static void buildHeap2(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify2(array, i, array.length - 1);
        }
    }

    private static void heapify2(int[] array, int index, int lastIndex) {
        while (true) {
            int maxIndex = index;
            int leftIndex = 2 * (index + 1) - 1;
            int rightIndex = 2 * (index + 1);
            if (leftIndex <= lastIndex && array[leftIndex] > array[index]) {
                maxIndex = leftIndex;
            }
            if (rightIndex <= lastIndex && array[rightIndex] > array[maxIndex]) {
                maxIndex = rightIndex;
            }
            if (maxIndex == index) {
                break;
            }
            swap(array, index, maxIndex);
            index = maxIndex;
        }
    }

    private static void swap(int[] array, int i, int k) {
        int tmp = array[i];
        array[i] = array[k];
        array[k] = tmp;
    }

    public static void print(int[] array) {

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int e : array) {
            sb.append(e).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void sort(int[] array) {
        buildHeap2(array);
        int i = array.length - 1;
        while (i > 0) {
            swap(array, 0, i);
            heapify2(array, 0, --i);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 19, 8, 4, 1, 20, 13, 16};
//        buildHeap1(array);
//        buildHeap2(array);
        sort(array);
        print(array);

        int[] array2 = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array2[i] = random.nextInt(100);
        }

        print(array2);
        sort(array2);
        print(array2);

    }
}

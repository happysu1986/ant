package com.ant.algo.sort;

/**
 * Created by xile.su on 2020/1/2
 */
public class CountingSort {

    public static void sort(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // 注意：必须是 max + 1
        int count[] = new int[max + 1];

        // 计数：count[k] 表示数字 k 出现的次数
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        // 累加：count[k] 表示小于等于 k 的数字有多少
        // 注意：一定要是 count.length，不能是 array.length
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] tmp = new int[array.length];

        // 从 array[array.length - 1] 开始而不是 array[0] ?
        // 为了稳定排序！
        for (int i = array.length - 1; i >= 0; i--) {
            int index = count[array[i]] - 1;
            tmp[index] = array[i];
            count[array[i]]--;
        }

        for (int i = 0; i < tmp.length; i++) {
            array[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{2, 5, 1, 8, 3, 5, 3};
        sort(array1);
        CommonUtil.print(array1);

//        int[] array2 = new int[]{1, 2, 3, 4, 5};
//        sort(array2);
//        CommonUtil.print(array2);
    }
}

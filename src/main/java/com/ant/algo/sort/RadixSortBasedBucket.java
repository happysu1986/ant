package com.ant.algo.sort;

/**
 * Created by xile.su on 2020/1/2
 */
public class RadixSortBasedBucket {

    /**
     * 排序10w个电话号码:从低位到高位按位排序，排序使用稳定排序算法
     */
    public static void sort(String[] phones) {
        for (int i = 10; i >= 0; i--) {
            bucketSort(phones, i);
        }
    }

    public static void bucketSort(String[] phones, int charAt) {
        int bucketCount = 10;
        int bucketSize = phones.length / 10 + 1;
        String[][] bucket = new String[bucketCount][bucketSize];

        // 每个桶存储的元素个数
        int[] indexArray = new int[bucketCount];
        for (int i = 0; i < phones.length; i++) {
            int index = phones[i].charAt(charAt) - '0';
            if (indexArray[index] == bucket[index].length) {
                extend(bucket, index);
            }
            bucket[index][indexArray[index]++] = phones[i];
        }

        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < indexArray[i]; j++) {
                phones[k++] = bucket[i][j];
            }
        }
    }

    // 桶扩容
    private static void extend(String[][] bucket, int index) {
        String[] tmp = new String[bucket[index].length * 2];
        for (int i = 0; i < bucket[index].length; i++) {
            tmp[i] = bucket[index][i];
        }
        bucket[index] = tmp;
    }

    public static void main(String[] args) {
        String[] phones = new String[]{"15712863055", "13512863055", "15812863055", "15712863050", "13512863059", "15812863051", "15712863065", "13512853055", "15912863055"};
        sort(phones);
        CommonUtil.print(phones);
    }
}

package com.ant.algo.search;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by xile.su on 2020/1/7
 */
public class SquareRoot {

    public static double square(int num) {
        double precision = 0.000001;
        double low = 0;
        double high = num;
        while (true) {
            double mid = low + (double) (high - low) / 2;

            if ((mid + precision) * (mid + precision) >= num &&
                    (mid - precision) * (mid - precision) <= num) {
                return BigDecimal.valueOf(mid).setScale(6, RoundingMode.HALF_UP).doubleValue();
            }
            if (mid * mid > num) {
                high = mid - precision;
            } else {
                low = mid + precision;
            }
        }
    }

    public static void getAndCheck(int num) {
        System.out.println(num);
        double value = square(num);
        System.out.println(value);
        System.out.println(value * value);
    }

    public static int mySqrt(int x) {
        long left = 0;
        long right = x;
        long middle = 0;
        while (true) {
            middle = left + (right - left) / 2;
            long value = middle * middle;
            if (value <= x && (middle + 1) * (middle + 1) > x) {
                return (int)middle;
            }

            if (value < x) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
//        return (int)middle;
    }

    public static int mySqrt2(int x) {
        long tmp = x;
        while( tmp * tmp > x){
            tmp = (tmp + x / tmp) / 2;
        }
        return (int)tmp;
    }

    // 牛顿法求平方根
    public int mySqrt3(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }


    public static void main(String[] args) {
        getAndCheck(1);
        System.out.println(mySqrt(2147395599));
    }
}

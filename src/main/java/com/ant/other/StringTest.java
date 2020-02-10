package com.ant.other;

/**
 * Created by xile.su on 2020/2/8
 */
public class StringTest {
//    public static void main(String[] args) {
//        String a = "abc";
//        String b = "abc";
//        // true
//        System.out.println("a==b: " + (a == b));
//
//        String c = new String("abc");
//        String d = new String("abc");
//        // false
//        System.out.println("c==d: " + (c == d));
//        //false
//        System.out.println("a==c: " + (a == c));
//
//        String e = "a" + "bc";
//        String f = "ab" + "c";
//        // true
//        System.out.println("e==f: " + (e == f));
//        // true
//        System.out.println("a==e: " + (a == e));
//
//        String g = "a" + new String("bc");
//        // false
//        System.out.println("a==g: " + (a == g));
//
//        String i = new String("a") + new String("bc");
//        // false
//        System.out.println("a==i: " + (a == i));
//    }

//    public static void main(String[] args) {
//        // 以字面量的形式创建String变量时，jvm会在编译期间就把该字面量（“hello”）放到字符串常量池中，
//        // 由Java程序启动的时候就已经加载到内存中了。这个字符串常量池的特点就是有且只有一份相同的字面量，
//        // 如果有其它相同的字面量，jvm则返回这个字面量的引用，
//        // 如果没有相同的字面量，则在字符串常量池创建这个字面量并返回它的引用
//        String s1 = "hello";
//        String s2 = "hello";
//
//        // 于s2指向的字面量“hello”在常量池中已经存在了（s1先于s2），于是jvm就返回这个字面量绑定的引用，所以s1==s2
//        System.out.println(s1 == s2); //true
//
//        // s3中字面量的拼接其实就是“hello”，jvm在编译期间就已经对它进行优化，所以s1和s3也是相等的
//        String s3 = "he" + "llo";
//        System.out.println(s1 == s3);//true
//
//        // s4中的new String("lo")生成了两个对象:
//        // 1. "lo" 存在字符串常量池
//        // 2. "new String("lo")" 存在堆
//        // String s4 = "hel" + new String("lo") 实质上是两个对象的相加，编译器不会进行优化，
//        // 相加的结果存在堆中，而s1存在字符串常量池中，当然不相等。
//        String s4 = "hel" + new String("lo");
//        System.out.println(s1 == s4);//false
//
//        // s4 和 s5 是不同的对象
//        String s5 = new String("hello");
//        System.out.println(s4 == s5);//false
//
//        // s5.intern()方法能使一个位于堆中的字符串在运行期间动态地加入到字符串常量池中（字符串常量池的内容是程序启动的时候就已经加载好了），
//        // 如果字符串常量池中有该对象对应的字面量，则返回该字面量在字符串常量池中的引用，
//        // 否则，创建复制一份该字面量到字符串常量池并返回它的引用。因此s1==s6输出true。
//        String s6 = s5.intern();
//        System.out.println(s1 == s6);//true
//
//        // s9 是两个对象相加，在堆中
//        String s7 = "h";
//        String s8 = "ello";
//        String s9 = s7 + s8;
//        System.out.println(s1 == s9);//false
//    }


//    public static void main(String[] args) {
//        String s1 = new String("hello");
//        String intern1 = s1.intern();
//        String s2 = "hello";
//        System.out.println(s1 == s2);
//
//        String s3 = new String("hello") + new String("hello");
//        String intern3 = s3.intern();
//        String s4 = "hellohello";
//        System.out.println(s3 == s4);
//    }

//    public static void main(String[] args) {
//        String s1 = new String("hello");
//        String intern1 = s1.intern();
//        String s2 = "hello";
//        System.out.println(s1 == s2);
//        // s3 在堆中
//        String s3 = new String("hello") + new String("hello");
//        // 字符串 hellohello 加入到常量池
//        // jdk1.6 是复制一份到常量池
//        // 在jdk 1.6以上字符串常量池中存储一份s3的引用，这个引用指向堆中的字面量
//        // 当运行到String s4 = "hellohello"时，发现字符串常量池已经存在一个指向堆中该字面量的引用，则返回这个引用，
//        // 而这个引用就是s3。所以s3==s4输出true
//        String intern3 = s3.intern();
//        String s4 = "hellohello";
//        System.out.println(s3 == s4);
//    }

    //    public static void main(String[] args) {
//        String s1 = new String("hello");
//        String s2 = "hello";
//        String intern1 = s1.intern();
//        System.out.println(s1 == s2);
//        String s3 = new String("hello") + new String("hello");
//        String s4 = "hellohello";
//        String intern3 = s3.intern();
//        System.out.println(s3 == s4);
//    }
    // jdk 1.6 结果：false，true，
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s1 == s2);

        String s3 = s2.intern();
        // true
        System.out.println(s1 == s3);
        // false
        System.out.println(s2 == s3);

        // hellohello
        String s4 = new String("hello" + "hello");
        // false: "hello" + "hello" jvm编译阶段优化为 "hellohello" 存常量池
        // s4 是堆中的对象
        // s4.intern() 把字符串 "hellohello" 加入到常量池，但是已经有这个字符串了，所以返回它的引用
        // 所以 s4 是堆中对象，s4.intern() 是常量池中对象，不相等
        System.out.println(s4 == s4.intern());

        // hellohellohello
        String s5 = new String("hello") + new String("hello") + new String("hello");
        // true
        System.out.println(s5 == s5.intern());
    }
}

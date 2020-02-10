package com.ant.other;

/**
 * Created by xile.su on 2020/2/3
 */
public class TryWithResourcesTest {

    public static class MyClass1 implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("closed!");
        }

        public void test() {
            System.out.println("test is run");
        }
    }

    public static void test1(){
        try (MyClass1 myClass = new MyClass1()) {
            myClass.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test2() throws Exception {
        try (MyClass1 myClass = new MyClass1()) {
            myClass.test();
        }
    }

    public static void main(String[] args) {
        test1();

        try {
            test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.javarush.task.task24.task2402;

/* 
Cloneable
*/
public class Solution {

    public static void main(String[] args) throws CloneNotSupportedException {
        Test1 test1 = new Test1();
        test1.clone();

        Test2 test2 = new Test2();
        test2.clone(new Test2());

        Test3 test3 = new Test3();
        test3.c1one();

        Test4 test4 = new Test4();
        test4.clone();
    }


    public static class Test1 implements Cloneable{
        protected Test1 clone() throws CloneNotSupportedException {
//            System.out.println("cloning test1");
            return (Test1)super.clone();
        }
    }

    public static class Test2 extends Test1 {
        public Test2 clone(Test2 test2) throws CloneNotSupportedException {
//            System.out.println("cloning test2");
            return (Test2)test2.clone();
        }
    }

    public static class Test3 {
        protected Object c1one() throws CloneNotSupportedException {
//            System.out.println("cloning test3");
            return new Test3();
        }
    }

    public static class Test4 extends Test3 implements Cloneable{
        protected Object c1one() throws CloneNotSupportedException {
//            System.out.println("cloning test4");
            return super.c1one();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
//            System.out.println("cloning test4 @override");
            return super.clone();
        }
    }
}

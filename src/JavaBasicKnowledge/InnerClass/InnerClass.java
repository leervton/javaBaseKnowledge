package JavaBasicKnowledge.InnerClass;

import java.util.HashSet;
import java.util.Set;

public class InnerClass {
    //声明一个静态内部类
    private static class MyClass{

        public static void m1(){
            System.out.println("静态内部类m1方法执行");
        }

        public void m2(){
            System.out.println("静态内部类中的实例方法m2执行");
        }
    }

    public static void main(String[] args) {
        //类名叫做InnerClass.MyClass
        InnerClass.MyClass.m1();
        //创建静态内部类对象
        InnerClass.MyClass mi = new InnerClass.MyClass();
        mi.m2();

        //给定一个Set集合
        //还集合中存储的对象是：InnerClass.MyClass类型
        Set<InnerClass.MyClass> set = new HashSet<>();
        //这个集合存储的对象是String类型
        Set<String> set1 =new HashSet<>();

        Set<MyMap.MyEntry<Integer,String>> set2 = new HashSet<>();
    }
}
class MyMap{
    public static class MyEntry<k,v>{

    }
}
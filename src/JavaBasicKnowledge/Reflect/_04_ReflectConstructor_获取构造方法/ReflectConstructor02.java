package JavaBasicKnowledge.Reflect._04_ReflectConstructor_获取构造方法;

import java.lang.reflect.Constructor;

/**
 * 通过反射机制调用构造方法实例化对象
 */
public class ReflectConstructor02 {
    public static void main(String[] args) throws Exception {
        //不使用反射机制怎么创建对象
        Vip v1 = new Vip();
        Vip v2 = new Vip(10,"liSi","2011-11-1",true);

        //使用反射机制怎么创建对象
        Class c = Class.forName("JavaBasicKnowledge.Reflect._04_ReflectConstructor_获取构造方法.Vip");
        //调用无参数构造方法
        Object obj = c.newInstance();//JDK8仍然是主流，所以这个虽然不能用但仍然是主流
        System.out.println(obj);

        //调用有参数的构造方法怎么办？
        //第一：先获取到这个有参数的构造方法
        Constructor constructor= c.getDeclaredConstructor(int.class,String.class,String.class,boolean.class);
        //第二：调用构造方法new对象
        Object o = constructor.newInstance(10,"jackson","1990.10.01",true);
        System.out.println(o);

        //调用无参数构造方法
        Constructor constructor1 = c.getDeclaredConstructor();
        Object o1 = constructor1.newInstance();
        System.out.println(o1);
    }
}

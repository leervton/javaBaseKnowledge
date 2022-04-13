package JavaBasicKnowledge.Reflect._05_ReflectMethod_获取方法.getDeclaredMethods和getMethods.controller;

import JavaBasicKnowledge.Reflect._05_ReflectMethod_获取方法.getDeclaredMethods和getMethods.bean.User;

/*
* 两个方法都会返回 Method 对象的一个数组，区别在于
        1、getDeclaredMethods()可以拿到反射类中的公共方法、私有方法、保护方法、默认访问，但不获得继承的方法。
        2、getMethods()可以拿到反射类及其父类中的所有公共方法。
* */
import java.lang.reflect.Method;

public class MainInvoke {
    public static void main(String[] args) {

        User user = new User();

        Class clazz = user.getClass();
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓getDeclaredMethods()↓↓↓↓↓↓↓↓↓↓↓");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }
        System.out.println("--------------------------------------------");
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓getMethods()↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    /*//使用newInstance创建Class的示例，默认会使用无参构造器，并且无参构造器不能私有
    User newInstance2 = clazz.newInstance();
		newInstance2.test();

    //使用指定构造器创建Class示例
    Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
    Object[] obj = new Object[]{"张大炮",28};
    User newInstance = (User)constructor.newInstance(obj);
		newInstance.test();*/

}

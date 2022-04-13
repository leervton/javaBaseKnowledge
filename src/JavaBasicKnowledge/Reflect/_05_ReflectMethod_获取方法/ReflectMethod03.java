package JavaBasicKnowledge.Reflect._05_ReflectMethod_获取方法;

import java.lang.reflect.Method;

/**
 * 重点：必须掌握，通过反射机制怎么调用一个对象的方法
 */
public class ReflectMethod03 {
    public static void main(String[] args) throws Exception {
        //不使用反射机制，怎么调用方法
        UserService userService = new UserService();
        boolean login = userService.userLogin("sho","321");
        System.out.println(login?"登录成功":"登陆失败");
        //调用方法要素分析
        /*
        要素分析：
            要素1：对象userService
            要素2：方法名userLogin
            要素3：实参列表
            要素4：返回值
         */

        //使用反射机制来调用一个对象的方法
        Class userServiceMethod = Class.forName("JavaBasicKnowledge.Reflect._05_ReflectMethod_获取方法.UserService");

        //创建一个对象
        Object o = userServiceMethod.newInstance();

        //获取方法
        Method usm = userServiceMethod.getDeclaredMethod("userLogin ", String.class, String.class);

        //调用方法
        //调用方法有几个要素？也需要四个要素
        //o.usm("admin","123");
        usm.invoke(o,"admin","123");
    }
}

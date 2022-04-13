package JavaBasicKnowledge.Reflect._05_ReflectMethod_获取方法;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射Method
 */
public class ReflectMethod01 {
    public static void main(String[] args) throws Exception {
        //获取类了
        Class userServiceMethod = Class.forName("JavaBasicKnowledge.Reflect._05_ReflectMethod_获取方法.UserService");
        //获取所有的method
        Method[] m = userServiceMethod.getDeclaredMethods();
        System.out.println(m.length);
        for (Method method:m){
            //获取方法名
            System.out.println(method.getName());
            //获取返回值类型
            System.out.println(method.getReturnType().getSimpleName());
            //获取修饰符列表
            System.out.println(Modifier.toString(method.getModifiers()));
            //获取参数列表
            Class[] parameterTypes = method.getParameterTypes();
            for (Class c: parameterTypes){
                System.out.println(c.getSimpleName());
            }
        }
    }
}



/*
    用户业务类
 */
class UserService{
    /**
     * 登陆方法
     * @param name     用户名
     * @param passWord 用户密码
     * @return true表示登录成功，false表示登录失败
     */
    public boolean userLogin(String name,String passWord){
        if ("admin".equals(name)&&"123".equals(passWord)){
            return true;
        }
        return false;
    }
    //可能还有一个同名userLogin方法
    //java中怎么区分一个方法，依靠方法名和形参

    /**
     * 系统退出方法
      */
    public void loginOut(){
        System.out.println("系统已经安全退出");
    }
}
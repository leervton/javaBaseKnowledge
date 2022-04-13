package JavaBasicKnowledge.Reflect._05_ReflectMethod_获取方法;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反编译方法
 */
public class ReflectMethod02 {
    public static void main(String[] args) throws Exception {
        StringBuilder s = new StringBuilder();
        Class userServiceMethod = Class.forName("JavaBasicKnowledge.Reflect._05_ReflectMethod_获取方法.UserService");
        s.append(Modifier.toString(userServiceMethod.getModifiers())+" class "+userServiceMethod.getSimpleName()+"{\n");
        Method[] methods = userServiceMethod.getDeclaredMethods();
        for (Method method:methods){
            s.append("\t");
            s.append(Modifier.toString(method.getModifiers()));
            s.append(" ");
            s.append(method.getReturnType().getSimpleName());
            s.append(" ");
            s.append(method.getName());
            s.append("(");
            //参数列表
            Class[] c = method.getParameterTypes();
            for (Class c1:c){
                s.append(c1.getSimpleName()+" ,");
            }
            //删除指定下标位置上的字符
            s.deleteCharAt(s.length()-1);
            //截取字符串
            //s.substring(0,s.length()-1);
            s.append("){}");
            s.append("\n");
        }
        s.append("\n}");
        System.out.println(s);
    }
}

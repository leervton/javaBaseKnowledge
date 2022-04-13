package JavaBasicKnowledge.Reflect._02_ReflectAdvance01;

import JavaBasicKnowledge.Reflect.entity.User;

import java.lang.reflect.Method;

/**
 * 已知条件:
 *          *类满足javabean规范(有无参数的构造器，属性私有化对外提供公开的setter和getter)
 *          *该类的完整类名User
 *          *该类中有一个属性字段Field，该字段的名字是:username
 *          *username的属性类型是java.lang.String类型
 *要求:通过反射机制给User类型对象的username属性赋值jack
 * */
public class _06_通过反射机制给属性赋值 {
    public static void main(String[] args) throws Exception{
        //已知条件
        String className = "JavaBasicKnowledge.Reflect.ReflectAdvance03.entity.User";
        String fieldName = "username";
        Class fieldType = String.class;

        //得出方法名
        String methodName = "set"+fieldName.toUpperCase().charAt(0)+fieldName.substring(1);
        System.out.println(methodName);

        //获取整个类的字节码，进行类加载
        Class c = Class.forName(className);

        //利用字节码文件，构造对象
        //User user = (User) c.newInstance();
        Object obj = c.newInstance();
        //获取方法的字节码
        Method method = c.getDeclaredMethod(methodName,fieldType);

        //调用方法
        method.invoke(obj,"jack");

        //调用username属性的值
        System.out.println(((User)obj).getUsername());


    }
}

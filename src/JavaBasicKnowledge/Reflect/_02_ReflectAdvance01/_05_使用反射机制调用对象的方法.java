package JavaBasicKnowledge.Reflect._02_ReflectAdvance01;

import JavaBasicKnowledge.Reflect.entity._05_SystemService;

import java.lang.reflect.Method;

public class _05_使用反射机制调用对象的方法 {
    public static void main(String[] args) throws Exception {
        //获取整个类的字节码,加载类并没有创建对象
        Class c = Class.forName("JavaBasicKnowledge.Reflect.entity._05_SystemService");


        //获取方法:getDeclaredMethod(方法名,方法参数类型);参数有几个写几个类型
        //获取方法名为login，形参为String和String的类型的方法
        Method method = c.getDeclaredMethod("login", String.class, String.class);
        //获取方法名为login，没有形参的方法
        Method method01 = c.getDeclaredMethod("login");
        //获取方法名为login，形参为int和double的类型的方法
        Method method02 = c.getDeclaredMethod("login", int.class, double.class);
        //获取方法名为login，形参依次为char,String和int的类型的方法
        Method method03 = c.getDeclaredMethod("login", char.class, String.class,int.class);
        //获取方法名为login，形参依次为int,char和String的类型的方法
        Method method04 = c.getDeclaredMethod("login", int.class,char.class, String.class);

        //通过反射机制调用方法（invoke---调用）
        _05_SystemService sy = new _05_SystemService();
        //调用对象sy存储在method中的login方法，并传参数
        //此处不使用c的原因是类加载，并没有被创建出来
        Object retValue = method.invoke(sy,"admin","123");
        System.out.println(retValue);

    }
}

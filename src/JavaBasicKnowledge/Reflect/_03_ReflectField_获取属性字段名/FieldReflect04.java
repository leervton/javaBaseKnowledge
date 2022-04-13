package JavaBasicKnowledge.Reflect._03_ReflectField_获取属性字段名;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;

/**
 * 使用web技术完成属性赋值
 * */
public class FieldReflect04 {
    public static void makeRequestToObj(HttpServletRequest request,Object obj) throws Exception {
        //获取整个字节码文件
        Class c = obj.getClass();

        //获取表单中所有input标签name属性的值（等同于获取了该类所有的属性名）
        Enumeration<String> fieldNames = request.getParameterNames();

        while (fieldNames.hasMoreElements()){
            //获取属性名
            String fieldName = fieldNames.nextElement();


            //获取方法名
            String methodName = "set"+fieldName.toUpperCase().charAt(0)+fieldName.substring(1);

            //获取要调用的方法
            Method method1 = c.getDeclaredMethod(methodName,String.class);

            //调用方法
            method1.invoke(obj,request.getParameter(fieldName));
        }
    }
}

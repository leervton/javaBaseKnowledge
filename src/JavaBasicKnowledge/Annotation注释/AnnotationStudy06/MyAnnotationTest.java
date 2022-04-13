package JavaBasicKnowledge.Annotation注释.AnnotationStudy06;

import java.lang.reflect.Method;

public class MyAnnotationTest {
    @MyAnnotation(userName = "admin",passWord = "123")
    public void doSome(){

    }

    public static void main(String[] args) throws Exception {
        //获取MyAnnotationTest的doSome()方法上面的注解信息
        Class c =Class.forName("JavaBasicKnowledge.Annotation注释.Annotation06.MyAnnotationTest");
        //获取doSome()方法
        Method method = c.getDeclaredMethod("daSome");
        //判断该方法上是否存在这个注解
        if (method.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation method01=method.getAnnotation(MyAnnotation.class);
            System.out.println(method01.userName());
            System.out.println(method01.passWord());
        }
    }
}

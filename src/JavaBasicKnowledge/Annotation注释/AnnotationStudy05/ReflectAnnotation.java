package JavaBasicKnowledge.Annotation注释.AnnotationStudy05;

public class ReflectAnnotation {
    public static void main(String[] args) throws Exception {
        //类加载器加载该类，从而获取
        Class c = Class.forName("JavaBasicKnowledge.Annotation注释.AnnotationStudy05.MyAnnotationTest");
        //判断类上面有@MyAnnotation
        System.out.println(c.isAnnotationPresent(MyAnnotation.class));//true
        //获取该注解
        if (c.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation my= (MyAnnotation)c.getAnnotation(MyAnnotation.class);
            System.out.println("类上面的注解对象"+my);
            //获取注解对象的属性怎么办？和调接口没啥区别
            int value = my.value();
            System.out.println(value);
        }


        //判断String类上面是否存在这个注解
        Class c1 = Class.forName("JavaBasicKnowledge.Annotation注释.AnnotationStudy05.MyAnnotationTest");
        System.out.println(c1.isAnnotationPresent(MyAnnotation.class));
    }
}

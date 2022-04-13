package JavaBasicKnowledge.Annotation注释.AnnotationStudy01;

public class MyAnnotationStudy01 {
    //@MyAnnotation
    //报错原因：如果一个注解当中有属性，那么必须给属性赋值（除非该属性使用了default指定了默认值）
    //public void doSome(){}

    //@MyAnnotation(属性名=属性值)
    //这里只需要指定name属性的值就好了
    @MyAnnotation(name = "张三",color = "红色")
    public void doSome(){

    }
}

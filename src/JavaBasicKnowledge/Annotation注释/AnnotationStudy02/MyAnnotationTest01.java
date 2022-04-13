package JavaBasicKnowledge.Annotation注释.AnnotationStudy02;

public class MyAnnotationTest01 {
    /*
    报错原因：是没有给属性指定值
    @MyAnnotation
    public void doSome(){
    }*/


    @MyAnnotation(value = "heHe")
    public void doSome(){}

    @MyAnnotation("哈哈")
    public void doOther(){}
}

package JavaBasicKnowledge.Annotation注释.AnnotationStudy04;

import JavaBasicKnowledge.Annotation注释.AnnotationStudy03.Season;

public class MyAnnotationTest01 {
    //数组是大括号
    @MyAnnotation(age=25,email={"123","456"},seasonArray = Season.AUTUMN)
    public void doSome(){

    }

    //如果数组只有一个元素，大括号是可以省略的
    @MyAnnotation(age=25,email="123",seasonArray = {Season.AUTUMN,Season.SPRING})
    public void doOther(){

    }
}

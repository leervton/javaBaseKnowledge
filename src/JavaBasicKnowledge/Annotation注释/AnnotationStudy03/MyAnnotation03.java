package JavaBasicKnowledge.Annotation注释.AnnotationStudy03;

/**
 * 注解当中的属性可以是哪一种类型？
 *      byte,short,int,long,float,double,boolean,char,String,Class类型
 *      及以上每一种数组类型
 */
public @interface MyAnnotation03 {
    int value();
    String value1();
    int[] value2();
    String[] value4();
    Season value5();
    Season[] value6();
    Class Value7();
    Class[] value8();
}

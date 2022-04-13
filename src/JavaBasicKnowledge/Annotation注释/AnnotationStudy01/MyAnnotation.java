package JavaBasicKnowledge.Annotation注释.AnnotationStudy01;

/**
 * 自定义注解：
 */
public @interface MyAnnotation {
    /**
     * 我们通常在注解当中可以定义属性，以下这个是MyAnnotation的name属性
     * 看着像一个方法，但是实际上我们称之为属性name
     * @return
     */
    String name();
    /**
     * 颜色属性
     */
    String color();
    /**
     * 年龄
     */
    int age() default 25;//这里加上修饰词default，指定默认值25，age这样可以不指定值了
}

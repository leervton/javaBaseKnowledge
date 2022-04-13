package JavaBasicKnowledge.Annotation注释.AnnotationStudy04;

import JavaBasicKnowledge.Annotation注释.AnnotationStudy03.Season;

public @interface MyAnnotation {
    /**
     * 年龄属性
     * @return
     */
    int age();

    /**
     * 邮箱地址属性，支持多个
     * @return
     */
    String[] email();

    /**
     * 季节数组，season是枚举类型
     */
    Season[] seasonArray();
}

package JavaBasicKnowledge.Annotation注释.AnnotationStudy;

/**
 * 1.注解：或者叫注释类型，英文单词是：Annotation
 * 2.注解Annotation是一种引用数据类型，编译之后也是生成xxx.class
 * 3.怎么自定义注解呢？语法格式？
 *      [修饰符列表] @interface 注解类型名{
 *
 *      }
 * 4.注解怎么使用？用在什么地方？
 * 第一：注解使用时的语法格式是：
 *      @注解类型名
 * 第二：注解可以出现在类上，属性上，方法上，变量上等。。。。。。
 *      注解还可以出现在注解类型上
 *
 * 5.JDK内置注解有哪些呢？
 *      Deprecated 用 @Deprecated 注释的程序元素，
 *                  不鼓励程序员使用这样的元素，通常是因为它很危险或存在更好的选择。
 *
 *      Override 表示一个方法声明打算重写超类中的另一个方法声明。
 *
 *      SuppressWarnings 指示应该在注释元素（以及包含在该注释元素中的所有程序元素）中取消显示指定的编译器警告。
 *6.元注解
 *      什么是元注解？
 *          用来标注"注解类型"的"注解"，称为元注解
 *
 *      常见的元注解有哪些？
 *          Target Retention
 *              关于Target注解：
 *                  这是一个元注解，用来标注"注解类型"的注解，这个Target注解可以标注"被标注的注解"可以出现在哪些位置上
 *                  @Target(ElementType.METHOD) ：表示"被注解的注解"只能出现在方法上（ElementType.METHOD）
 *                  @Target(value= {CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
 *                                              :表示该注解可以出现在构造方法上，字段上，局部变量上，方法上。。。。类上
 *
 *              关于Retention
 *                  这是一个元注解，用来标注"注解类型"的注解，这个Target注解可以标注"被标注的注解"最终保存到哪里
 *                  @Retention(RetentionPolicy.SOURCE)： 表示该注解只被保留在java源文件中
 *                  @Retention(RetentionPolicy.CLASS): 表示该注解只能被保存在class文件中
 *                  @Retention(RetentionPolicy.RUNTIME)： 表示该注解被保存在class文件中，并且可以被反射机制所读取
 *
 *
 */
@MyAnnotation
public class Annotation01 {
    @MyAnnotation
    private int no;

    @MyAnnotation
    public Annotation01(@MyAnnotation String name) {

    }

    public static void m1(){
        @MyAnnotation
        int i;
    }
    public void m2(){
    }
}
@MyAnnotation
interface MyInterface{

}
@MyAnnotation
enum Season{
    @MyAnnotation
    season,summer,autumn,winter
}
package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * 有些异常发生业务上就是希望程序不要再运行，这时候就不要try了
 *
 * 处理异常的第一种方式：在方法声明的位置上使用throws关键字抛出异常，谁调用我这个方法，我就抛给谁，抛给调用者处理
 *                   这种处理异常的态度：上报
 * 处理异常的第二种态度：
 *                  使用try.....catch语句异常进行捕捉
 *                  这个异常不会上报，自己会把这个异常进行处理
 *                  被处理的异常是真正的解决了，而不是推给上级
 *
 */
public class ExceptionSolution03 {
    //一般不建议在main方法上使用throws，因为这个异常如果真正的发生了，一定会抛给jvm，jvm只有终止
    //异常处理机制的作用是增强程序的健壮性，怎么能做到，异常发生了也不影响程序的执行，所以一般main方法中的异常建议使用try...catch
    //进行捕捉，main就不要继续上抛了

    /**
     * public static void main(String[] args) throws FileNotFoundException{
     *         System.out.println("main begin");
     *         m1();
     *         System.out.println("main over");
     * }
     *
     */
    public static void main(String[] args) {
        System.out.println("main begin");
        try {
            //尝试运行程序
            m1();
        } catch (FileNotFoundException e) {
            //catch是捕捉异常之后走的分支
            System.out.println("文件不存在");
        }
        System.out.println("main over");
    }
    public static void m1()throws FileNotFoundException{
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 over");
    }
    public static void m2() throws FileNotFoundException {
        System.out.println("m2 begin");
        //此处编译器报错原因：m3（）方法声明位置上有：throws FileNotFoundException
        //我们在m3这里调用m3()没有对异常进行预处理，所以编译报错
        //处理方法：要么继续上抛，要么捕捉
        /**
         * ----------------重点------------------
         * 抛其他无关类或者子类异常不行，但是抛其异常的父类却可以
         * 这是因为父类异常包括了子类异常
         */
        m3();
        System.out.println("m2 over");
    }
    public static void m3() throws FileNotFoundException {
        //调用SUN jdk某个类的构造方法
        //这个类还没有学过，后期学习IO流的时候就知道了
        //我们只是借助这个类学习一下异常处理机制
        //创建一个输入流对象，该流指向一个文件
        /**
         * 编译报错的原因是什么？
         *      第一：这里调用了一个构造方法FileInputStream（String name）
         *      第二：这个构造方法的声明位置上有：throws FileNotFoundException
         *      第三：通过类的继承结构可以看到FileNotFoundException父类是IOException，IOException的父类是Exception
         *      最终得知，FileNotFoundException是编译时异常
         *
         *      错误原因？编译时异常要求程序员编写程序阶段必须对它进行处理，不处理编译器报错
         *
         *      我们采用第一种处理方式：在方法声明的位置上使用throws继续上抛
         */
        new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");
    }
}

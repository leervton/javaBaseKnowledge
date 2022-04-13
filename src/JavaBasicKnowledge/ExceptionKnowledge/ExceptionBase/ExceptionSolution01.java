package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

public class ExceptionSolution01 {
    /**
     * 以下代码报错的原因是什么？
     *      因为doSome()方法声明位置上使用了：throws ClassNotFoundException
     *      而ClassNotFoundException是编译时异常，必须编写代码时处理，没有处理
     *      编译器报错
     */
    public static void main(String[] args) {
        /**
         * main方法中调用了doSome（）方法
         * 因为doSome（）方法声明位置上有：throws ClassNotFoundException
         * 我们在调用doSome（）方法的时候必须对这种异常进行预先处理
         * 如果不处理，编译器就报错
         */
        //Unhandled exception: java.lang.ClassNotFoundException
        //doSome();
    }

    /**
     * doSome方法在方法声明的位置上使用了：throws ClassNotFoundException
     * 这个代码表示doSome（）方法在执行过程中，有可能出现throws ClassNotFoundException异常
     * 这个异常叫做类没有找到异常，这个异常的直接父类是：Exception，所以throws ClassNotFoundException属于编译异常
     * @throws ClassNotFoundException
     */
    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome!!!!");
    }
}

package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

/**
 * 1.什么是异常？java提供异常处理机制有什么用？
 *    以下程序执行过程中发生了不正常的情况，而这种不正常的情况叫做：异常
 *    java语言是很完善的语言，提供了异常的处理方式，以下程序执行过程中出现了不正常的情况，
 *    java把该异常信息打印到控制台，供程序员参考，程序员看到异常信息之后，可以对程序进行修改，让程序更加健壮
 *    异常机制的出现给编程人员提示了可能出现的不合理的错误
 *
 * 2.以下程序执行，控制台出现了：
 *      Exception in thread "main" java.lang.ArithmeticException: / by zero
 *  	at Test.Exception01.ExceptionBase.ExceptionClass.main(ExceptionClass.java:16)
 *  这个信息被我们称之为：异常信息，这个信息是jvm打印的
 *
 *  3.什么是异常：程序执行过程中的不正常情况。
 *    异常的作用：增强程序的健壮性、
 *
 *  4.为什么会有异常？
 *    （1） 编译时异常可以认为是程序存在的潜在风险，例如程序要打开一个文件，但是文件不存在，
 *     或者试图创建一个socket，但是远程主机没有开机等等，这种情况不是代码写得有错误，写代码的时候不能确定异常情况会不会发生，
 *     但是知道存在这样一种风险。像eclipse这样的IDE能够根据上下文知道某些操作是否存在什么样的风险，会给出提示。
 *
 *    （2）运行时异常可以认为是程序写得有问题，比如说数组越界、除以0和空指针访问等等，IDE是不能检测出代码中的bug的。
 *     这种情况引起的异常称为运行时异常，简单来说就是代码中的bug。
 */

public class ExceptionBase {
    public static void main(String[] args) {

        int a =10;
        int b =0;
        int c = a/b;//程序执行到此处，会new出一个异常对象：Exception in thread "main" java.lang.ArithmeticException: / by zero
                    //并且jvm将new的异常对象抛出，打印输出信息到控制台了
        System.out.println(a +"/"+ b + "=" + c);


        //我观察到异常信息之后，对以上程序进行修改

        /*
        int a =10;
        int b =0;
        if(b==0){
            System.out.println("除数不能为0");
            return;
        }
        int c = a/b;
        System.out.println(a +"/"+ b + "=" + c);

         */
    }

}

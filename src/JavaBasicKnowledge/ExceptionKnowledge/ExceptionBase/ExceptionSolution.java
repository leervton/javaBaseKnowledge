package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

public class ExceptionSolution {
    /**
     *java语言中对异常的处理包括两种方式：
     *      第一种方式：在方法声明的位置上，使用throws关键字，抛给上一级
     *                谁调用我，我就抛给谁，抛给上一级
     *      第二种方式：使用try....catch语句进行异常的捕捉
     *                这件事谁也不知道，因为我提前测试出来了
     *
     *      举个例子：
     *              我是某集团的一个销售员，因为我的失误，导致公司损失1000元
     *              “损失1000元”这可以看作是一个异常发生了，我有两种处理方式
     *              第一种方式：我把这件事告诉我的领导【异常上抛】
     *              第二种方式：我为了不让领导知道，自己掏腰包把这个钱补上【异常的捕捉】
     *
     *            思考：异常发生之后，如果我选择上抛，抛给了我的调用者，调用者需要对这个异常
     *                  继续处理，那么调用者处理这个异常同样有两种方法，要么继续上抛，
     *                  要么try....catch寻找捕捉异常，自己处理
     *
     *            注意：java中异常发生之后，如果一直上抛，最终抛给了main方法，main方法继续向上抛，抛给了调用者jvm
     *                 jvm知道这个异常的发生，只有一个结果，终止jvm的执行
     *
     *             在以后的开发中，处理编译时异常，应该上报还是捕捉，怎么选？
     *             如果希望调用者处理，就用throws上报
     */
    public static void main(String[] args) {
        System.out.println(100/0);
        /**
         * 程序执行到System.out.println(100/0);时，发生了Exception in thread "main" java.lang.ArithmeticException: / by zero
         * 底层new出了一个ArithmeticException异常对象，然后抛出了，由于是main方法调用了100/0，所以这个异常ArithmeticException抛给了
         * main方法，main方法没有处理，将这个异常自动抛给了jvm，jvm最终终止了程序的执行
         *
         * ArithmeticException继承了RuntimeException，属于运行时异常，在编写程序阶段不需要对这种异常进行预先处理
         */

        System.out.println("此处代码执行吗？不执行");
    }
}

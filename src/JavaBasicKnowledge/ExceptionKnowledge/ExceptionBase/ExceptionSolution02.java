package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

public class ExceptionSolution02 {
    /**
     * 第一种处理异常方式：在方法声明的位置上继续使用throws，来完成异常的继续上抛，抛给调用者
     * 上抛类似于推卸责任，继续把异常传递给调用者
     */
    /*
    public static void main(String[] args) throws ClassNotFoundException{
        doSome();
    }
    */

    /**
     * 第二种处理方式：try.....catch进行捕捉
     * 捕捉等于把异常拦下来，异常真正的解决了（调用者是不知道的）
     * @param args
     */
    public static void main(String[] args) {
        try {
            doSome();
        } catch (ClassNotFoundException e) {
            System.out.println("1111");
        }
    }
    public static void doSome() throws ClassNotFoundException{
        System.out.println("doSome!!!!");
    }
}

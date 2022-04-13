package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

/**
 * 异常对象有两个非常重要的方法：
 *
 *      获取异常简单的描述信息：
 *          String msg = exception.getMessage();
 *
 *      打印异常追踪的栈堆信息
 *          exception.printStackTrace();
 */
public class ExceptionMessage {
    public static void main(String[] args) {
        //这里虽然new了一个异常对象，但是却没有throw出去，也不会当作异常对象，只是一个普通的java对象而已，因此不会中断jvm处理
        //除非 throw npe; 这时侯创建的空指针异常对象npe被抛出给这个主方法，此时才能真正的算作异常对象，是可以使jvm被终止的异常对象
        NullPointerException npe = new NullPointerException("空指针异常");
        //--------------------------------------------------------------------------------------------------------
        //获取异常的简单描述：这个msg其实获取的是构造方法里的string类型参数：空指针异常
        String msg = npe.getMessage();
        System.out.println(msg);
        //---------------------------------------------------------------------------------------------------------
        //打印异常堆栈追踪信息：打印异常堆栈追踪信息的时候采用了异步线程的方式打印的
        npe.printStackTrace();

        System.out.println("hello world");
    }
}

package JavaBasicKnowledge.ExceptionKnowledge.CreatException;

/**
 * Sun公司提供的内置的异常肯定是不够用的，
 * 在实际开发中，有很多业务，这些业务出现异常之后，jdk中都是没有的，和业务挂钩的，那么异常类我们程序员可以自己定义吗？
 * 可以
 *
 * java中如何自定义异常呢？
 *      两步：
 *          1.第一步：编写一个类继承Exception或者RuntimeException
 *          2.第二部：提供两个构造方法，一个无参数构造方法，一个有参数且形参类型为String类型的有参数构造方法
 */
public class DesignNewException {
    public static void main(String[] args) {
        //创建异常对象（只呢new了异常对象，却没有手动抛出）
        MyException me = new MyException("用户名不能为空");

        //打印异常堆栈信息
        me.getMessage();
    }
}

class MyException extends Exception{
    public MyException() {
    }

    public MyException(String message) {
        //这里不写的话，会默认调取父类无参构造方法，而调用父类无参构造的话，则无法获取异常简单的描述信息：
        super(message);
    }
}

class MyException01 extends Exception{
    public MyException01() {
    }

    public MyException01(String message) {
        super(message);
    }
}
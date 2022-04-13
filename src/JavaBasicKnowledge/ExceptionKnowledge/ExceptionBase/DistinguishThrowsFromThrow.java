package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

/**
 * 分辨throw和throws的区别
 *  1.throw：位于方法体内，意思是抛出（手动抛出），意思就是
 *  2.throws：位于类名声明位置，意思是上抛（自动上抛），上抛给谁呢？谁调用抛给谁
 */
public class DistinguishThrowsFromThrow{
    public static void main(String[] args) throws testException {
        //创建异常类实例对象
        testException e = new testException();
        //手动抛出异常,那问题来了，抛出去的异常到哪了？
        //其实这个手动抛出的异常只是声明该方法存在异常现象，没有往上级抛出，如果不解决编译报错
        //解决方法要么捕捉，要么继续throws上抛，该方法中就是继续throws上抛
        /**
         * 举个例子：车子正常行驶，但是自己检查发现可能存在熄火这一异常现象！所以这时候我们要把问题提出来，这就是throw
         *          问题摆出来后，即throw出来后，是自己解决（try/catch捕捉），还是抛给别人解决（throws上抛），只有这两种解决办法
         */
        throw e;//在这里，自己抛出一个异常，自己捕捉，自娱自乐没有意义，所以建议上抛
    }
}

//创建异常类
class testException extends Exception{
    public testException() {
    }

    public testException(String S) {
        super(S);
    }
}

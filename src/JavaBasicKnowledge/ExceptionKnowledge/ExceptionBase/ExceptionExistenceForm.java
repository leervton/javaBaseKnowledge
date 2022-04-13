package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

/**
 * java语言中异常是以什么形式存在的？
 *  1.异常在java语言中以类的形式存在，每一个异常类都可以创建异常对象
 *  2.异常对应的现实生活问题是什么？
 *          火灾（异常类）：
 *              2008.8.8 小明家着火了（异常对象）
 *              2008.6.3 小红家着火了（异常对象）
 *
 */
public class ExceptionExistenceForm {
    public static void main(String[] args) {
        //通过异常类实例化异常对象
        NumberFormatException nfe = new NumberFormatException("数字格式化异常");

        System.out.println(nfe);

        //通过异常类实例化异常对象
        NullPointerException npe = new NullPointerException("空指针异常");

        System.out.println(npe);
    }
}

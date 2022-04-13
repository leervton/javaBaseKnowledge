package JavaBasicKnowledge.Reflect._02_ReflectAdvance;

/**
 * 研究一下：Class.forName()发生了什么？
 *      这个方法的执行会导致类加载
 *      重点：如果你只是希望一个类的静态代码块执行，其他代码一律不执行
 *            你可以使用：
 *                  Class.forName()
 *            这个方法的执行会导致类加载，类加载时，静态代码块执行
 *
 * 提示：
 *      后面的JDBC技术的时候我们还需要
 */
public class ForNameStudy {
    public static void main(String[] args) {
        try {
            Class.forName("JavaBasicKnowledge.Reflect._02_ReflectAdvance.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class MyClass{
    //静态代码块在类加载的时候执行，并且只执行一次
    static{
        System.out.println("MyClass类的静态代码块执行了");
    }
}
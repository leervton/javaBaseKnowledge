package JavaBasicKnowledge.Extends;

/**
 * 前言：instanceof 判断该对象是不是某种数据类型
 * ------------------------------------------------------
 * | instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例 |
 * |        A instanceof B 这句的意思是判断A是否是B类型       |
 * |                实例 instanceof 对象类                 |
 * |                子类 instanceof  父类                  |
 * -------------------------------------------------------
 * java中，instanceof运算符的前一个操作符是一个引用变量，后一个操作数通常是一个类（可以是接口），
 * 用于判断前面的对象是否是后面的类，或者其子类、实现类的实例。如果是返回true，否则返回false。
 *
 * 也就是说：
 *
 * 使用instanceof关键字做判断时， instanceof 操作符的左右操作数必须有继承或实现关系
 *
 * 下面我们用继承树来判断instanceof的返回值
 */
interface Man{}
class Person1 implements Man{}
class Student extends Person1 {}
class Postgraduate extends Student {}
class Animal {}

public class Instanceof {
    public static void main(String[] args) {
        System.out.println("Student 的对象是谁的实例？");
        instanceofTest(new Student());
        System.out.println("Animal 的对象是谁的实例？");
        instanceofTest(new Animal());
        System.out.println("Postgraduate 的对象是谁的实例？");
        instanceofTest(new Postgraduate());
        //一个类的实例是这个类本身的实例，也是他父类，父类的父类的实例，也是实现的接口的实例
    }

    public static void instanceofTest(Object p) {
        if (p instanceof Animal)
            System.out.println(p.getClass() + "类的实例  是类Animal的实例");
        if (p instanceof Postgraduate)
            System.out.println(p.getClass() + "类的实例  是类Postgraduate的实例");
        if (p instanceof Student)
            System.out.println(p.getClass() + "类的实例  是类Student的实例");
        if (p instanceof Person1)
            System.out.println(p.getClass() + "类的实例  是类Person的实例");
        if (p instanceof Man)
            System.out.println(p.getClass() + "类的实例  是接口Man的实例");
        if (p instanceof Object)
            System.out.println(p.getClass() + "类的实例  是类Object的实例");

    }
}
/**
 *
 *
 *
 * 上述程序中：
 *
 * 由上面继承树可知，某个类（接口也可以看成一个特殊的类）的对象是不是其他类（或接口）的实例，只需按箭头方向，以
 *
 * 此对象所在的类为起点到达此继承树分支（可能有多个分支）终点，沿途经过的类（包括本类，或接口）就都是该对象的实例。
 *
 * 所以输出结果是：
 *              Student 的对象是谁的实例？
 * class t20170722FromInternet.Student类的实例  是类Student的实例
 * class t20170722FromInternet.Student类的实例  是类Person的实例
 * class t20170722FromInternet.Student类的实例  是接口Man的实例
 * class t20170722FromInternet.Student类的实例  是类Object的实例
 *                 Animal 的对象是谁的实例？
 * class t20170722FromInternet.Animal类的实例  是类Animal的实例
 * class t20170722FromInternet.Animal类的实例  是类Object的实例
 *              Postgraduate 的对象是谁的实例？
 * class t20170722FromInternet.Postgraduate类的实例  是类Postgraduate的实例
 * class t20170722FromInternet.Postgraduate类的实例  是类Student的实例
 * class t20170722FromInternet.Postgraduate类的实例  是类Person的实例
 * class t20170722FromInternet.Postgraduate类的实例  是接口Man的实例
 * class t20170722FromInternet.Postgraduate类的实例  是类Object的实例
 * -------------------------------------------------------------------------------------
 *
 *
 * 但是，要注意一点：
 *
 *       在判断某个类（接口也可以看成一个特殊的类）的对象是不是其他类（或接口）的实例，
 *       一定要首先进行向上转型，然后才可用instanceof关键字进行判断，这是基本操作规范。
 */
interface A{
    void say();
}
class B implements A{
    public void say()
    {
        System.out.println("B实现的say()方法");
    }
}
class C implements A{
    public void say()
    {
        System.out.println("C实现的say()方法");
    }
}

/**
 * 总结：
 * 如果一个类的实例是这个类本身的实例，那么它也是它的父类、它的父类的父类的实例，也是由它实现的接口的实例
 * 且instanceof左边操作元显式声明的类型与右边操作元必须是同种类或右边是左边父类的继承关系
 */
class TestDemo{
    public static void main(String[] args) {
        A a= new B();  //接口不能new
        System.out.println(a instanceof B);   //true;发生了A a= new B();
        System.out.println(a instanceof C);   //false;没有发生A a = new C();
    }
}
package JavaBasicKnowledge.StaticMethod;
/**
 * 参考类：package JavaBasicKnowledge.ListBase.Array.ArrayAndReferenceObject01；
 * 有意思的小知识：
 *      复写方法带有static时。按父类方法执行
 *      复写方法没有static时。按照数组元素引用查找子类，然后按子类方法执行
 *
 *      此处代码的问题在于：静态方法无法被重写
 *  *                  一个指向子类对象的父类引用变量来调用父子同名的静态方法时，只会调用父类的静态方法。
 *  *                  这是因为静态方法只能被继承，不能被重写，如果子类有和父类相同的静态方法，
 *  *                  那么父类的静态方法将会被隐藏，对于子类不可见，
 *  *                  也就是说，子类和父类中相同的静态方法是没有关系的方法，他们的行为不具有多态性。
 *  *                  但是父类的静态方法可以通过父类.方法名调用。
 */
public class StaticMethod {
}

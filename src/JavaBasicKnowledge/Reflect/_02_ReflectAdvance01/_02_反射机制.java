package JavaBasicKnowledge.Reflect._02_ReflectAdvance01;

/**
 * 反射(reflect)机制中涉及到的几个重点类型，反射机制重要的作用就是让程序变得更加灵活，
 * 因为在反射机制中可以拿到一个字节码文件的任何成员，所以reflect就是SUN提供的一套特殊的接口
 * ，这套接口可以让我们java程序员和字节码文件直接建立联系从而直接操纵字节码中的数据，让程序更加灵活
 * 后期的Strut2+Spring+Hibernate都是使用了大量的反射机制，因为这些框架需要更加灵活性
 *
 * java.lang.Class(普通类，名字比较特殊而已):
 *              java.lang.Class类的实例对象代表某个类的字节码文件（全部字节码）
 *
 * java.lang.reflect.Method
 *              java.lang.reflect.Method类的实例对象代表某个类所有字节码中的方法相关的字节码
 *
 * java.lang.reflect.Constructor
 *              java.lang.reflect.Constructor类的实例对象代表某个类所有字节码中的构造函数相关的字节码文件
 *
 * java.lang.reflect.Field
 *             java.lang.reflect.Field类的实例对象代表着某个类所有字节码中的字段相关的字节码
 *
 * Class = Method + Constructor + Field + Modifier....（都是从字节码的层面考虑的）
 * */
public class _02_反射机制 {
}

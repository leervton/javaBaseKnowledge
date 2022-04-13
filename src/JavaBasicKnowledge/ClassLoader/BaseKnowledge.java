package JavaBasicKnowledge.ClassLoader;

/**
 * JDK自带的类加载器
 *  1.什么是类加载器
 *      专门负责加载类的命令/工具
 *      ClassLoader
 *  2.JDK中自带了3个类加载器
 *      启动类加载器（父加载器）rt.jar
 *      扩展类加载器（母加载器）ext/*.jar
 *      应用类加载器      配置的环境变量classPath加载
 * 3.假设有这样一段代码
 *  String="abc";
 *   代码在代码开始执行之前，会将所需要类全部加载到JVM中，
 *   通过类加载器加载，看到以上代码类加载器会找到String.class
 *   文件，找到就加载，那么是怎么进行加载的呢？
 *          首先通过“启动类加载器”加载:
 *              C:\Program Files\Java\jdk-13.0.2\lib\rt.jar
 *              rt.jar中都是JDK最核心的类库
 *          如果通过“启动类加载器”加载不到的时候
 *
 *          会通过“扩展类加载器”进行加载
 *              注意：扩展类加载器专门加载：
 *               C:\Program Files\Java\jdk-13.0.2\lib\ext\*.jar
 *
 *         如果扩展类加载器没有加载到，那么会通过应用类加载器加载
 *              注意：应用类加载器专门加载：classPath（环境变量配置的路径）中的jar包（class文件）
 *
 *4.java中为了保证类加载器的安全，使用了双亲委派机制
 *      优先从启动类加载器中加载，这个称为“父”
 *      “父”无法加载到，再从扩展类加载器中加载
 *      这个称之为“母”，双亲委派机制，如果都加载不到
 *      才会考虑从应用类加载器中加载，直到加载到为止
 */
public class BaseKnowledge {
}

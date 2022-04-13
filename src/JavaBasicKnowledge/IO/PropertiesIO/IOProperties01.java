package JavaBasicKnowledge.IO.PropertiesIO;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * IO和Properties的联合应用
 * 非常好的一个设计理念
 *      以后经常变动的数据，可以单独写到一个文件中，使用程序动态读取，将来只需要修改这个文件内容
 *      java代码不需要改动，不需要重新编译，服务器也不需要重启，就可以拿到动态信息
 *
 *      类似于以上机制的文件被叫做配置文件
 *      并且当配置文件中的内容格式是：
 *          key1=value
 *          key2=value
 *      的时候，我们把这种配置文件叫做属性配置文件
 *
 *      java规范中有要求：属性配置文件建议以.Properties结尾，但这不是必须的
 *      这种以.properties结尾的文件在java中被称之为：属性配置文件
 *      其中Properties是专门存放属性配置文件内容的一个类
 */
public class IOProperties01 {
    public static void main(String[] args) throws Exception {
        /**
         *Properties是一个Map集合，key和value都是String类型
         * 想将userInfo文件中的数据加载到Properties对象中
         */
        //新建一个输入流，指向文件地址
        FileInputStream fis = new FileInputStream("../userInfo.properties");

        //新建一个Map集合
        Properties p = new Properties();

        //调用Properties对象的load方法将文件中的数据加载到Map集合当中
        //文件中的数据顺着IO流管道加载到Map集合当中，其中等号左边作key，等号右边作为value
        p.load(fis);

        //通过key来获取value呢？
        String userName= p.getProperty("username");
        System.out.println(userName);

        String passWord = p.getProperty("password");
        System.out.println(passWord);
    }
}

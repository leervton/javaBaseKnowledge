package JavaBasicKnowledge.Reflect.ReflectExample;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 */
public class IOProperties {
    public static void main(String[] args) throws Exception {
        //获取一个文件的绝对路径
        //String path = Thread.currentThread().getContextClassLoader().getResource("classinfo01.properties").getPath();
        //FileReader fr = new FileReader(path);

        //直接以流的形式返回
        InputStream fr = Thread.currentThread().getContextClassLoader().getResourceAsStream("classinfo01.properties");
        Properties pp = new Properties();
        pp.load(fr);
        fr.close();

        //通过key获取Value
        String className = pp.getProperty("className");
        System.out.println(className);

    }
}

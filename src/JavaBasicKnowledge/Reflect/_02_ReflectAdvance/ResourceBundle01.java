package JavaBasicKnowledge.Reflect._02_ReflectAdvance;

import java.util.ResourceBundle;

/**
 * java.util包下提供了一个资源绑定器，便于获取属性配置文件中的内容
 * 使用以下这种方式的时候，属性配置文件xxx.properties必须放在类路径下(src目录下)
 */
public class ResourceBundle01 {
    public static void main(String[] args) {
        //资源绑定器，只能绑定XXX.properties，并且这个文件必须在类路径下，文件拓展名也必须是properties
        //并且在写路径的时候，路径后面的拓展名不能写
        ResourceBundle b = ResourceBundle.getBundle("classinfo01");

        String className = b.getString("className");
        System.out.println(className);
    }
}

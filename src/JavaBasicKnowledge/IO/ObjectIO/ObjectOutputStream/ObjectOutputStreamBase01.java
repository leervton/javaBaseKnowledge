package JavaBasicKnowledge.IO.ObjectIO.ObjectOutputStream;

import JavaBasicKnowledge.IO.ObjectIO.Bean.User;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 能不能一次序列化多个对象
 *      ：可以，可以将对象放到集合当中，序列化集合
 * 提示：
 *      参与序列化的ArrayList集合以及集合的元素User都需要实现java.io.Serializable接口
 */
public class ObjectOutputStreamBase01 {
    public static void main(String[] args) throws Exception {
        List<User> list = new ArrayList<>();
        list.add(new User("张三",12,333));
        list.add(new User("李四",22,33));
        list.add(new User("王五",12,3353));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("User"));

        //一次序列化一个集合，这个集合对象中放了其他对象
        oos.writeObject(list);

        //刷新
        oos.flush();
        //关闭
        oos.close();
    }
}

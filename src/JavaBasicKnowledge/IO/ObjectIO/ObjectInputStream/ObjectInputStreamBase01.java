package JavaBasicKnowledge.IO.ObjectIO.ObjectInputStream;

import JavaBasicKnowledge.IO.ObjectIO.Bean.User;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 对集合进行反序列化
 *      如果不用集合，直接存储多个对象，当存储第二个对象时会直接报错
 */
public class ObjectInputStreamBase01 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("User"));
        /*Object obj = ois.readObject();
        System.out.println(obj instanceof List);//说明返回的值是一个List集合
         */
        List<User> userList= (List<User>)ois.readObject();
        for (User u:userList){
            System.out.println(u);
        }
        ois.close();
    }
}

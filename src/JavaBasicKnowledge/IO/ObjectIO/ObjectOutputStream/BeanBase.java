package JavaBasicKnowledge.IO.ObjectIO.ObjectOutputStream;

import JavaBasicKnowledge.IO.ObjectIO.Bean.Student;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *java.io.NotSerializableException
 *      1.student对象不支持序列化，但是实现Serializable就可以了
 *      2.参与序列化和反序列化的对象，必须实现Serializable接口
 *      3.注意：通过源代码发现Serializable只是一个标志性接口，这个接口当中什么对象都没有
 *            那么它起到一个什么作用？
 *                  起到一个标识的作用，标志的作用，java虚拟机看到这个类实现了这个接口
 *                  可能会对这个类进行特殊待遇
 *                  Serializable这个标志接口是给java虚拟机参考的，java虚拟机看到这个接口之后，会
 *                  给该类自动生成一个序列化版本号
 *      4.序列化版本号有什么作用？
 *          JavaBasicKnowledge.IO.ObjectIO.Bean.Student;
 *              local class incompatible:
 *                                        stream classdesc serialVersionUID = 8298344951020915845(十年后)
 *                                        local class serialVersionUID = 5970733111664672080（十年前）
 *
 *     5.java语言中是采用什么机制来区分类的？
 *          第一：首先通过类名（完整类名包括包名）进行比对的，如果类名不一样，肯定不是同一个类
 *          第二：如果类名一样，再怎么进行类的区分呢？
 *                              靠序列化版本号进行区分
 *                 小明写了一个类：JavaBasicKnowledge.IO.ObjectIO.Bean.Student;
 *                 小红写了一个类：JavaBasicKnowledge.IO.ObjectIO.Bean.Student;
 *                 不同的人编写了同一个类，但这两个类确实不是同一个类，这个时候序列化版本号就起到作用
 *                 对于java虚拟机来说，java虚拟机是可以区分这两个类的，因为这两个类都实现了Serializable接口
 *                 都有默认的序列化版本号，他们的序列化版本号不一样，所以区分开了
 *
 *     6.这种自动生成序列化版本号有什么缺陷？
 *              一旦代码确定之后，不能进行后续的修改，因为修改，必然会重新编译，此时会生成新的序列化版本号
 *              这个时候java虚拟机会认为这是一个全新的类，这样就报错了
 *
 *     7.最终结论
 *              凡是一个类实现了Serializable接口，建议给该类提供一个固定不变的序列化版本号
 *              这样，以后即使这个类的代码修改了，但是版本号不变，Java虚拟机会认为是同一个类
 *
 */
public class BeanBase {
    public static void main(String[] args) throws Exception {
        //创建java对象
        Student student = new Student("张三",22,12563);
        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student"));
        //序列化对象
        oos.writeObject(student);
        //刷新
        oos.flush();
        //关闭
        oos.close();
    }
}

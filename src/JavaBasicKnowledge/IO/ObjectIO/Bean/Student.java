package JavaBasicKnowledge.IO.ObjectIO.Bean;

import java.io.Serializable;

public class Student implements Serializable {
    //Serializable这个标志接口是给java虚拟机参考的，java虚拟机看到这个接口之后，会给该类自动生成一个序列化版本号
    //这里没有手动写出来，java虚拟机会默认提供这个序列化版本号
    //建议将序列化版本号手动的写出来，不建议自动生成
    private static final long serialVersionUID =456456456543562L;
    private String name;

    //过了很久，Student这个类源代码改动了
    //源代码改动之后，需要重新编译，编译之后生成了全新的字节码文件
    //并且class文件再次运行的时候，java虚拟机生成的序列化版本号也会发生相应的改变
    private int age;

    //transient关键字表示游离的，不参与序列化
    private transient int no;//no不参与序列化操作

    public Student() {
    }

    public Student(String name, int age, int no) {
        this.name = name;
        this.age = age;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", no=" + no +
                '}';
    }


}

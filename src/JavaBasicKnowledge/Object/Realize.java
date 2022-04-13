package JavaBasicKnowledge.Object;

public class Realize {
    /**
     * 方法区外不能进行赋值操作
     * 如果需要在方法区外进行赋值操作，建议利用有参构造函数进行赋值
     * 或者使用set方法赋值
     *
     * 类中只能写属性与方法
     * */
    Father father = new Father("lisi",12,"123");
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "zhangsan";
    }
}

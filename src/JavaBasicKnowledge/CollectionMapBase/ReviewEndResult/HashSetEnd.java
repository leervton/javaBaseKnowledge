package JavaBasicKnowledge.CollectionMapBase.ReviewEndResult;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class HashSetEnd {
    public static void main(String[] args) {
        //创建集合对象
        HashSet<String> set = new HashSet<>();

        //添加元素
        set.add("adc");
        set.add("tank");
        set.add("gank");
        set.add("uproad");
        set.add("main");

        //set集合中的元素不能通过下标获取了，因为没有下标
        //遍历集合（迭代器）
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //便利集合
        for (String s:set){
            System.out.println(s);
        }

        //测试HashSet集合的特点：无序不可重复
        set.add("king");
        set.add("king");
        set.add("king");
        System.out.println(set.size());
        set.add("1");
        set.add("2");
        set.add("10");

        for (String s:set){
            System.out.println("---->"+s);
        }

        //创建Set集合，存储Students数据
        Set<Student> set1 = new HashSet<>();
        Student s1 = new Student(111,"张三");
        Student s2 = new Student(222,"李四");
        Student s3 = new Student(333,"张三");
        Student s4 = new Student(111,"张三");

        set1.add(s1);
        set1.add(s2);
        set1.add(s3);
        set1.add(s4);

        System.out.println(set1.size());
    }
}

class Student{
    int no;
    String name;

    public Student() {
    }

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return no == student.no &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name);
    }
}
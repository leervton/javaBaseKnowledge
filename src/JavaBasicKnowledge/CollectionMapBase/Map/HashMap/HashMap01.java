package JavaBasicKnowledge.CollectionMapBase.Map.HashMap;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 1.向Map集合中存，以及从Map集合中取，都是先调用key的hashCode()方法，然后再调用equals()
 *   equals()方法有可能调用，也有可能不调用
 *      拿put<K,V>（）方法举例，什么时候不调用equals()方法？
 *              k.hashCode()方法返回哈希值
 *              哈希值经过哈希算法转换成数组下标
 *              数组下标所指的位置为null，equals不需要调用直接添加
 *      拿get(k)举例，什么时候equals不需要调用？
 *              如果单向链表上只有一个元素，不需要调用equals
 *
 * 2.注意：如果一个类的equals方法重写了，那么hashCode()方法必须重写
 *        并且equals方法如果返回true，那么hashCode()方法返回的值必须一样
 *              equals方法返回true表示两个对象相同，在同一个单向链表上比较
 *              那么对于同一个单向链表上的节点来说，他们的哈希值都是相同的
 *              所以hashCode()方法的返回值也应该相同
 *
 * 3.hashCode()方法和equals()方法用Idea工具同时生成
 * 4.终极结论：
 *      放在HashMap集合key部分的，以及放在HashSet集合中的元素，需要同时重写HashCode方法和equals方法
 *
 */
public class HashMap01 {
    public static void main(String[] args) {
        Student s = new Student("张三");
        Student s1 = new Student("张三");
        //重写equals之前是false，重写之后是true
        System.out.println(s.equals(s1));
        System.out.println("s的hashCode="+s.hashCode());
        System.out.println("s1的hashCode="+s1.hashCode());
        /**
         * s.equals(s1)结果已经是true了，表示s和s1是一样的，相同的，那么往HashSet集合中放的话
         * 按说只能放一个（HashSet集合特点：无序，不可重复）
         */
        Set<Student> set = new HashSet<>();
        set.add(s);
        set.add(s1);
        System.out.println(set.size());//这里的结果按理说是1，但是结果是2，显然不符合HashSet集合存储的特点
    }
}
class Student{
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   /*
    //hashCode()和equals()方法都没有重写
    //重写equals方法,核心在于八种基本数据类型和String这个引用数据类的型内容比较已经被写好了
    public boolean equals(Object obj){
        if (obj == null||!(obj instanceof Student)){
            return false;
        }else if (obj == this){
            return true;
        }else if (((Student)obj).name.equals(this.name)){
            return true;
        }
        return false;
    }
   */
   //自动生成hashCode()和equals()方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
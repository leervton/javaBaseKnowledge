package JavaBasicKnowledge.CollectionMapBase.TreeSortedComparable;

import java.util.TreeSet;

/**
 * 对自定义的类型来说，TreeSet可以进行排序吗？
 *      以下程序中对于Person类型来说，无法排序，因为没有指定Person对象之间的
 *      排序规则
 *
 * 以下程序运行时出现异常：Person cannot be cast to class java.lang.Comparable
 */
public class Tree01 {
    public static void main(String[] args) {
        Person p1 = new Person(20);
        Person p2 = new Person(30);
        Person p3 = new Person(40);
        //创建TreeSet集合
        TreeSet<Person> treeSet = new TreeSet<>();
        //添加元素
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);

        //遍历
        for (Person p:treeSet){
            System.out.println(p);
        }

    }
}

class Person{
    int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "person="+age;
    }
}
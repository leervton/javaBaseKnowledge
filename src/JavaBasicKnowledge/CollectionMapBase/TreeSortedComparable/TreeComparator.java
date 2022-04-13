package JavaBasicKnowledge.CollectionMapBase.TreeSortedComparable;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet集合中元素可排序的第二种方式：使用比较器的方式
 * 最终的结论：
 *      放到TreeSet或者TreeMap集合key部分的元素想要做到排序，包括两种方式：
 *              第一种：放在集合中的元素实现java.lang.Comparable接口
 *              第二种：在构造TreeSet或者TreeMap集合的时候给他传递一个比较器对象
 *
 * Comparable和Comparator怎么选？
 *      如果比较规则不会发生改变或者说比较规则只有一个的时候，建议实现Comparable接口
 *      如果比较规则有多个，并且需要多个比较规则之间频繁切换，建议使用compactor接口
 *
 *      Comparator接口的涉及符合OCP规则
 */
public class TreeComparator {
    public static void main(String[] args) {
        //创建TreeSet集合的时候，需要使用这个比较器
        //TreeSet<Vehicle> t = new TreeSet<>();//这样不行，没有通过构造方法传递一个比较器进去

        //给构造方法传递一个比较器
        TreeSet<Vehicle> t = new TreeSet<>(new VehicleComparator());
        /**
        //如果不想写比较器，可以采用匿名内部类(这个类没有名字，直接new接口)
        TreeSet<Vehicle> t1 = new TreeSet<>(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.age-a2.age;
            }
        });
        */
        t.add(new Vehicle(100));
        t.add(new Vehicle(200));
        t.add(new Vehicle(300));
        t.add(new Vehicle(10));

        for (Vehicle v:t){
            System.out.println(v);
        }
    }
}
class Vehicle{
    int age;
    public Vehicle(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "age=" + age +
                '}';
    }
}
//单独在这里写一个比较器
//比较器实现java.util.Comparator接口（Comparable是java.lang包下的，Comparator是java.util包下的）
class VehicleComparator implements Comparator<Vehicle>{
    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        //指定比较规则
        //按照年龄排序
        return o1.age-o2.age;
    }
}
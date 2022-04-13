package JavaBasicKnowledge.CollectionMapBase.TreeSortedComparable;

import java.util.TreeSet;

public class Tree02 {
    public static void main(String[] args) {
        Customer p1 = new Customer(20);
        Customer p2 = new Customer(30);
        Customer p3 = new Customer(40);
        //创建TreeSet集合
        TreeSet<Customer> treeSet = new TreeSet<>();
        //添加元素
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);

        //遍历
        for (Customer p:treeSet){
            System.out.println(p);
        }

    }
}
//放在TreeSet集合中的元素需要实现java.lang.Comparable接口
//并实现CompareTo方法，equals可以不写
class Customer implements Comparable<Customer>{
    int age;

    public Customer(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer="+age;
    }
    //需要在这个方法里编写比较的逻辑，或者说比较的规则，按照什么进行比较
    //k.compareTo(t.key)
    //拿着参数key和集合中的每一个key进行比较，返回值可能是大于0，小于0，或者等于0
    //比较规则最终还是由程序指定的，例如按照年龄升序或者按照年龄降序
    @Override
    public int compareTo(Customer o) {//o1.compareTo(o2);
        //this是o1
        //o是o2
        //o1和o2比较的时候，就是this和o进行比较
        /*if (age == o.age){
            return 0;
        }else if (age>o.age){
            return 1;
        }
        return -1;*/
        //return this.age-o.age;//升序
        return o.age-age;//降序
    }
}
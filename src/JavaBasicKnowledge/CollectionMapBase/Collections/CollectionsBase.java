package JavaBasicKnowledge.CollectionMapBase.Collections;
import java.util.*;

/**
 * java.util.Collection集合接口
 * java.util.Collections集合工具类，方便集合的操作
 */
public class CollectionsBase {
    public static void main(String[] args) {
        //ArrayList不是线程安全的
        List<String> list = new ArrayList<>();

        //变成线程安全的
        Collections.synchronizedList(list);

        //排序
        list.add("abc");
        list.add("avb");
        list.add("agv");
        list.add("abx");

        Collections.sort(list);
        for (String s:list) {
            System.out.println(s);
        }

        List<Customers> list1 = new ArrayList<>();
        list1.add(new Customers(100));
        list1.add(new Customers(150));
        list1.add(new Customers(120));
        list1.add(new Customers(360));
        list1.add(new Customers(22));
        //对list集合中的元素进行排序必须要保证list集合中的元素实现了：Comparable接口
        Collections.sort(list1);

        for (Customers customers:list1){
            System.out.println(customers);
        }

        //对set集合怎么进行排序呢？
        Set<String> set = new HashSet<>();
        set.add("king");
        set.add("kingSoft");
        set.add("king1");
        set.add("king2");

        //将set集合变成list集合
        List<String> list2 = new ArrayList<>(set);
        Collections.sort(list2);
        for (String s:list2){
            System.out.println(s);
        }
        //这种方法也可以排序
        //Collections.sort(list集合，比较器对象);
    }
}
class Customers implements Comparable<Customers>{
    int age;
    public Customers(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "age=" + age +
                '}';
    }
    //注意：这里必须使用泛型，不然形参会是Object类
    @Override
    public int compareTo(Customers o) {
        return age-o.age;
    }
}


package JavaBasicKnowledge.CollectionMapBase.ReviewEndResult;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 无序不可重复，但是可以排序
 */
public class TreeSetEnd {
    public static void main(String[] args) {
        //TreeSet<String> treeSet = new TreeSet<>();
        //编写比较器可以改变
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1;
            }
        });
        //添加元素
        treeSet.add("1");
        treeSet.add("10");
        treeSet.add("30");
        treeSet.add("50");
        treeSet.add("0");
        //遍历
        //迭代器
        Iterator<String> it = treeSet.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //foreach
        for (String s:treeSet){
            System.out.println(s);
        }

        TreeSet<B> bTreeSet = new TreeSet<>(new BComparator());
        bTreeSet.add(new B(1));
        bTreeSet.add(new B(2));
        bTreeSet.add(new B(3));
        bTreeSet.add(new B(0));
        for (B b: bTreeSet){
            System.out.println(b);
        }
    }
}
class A implements Comparable<A>{
   int i;

    public A(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                '}';
    }

    @Override
    public int compareTo(A o) {
        return i-o.i;
    }
}
//比较器方法
class B{
    int k;

    public B(int k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "B{" +
                "k=" + k +
                '}';
    }

}
class BComparator implements Comparator<B>{

    @Override
    public int compare(B o1, B o2) {
        return o1.k-o2.k;
    }
}
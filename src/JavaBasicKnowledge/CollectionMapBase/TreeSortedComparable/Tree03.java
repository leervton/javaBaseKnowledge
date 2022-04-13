package JavaBasicKnowledge.CollectionMapBase.TreeSortedComparable;

import java.util.TreeSet;

/**
 * 先按照年龄升序，如果年龄一样的再按照姓名升序
 */
public class Tree03 {
    public static void main(String[] args) {
        TreeSet<Vip> vips = new TreeSet<>();
        vips.add(new Vip(20,"张三"));
        vips.add(new Vip(60,"李四"));
        vips.add(new Vip(40,"王五"));
        vips.add(new Vip(10,"赵六"));
        for (Vip v:vips){
            System.out.println(v);
        }
    }
}
class Vip implements Comparable<Vip>{
    int age;
    String name;

    public Vip() {
    }

    public Vip(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * compareTo方法的返回值很重要：
     *      返回为0表示相同，value会覆盖
     *      返回大于0，会在右子树上找
     *      返回小于0，会在左子树上找
     *      负数在左，正数在右
     * @param o
     * @return
     */
    @Override
    public int compareTo(Vip o) {
        if (age==o.age){
            //年龄相同时按照名字排序
            //姓名是String类型，可以直接比较，调用compareTo来完成比较
            return name.compareTo(o.name);
        }else {
            //年龄不一样
            return age-o.age;
        }
    }
}
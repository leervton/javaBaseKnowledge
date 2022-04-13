package JavaBasicKnowledge.CollectionMapBase.Collection.List.ArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * 集合ArrayList的另一种构造方法
 */
public class ArrayListAnotherConstructor {
    public static void main(String[] args) {
        //默认初始化容量10
        List list = new ArrayList();

        //指定初始化容量100
        List list01 = new ArrayList(100);

        //创建一个HashSet集合
        Collection c = new HashSet();

        c.add("100");
        c.add("120");
        c.add("10");
        c.add("110");
        c.add("101");

        //通过这个构造方法就可以将HashSet集合转换成List集合
        List list02 = new ArrayList(c);
        for (int i=0;i<list02.size();i++){
            System.out.println(list02.get(i));
        }
    }
}

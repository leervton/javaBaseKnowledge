package JavaBasicKnowledge.CollectionMapBase.ReviewEndResult;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEnd {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");

        //取元素，List集合有下标
        String firstElement = list.get(0);
        System.out.println(firstElement);

        //遍历的两种方式：用下标或者迭代器
        //下标
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //迭代器(该方式通用的，所有的Collection都能用)
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //迭代器改for循环
        for (Iterator<String> it2 = list.iterator();it2.hasNext();){
            System.out.println(it2.next());
        }
        //增强for
        for (String s:list){
            System.out.println(s);
        }

    }
}

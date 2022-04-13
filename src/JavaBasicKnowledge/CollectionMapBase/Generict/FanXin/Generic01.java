package JavaBasicKnowledge.CollectionMapBase.Generict.FanXin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * JdK8之后引入了自动类型推断机制，又称为钻石表达式
 */

public class Generic01 {
    public static void main(String[] args) {
        //new ArrayList<这里的类型会自动推断，JDK8之前这里必须要写类型>();
        // 前提是JDK8之后才被允许自动推断类型，尖括号里面不用写类型
        //自动类型推断，钻石表达式
        List<Animal> list = new ArrayList<>();

        list.add(new Cat());
        list.add(new Bird());
        list.add(new Animal());

        Iterator<Animal> it = list.iterator();
        while (it.hasNext()){
            //调用公共方法
            //(it.next()).move();
            Animal a = it.next();
            a.move();
            //调用子类特有方法
            if (a instanceof Cat){
                ((Cat) a).CatchMouse();
            }else if (a instanceof Bird){
                ((Bird) a).fly();
            }
        }

        List<String> list1 = new ArrayList<>();

        //类型不匹配
        //list1.add(new Cat());

        list1.add("abc");

        //类型不匹配
        //list1.add(123);
    }
}

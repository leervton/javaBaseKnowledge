package JavaBasicKnowledge.CollectionMapBase.Collection.CollectionBaseKnowledge;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 关于java.util.Collection接口中常用的方法：
 * 1.Collection中能存放什么元素？
 *      如果没有使用"泛型"之前，只要是Object的子类型都可以往集合中存储
 *      使用了"泛型"之后，Collection之中只能存储某个具体的类型
 *      集合后期我们会学习"泛型"语法，目前先不用管，Collection中什么都能存
 *      只要是Object的子类型就行（集合中不能直接存储基本数据类型，也不能存储java对象，只是存储java对象的内存地址）
 *
 * 2.Collection中的常用方法
 *      boolean add（Object e） 向集合中添加元素
 *      int size(); 获取集合中元素的个数
 *      void clear(); 清空集合
 *      boolean contains(Object o) 判断当前集合中是否包含元素o，包含返回true，不包含返回false
 *      c.remove(Object o); 删除某个元素实例
 *      boolean isEmpty(); 判断集合是否为空
 *      Object[] toArray(); 把集合转换成数组
 */
public class collection {
    public static void main(String[] args) {
        //创建一个集合对象
        //Collection c = new Collection(); //接口是抽象的，无法实例化

        //多态
        Collection c = new ArrayList();

        //测试Collection接口中的常用方法
        c.add(1200);//1200被自动装箱了，实际上放了一个内存地址，Integer i = new Integer(1200);
        c.add(3.14);
        c.add(new Object());
        c.add("你好");
        c.add(new student());
        c.add(true);//自动装箱

        //获取集合中元素的个数
        System.out.println("集合中元素的个数是多少？"+c.size());

        //清空集合
        c.clear();
        System.out.println("集合中元素的个数是多少？"+c.size());

        //再次向集合中添加元素
        c.add("hello");
        c.add("world");
        c.add("浩克");
        c.add("绿巨人");
        c.add(1);

        //判断集合中是否包含绿巨人
        boolean flag = c.contains("绿巨人");
        System.out.println(flag);//true
        boolean flag2 = c.contains("绿巨人2");
        System.out.println(flag2);//false
        System.out.println(c.contains(1));//true

        //判断集合是否为空
        System.out.println(c.isEmpty());//false
        c.clear();//清空
        System.out.println(c.isEmpty());//true

        c.add("abc");
        c.add("def");
        c.add("helloWorld");
        c.add(100);

        //转换成数组
        Object[] objs = c.toArray();
        for(int i = 0; i<objs.length;i++){
            //遍历数组
            Object o = objs[i];
            /**
             * 在这里，我们应该注意一件事：
             *      Object类中的toString();方法并没有重写
             *      而储存在数组里面的元素String类和包装类的toString方法被重写了
             *      --------------------------------------------------
             *      按我们测试的结果来看，存入数组的元素调用方法，直接都是父类的方法
             *      但是这里却是调用子类的方法，与测试结果不符
             *
             */
            System.out.print(objs[i]);//abc def helloWorld 100
            //System.out.println(o.toString());//在这里字符串类的toString的方法已经被重写，八种包装类也被重写了
        }

    }
}

class student{

}
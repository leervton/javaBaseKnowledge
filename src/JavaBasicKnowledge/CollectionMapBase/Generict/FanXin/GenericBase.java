package JavaBasicKnowledge.CollectionMapBase.Generict.FanXin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Jdk5.0之后推出的新特性：泛型
 *      泛型这种语法机制，只在程序编译阶段起作用，只是给编译器做参考的（运行阶段意义不大）
 *      使用了泛型的好处是什么？
 *          第一，集合中存储的元素类型统一了
 *          第二，从集合中取出的元素类型是泛型指定的类型，不需要大量的“向下转型”
 *      泛型的缺点是什么？
 *           导致集合中存储的元素缺乏多样性
 *           大多数业务中，集合的元素的类型还是统一的，所以这种泛型特性被大家认可
 *   注意：泛型是无法被继承的
 */

public class GenericBase {
    public static void main(String[] args) {
        /*
        //先不使用泛型机制，分析程序缺点
        List list = new ArrayList();
        //准备对象
        Cat cat = new Cat();
        Bird bird = new Bird();
        //将对象添加到集合当中
        list.add(cat);
        list.add(bird);
        //遍历集合，取出Cat，让他抓老鼠；取出bird，让他飞
        Iterator it = list.iterator();
        while (it.hasNext()){
            //通过迭代器取出的对象只能是Object类型
            Object o = it.next();
            //Object类中没有这种方法，无法调用，只能向下转型
            if (o instanceof Cat){
                ((Cat) o).CatchMouse();
            }else if (o instanceof Bird){
                ((Bird) o).fly();
            }
        }
        */
        /**
         * 使用Jdk5之后的泛型机制
         */
        //使用List<Animal>之后，表示List集合中只允许存储Animal类型的数据,存入其他类型的数据就会报错
        //用泛型来指定集合中存储数据的类型
        List<Animal> list = new ArrayList<Animal>();

        //指定List集合中只能存储Animal类型，那么存储String类型就报错
        //这样用了泛型之后，集合中的元素的数据就更统一了
        //list.add("123");
        Cat cat = new Cat();
        Bird bird = new Bird();

        list.add(cat);
        list.add(bird);
        //获取迭代器
        Iterator<Animal> it = list.iterator();
        while (it.hasNext()){
            //使用泛型之后，每一次迭代返回的数据都是Animal类型
            Animal animal = it.next();
            //这里不需要强制类型转换了，直接调用即可
            animal.move();
            //但是这里如果调用子类特有的方法，还是避免不了向下转型
            if (animal instanceof Cat){
               ((Cat) animal).CatchMouse();
            }else if (animal instanceof Bird){
                ((Bird) animal).fly();
            }
        }

    }
}
class Animal{
    public void move(){
        System.out.println("动物在移动");
    }
}
class Cat extends Animal{
    public void CatchMouse(){
        System.out.println("猫抓老鼠");
    }
}
class Bird extends Animal{
    public void fly(){
        System.out.println("鸟儿在飞行");
    }
}
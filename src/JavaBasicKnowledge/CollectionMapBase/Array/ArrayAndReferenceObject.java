package JavaBasicKnowledge.CollectionMapBase.Array;

/**
 * 数组和引用对象类型的元素的关系
 *      数组在创建的时候已经把数组元素的属性确定下来了，即Father[]的每一个元素类型都是Father
 *      即使father[0]储存的类是子类son，也必须认为是Father看待。
 *      因为从继承关系来看，son的类型是Son，但也是Father，所以son才能储存进Father数组里面，
 *      既然储存进Father[]数组里面了，那么jvm必须认为son的属性必须是Father
 *      而不是son
 *
 *      数组元素的类型和数组类型保持一致，即使元素是其子类，子类类型和数组类型不一致也只认为元素的类型是数组类型
 *
 *
 */
public class ArrayAndReferenceObject {
    public static void main(String[] args) {
        Father[] fathers = new Father[2];
        Son son = new Son();
        //数组在创建的时候已经把数组元素的属性确定下来了，
        //数组元素的类型和数组保持一致，即使元素是其他类型也不管
        //即father[]数组每一个元素的类型都是Father
        fathers[0]= son;
        //father[0]的类型是Father
        fathers[0].doThings();//爸爸正在吹牛逼

        //将子类绑定父类身上，调用方法
        Father father1 = fathers[0];
        father1.doThings();//爸爸正在吹牛逼

        Son son1 = (Son)fathers[0];
        son1.doThings();//儿子正在吹牛逼

    }
}
class Father{
    public static void doThings(){
        System.out.println("爸爸正在吹牛逼");
    }
}

class Son extends Father{
    public static void doThings(){
        System.out.println("儿子正在吹牛逼");
    }
}
/**反编译：
 * public class k
 * {
 *   public static void main(String[] paramArrayOfString)
 *   {
 *     Father[] arrayOfFather = new Father[2];
 *     Son localSon1 = new Son();
 *
 *     arrayOfFather[0] = localSon1;
 *
 *     arrayOfFather[0];
 *     Father.doThings();
 *
 *     Father localFather = arrayOfFather[0];
 *     Father.doThings();
 *
 *     Son localSon2 = (Son)arrayOfFather[0];
 *     Son.doThings();
 *   }
 * }
 * 由此看出，即使数组内存储了引用对象元素，调动引用对象元素的方法时，也是执行父类方法，根本不会执行元素方法
 */

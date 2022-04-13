package JavaBasicKnowledge.CollectionMapBase.Collection.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.ArrayList初始化容量是10（底层先创建了一个长度为0的数组，当添加第一个元素的时候，初始化容量是10）
 * 2.ArrayList集合底层是一个Object类型的数组Object[]
 * 3.构造方法：
 *      new ArrayList();
 *      new ArrayList(20);
 * 4.ArrayList的扩容是原容量的1.5倍
 *      ArrayList集合底层是数组，怎么优化？
 *      尽可能少的扩容，因为数组扩容效率比较低，建议在使用ArrayList集合的时候
 *      预估计元素的个数，给顶一个初始化容量
 * 5.数组优点：
 *      数组检索效率比较高（每个元素占用空间大小是一样的，内存地址是连续的，知道首元素内存地址，然后知道下标，通过数学表达式计算出元素的内存地址所以检索效率最高）
 * 6.数组缺点：
 *      随机增删元素效率比较低
 *      另外数组无法存储大数据量（很难找到一块非常巨大的连续的内存空间）
 * 7.数组向数组末尾添加元素效率很高，不受影响
 *      使用ArrayList次数比较多
 *      一般查找元素操作比较多
 *      其次添加元素也是往集合末尾添加元素
 */
public class ArrayListBase {
    public static void main(String[] args) {

        //默认初始化容量10
        List list = new ArrayList();
        //集合的size()方法是获取当前集合中元素的个数，不是获取集合的容量
        System.out.println(list.size());//0


        //指定初始化容量20
        List list01 = new ArrayList(20);
        //集合的size()方法是获取当前集合中元素的个数，不是获取集合的容量
        System.out.println(list01.size());//0
    }
}

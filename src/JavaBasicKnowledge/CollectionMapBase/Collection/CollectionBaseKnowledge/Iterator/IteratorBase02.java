package JavaBasicKnowledge.CollectionMapBase.Collection.CollectionBaseKnowledge.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 重点：当集合的结构（内部数据被增删改之后）发生了改变时，迭代器必须重新获取，如果还是用以前老的迭代器，
 *      会出现异常：java.util.ConcurrentModificationException
 *
 * 重点：在迭代集合元素的时候，不能调用集合对象的remove方法，删除元素：
 *          c.remove();不能这样，会导致数据结构发生变化，无法使用it.next();
 *          会出现异常：java.util.ConcurrentModificationException
 *
 * 原因：这个异常的根源在于迭代器，ArrayList内部有一个计数器，用于计算ArrayList被修改的次数，每次ArrayList被修改的时候计数器就会加1。
 *      当调用ArrayList的iterator()方法的时候，ArrayList会将计数器的数值传给迭代器，作为迭代器的中计数器的初始值。
 *      每次迭代器调用next()或者remove()方法的时候都会检查迭代器里面的计数器和ArrayList的计数器数值是否相同，如果不相同则抛出
 */
public class IteratorBase02 {
    public static void main(String[] args) {
        //创建集合
        Collection c = new ArrayList();

        //增加元素
        c.add("abc");
        c.add("def");
        c.add("hjk");
        c.add("shn");

        //创建迭代器对象
        Iterator it = c.iterator();

        //迭代删除元素
        while (it.hasNext()){
            Object o = it.next();
            //删除元素之后，集合的结构发生了改变，本应该重新获取迭代器
            //但是，每次循环删除元素之后，下一次循环却没有重新获取迭代器，所以会出现异常
            //c.remove(); 用集合里的remove方法来删除集合内的元素,导致集合内的计数器和迭代器内的计数器不一致，抛出异常
            //那么用迭代器来删除有问题吗？
            //没问题，会自动更新迭代器内的计数器，并删除集合中的元素
            /**
             * 在迭代元素的时候，一定要用迭代器当中的remove方法去删除，不要用集合中的方法去删除
             */
            it.remove();
            System.out.println(o);
        }
        System.out.println(c.size());//0
    }
}
/**
 * ConcurrentModificationException异常是一个RuntimeException，名字翻译过来就是并发修改异常。
 * 这个异常通常情况下在多线程的并发访问容器的时候抛出，但是也并不绝对，单线程的时候也可以抛出这个异常。本篇我们继续以Vector为例。
 *
 * 异常的根源
 * 这个异常的根源在于迭代器，Vector内部有一个计数器，用于计算Vector被修改的次数，每次Vector被修改的时候计数器就会加1。
 * 当调用Vector的iterator()方法的时候，Vector会将计数器的数值传给迭代器，作为迭代器的中计数器的初始值。
 * 每次迭代器调用next()或者remove()方法的时候都会检查迭代器里面的计数器和Vector的计数器数值是否相同，
 * 如果不相同则抛出ConcurrentModificationException。这个异常不是只在多线程的时候才会抛出，单线程也有可能抛出这个异常。
 * 举个例子：
 * public class CMExceptionTest {
 * 	public static void main(String[] args) {
 * 		Vector<String> vct = new Vector<String>();
 * 		for(int i=0; i < 10; i++) {
 * 			vct.add(Integer.toString(i));
 *       }
 *
 * 		Iterator<String> ite = vct.iterator();
 * 		vct.remove(0);//这里是错误的根源
 * 		String str = ite.next();
 * 		}
 * }
 * 在上面的代码中，我们向Vector里面加了10个元素，调用iterator()方法获取当前的迭代器，
 * 此时vct和ite中的计数器都是10；接下来又通过vct对象删除了容器中的第一个元素，
 * 此时vct中的计数器是11，而ite中的计数器没有变化，这也是导致异常的根源；
 * 然后我们调用ite.next()时，迭代器对比了自己的计数器和vct的计数器，发现两者不一致，所以就抛出了异常。
 *
 * 异常的常见情况
 * 在上面的例子中抛出了并发修改异常，但实际上我们在写代码的时候通常调用iterator()方法后会立即使用这个迭代器，
 * 因此在单线程的时候很少出现这个异常。
 *
 * 1.for( : )
 *
 * 多线程的时候这个异常就比较常见了，比如两个线程并发向容器里面添加元素，最后使用for( : )打印出容器内的所有元素，代码如下：
 *
 * class AddElement implements Runnable {
 * 	public void run() {
 * 		Random rand = new Random();
 * 		for(int i=0; i < 100; i++) {
 * 			Integer itg = rand.nextInt();
 * 			AddElementToCollection.vct.add(itg);
 *        }
 * 		for(Integer integer : AddElementToCollection.vct) {
 * 			System.out.println(integer);
 *        }* 	}
 * }
 *
 * public class AddElementToCollection {
 * 	public static Vector<Integer> vct = new Vector<Integer>();
 * 	public static void main(String[] args) {
 * 		ExecutorService exec = Executors.newCachedThreadPool();
 * 		exec.execute(new AddElement());
 * 		exec.execute(new AddElement());
 * 		exec.shutdown();
 * 		}
 * }
 * 上面的代码运行后会抛出并发修改异常。在本例中我们生成了两个线程，分别向vct内添加100个随机数，之后通过for循环打印出这些数字。
 * 可能有的同学会好奇，为什么没有使用迭代器也抛出异常，实际上Java虚拟机在处理for( : )指令时会隐式调用迭代器，
 * 因此当A线程向vct中添加了100个随机数的时候，B线程可能还没有添加完成，这时A线程通过迭代器遍历容器就会抛出并发修改异常。
 *
 * 2.toString()
 *
 * Vector的toString()方法中也隐式的使用了迭代器，我们可以查看一下它的源代码：
 *
 * Vector.toString()
 *
 * public synchronized String toString() {
 *         return super.toString();
 * }
 * AbstractCollection.toString()
 *
 * public String toString() {
 *         Iterator<E> it = iterator();
 *         if (! it.hasNext())
 *             return "[]";
 *
 *         StringBuilder sb = new StringBuilder();
 *         sb.append('[');
 *         for (;;) {
 *             E e = it.next();
 *             sb.append(e == this ? "(this Collection)" : e);
 *             if (! it.hasNext())
 *                 return sb.append(']').toString();
 *             sb.append(',').append(' ');
 *         }
 * }
 * 从上面的代码中可以看出Vector调用了AbstractCollection.toString()方法，
 * 而AbstractCollection.toString()方法使用了迭代器遍历整个容器。
 *
 * 使用调用Vector.toString()方法时不会出现并发访问异常，因为Vector.toString()方法加锁了，
 * 当调用toString()方法时其它线程不能修改容器，因此不会抛出并发访问异常。
 * 但是ArrayList、LinkedList这些非线程安全的容器类就不能保证调用toString()方法的时候没有其它线程修改容器了，
 * 因此调用这些类的toString()方法有可能导致并发访问异常。
 *
 * --------------------------------------------------避免异常的方法-------------------------------------------
 *
 *                                       ----------------加锁----------------------
 *
 * 避免异常的方法也不难，最简单的方式就是和Vector.toString()一样，我们每次调用迭代器的时候都对Vector的对象加锁即可。比如下面的代码：
 *
 * synchronized(vct) {
 * 	for(String str : vct) {
 * 		System.out.println(str);* 	}
 * }
 * 这样就可以避免在遍历的时候其它线程对容器修改，但是如果容器特别大的时候会导致遍历容器需要等很久，
 * 而其它线程必须等待，这样就降低了系统的性能，因此这种解决方案并不是完美的。
 *
 *                                         ---------------分段遍历--------------
 *
 * 另一种方式就是分段遍历容器，比如容器中一共有十万个元素，我们通过subList()方法先获得前一千个元素，遍历这个子集，
 * 然后再获得从一千到两千的元素......以此类推。但是这种方案也是有缺陷的，因为每次拿到的子集都相当于一个快照，
 * 在遍历子集的时候别的线程可能已经修改了这个容器，因此这种方法要求客户端代码对数据一致的敏感性不高，对敏感性高就只能使用加锁的方法。
 *
 *                                       -------------------总结--------------------
 * 本篇我们介绍了并发访问异常，抛出异常的主要原因就是迭代器中的修改计数器和容器中的修改计数器的数值不同导致的。
 * 主要有两种方式会导致隐式调用迭代器，一种是for( : )，另一种是容器的toString()方法。规避这个异常有两种方式，
 * 对容器加锁和分段遍历，但两者各有优缺点。
 */

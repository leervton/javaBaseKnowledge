package NormalKnowledge.Base;
/**
 * 枚举，迭代，JDBC中的ResultSet
 * https://www.cnblogs.com/leskang/p/6031282.html
 * Java中四种遍历集合的方法
 *      迭代是集合中进行的基本操作之一。基本上，迭代是从一个到另一个集合
 *      比如，你想在一个班级中遍历所有的学生打印出他们的名字或找到在最近的考试中的最高分是谁。
 *      或者你想遍历一组数字计算和或平均值。这样的操作在编程中是十分常见的。
 *
 *      Java提供了四种在集合上遍历的方法，包括循环，迭代和forEach（从Java 8开始）
 *
 *              在学习每种遍历方式之前，我们需要现有一组List集合：
 *
 *                  public static void main(String[] args) {
 *                      List<String> listNames = new ArrayList<>();
 *
 *                      listNames.add("qiuqiu");
 *                      listNames.add("kaka");
 *                      listNames.add("beibei");
 *                      listNames.add("hutu");
 *                      listNames.add("wangzai");
 *                  }
 *
 *              这个list包含我们小区的所有小狗的名字。注意在语句的右边<>的使用
 *              ArrayList<>();
 *              这个语法从Java7开始使用，允许我们以一种更严谨的方式声明泛型的集合，
 *              因为编译器可以从左边推测出右边的参数类型（因此叫做“类型引用”）
 *
 * 【1】 经典循环方式
 *          这种迭代方法在编程中非常熟悉，其中计数器变量从集合中的第一个元素运行到最后一个元素
 *
 *                      for (int i = 0; i < listNames.size(); i++) {
 *                          String name = listNames.get(i);
 *                          System.out.println(name);
 *                      }
 *          pros：
 *          - 这是编程中最熟悉的构造
 *          - 如果我们需要访问并使用计数器变量，比如打印小狗狗们的的数字顺序：1，2，3……
 *
 *          cons:
 *          - 使用计数器变量要求集合必须以基于索引的形式（如ArrayList）存储元素，并且我们必须提前知道集合的大小
 *
 *          该集合必须提供一种通过基于索引的方式访问其元素的方法，这不是所有集合都支持的方式，例如， Set不会将元素存储为基于索引的元素。
 *          因此这种方法不能用于所有集合。
 * 【2】迭代的方式
 *          由于经典循环方式的限制，创建了使用迭代器的方式，这种方式允许我们迭代各种集合。因此你可以看到Collection接口定义了每个集合必须实现iterator()方法
 *
 *      在List上用迭代器遍历：
 *
 *         Iterator<String> itr = listNames.iterator();
 *
 *         while (itr.hasNext()) {
 *             String name = itr.next();
 *             System.out.println(name);
 *         }
 *      在Set上用迭代器遍历：
 *
 *         Set<String> set = new HashSet<>();
 *
 *         set.add("a");
 *         set.add("b");
 *         set.add("c");
 *         set.add("d");
 *
 *         Iterator<String> itr = set.iterator();
 *
 *         while (itr.hasNext()) {
 *             String letter = itr.next();
 *             System.out.println(letter);
 *         }
 *      在Map上用迭代器遍历：
 *
 *         Map<String, Integer> grade = new HashMap<>();
 *
 *         grade.put("Operating System", 90);
 *         grade.put("Computer Network", 92);
 *         grade.put("Software Engineering", 90);
 *         grade.put("Oracle", 90);
 *
 *         Iterator<String> itr = grade.keySet().iterator();
 *
 *         while (itr.hasNext()) {
 *             String key = itr.next();
 *             Integer value = grade.get(key);
 *             System.out.println(key + "=>" + value);
 *         }
 *【3】加强for循环
 *          从Java 5开始，程序员可以使用一种更简洁的语法来遍历集合-加强for循环。
 *
 *         for (String s : listNames) {
 *             System.out.println(s);
 *         }
 *          注意：
 *          加强for循环实际上在背后使用的是迭代器。这意味着编译时Java编译器会将增强型for循环语法转换为迭代器构造。
 *          新的语法为程序员提供了一种更方便的迭代集合的方式。
 *
 * 【4】使用Lambda表达式的forEach
 *          Java 8引入了Lambda表达式，介绍了一种遍历集合的全新方式-forEach方法
 *              listNames.forEach(name -> System.out.println(name));
 *          forEach方法与之前的方法最大的区别是什么？
 *              在之前的方法中（经典for循环，迭代器和加强for循环），程序员可以控制集合是如何迭代的。迭代代码不是集合本身的一部分
 *              - 它是由程序员编写的 - 因此称为外部迭代。
 *              相比之下，新方法将迭代代码封装在集合本身中，因此程序员不必为迭代集合编写代码。
 *              相反，程序员会在每次迭代中指定要做什么 - 这是最大的区别！ 因此术语内部迭代：集合处理迭代本身，
 *              而程序员传递动作 - 即每次迭代需要做的事情。
 *
 *
 * =================================================================================
 *
 * java集合遍历的几种方式总结及比较：
 *      集合类的通用遍历方式, 用迭代器迭代:
 *      Iterator it = list.iterator();
 *      while(it.hasNext()) {
 *      　　Object obj = it.next();
 *      }
 *
 *  Map遍历方式：
 *      1、通过获取所有的key按照key来遍历
 *      //Set<Integer> set = map.keySet(); //得到所有key的集合
 *      for (Integer in : map.keySet()) {
 *          String str = map.get(in);//得到每个key多对用value的值
 *      }
 *
 *      2、通过Map.entrySet使用iterator遍历key和value
 *      Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
 *      while (it.hasNext()) {
 *           Map.Entry<Integer, String> entry = it.next();
 *             System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
 *      }
 *
 *      3、通过Map.entrySet遍历key和value，推荐，尤其是容量大时
 *      for (Map.Entry<Integer, String> entry : map.entrySet()) {
 *          //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
 *          //entry.getKey() ;entry.getValue(); entry.setValue();
 *          //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
 *          System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
 *      }
 *
 *      4、通过Map.values()遍历所有的value，但不能遍历key
 *      for (String v : map.values()) {
 *          System.out.println("value= " + v);
 *      }
 *
 * List遍历方式：
 *      第一种：
 *      for(Iterator iterator = list.iterator();iterator.hasNext();){
 *          int i = (Integer) iterator.next();
 *          System.out.println(i);
 *      }
 *      第二种：
 *      Iterator iterator = list.iterator();
 *      while(iterator.hasNext()){
 *          int i = (Integer) iterator.next();
 *          System.out.println(i);
 *      }
 *      第三种：
 *      for (Object object : list) {
 *          System.out.println(object);
 *      }
 *      第四种：
 *      for(int i = 0 ;i<list.size();i++) {
 *          int j= (Integer) list.get(i);
 *          System.out.println(j);
 *      }
 *
 *数据元素是怎样在内存中存放的？
 *       主要有2种存储方式：
 *      1、顺序存储，Random Access（Direct Access）：
 *              这种方式，相邻的数据元素存放于相邻的内存地址中，整块内存地址是连续的。可以根据元素的位置直接计算出内存地址，直接进行读取。
 *              读取一个特定位置元素的平均时间复杂度为O(1)。正常来说，只有基于数组实现的集合，才有这种特性。Java中以ArrayList为代表。
 *      2、链式存储，Sequential Access：
 *              这种方式，每一个数据元素，在内存中都不要求处于相邻的位置，每个数据元素包含它下一个元素的内存地址。
 *              不可以根据元素的位置直接计算出内存地址，只能按顺序读取元素。读取一个特定位置元素的平均时间复杂度为O(n)。主要以链表为代表。
 *              Java中以LinkedList为代表。
 *
 * 每个遍历方法的实现原理是什么？
 *       1、传统的for循环遍历，基于计数器的：
 *              遍历者自己在集合外部维护一个计数器，然后依次读取每一个位置的元素，当读取到最后一个元素后，停止。主要就是需要按元素的位置来读取元素。
 *      2、迭代器遍历，Iterator：
 *              每一个具体实现的数据集合，一般都需要提供相应的Iterator。相比于传统for循环，Iterator取缔了显式的遍历计数器。所以基于顺序存储集合的Iterator可以直接按位置访问数据。而基于链式存储集合的Iterator，正常的实现，都是需要保存当前遍历的位置。然后根据当前位置来向前或者向后移动指针。
 *      3、foreach循环遍历：
 *              根据反编译的字节码可以发现，foreach内部也是采用了Iterator的方式实现，只不过Java编译器帮我们生成了这些代码。
 *
 * 各遍历方式对于不同的存储方式，性能如何？
 *      1、传统的for循环遍历，基于计数器的：
 *              因为是基于元素的位置，按位置读取。所以我们可以知道，对于顺序存储，因为读取特定位置元素的平均时间复杂度是O(1)，
 *              所以遍历整个集合的平均时间复杂度为O(n)。而对于链式存储，因为读取特定位置元素的平均时间复杂度是O(n)，
 *              所以遍历整个集合的平均时间复杂度为O(n2)（n的平方）。
 *                  ArrayList按位置读取的代码：直接按元素位置读取。
 *
 *                  transient Object[] elementData;
 *
 *                  public E get(int index) {
 *                      rangeCheck(index);
 *                      return elementData(index);
 *                  }
 *
 *                  E elementData(int index) {
 *                      return (E) elementData[index];
 *                  }
 *
 *
 *                  LinkedList按位置读取的代码：每次都需要从第0个元素开始向后读取。其实它内部也做了小小的优化。
 *
 *                  transient int size = 0;
 *                  transient Node<E> first;
 *                  transient Node<E> last;
 *
 *                  public E get(int index) {
 *                      checkElementIndex(index);
 *                      return node(index).item;
 *                  }
 *
 *                  Node<E> node(int index) {
 *                      if (index < (size >> 1)) {   //查询位置在链表前半部分，从链表头开始查找
 *                          Node<E> x = first;
 *                          for (int i = 0; i < index; i++)
 *                              x = x.next;
 *                          return x;
 *                      } else {                     //查询位置在链表后半部分，从链表尾开始查找
 *                          Node<E> x = last;
 *                          for (int i = size - 1; i > index; i--)
 *                              x = x.prev;
 *                          return x;
 *                      }
 *                  }
 *
 *       2、迭代器遍历，Iterator：
 *              那么对于RandomAccess类型的集合来说，没有太多意义，反而因为一些额外的操作，还会增加额外的运行时间。
 *              但是对于Sequential Access的集合来说，就有很重大的意义了，因为Iterator内部维护了当前遍历的位置，
 *              所以每次遍历，读取下一个位置并不需要从集合的第一个元素开始查找，只要把指针向后移一位就行了，这样一来，遍历整个集合的时间复杂度就降低为O(n)；
 *              （这里只用LinkedList做例子）LinkedList的迭代器，内部实现，就是维护当前遍历的位置，然后操作指针移动就可以了：
 *                  代码：
 *                  public E next() {
 *                      checkForComodification();
 *                      if (!hasNext())
 *                          throw new NoSuchElementException();
 *
 *                      lastReturned = next;
 *                      next = next.next;
 *                      nextIndex++;
 *                      return lastReturned.item;
 *                  }
 *
 *                  public E previous() {
 *                      checkForComodification();
 *                      if (!hasPrevious())
 *                          throw new NoSuchElementException();
 *
 *                      lastReturned = next = (next == null) ? last : next.prev;
 *                      nextIndex--;
 *                      return lastReturned.item;
 *                  }
 *
 *                  3、foreach循环遍历：
 *                          分析Java字节码可知，foreach内部实现原理，也是通过Iterator实现的，只不过这个Iterator是Java编译器帮我们生成的，
 *                          所以我们不需要再手动去编写。但是因为每次都要做类型转换检查，所以花费的时间比Iterator略长。时间复杂度和Iterator一样。
 *                  Iterator和foreach字节码如下：
 *                   //使用Iterator的字节码：
 *                          de:
 *                           0: new           #16                 // class java/util/ArrayList
 *                           3: dup
 *                           4: invokespecial #18                 // Method java/util/ArrayList."<init>":()V
 *                           7: astore_1
 *                           8: aload_1
 *                           9: invokeinterface #19,  1           // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
 *                          14: astore_2
 *                          15: goto          25
 *                          18: aload_2
 *                          19: invokeinterface #25,  1           // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
 *                          24: pop
 *                          25: aload_2
 *                          26: invokeinterface #31,  1           // InterfaceMethod java/util/Iterator.hasNext:()Z
 *                          31: ifne          18
 *                          34: return
 *
 *
 *                  //使用foreach的字节码：
 *                          Code:
 *                             0: new           #16                 // class java/util/ArrayList
 *                             3: dup
 *                             4: invokespecial #18                 // Method java/util/ArrayList."<init>":()V
 *                             7: astore_1
 *                             8: aload_1
 *                             9: invokeinterface #19,  1           // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
 *                            14: astore_3
 *                            15: goto          28
 *                            18: aload_3
 *                            19: invokeinterface #25,  1           // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
 *                            24: checkcast     #31                 // class loop/Model
 *                            27: astore_2
 *                            28: aload_3
 *                            29: invokeinterface #33,  1           // InterfaceMethod java/util/Iterator.hasNext:()Z
 *                            34: ifne          18
 *                            37: return
 *
 *
 * 各遍历方式的适用于什么场合？
 *      1、传统的for循环遍历，基于计数器的：
 *              顺序存储：读取性能比较高。适用于遍历顺序存储集合。
 *              链式存储：时间复杂度太大，不适用于遍历链式存储的集合。
 *      2、迭代器遍历，Iterator：
 *              顺序存储：如果不是太在意时间，推荐选择此方式，毕竟代码更加简洁，也防止了Off-By-One的问题。
 *              链式存储：意义就重大了，平均时间复杂度降为O(n)，还是挺诱人的，所以推荐此种遍历方式。
 *      3、foreach循环遍历：
 *              foreach只是让代码更加简洁了，但是他有一些缺点，就是遍历过程中不能操作数据集合（删除等），所以有些场合不使用。
 *              而且它本身就是基于Iterator实现的，但是由于类型转换的问题，所以会比直接使用Iterator慢一点，但是还好，时间复杂度都是一样的。
 *              所以怎么选择，参考上面两种方式，做一个折中的选择。
 *
 * Java的最佳实践是什么？
 *      Java数据集合框架中，提供了一个RandomAccess接口，该接口没有方法，只是一个标记。通常被List接口的实现使用，用来标记该List的实现是否支持Random Access。
 *      一个数据集合实现了该接口，就意味着它支持Random Access，按位置读取元素的平均时间复杂度为O(1)。比如ArrayList。
 *      而没有实现该接口的，就表示不支持Random Access。比如LinkedList。
 *      所以看来JDK开发者也是注意到这个问题的，那么推荐的做法就是，如果想要遍历一个List，那么先判断是否支持Random Access，
 *      也就是 list instanceof RandomAccess。
 *      比如：
 *      if (list instanceof RandomAccess) {
 *          //使用传统的for循环遍历。
 *      } else {
 *          //使用Iterator或者foreach。
 *      }
 * */
public class 使用指针遍历数据 {
}

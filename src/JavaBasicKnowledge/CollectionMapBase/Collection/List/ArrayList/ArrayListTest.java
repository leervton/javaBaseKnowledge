package JavaBasicKnowledge.CollectionMapBase.Collection.List.ArrayList;

import java.util.ArrayList;

/**
 * modCount(modify count 修改次数统计)：记录了ArrayList结构变化的次数
 */

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
            /*

            //ArrayList的默认构造方法
                public ArrayList() {
                    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
                }

            //DEFAULTCAPACITY_EMPTY_ELEMENTDATA;

                 private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

             */
        arrayList.add(1);

                /*
                //判断集合是否需要扩容？

                        // 添加单个元素,添加元素之前会先检查容量，如果容量不足则调用grow方法
                        public boolean add(E e) {
                            // 判断添加后的长度是否需要扩容
                            ensureCapacityInternal(size + 1);  // Increments modCount!!
                            // 然后在数组末尾添加当前元素，并且修改size的大小
                            elementData[size++] = e;
                            // 返回布尔值true
                            return true;
                        }

               ==========================================================================
                //按顺序执行代码【ensureCapacityInternal：确保内部内存】，检查添加数据后容量是否需要扩容

                        private void ensureCapacityInternal(int minCapacity) {
                            ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
                        }
                        elementData是存放元素的数组；
                        minCapacity=size + 1（size：当前元素个数）
                 ==========================================================================
                // 判断是否是第一次初始化数组【calculateCapacity：内存核算】
                private static int calculateCapacity(Object[] elementData, int minCapacity) {

                    // 判断当前数组是否等于空的数组
                    // 注意：这里的 DEFAULTCAPACITY_EMPTY_ELEMENTDATA 并不是 EMPTY_ELEMENTDATA，不过并无太大差别，
                            只是为了区分何时需要扩容而已
                    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {

                        // 取其中最大的值作为判断本次是否需要扩容的依据，由于第一次数组是空的，所以默认要使数组扩容到10的长度
                        return Math.max(DEFAULT_CAPACITY, minCapacity);
                    }
                    return minCapacity;
                }

                ================================================================================
                //再次执行
                        // 判断扩容的方法
                        private void ensureExplicitCapacity(int minCapacity) {

                                // 如果需要扩容modCount自增，这个参数是指当前列表的结构被修改的次数
                                modCount++;

                                // overflow-conscious code
                                // 判断当前数据量是否大于数组的长度，如果是，进行扩容
                                if (minCapacity - elementData.length > 0)
                                    // 执行扩容操作
                                    grow(minCapacity);
                         }

                //扩容方法
                        // grow扩容方法
                        private void grow(int minCapacity) {
                            // overflow-conscious code
                            // 记录扩容前的数组长度
                            int oldCapacity = elementData.length;

                            // 将原数组的长度扩大1.5倍作为扩容后数组的长度（如果扩容钱数组长度为10，
                                那么经过扩容后的数组长度应该为15）
                            // 这里涉及到异或运算，不懂的朋友可以看下这篇文章
                             https://blog.csdn.net/Woo_home/article/details/103146845
                            int newCapacity = oldCapacity + (oldCapacity >> 1);

                            // 如果扩容后的长度小于当前的数据量
                            if (newCapacity - minCapacity < 0)
                                //那么就将当前的数据量的长度作为本次扩容的长度
                                newCapacity = minCapacity;

                            // 判断新数组的长度是否大于可分配数组的最大值
                            if (newCapacity - MAX_ARRAY_SIZE > 0)
                                // 将扩容长度设置为最大可用长度
                                newCapacity = hugeCapacity(minCapacity);
                            // minCapacity is usually close to size, so this is a win:
                            // 拷贝，扩容，构建一个新的数组
                            elementData = Arrays.copyOf(elementData, newCapacity);
                        }
                        //可分配数组的最大值，grow方法调用的hugeCapacity源码

                //数组定义最大长度
                        //如果新数组长度超过当前数组定义的最大长度时
                        private static int hugeCapacity(int minCapacity)
                                // 抛出OOM异常
                                if (minCapacity < 0) // overflow
                                    throw new OutOfMemoryError();

                                // 将扩容长度设置为Integer.MAX_VALUE,也就是int的最大长度
                                return (minCapacity > MAX_ARRAY_SIZE) ?
                                    Integer.MAX_VALUE :
                                MAX_ARRAY_SIZE;
                        }
                //




                 */


    }
}

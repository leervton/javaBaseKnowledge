package HomeWork;

/**
 * 如何获取任何引用类存储的元素
 *      1.String类型和八种基本数据类型的toString方法和equals方法已经被写好了
 *      2.通过强转即可
 */
public class GetKey {
}
class Get{
    Integer i = new Integer(100);
    public static void getKey(Object o){
        if(o instanceof Integer){
            Integer integer = (Integer)o;
            integer.toString();
        }
    }

}
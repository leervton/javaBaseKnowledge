package NormalKnowledge.Base;
/**
 * 内存地址：可以使用hashcode简单的获取
 *
 * 物理地址：class或者getClass()
 * */
public class 地址 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.toString());
        System.out.println(a.hashCode());
        System.out.println(Integer.toHexString(a.hashCode()));
        System.out.println(a.getClass());
        System.out.println(A.class);
    }
}

class A{

}
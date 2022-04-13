package JavaBasicKnowledge.ChanglableArguements;
/**
 * 以下的例子不属于反射机制中的知识点，属于java基础语法
 *
 * （关于java中可变长参数）
 *          --可变长参数的语法规则
 *              类型...
 *                  例如：
 *                      Class...
 *                      int...
 *                      String...
 *                      byte...
 *          --可变长参数可以接收的参数个数
 *              0-N个
 *              但是类型有要求
 *          --如果方法中有一个方法的参数可以精确匹配，则不再执行可变长参数的方法
 *
 *          --可变长参数可以当作数组处理
 *
 *          --可变长参数在参数列表中只能有一个，并且只能在最后的位置上
 *
 * */
public class 可变长参数 {
    /**
     * @param args 可变长参数
     */
    public static void m1(int... args){
        System.out.println("m1执行了");
    }

    public static void m1(int a,int b){
        System.out.println(a+b);
    }

    //error
    /*public static void m2(int... a,int b){
        System.out.println(a+b);
    }*/

    //error
    /*public static void m2(String... a,int b){
        System.out.println(a+b);
    }*/

    public static void m2(String... strings){
        /*for (String s:strings){
            System.out.println(s);
        }*/

        for (int i = 0;i<strings.length;i++){
            System.out.println(strings[i]);
        }
    }
    public static void main(String[] args) {
        m1();
        m1(1);
        m1(1,2);
        m1(1,2,3);
        m1(12,3,5,67,6);

        m2("nihao","cheh");
    }
}

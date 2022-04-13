package JavaBasicKnowledge.Reflect.VariableArgs;
/*
可变长参数
        int... args这就是可变长度参数
        语法：类型... （注意：一定是3个点）

        1.可变长度参数要求的参数个数是：0-n个
        2.Vararg parameter must be the last in the list
          可变长参数必须在参数列表中的最后一个位置，而且只能出现一个
        3.可变长度参数可以当作一个数组来看待,也可以传一个数组进去
 */
public class ChangeableArgs {
    public static void main(String[] args) {
        m();
        m(1);
        m(22,2,22);
        m(22,22,22,4,4);
        m3("a","b","c","d");

        //也可以传一个数组进去
        String[] str = {"a","f","s"};
        m3(str);

        //直接传入一个数组
        m3(new String[]{"我","是","中","国","人"});
        m3("我","是","中","国","人");
    }
    public static void m(int... args){
        System.out.println("m方法执行了");
    }
    //public static void m2(String... args,int...arg){}
    public static void m2(String args,int...arg){}

    public static void m3(String... args){
        //args有length属性，说明args是一个数组！
        //可以将可变长度参数当作一个数组来看待
        for (int i = 0;i<args.length;i++){

        }
    }
}

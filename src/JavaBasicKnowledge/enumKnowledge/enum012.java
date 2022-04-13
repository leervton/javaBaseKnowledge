package JavaBasicKnowledge.enumKnowledge;

//采用枚举的方式改造程序

/**
 * 总结：
 *      1.枚举是一种引用数据类型
 *      2.枚举类型怎么定义？语法是？
 *          enum 枚举类型名称{
 *              枚举值1，枚举值2，枚举值3
 *          }
 *      3.结果只有两种情况建议使用布尔类型
 *
 */
public class enum012 {
    public static void main(String[] args) {
        Result r = divide012(10,0);
        System.out.println(r == Result.success?"计算成功":"计算失败");
    }

    public static boolean divide01(int a,int b){
        try {
            int c = a/b;
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * ---------------------------------利用枚举修改程序------------------------------
     * @param a
     * @param b
     * @return
     */
    public static Result divide012(int a,int b){
        try {
            int c = a/b;
            return Result.success;
        }catch (Exception e){
            return Result.fail;
        }
    }
}

//枚举：一枚一枚可以列举出来的，才建议使用枚举类型
//枚举编译之后也是生成class文件
//枚举也是一种引用数据类型
//枚举中的每一个值都可以看作常量
enum Result{
    //success是枚举Result类型中的一个值
    //fail是枚举Result类型中的一个值
    //枚举中的每一个值，可以看作是“常量”
    success,fail
}
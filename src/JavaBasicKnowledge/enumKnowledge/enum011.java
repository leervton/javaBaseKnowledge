package JavaBasicKnowledge.enumKnowledge;
//这个代码，在设计方面有什么缺陷？
/*
    以下代码可编译也可以运行，但会出现误操作，写程序的时候，可能程序员手贱把返回值1改成了1000
    导致 System.out.println(retValue == 1?"计算成功":"计算失败");
    永远输出计算失败，程序直接出bug
    【解决办法】不要返回int类型，最好返回布尔类型，因为布尔类型只有false和true两种类型，直接写死
 */
public class enum011 {
    public static void main(String[] args) {
        int retValue = divide(10,2);
        System.out.println(retValue == 1?"计算成功":"计算失败");

        boolean success = divide01(10,0);
        System.out.println(success?"计算成功":"计算失败");

    }

    /**
     * 计算两个int类型数据的商，如果计算成功返回1，计算失败返回0
     * 但以下虽然返回的是int类型，但写程序的时候，可能程序员手贱把返回值1改成了1000
     * 导致 System.out.println(retValue == 1?"计算成功":"计算失败");
     * 永远输出计算失败，程序直接出bug
     * 【解决办法】不要返回int类型，最好返回布尔类型
     *
     * @param a int类型的被除数
     * @param b int类型的除数
     * @return 返回1表示成功，返回0表示失败
     */
    public static int divide(int a,int b){
       try {
           int c = a/b;
            //程序执行到此处说明以上代码没有发生异常，表示执行成功
           return 1;
       }catch (Exception e){
           //当b=0时，int c = a/b，这个程序不报错出异常，异常（可运行，但无解，只能报异常）
           //除数为0的异常，java.lang.ArithmeticException: / by zero
           //如果try代码块出现异常，则执行此处代码块的代码！
           return 0;
       }
    }

    /**
     * 【---------------------------------修改之后的优化代码--------------------------------------------------】
     * @param a
     * @param b
     * @return
     */
    public static boolean divide01(int a,int b){
        try {
            int c = a/b;
            //程序执行到此处说明以上代码没有发生异常，表示执行成功
            return true;
        }catch (Exception e){
            //当b=0时，int c = a/b，这个程序不报错出异常，异常（可运行，但无解，只能报异常）
            //除数为0的异常，java.lang.ArithmeticException: / by zero
            //如果try代码块出现异常，则执行此处代码块的代码！
            return false;
        }
    }
    /**
     * 【------------------思考----------------------------------------------------------------------------】
     * 以后开发的时候有没有可能，
     * 一个方法执行的结果可能包括有一种情况，三种情况，四种情况以及多种情况，
     * 但每一个情况都是可以列举出来的，即一个一个地枚举出来，
     * 此时布尔类型无法满足需求，可以使用java语言中的枚举类型
     */
}

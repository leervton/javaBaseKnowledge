package JavaBasicKnowledge.ExceptionKnowledge.TryCatch;

/**
 * finally面试题
 */
public class TryCatchLogicError {
    public static void main(String[] args) {
        int result = m();
        System.out.println(result);
    }
    /*
        java语法规则（有一些规则是不能破坏的，一旦这么说，就必须这么做！）：
            java中有一条这样的规则：
                方法体中的代码必须遵循自上而下的顺序，依次逐行执行，这是亘古不变的语法！
            java中还有一条语法规则：
                return语句一旦执行，整个方法必须结束，这也是亘古不变的语法！所以return语句一定是最后执行的！！！

     */
    public static int m(){
        int i = 100;
        try{
            //这行代码按照由上到下依次逐行的原则，必须返回i=100
            // 但是执行了return语句，整个方法就结束了，finally就无法执行到了
            //finally按照语法要求必须执行，这样产生了逻辑冲突
            return i;
        }finally {
            i++;
        }
    }
    /**
     * --------------反编译------------------------------------
     * public static int m(){
     *      int i = 100;
     *      int j = i;
     *      i++;
     *      return j;
     *}
     * 这里为了使代码符合Java语法规则，底层代码取了临时变量，修改了源代码
     */
}

package JavaBasicKnowledge.ExceptionKnowledge.TryCatch;

/**
 * finally语句
 */
public class TryCatch01 {
    public static void main(String[] args) {
        /*
        try 和 finally,没有catch可以吗？可以
        try不能单独使用

        以下代码的执行顺序：
            先执行try....
            再执行finally....
            最后执行return.....
            return执行，方法必然结束
        */
        try{
            System.out.println("try.....");
            return;//结束方法
        }finally {
            System.out.println("finally.....");
        }

        //这里不能写语句，因为这个代码是无法执行到的
        //System.out.println();
    }
}

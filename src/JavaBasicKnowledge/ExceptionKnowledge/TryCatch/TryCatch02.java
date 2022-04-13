package JavaBasicKnowledge.ExceptionKnowledge.TryCatch;
/*
    finally
 */

public class TryCatch02 {
    public static void main(String[] args) {
        try {
            System.out.println("try.....");

            System.exit(0);//退出jvm,finally之后的代码就不执行了，唯一的一种情况
        }finally {
            System.out.println("finally.....");
        }
    }
}

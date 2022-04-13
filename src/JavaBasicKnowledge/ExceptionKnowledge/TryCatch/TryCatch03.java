package JavaBasicKnowledge.ExceptionKnowledge.TryCatch;

public class TryCatch03 {
    public static void main(String[] args) {
       math m = new math();
        try {
            m.divide(10,0);
        }catch (MyDesignException e) {
            System.out.println(e.getMessage());
        }

    }
}

//创建计算类
class math{
   public static void divide(int a,int b) throws MyDesignException {
       if (b!=0){
           System.out.println(a/b);
       }else if(b == 0){
           throw new MyDesignException("除数不能为0");
       }
   }
}

//创建异常类
class MyDesignException extends Exception{

    public MyDesignException() {
    }

    public MyDesignException(String message) {
        super(message);
    }
}

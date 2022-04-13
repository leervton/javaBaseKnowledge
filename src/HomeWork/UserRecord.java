package HomeWork;

/**编写程序模拟用户注册：
 *          1.程序执行时，提醒用户输入“用户名”和“密码”信息
 *          2.输入信息之后，后台java程序模拟用户注册
 *          3.注册时，用户名字要求长度在6-14之间，小于或大于都表示异常
 * 注意：
 *      完成注册的方法放到单独的一个类中
 *      异常类自定义即可
 */

public class UserRecord {
    public static void main(String[] args) {
        new Input();
    }
}
class Input{
    public Input() {
        InputName();
    }
    //键盘输入用户名和密码
    public static void InputName(){
        String[] e = new String[20];
        int[] k = new int[10];
        UserRecordMethod m = new UserRecordMethod();
        //创建一个键盘扫描器对象
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.println("请输入用户名，只能使用汉字，字母");
        String countName = "用户名：";
        //接收用户的输入，从键盘上接受一个String类型的对象，并存入数组中
        for (int i = 0;i<20;i++){
            e[i] = s.next();
            try {
                m.UserLength(e);
                countName += e[i];
                System.out.println(countName);
            } catch (NormalException ex) {
                System.out.println(ex.getMessage());;
            }
        }
        String countPassWord ="密码：";
        System.out.println("请输入密码，只能用数字：");
        for (int i = 0; i<10;i++){
            k[i] = s.nextInt();
            countPassWord = countPassWord +""+e[i];
        }
    }
}

class  UserRecordMethod{
    public static int SearchNotNull(String[] e){
        int count = 0;
        for (int k = 0;k<e.length;k++){
            if(e[k] == null){
                count++;
            }
        }
        return e.length - count;
    }
    public static void UserLength( String[] e) throws NormalException {
        if (SearchNotNull(e) ==0){
            throw new NormalException("用户名不能为空");
        }else if (SearchNotNull(e)<6||SearchNotNull(e)>14){
            throw new NormalException("用户名长度应在6-14之间");
        }
    }
}

class NormalException extends Exception{
    public NormalException() {
    }

    public NormalException(String message) {
        super(message);
    }
}

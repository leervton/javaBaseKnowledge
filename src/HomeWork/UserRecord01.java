package HomeWork;
/**编写程序模拟用户注册：
 *          1.程序执行时，提醒用户输入“用户名”和“密码”信息
 *          2.输入信息之后，后台java程序模拟用户注册
 *          3.注册时，用户名字要求长度在6-14之间，小于或大于都表示异常
 * 注意：
 *      完成注册的方法放到单独的一个类中
 *      异常类自定义即可
 */
public class UserRecord01 {
    public static void main(String[] args) {
        //创建UserService对象
        UserService user = new UserService();
        try {
            user.register("小明","123");
        } catch (IllegalNameException e) {
            System.out.println(e.getMessage());
        }

    }
}
class UserService{
    public void register(String name,String password) throws IllegalNameException {
        /**
         *1.null判断最好放在所有条件的最前面！
         *
         *2.null判断最好这样写：null == name;而不是name==null
         *
         *3."abc".equals(name)比name.equals("abc")好！因为如果变量name为null，可以避免空指针异常
         *
         * 这里我们应该注意，如果首先不对String name是否为null进行判断的话，容易发生空指针异常
         * 如果name =null，这时候name.length就会变成null.length，即发生空指针异常
         */
        if(name ==null||name.length()<6||name.length()>14){
            throw new IllegalNameException("非法用户名，用户名应该在6-14");
        }
        //执行到此处，表示用户名注册成功
        System.out.println("注册成功，欢迎"+name);
    }
}
class IllegalNameException extends Exception{
    public IllegalNameException() {

    }

    public IllegalNameException(String message) {
        super(message);
    }


}
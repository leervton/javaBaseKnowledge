package JavaBasicKnowledge.Reflect.entity;
/**
 * 系统服务类
 * */
public class _05_SystemService {
    public boolean login(String username,String userland){
        return "admin".equals(username)&&"123".equals(userland);
    }

    public void login(){}
    public void login(int a,double b){}
    public void login(char a,String b,int c){}
    public void login(int c,char a,String b){}


    public void logout(){
        System.out.println("系统已安全退出");
    }
}

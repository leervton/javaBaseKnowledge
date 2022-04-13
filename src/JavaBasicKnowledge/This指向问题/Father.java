package JavaBasicKnowledge.This指向问题;

public class Father {
    //service方法出现this指向指向调用service方法实例对象
    public void service(String method){
        if ("get".equals(method)){
            this.doGet();
        }else if ("post".equals(method)){
            this.doPost();
        }
    }
    public void doGet(){
        System.out.println("father doGet is running.....");
    }
    public void doPost(){
        System.out.println("father doPost is running.....");
    }
}

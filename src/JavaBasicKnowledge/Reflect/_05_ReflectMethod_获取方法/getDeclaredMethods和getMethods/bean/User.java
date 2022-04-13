package JavaBasicKnowledge.Reflect._05_ReflectMethod_获取方法.getDeclaredMethods和getMethods.bean;

public class User extends Person {
    public void publicMethod() {

    }

    private void privateMethod(){
    }


    protected void protectedMethod(){

    }

    void defaultMethod(){

    }

    public User(){}

    public User(String name,int age){
        System.out.println(name+"今年"+age+"岁");
    }

}

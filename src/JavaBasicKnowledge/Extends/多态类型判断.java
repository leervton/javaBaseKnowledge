package JavaBasicKnowledge.Extends;


//利用的Class来判断即可
public class 多态类型判断 {
    public static void main(String[] args) {
        father f = new son();
        //getClass和class获取的Class类并不一样
        System.out.println(f.getClass());//class JavaBasicKnowledge.Extends.son
        System.out.println(father.class);//class JavaBasicKnowledge.Extends.father
    }
}

class father{
    public void doSome(){
        System.out.println("father do things");
    }
}

class son extends father{
    @Override
    public void doSome() {
        System.out.println("son do things");
    }
}

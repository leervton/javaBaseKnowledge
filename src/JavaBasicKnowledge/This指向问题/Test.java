package JavaBasicKnowledge.This指向问题;

public class Test {
    public static void main(String[] args) {
        Son01 son01=new Son01();
        son01.service("get");
        Son02 son02=new Son02();
        son02.service("get");
    }
}
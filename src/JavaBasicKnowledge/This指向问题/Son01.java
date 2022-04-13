package JavaBasicKnowledge.This指向问题;

public class Son01 extends Father {
    @Override
    public void doGet() {
        System.out.println("son doGet is running...");
    }

    @Override
    public void doPost() {
        System.out.println("son doPost is running...");
    }
}

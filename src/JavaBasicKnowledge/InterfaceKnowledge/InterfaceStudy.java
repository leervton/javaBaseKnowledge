package JavaBasicKnowledge.InterfaceKnowledge;

/**
 * 研究子类实现接口后，父类和接口的关系
 */

public class InterfaceStudy {
}

interface Run{
    void run();
}
class Vehicle {

}

class Bike extends Vehicle implements Run{
    @Override
    public void run() {

    }
}


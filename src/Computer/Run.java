package Computer;

public class Run {
    public static void main(String[] args) {
        Mouse mouse1 = new Mouse();

        Computer computer = new Computer(mouse1);
        computer.peiJian();
    }
}

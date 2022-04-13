package JavaBasicKnowledge.number;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        //随机产生随机数的类
        Random r = new Random();
        //随机产生一个int类型取值范围内的数字
        int num = r.nextInt();

        System.out.println(num);

        //随机产生[0-100]之间的随机数，不能产生101，而不是[1-101]，
        r.nextInt(101);
    }
}

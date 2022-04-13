package JavaBasicKnowledge.loop;

public class label标签 {
    public static void main(String[] args) {
        //用label标签来标识循环，可以跳出指定的循环
        // 此处添加一个标签，标签名自定义
        label: for (int i = 0; 1 < 10; i++) {

            for (int j = 0; j < 5; j++) {

                System.out.println("i=" + i + "\tj=" + j);

                if (j == 2) {
                    break;// 此处break只能跳出里面的一层；
                }

                if (i == 5) {
                    break label; // 此处break跳出的是外面的循环
                }

            }

        }
    }
}

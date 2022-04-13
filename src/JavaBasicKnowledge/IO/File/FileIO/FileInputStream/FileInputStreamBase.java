package JavaBasicKnowledge.IO.File.FileIO.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java.io.FileInputStream
 *      1.文件字节输入流，万能的，任何类型的文件都可以采用这个流来读
 *      2.字节的方式，完成输入的操作，完成读的操作（从硬盘----->内存）
 *      3.
 */
public class FileInputStreamBase {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            //创建文件字节输入流对象
            //文件路径：C:\Users\Administrator\Desktop\java\temp（IDEA会自动把\编程\\，因为java中\表示转义）
            //以下都是采用了绝对路径的方式
            //FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\java\\temp");
            //写成这个/也是可以的
            fis = new FileInputStream("C:/Users/Administrator/Desktop/java/temp");

            //开始读
            int readData = fis.read();//这个方法的返回值是：读取到的字节本身的ASC码
            System.out.println(readData);//a：97

            readData = fis.read();
            System.out.println(readData);//a：97

            readData = fis.read();
            System.out.println(readData);//a：97

            readData = fis.read();
            System.out.println(readData);//a：97

            readData = fis.read();
            System.out.println(readData);//a：多余的13代表换行

            readData = fis.read();
            System.out.println(readData);//a：多余的10代表回车

            //当读取不到任何数据时返回-1
            readData = fis.read();
            System.out.println(readData);//a：-1



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //在finally语句块当中确保流一定关闭
            if (fis!=null){
                //关闭流的前提是：流不是空，流是null没必要关闭。避免了空指针异常
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

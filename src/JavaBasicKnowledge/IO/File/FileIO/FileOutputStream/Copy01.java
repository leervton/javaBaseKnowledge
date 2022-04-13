package JavaBasicKnowledge.IO.File.FileIO.FileOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 复制文件
 *      先把文件Input输入内存之中，然后由内存Output输出写入硬盘
 *      使用FileInputStream+FileOutputStream完成文件内容的拷贝
 *      拷贝的过程应该是一边读一边写
 *      使用以上的字节流拷贝文件的时候，文件的类型随意，字节流是万能的，什么样的文件都能拷贝
 */
public class Copy01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建一个输入流对象
            fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\java\\图吧工具箱2019自动解压程序.exe");
            //创建一个输出流对象
            fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\java\\001\\图吧工具箱2019自动解压程序.exe");
            //最核心的内容：一边读一边写
            //如果无访问权限，说明输出流对象只写到了文件目录那C:\Users\Administrator\Desktop\java\001
            // 并没有写完C:\Users\Administrator\Desktop\java\001\图吧工具箱2019自动解压程序.exe
            byte[] bytes = new byte[1024*1024];//一次拷贝1MB
            int readCount = 0;
            while((readCount = fis.read(bytes))!=-1){
                fos.write(bytes,0,readCount);
            }

            //=======注意！输出流最后要刷新==================================================
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //要分开try，不要一起try；一起try时
            // 其中一个报异常后，会进入catch语句块导致另一个异常不会执行，影响了另一个流的关闭
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

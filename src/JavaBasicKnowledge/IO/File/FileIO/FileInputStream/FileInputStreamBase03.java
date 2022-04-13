package JavaBasicKnowledge.IO.File.FileIO.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 最终版
 */
public class FileInputStreamBase03 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\java\\temp");
            //准备一个byte数组
            byte[] bytes = new byte[4];
            /*
            while (true){
                int readCount = fis.read(bytes);
                if (readCount == -1){
                    break;
                }
                System.out.print(new String(bytes,0,readCount));
            }*/
            //while循环修改
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1){
                System.out.print(new String(bytes,0,readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!= null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package JavaBasicKnowledge.IO.File.FileIO.FileWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 使用FileReader，FileWriter进行拷贝的话，只能拷贝普通文本文件
 *
 */
public class Copy02 {
    public static void main(String[] args) {
        FileReader fir = null;
        FileWriter fiw = null;
        try {
            //读
            fir = new FileReader("");
            //写
            fiw = new FileWriter("");
            char[] chars = new char[1024*512];
            //一边读一边写
            int readCount =0;
            while ((readCount=fir.read(chars))!=-1){
                //读多少，写多少
                fiw.write(chars,0,readCount);
            }
            //刷新
            fiw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           if (fir!=null){
               try {
                   fir.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (fiw!=null){
               try {
                   fiw.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
    }
}

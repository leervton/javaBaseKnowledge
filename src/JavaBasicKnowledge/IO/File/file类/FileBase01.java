package JavaBasicKnowledge.IO.File.file类;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File类常用方法
 */
public class FileBase01 {
    public static void main(String[] args) {
        File file = new File("E:\\360驱动大师目录\\下载保存目录\\audio_realtek_6.0.8899.1_w71064.zip");
        //获取文件名
        System.out.println("文件名"+file.getName());

        //判读是否是一个目录？
        System.out.println(file.isDirectory());//false
        //判断是否是一个文件？
        System.out.println(file.isFile());//true

        //获取文件最后一次修改时间
        long modifyTime = file.lastModified();//这个毫秒是从1970年到现在的总毫秒数
        //将总毫秒数转换成日期
        Date date = new Date(modifyTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss SSS");
        String str = sdf.format(date);
        System.out.println(str);

        //获取文件大小,显示的是字节
        System.out.println(file.length());
    }
}

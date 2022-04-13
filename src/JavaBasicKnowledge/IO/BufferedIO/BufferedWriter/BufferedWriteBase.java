package JavaBasicKnowledge.IO.BufferedIO.BufferedWriter;
import java.io.*;

/**
 * bufferedWrite:带有缓冲的字符输出流
 */
public class BufferedWriteBase {
    public static void main(String[] args) throws Exception {
        //带有缓冲区的字符输出流
        //BufferedWriter bw = new BufferedWriter(new FileWriter(""));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("",true)));
        bw.write("copy");
        bw.write("\n");
        bw.write("hello");
        //刷新
        bw.flush();
        //关闭最外层
        bw.close();
    }
}

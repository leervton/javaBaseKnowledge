package JavaBasicKnowledge.IO.BufferedIO.BufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *BufferedReader：
 *      带有缓冲区的字符输入流，
 *      使用这个流的时候不需要自定义char数组或者说不需要自定义byte数组，自带缓冲
 */
public class BufferedReaderBase {
    public static void main(String[] args) throws Exception {
        FileReader fir = new FileReader("");
        //当一个流的构造方法中需要一个流的时候，这个被传进来的流被叫做：节点流
        //外部负责包装的这个流，叫做：包装流，还有一个名字叫：处理流
        //像当前这个程序来说，FileReader就是一个节点流，BufferReader就是包装流/处理流
        BufferedReader br = new BufferedReader(fir);
        /*
        //读一行
        String firstLine = br.readLine();
        System.out.println(firstLine);

        String secondLine = br.readLine();
        System.out.println(secondLine);

        String thirdLine = br.readLine();
        System.out.println(thirdLine);
         */
        //br.readLine()方法读取一个文本行，但不带换行符
        String s = null;
        while((s=br.readLine())!=null){
            System.out.println(s);
        }
        //关闭流
        //对于包装流来说，只需要关闭最外层流就行，里面的节点流会自动关闭（可以看源代码）
        br.close();
    }
}

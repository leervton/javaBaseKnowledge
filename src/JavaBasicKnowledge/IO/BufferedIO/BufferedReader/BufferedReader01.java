package JavaBasicKnowledge.IO.BufferedIO.BufferedReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BufferedReader01 {
    public static void main(String[] args) throws Exception {
       /* //字节流
        FileInputStream fis = new FileInputStream("");
        //通过转换流转换
        //fis是节点流，isr是包装流
        InputStreamReader isr = new InputStreamReader(fis);

        //这个构造方法只能传一个字符流，不能传一个字节流；但可以把字节流通过转换流转换成字符流，然后传进包装流内
        //isr是节点流，br是包装流，所以节点流和包装流是相对而言的
        BufferedReader br = new BufferedReader(isr);*/

        //合并写法
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("")));
        String line =null;
        while((line = br.readLine())!=null){
            System.out.println(line);
        }

        //关闭最外层
        br.close();
    }
}

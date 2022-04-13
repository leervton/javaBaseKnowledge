package JavaBasicKnowledge.IO.DataIO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * java.io.DataOutputStream:数据专属流
 * 这个流可以将数据连同数据类型一并写入文件
 * 注意：这个文件不是普通文档（这个文件用记事本打不开，所以是非普通文档）
 */
public class DataOutputStreamBase {
    public static void main(String[] args) throws Exception{
        //创建数据专属的字节输出流
        DataOutputStream dos =new DataOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\java\\data"));
        //写数据
        byte b =100;
        short s =200;
        int i = 100;
        long l = 200l;
        float f =3.0f;
        double d = 3.14;
        boolean b1 = false;
        char c = 'a';
        //写,把数据以及数据类型一并写入到文件当中
        dos.writeByte(b);
        dos.writeShort(s);
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.writeBoolean(b1);
        dos.writeChar(c);
        //刷新
        dos.flush();
        //关闭最外层
        dos.close();
    }
}

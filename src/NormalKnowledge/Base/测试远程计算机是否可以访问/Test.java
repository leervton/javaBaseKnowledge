package NormalKnowledge.Base.测试远程计算机是否可以访问;

import java.io.IOException;
import java.net.InetAddress;

public class Test {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String host = "124.221.63.51";
        int timeOut = 3000; //超时应该在3钞以上
        boolean status = InetAddress.getByName(host).isReachable(timeOut);
        //当返回值是true时，说明host是可用的，反正则不可。
        //使用时应注意，如果远程服务器设置了防火墙或相关的配制，可能会影响到结果，也是无法避免的
        //另外，由于发送ICMP请求需要程序对系统有一定的权限，当这个权限无法满足时，isReachable方法将试着连接远程主机的TCP端口7(Echo).
        System.out.println(status);
    }
}

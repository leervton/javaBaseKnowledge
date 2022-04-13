package NormalKnowledge.Base;
//我们现实生活中需要字符串进行动态变化，这时候除了""+username+""这种
public class 字符串动态变化解决方案 {
    public static void main(String[] args) {
        int a = 1000;
        Object key01 = null;
        //==========================
        String key= a+"";
        String key02= key01 +"";
        System.out.println(key);
        System.out.println(key02);
    }
}

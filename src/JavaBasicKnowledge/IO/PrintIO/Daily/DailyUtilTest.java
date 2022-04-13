package JavaBasicKnowledge.IO.PrintIO.Daily;

import JavaBasicKnowledge.IO.PrintIO.Daily.DailyUtil;

public class DailyUtilTest {
    public static void main(String[] args) {
        //测试工具类是否好用
        DailyUtil.log("调用了System类的gc()方法,建议启动垃圾回收");
        DailyUtil.log("调用了UserService的doSome()方法");
        DailyUtil.log("用户尝试登录，验证失败");
        DailyUtil.log("我非常喜欢这个记录日志的工具哟！");
    }
}

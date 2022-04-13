package JavaBasicKnowledge.Reflect._02_ReflectAdvance01;

import JavaBasicKnowledge.Reflect.entity._05_SystemService;

public class _05_不使用反射机制调用对象的方法 {
    public static void main(String[] args) {
        //不使用反射机制调用对象的方法
        _05_SystemService sy = new _05_SystemService();
        //直接调用方法即可
        boolean success = sy.login("admin", "123");

        System.out.println(success?"登录成功":"登陆失败");

        /**
         * 以上代码存在的问题是:
         *                      类固定了
         *                      方法名固定了
         *                      参数固定了
         * 导致不可扩展
         * 所以最好使用反射机制进行调用，反射机制调用的时候，类名可以配置到配置文件中
         * 方法名也可以配置到配置文件中，参数也可以配置到配置文件中
         * 反射的缺点是，程序复杂不好实现，另外操作字节码效率比较低下
         * */
    }
}

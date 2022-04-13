package JavaBasicKnowledge.ClassNote;

import static java.lang.Math.floorMod;

public class Test07 {
    public static void main(String[] args) {
        /**
         * 对于整数a，b来说，取模运算和取余运算的过程相同：
         * 求整数商：c=a/b
         * 计算模或者余数：r=a−c×b
         * 只是取模和取余在第一步求商的方法上有所不同：
         * 取余运算在取c的值时，向 0 方向舍入( fix() 函数)
         * 而取模运算在计算 c的值时，向负无穷方向舍入( floor() 函数)。
         * ..........................................................................................
         * 对于整数a,b来说，取余和取模都有着下面这个关系：
         * 1：求整数的商 c = a / b
         * 2：计算模或者余数 r = a - c * b
         * 取余和取模的不同之处就是在c这里的不同
         * 取余运算我们是尽可能的向0方向舍去小数位，比如-1/3是-0.33333，我们就取c为0，然后计算r = -1 - 0 * 3，即r为-1；
         * 取模运算是尽可能向负无穷的方向舍去小数位，比如-1/3是-0.33333，我们就取c是-1，然后计算r = -1 - ( -1) * 3，及c是2。
         * ..................................................................................................
         * 下面我们再举一个例子 -7 % 4
         *
         * 1.这里a是-7， b是4，我们计算-7 / 4 = -1.75 
         *
         * 2.取余：尽可能向0舍去小数位，即c取-1 
         *
         *    取模：尽可能向负无穷舍去小数位，即c取-2
         *
         * 3.取余：r = -7 - (-1) * 4，即 r 为 -3
         *
         *    取模：r = -7 - (-2) * 4，即 r 为1
         *
         * 下面我们再举一个例子 7 % -4
         *
         * 1.这里a是7， b是-4，我们计算7 / -4 = -1.75 
         *
         * 2.取余：尽可能向0舍去小数位，即c取-1
         *
         *   取模：尽可能向负无穷舍去小数位，即c取-2
         *
         * 3.取余：r = 7 - (-1) * (-4)，即 r 为 3
         *
         *   取模：r = 7 - (-2) * (-4)，即 r 为-1
         */
        System.out.println("------Complementarity------");
        System.out.println(7 % 4);
        System.out.println((-7) % 4);
        System.out.println(7 % (-4));
        System.out.println((-7) % (-4));

        System.out.println();
        System.out.println("------Modulo Operation------");
        System.out.println(floorMod(7, 4));
        System.out.println(floorMod(-7, 4));
        System.out.println(floorMod(7, -4));
        System.out.println(floorMod(-7, -4));

    }
}

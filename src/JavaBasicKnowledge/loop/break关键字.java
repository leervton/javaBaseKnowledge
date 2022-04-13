package JavaBasicKnowledge.loop;

public class break关键字 {
    public static void main(String[] args) {
        /**
         * break语句的作用。
         *
         *      只能在循环体内和switch语句体内使用break语句。
         *      当break出现在循环体中的switch语句体内时，其作用只是跳出该switch语句体。
         *      当break出现在循环体中，但并不在switch语句体内时，则在执行break后，跳出本层循环体,注意不是外层循环。
         *      在循环结构中，应用break语句使流程跳出本层循环体，从而提前结束本层循环。
         *
         * */
        //不加label标签的break跳出1层,比如
        for(int i = 0;i<4;i++){
            //跳出这一层循环
            for(int k = 0;k<3;k++){
                break;
            }
        }

        //加label标签的break可以跳出指定循环,比如
        // 设置一个label标记 使用带此标记的break语句跳出指定循环体
        OK: for(int i=1;i<100;i++){   //让i循环99次
            for(int j=1;j<=i;j++){
                if(i==10){
                    break OK ;
                }
                System.out.print(i + "*" + j + "=" + i*j) ;
                System.out.print(" ") ;
            }
            System.out.println() ;
        }
    }
}

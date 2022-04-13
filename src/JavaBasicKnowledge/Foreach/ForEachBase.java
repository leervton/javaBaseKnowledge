package JavaBasicKnowledge.Foreach;

/**
 * JDK5.0之后推出的一个新特性：叫做增强for循环，或者叫foreach
 */
public class ForEachBase {
    public static void main(String[] args) {
        int[] arr ={432,567,1,2,58,96};

        //循环遍历(普通for循环)
        for (int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        //增强for循环（foreach）
        //语法格式
        /*
        for (元素类型 变量名：数组或集合){
            System.out.println(变量名);
        }
       */
        System.out.println("=============================================");
        //foreach有一个缺点：没有下标，在需要使用下标的循环中不建议使用譬如
        //System.out.println(arr[i]+"结果");
        for(int data: arr){
            //data就是数组中的元素(数组中的每一个元素)
            System.out.println(data);
        }
    }
}

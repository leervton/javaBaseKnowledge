package JavaBasicKnowledge.Annotation注释.AnnotationStudy07;

import java.lang.reflect.Field;

/**
 * 注解在开发中有什么用？
 *      需求：
 *          假设有这样的一个注解，叫做：@ID
 *          这个注解只能出现出现在类上面，当这个类上有这个注解的时候
 *          要求这个类中必须有一个int类型的id属性，如果没有这个属性
 *          就报异常，如果有这个属性则正常执行
 */
public class AnnotationApply {
    public static void main(String[] args) throws Exception {
        //JVM装载类，获取类
        Class classUser = Class.forName("JavaBasicKnowledge.Annotation注释.AnnotationStudy07.AnnotationApply");
        //判断类上是否有注解
        boolean isRight = false;//给一个标记
        if (classUser.isAnnotationPresent(Id.class)){
            //当一个类上面有@Id注解的时候，要求类中必须存在int类型的id属性
            //如果没有int类型的id属性则报异常
            Field[] fields = classUser.getFields();
            for (Field field:fields){
                if ("Id".equals(field.getName())&&"int".equals(field.getType().getSimpleName())){
                    //表示这个类是合法的类，有@Id注解，则这个类中必须有int类型的id
                    isRight = true;
                    break;
                }
            }
        if (!isRight){
            throw new LackOfIdException("被Id注解标注的类中必须要有一个int类型的Id属性！");
        }

        }

    }
}

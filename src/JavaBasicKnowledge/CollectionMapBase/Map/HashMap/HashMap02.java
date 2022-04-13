package JavaBasicKnowledge.CollectionMapBase.Map.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap集合key部分允许为null吗？
 */
public class HashMap02 {
    public static void main(String[] args) {
        Map map = new HashMap();
         //HashMap集合允许key部分为null
        map.put(null,null);
        System.out.println(map.size());//1

        map.put(null,100);//相同的key被覆盖，元素只有1个
        System.out.println(map.get(null));//100
    }
}

package JavaBasicKnowledge.CollectionMapBase.Map.HashMap;

import java.util.Objects;

public class Production {
    private int id;
    private String name;
    //构造器
    public Production() {
    }

    public Production(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //重写equals和hashCode方法
    //假设业务要求：商品编号相同，并且商品名字相同表示同一个商品
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Production)) return false;
        Production that = (Production) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

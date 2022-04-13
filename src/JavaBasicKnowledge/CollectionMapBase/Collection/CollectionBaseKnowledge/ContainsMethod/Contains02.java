package JavaBasicKnowledge.CollectionMapBase.Collection.CollectionBaseKnowledge.ContainsMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Contains02 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(new String("jack"));
        c.add(new Name("Jack"));
        System.out.println(c.contains("jack"));//true
        System.out.println(c.contains("Jack"));//false


    }
}
class Name{
    private String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }
}
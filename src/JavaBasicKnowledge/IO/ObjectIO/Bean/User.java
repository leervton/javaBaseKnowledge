package JavaBasicKnowledge.IO.ObjectIO.Bean;

import java.io.Serializable;
import java.util.Objects;

public class User implements Comparable<User>, Serializable {
    private String name;
    private int age;
    private int no;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                no == user.no &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, no);
    }

    public User() {
    }

    public User(String name, int age, int no) {
        this.name = name;
        this.age = age;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", no=" + no +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}

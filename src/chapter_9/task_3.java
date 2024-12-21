package chapter_9;

import java.util.Objects;

public class task_3 {
    public static void main(String[] args) {
    BB b = new BB(20);
    BB d = new BB(20);
    BB e = new BB(25);
    BB l = new BB(22);
        System.out.println(b.equals(d));
        System.out.println(e.equals(l));
    }
}

abstract class AA {
    abstract int getAge();

}

class BB extends AA{
    private int age;

    BB(int age){
        this.age = age;
    }
    @Override
    int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BB bb = (BB) o;
        return age == bb.age;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(age);
    }
}

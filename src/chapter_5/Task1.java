package chapter_5;

public class Task1 {
    public static void main(String[] args) {
    A a = new A(20);
    B b = new B(10);

        System.out.println(a.getAge());
        System.out.println(b.getAge());
    }
}

class A{
    private int age;

    public A(int age) {
        this.age = age;
    }

    protected int getAge() {
        return age;
    }
}

class B extends A{

    public B(int age) {
        super(age);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }
}
package chapter_11;

public class GetIndexTask {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        A a4 = new A();

        System.out.println(a2.getIndex());
        System.out.println(a1.getIndex());
        System.out.println(a2.getIndex());
        System.out.println(a3.getIndex());
        System.out.println(a4.getIndex());
    }
}

class A{
    private int increment;
    static int counter;

    public A(){
        this.increment = ++counter;
    }
    public int getIndex(){
        return increment;
    }
}
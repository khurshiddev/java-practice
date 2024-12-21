package chapter_9;

public class task_1 {
    public static void main(String[] args) {
        B b = new B(20);
        b.maydon();
    }

}

class A{
    private int size;
    public A(int size){
        this.size = size;
    }

    protected int maydon(){
        return size;
    }

}

class B extends A{

   public B(int size) {
        super(size);
    }

    @Override
    public int maydon() {
        return super.maydon();
    }
}

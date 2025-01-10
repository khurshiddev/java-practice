package chapter_14;

public class InnerLocalClass {
    public static void main(String[] args) {

    }
}

class K {

}

class D {
    void show() {
        class L {

        }
        K k = new K();
    }
}
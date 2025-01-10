package chapter_14;

public class InnerMemberClass {
    public static void main(String[] args) {
        A a = new A();
        A.B b1 = new A.B();
        A.B.C c1 = b1.new C();
        A.C c2 = a.new C();
        A.C.B b2 = c2.new B();
        A.C.B.F f = b2.new F();
    }
}

class A {
    public static class B {
        class C {

        }
    }

    class C {
        class B {
            class F {

            }
        }
    }
}
package chapter_15;

public class LocalInner {
    public static void main(String[] args) {
        MathOperation math = new MathOperation();
        math.calculateSquare(10);
    }
}

class MathOperation{
    void calculateSquare(int value){
        class Square{
            int calculator(){
                return value * value;
            }
        }

        Square sq = new Square();
        int res = sq.calculator();
        System.out.println("result is: " + res);
    }
}

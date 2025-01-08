package chapter_8.task_3;

public class StringGetNumber {
    public static void main(String[] args) {

        checkTest(getMaxNumber("Salom bugun havo yaxshi"), null);
        checkTest(getMaxNumber("Bugun 15-yanvar. Havo 20 gradus issiq."), 20);
        checkTest(getMaxNumber("Bugun 15.01.2021 sana."), 2021);
        checkTest(getMaxNumber("1991-yilda biz mustaqil bo'lganmiz."), 1991);
        checkTest(getMaxNumber("-20 va 5"), 20);
        checkTest(getMaxNumber("15"), 15);
        checkTest(getMaxNumber("00200"), 200);
    }

    private static Integer getMaxNumber(String text) {
        if (text.isEmpty()) return null;
        int max = -1;
        int num = 0;
        for (char c : text.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (c -'0');
                if(max < num){
                    max = num;
                }
            }else {
                num = 0;
            }
        }
        if(max == -1) return null;
        return max;
    }


    private static int index = 0;

    private static void checkTest(Integer result, Integer expected) {
        if (result != expected && !expected.equals(result)) {
            throw new ArithmeticException("Natija xato");
        } else {
            System.out.println("✅ Test " + ++index);
        }
    }
}

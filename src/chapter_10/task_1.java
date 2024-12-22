package chapter_10;

public class task_1 {
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
        String[] textTo = text.split("\\D+");
        Integer max = null;
        for(String tex : textTo) {
            if(!tex.isEmpty()) {
                int nums = Integer.parseInt(tex);
                if(max == null || nums > max) {
                    max = nums;
                }
            }
        }
        return max;
//        int compare = text.charAt(count);
//        for (int i = 0; i < text.length(); i++) {
//            if (max > compare) {
//                count++;
//            } else if (compare > max) {
//                max = compare;
//            }
//        }

//        int maxNumber = 0;
//        String[] nums = text.split("");
//        for (int i = 0; i < text.length(); i++) {
//            int grade = Integer.parseInt(nums[i]);
//            if(grade > maxNumber){
//                maxNumber = grade;
//            }
//        }
//        for (char c : text.toCharArray()) {
//            if(Character.isLetterOrDigit(c)){
//                return text;
//            }
//        }

//        char[] toChar = new char[text.length()];
//        for (int i = 0;i< text.length(); i++ ){
//            text.replace("\\d","");
//        }


        }
        private static int index = 0;
        private static void checkTest (Integer result, Integer expected){
            if (result != expected && !expected.equals(result)) {
                throw new ArithmeticException("Natija xato");
            } else {
                System.out.println("✅ Test " + ++index);
            }
        }
    }

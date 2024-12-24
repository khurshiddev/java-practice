package chapter_11;

public class DollarConvertor {
    public static void main(String[] args) {
        Convertor.setKurs(12000);
        Convertor con1 = new Convertor();
        Convertor con2 = new Convertor();
        System.out.println(con1.getSum(10));
        System.out.println(con2.getDollar(250000));
    }
}

class Convertor {
    private static double kurs;
    public static void setKurs(double kurs) {
        Convertor.kurs = kurs;
    }
    public double getSum(double dollar) {

        return kurs * dollar;
    }
    public double getDollar(double sum) {
        return sum / kurs;
    }
}
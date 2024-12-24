package chapter_11;

public class BonusTask {
    public static void main(String[] args) {
        Bonus bonus = new Bonus(4);
        Lid lid = new Lid("abA12BBA");
        Lid lid2 = new Lid("ab1baba2");
        Lid lid3 = new Lid("abababab");

        System.out.println(bonus.check(lid));
        System.out.println(bonus.check(lid2));
        System.out.println(bonus.check(lid3));

    }
}

class Bonus {
    private int count;
    private char[] lid;
    private String unli = "aeiou";
    private String undosh = "aeiou1234567890";

    public Bonus(int count) {
        this.count = count;
    }

    public boolean check(Lid lid) {
        if (lid.getLid().length() != 8) return false;
        this.lid = lid.getLid().toLowerCase().toCharArray();
        if (count == 0) return false;
        if (vowelCount() != consonantCount()) return false;
        int first = 0;
        int second = 0;
        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(this.lid[i])) {
                first += (this.lid[i] - 'a') + 1;
            } else first += (this.lid[i] - '0');
            if (!Character.isDigit(this.lid[7 - i])) {
                second += (this.lid[7 - i] - 'a') + 1;
            } else second += (this.lid[7 - i] - '0');
        }
        if (first != second) return false;
        count--;
        return true;
    }

    private int vowelCount() {
        int charCount = 0;
        for (char ch : lid) {
            if (unli.indexOf(ch) != -1) charCount++;

        }
        return charCount;
    }


    private int consonantCount() {
        int charCount = 0;
        for (char ch : lid) {
            if (undosh.indexOf(ch) == -1) charCount++;

        }
        return charCount;
    }
}

    class Lid {
        private String lid;

        public Lid(String lid) {
            this.lid = lid;
        }

        public String getLid() {
            return lid;
        }
    }


package chapter_12;

import java.util.Arrays;

public class StringBuilderMethods {
    public static void main(String[] args) {
        MyStringBuilder st = new MyStringBuilder();
        System.out.println("Boshlang'ich: " + st);
        st.append("Salom");
        System.out.println("append() bilan qo'shilgan: " + st);
        st.delete(0, 2);
        System.out.println("delete() bilan o'chirilgan: " + st);
        st.replace(0, 2, "WWW");
        System.out.println("replace() bilan almashtirilgan: " + st);
        st.deleteCharAt(0);
        System.out.println("deleteCharAt() bilan o'chirilgan belgi: " + st);
        char[] chars = {'A', 'B', 'C'};
        st.append(chars);
        System.out.println("append() bilan char[] qo'shilgan: " + st);
        int index = st.indexOf("WW");
        System.out.println("indexOf() 'WW' ni topdi: " + index);
        st.reverse();
        System.out.println("reverse() bilan teskari: " + st);
        st.delete(3, 6);
        System.out.println("delete() metodini yana sinash: " + st);
        System.out.println("Oxirgi natija: " + st);


   }
}

class MyStringBuilder {
    private char[] mass;
    private int length = 10;
    private int index;


    MyStringBuilder() {
        mass = new char[length];

    }

    MyStringBuilder(String str) {
        if (str == null) str = "";
        mass = str.toCharArray();
        index = mass.length;
    }


    MyStringBuilder delete(int start, int end) {
        if (start < 0 || start > index || start > end) {
            System.out.println("Index topilmadi");
            return this;
        }
        if (end > index) {
            end = index;
        }
        int len = end - start;
        if (len > 0) {
            System.arraycopy(mass, start + len, mass, start, index - end);
            index -= len;
        }
        return this;
    }

    @Override
    public String toString() {
        return new String(mass, 0, index);
    }

    MyStringBuilder replace(int start, int end, String str) {
        if (start < 0 || start > index || start > end) {
            System.out.println("Index topilmadi");
            return this;
        }
        int count = this.index;
        if (end > count) {
            end = count;
        }
        int len = str.length();
        int newCount = count + len - (end - start);

        while (length - index < newCount) {
            length += length >> 1;
        }
        if (newCount > mass.length) {
            mass = Arrays.copyOf(mass, newCount);
        }

        System.arraycopy(mass, end, mass, start + len, count - end);
        str.getChars(0, len, mass, start);
        this.index = newCount;
        return this;

    }


    MyStringBuilder append(String st) {
        while (length - index < st.length()) {
            length += length >> 1;
        }
        mass = Arrays.copyOf(mass, length);
        for (int i = 0; i < st.length(); i++) {
        mass[index++] = st.charAt(i);

        }
        return this;
    }
//    public MyStringBuilder append(String str) {
//        if (str == null) str = "null";
//        int len = str.length();
//        provideIn(index + len);
//        str.getChars(0, len, mass, index);
//        index += len;
//        return this;
//    }

    MyStringBuilder append(char[] chars) {
        if (chars == null) {
            append("null");
        } else {
            int len = chars.length;

            while (length - index < len) {
                length += length >> 1;
            }
            mass = Arrays.copyOf(mass, length);

            for (int i = 0; i < len; i++) {
                mass[index++] = chars[i];
            }
        }
        return this;
    }
//    public MyStringBuilder append(char[] chars) {
//        if (chars == null) {
//            append("null");
//        } else {
//            int len = chars.length;
//            provideIn(index + len);
//            System.arraycopy(chars, 0, mass, index, len);
//            index += len;
//        }
//        return this;
//    }

     MyStringBuilder deleteCharAt(int pos) {
        if (pos < 0 || pos >= index) {
            System.out.println("indexdan oshib ketdi");
            return this;
        }
        for (int i = pos; i < index - 1; i++) {
            mass[i] = mass[i + 1];
        }
        this.index--;
        return this;
    }

     int indexOf(String str) {
        if (str == null || str.length() == 0 || index == 0) {
            return -1;
        }

        String sb = new String(mass, 0, index);
        return sb.indexOf(str);
    }

     MyStringBuilder reverse() {
        int n = index - 1;
        for (int i = 0; i <= n / 2; i++) {
            char temp = mass[i];
            mass[i] = mass[n - i];
            mass[n - i] = temp;

        }
        return this;
    }
}

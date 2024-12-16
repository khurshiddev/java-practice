package chapter_1;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st1 = sc.next();
        int temp = 0;
        String  vowels = ("aeiouAEIOU");

        for (int i = 0; i < st1.length(); i++) {
            char c = st1.charAt(i);
            if(vowels.indexOf(c) != - 1) {
                temp++;
            }
        }
        System.out.println(temp);
    }

}

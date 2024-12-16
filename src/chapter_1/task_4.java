package chapter_1;

import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        char[] vowels = "aeiouAEIOU".toCharArray();
        for (int i = 0; i < vowels.length; i++) {
            s1 = s1.replace(Character.toString(vowels[i]), "");
        }
        System.out.println(s1);
    }
}

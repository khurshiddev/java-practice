package chapter_2;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = "salom hammaga salom do’stlar";
        String s2 = "GITA";

        s1 = s1.replace("salom",s2);
        System.out.println(s1);
    }
}

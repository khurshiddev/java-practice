package chapter_2;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        sc.nextLine();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();


        if (n1 > s1.length()) n1 = s1.length();
        if (n2 > s2.length()) n2 = s2.length();
        String st1 = s1.substring(0,n1);
        String st2 = s2.substring(s2.length() - n2);
        String res = st1 + st2;
        System.out.println(res);
    }
}

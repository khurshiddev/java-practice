package chapter_2;

import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String [] res = s1.split(" ");
        System.out.println(res.length);
    }
}

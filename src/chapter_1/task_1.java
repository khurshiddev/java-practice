package chapter_1;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next().toLowerCase();
        String s2 = sc.next().toLowerCase();

        if(s1.equals(s2)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}

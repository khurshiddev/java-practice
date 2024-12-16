package chapter_1;

import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        if(s1.equals(s2.toLowerCase())
        && s2.equals(s1.toUpperCase())){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}

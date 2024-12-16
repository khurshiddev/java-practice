package chapter_2;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char c = 'l';
        String s1 = sc.nextLine();
        String s2 = "www";

        String res = "";
        for (int i = 0; i < s1.length(); i++) {
            char temp = s1.charAt(i);
            res += temp;
            if(temp == c){
                res += s2;
            }

        }
        System.out.println(res);
    }
}

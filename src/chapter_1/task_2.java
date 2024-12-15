package chapter_1;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n1 = sc.next();
        String n2 = sc.next();

        String vowels = ("aeiouAEIOU");
        String res1 = "";
        String res2 = "";

        for(int i = 0; i < n1.length(); i++){
            char ch = n1.charAt(i);
            if(n1 == vowels){
                res1 += ch;
            }
        }
        for(int i = 0; i < n1.length(); i++){
            char ch = n2.charAt(i);
            if(n1 == vowels){
                res2 += ch;
            }
        }

        System.out.println(res1.equals(res2));

    }
}

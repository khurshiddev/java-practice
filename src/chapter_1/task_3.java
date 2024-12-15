package chapter_1;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st1 = sc.next();
        String st2 = sc.next();

        String vowels = "aeiuoAEIUO";
        String res = "";

        for(int i = 0; i < st1.length(); i++){
            for(int j = 0; j < st2.length(); j++){
                if(i == vowels && j == vowels){
                    res += j;
                    res += i;

                }
            }
        }
        System.out.println();
    }
}

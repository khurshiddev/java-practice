package chapter_1;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n1 = sc.next().toLowerCase();
        String n2 = sc.next().toLowerCase();

//        String  vowels = ("aeiouAEIOU");
        n1 = n1.replaceAll("[aeiouAEIOU]","");
        n2 = n2.replaceAll("[aeiouAEIOU]","");

        if(n1.equalsIgnoreCase(n2)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }



    }
}

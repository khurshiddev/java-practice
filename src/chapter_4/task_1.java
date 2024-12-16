package chapter_4;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Massiv uzunligi kirgizing");

        int n = sc.nextInt();
        int [] arr = new int [n];
        for (int i = 0; i < arr.length ; i++) {
           arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr[i] += 2;
            System.out.print(arr[i] + ", ");
        }

    }
}

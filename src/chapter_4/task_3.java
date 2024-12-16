package chapter_4;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {9,8,7,6,5,4,2,1};

        for(int i = 0; i < nums.length; i++){
            int ce = nums[i];
            int j = i -1;
            while(j >= 0 && nums[j] > ce) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = ce;
        }
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }
}

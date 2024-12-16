package chapter_4;

public class task_10 {
    public static void main(String[] args) {
        int[] nums = {10, 3, 4, 3, 4, 5, 8, 10, 3};

        //selected sorting
        for(int i = 1; i < nums.length; i++){
            int ce = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > ce) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = ce;
        }

        int res = 1;
        for(int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[res] = nums[j];
                res++;
            }
        }
            for (int i = 0; i < res; i++) {
                System.out.print(nums[i] + ", ");
            }
    }
}

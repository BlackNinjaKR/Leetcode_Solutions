public class Bubble_Sort
{
    public static void main(String args[])
    {
        int nums[] = {9,1,2,8,3,7,5,6,3,6,2,4,1,0};
        Bubble_Sort obj = new Bubble_Sort();
        obj.bubbleSort(nums);
        for (int item : nums)
            System.out.print(item+" ");
    }
    void bubbleSort(int[] nums)
    {
        for (int i = 0; i<nums.length; i++)
            for (int j = 0; j<nums.length-i-1; j++)
                if(nums[j]>nums[j+1])
                {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
    }
}
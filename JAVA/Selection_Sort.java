public class Selection_Sort
{
    public static void main(String args[])
    {
        int nums[] = {9,1,2,8,3,7,5,6,3,6,2,4,1,0};
        Selection_Sort obj = new Selection_Sort();
        obj.selectionSort(nums);
        for (int item : nums)
            System.out.print(item+" ");
    }
    void selectionSort(int nums[])
    {
        int min_idx=0;
        for (int i = 0; i<nums.length; i++)
        {
            min_idx = i;
            for (int j = i+1; j<nums.length;j++)
                if(nums[j]<nums[min_idx])
                    min_idx = j;
            int temp = nums[i];
            nums[i] = nums[min_idx];
            nums[min_idx] = temp;
        }
    }
}

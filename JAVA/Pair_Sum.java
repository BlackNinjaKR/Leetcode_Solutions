/*
Given a sorted array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/
public class Pair_Sum
{
    int[] pairSum(int[] nums, int target)
    {
        int[] ans = new int[2];
        int i = 0, j = nums.length-1;
        while(i<j)
        {
            if ((nums[i]+nums[j])>target)
                j--;
            else if ((nums[i]+nums[j])<target)
                i++;
            else
            {
                ans[0] = i;
                ans[1] = j;
                return ans;
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        int nums[] = {2,7,11,15};
        int target = 9;
        Pair_Sum obj = new Pair_Sum();
        int[] ans = obj.pairSum(nums, target);
        System.out.println("("+ans[0]+","+ans[1]+")");
    }
}
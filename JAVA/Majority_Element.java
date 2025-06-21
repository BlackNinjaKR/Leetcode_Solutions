/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
*/
public class Majority_Element {
    int majorityElement(int[] nums)
    {
        int freq = 0, ans = Integer.MIN_VALUE;
        for(int val : nums)
        {
            if(freq == 0)
                ans = val;
            if (ans == val)
                freq++;
            else
                freq--;
        }
        int count = 0;
        for (int val:nums)
        {
            if (val==ans)
                count++;
        }
        if(count<(nums.length/2))
        {
            ans=-1;
        }
        return ans;
    }
    public static void main(String args[])
    {
        int[] nums = {2,2,1,1,1,2,2};
        Majority_Element obj = new Majority_Element();
        System.out.println(obj.majorityElement(nums));
    }
}

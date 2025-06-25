/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
*/
#include<stdio.h>
int majorityElement(int nums[])
{
    int ans, freq = 0;
    for (int i = 0; i < sizeof(nums)/sizeof(nums[0]); i++)
    {
        if (freq == 0)
        {
            ans = nums[i];
        }
        if (ans == nums[i])
            freq++;
        else
            freq--;
    }
    return ans;
}
int main()
{
    int nums[] = {2,2,1,1,1,2,2};
    printf("%d",majorityElement(nums));
    return 0;
}
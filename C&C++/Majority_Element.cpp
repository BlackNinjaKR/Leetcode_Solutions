/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
*/
#include<iostream>
#include<vector>
using namespace std;

int majorityElement(vector<int>& nums)
{
    int freq = 0, ans = INT_MIN;
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
    if((size_t)count<(nums.size()/2))
    {
        ans=-1;
    }
    return ans;
}

int main()
{
    vector<int> nums = {2,2,1,1,1,2,2};
    cout<<majorityElement(nums)<<endl;
    return 0;
}
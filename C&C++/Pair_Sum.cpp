/*
Given a sorted array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/
#include<vector>
#include<iostream>
using namespace std;

vector<int> twoSum(vector<int>& nums, int target)
{
    vector<int> ans;
    int i = 0, j = nums.size()-1;
    while(i<j)
    {
        if((nums[i]+nums[j])>target)
            j--;
        else if ((nums[i]+nums[j])<target)
            i++;
        else
        {
            ans.push_back(i);
            ans.push_back(j);
            return ans;
        }
    }
    return ans;
}

int main()
{
    vector<int> nums = {2,7,11,15};
    int target = 9;
    vector<int> ans = twoSum(nums, target);
    cout << "(" << ans[0] << "," << ans[1] << ")" << endl;
    return 0;
}
/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1


Intuition
The key insight is to use the properties of the XOR (^) bitwise operator. XOR has two very useful characteristics:

a ^ a = 0 – any number XORed with itself is 0.
a ^ 0 = a – any number XORed with 0 remains unchanged.
Since every number in the array appears exactly twice except for one unique number, XORing all the numbers together will cancel out the duplicates and leave only the number that appears once.

Approach
Initialize a variable result to 0.
Iterate through the array and XOR each element with result.
After the loop, result will contain the single number that doesn't have a duplicate.

Complexity
Time complexity: O(1)
Space complexity: O(1)
*/

#include<iostream>
#include<vector>

using namespace std;

class Single_Number_BW
{
    private:
        vector<int> nums = {4,1,2,1,2};
    public:
        vector<int> getNums()
        {
            return nums;
        }
        int singleNumber(vector<int> nums)
        {
            int result = 0;
            for (int i : nums)
                result ^= i;
            return result;
        }
};

int main()
{
    Single_Number_BW obj;
    cout << obj.singleNumber(obj.getNums()) << endl;
    return 0;
}
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
My first thought was to check how many times each number appears in the array. Since all elements except one appear exactly twice, I can count the frequency of each number and return the one with count equal to 1.

Approach
For each number in the array, I loop through the entire array again to count its frequency. If I find that its count is 1, I return it as the result. This approach ensures correctness but has a time complexity of O(n^2) due to the nested loops.

Complexity
Time complexity: O(n^2)
Space complexity: O(1)
*/

#include<iostream>
#include<vector>

using namespace std;

class Single_Number_NL //Solution using Nested Loop
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
            for (int i : nums)
            {
                int counter = 0;
                for (size_t j = 0; j < nums.size() ; j++)
                {
                    if (i == nums.at(j))
                        counter++;
                }
                if (counter == 1)
                    return i;
            }
            return 0;
        }
};

int main()
{
    Single_Number_NL obj;
    cout << obj.singleNumber(obj.getNums()) << endl;
    return 0;
}
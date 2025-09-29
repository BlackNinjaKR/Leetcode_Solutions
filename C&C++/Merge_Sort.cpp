#include <iostream>
#include <vector>
using namespace std;

class Merge_Sort
{
    public:
        void merge(vector<int>& nums, int l, int mid, int r)
        {
            vector<int> temp;
            int i = l, j = mid + 1;
            while(i<=mid && j<=r)
                if(nums[i]<=nums[j])
                    temp.push_back(nums[i++]);
                else
                    temp.push_back(nums[j++]);
            if (i>mid)
                while(j<=r)
                    temp.push_back(nums[j++]);
            else
                while(i<=mid)
                    temp.push_back(nums[i++]);

            int k = 0;
            for (i = l, k = 0; i <= r; i++, k++)
                nums[i] = temp[k];
        }
        void mergeSort(vector<int>& nums, int l, int r)
        {
            if (l<r)
            {
                int mid = l + (r - l)/2;
                mergeSort(nums, l, mid);
                mergeSort(nums, mid+1, r);
                merge(nums, l, mid, r);
            }
        }
        vector<int> sortArray(vector<int>& nums)
        {
            mergeSort(nums, 0, nums.size()-1);
            return nums;
        }
};

int main()
{
    Merge_Sort obj;
    vector<int> nums = {9, 1, 8, 2, 7, 3, 6, 4, 5, 0};
    nums = obj.sortArray(nums);
    for (int items : nums)
        cout<<items<<" ";
}
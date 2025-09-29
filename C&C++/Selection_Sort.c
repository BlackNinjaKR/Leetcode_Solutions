#include<stdio.h>
void selectionSort(int nums[], int size)
{
    for (int i = 0; i<size; i++)
    {
        int min_idx = i;
        for (int j = i+1; j<size; j++)
            if (nums[j]<nums[min_idx])
                min_idx = j;
        int temp = nums[i];
        nums[i] = nums[min_idx];
        nums[min_idx] = temp;
    }
}
int main()
{
    int nums[] = {9,1,2,8,3,7,5,6,3,6,2,4,1,0}, size = sizeof(nums)/sizeof(int);
    selectionSort(nums, size);
    for (int i = 0; i<size; i++)
        printf("%d ",nums[i]);
}
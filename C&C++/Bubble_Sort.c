#include <stdio.h>
void bubbleSort(int nums[], int size)
{
    for (int i = 0; i < size; i++)
        for (int j = 0; j < size-i-1; j++)
            if(nums[j]>nums[j+1])
            {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
}
int main()
{
    int nums[] = {9,1,2,8,3,7,5,6,3,6,2,4,1,0};
    int size = sizeof(nums)/sizeof(nums[0]);
    bubbleSort(nums, size);
    for(int i = 0; i<size; i++)
        printf("%d ",nums[i]);
    return 0;
}
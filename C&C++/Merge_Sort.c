#include<stdio.h>
#include<stdlib.h>
void merge(int nums[], int l, int mid, int r)
{
    int i = l, j = mid+1, k = 0;
    int *temp = (int*)malloc(((r-l+1)*sizeof(int)));
    if(!temp) return;

    while(i<=mid && j<=r)
        if (nums[i]<=nums[j])
            temp[k++] = nums[i++];
        else
            temp[k++] = nums[j++];
    if (i>mid)
        while(j<=r)
            temp[k++]=nums[j++];
    else
        while(i<=mid)
            temp[k++]=nums[i++];

    for(i = l, k = 0; i<=r; i++, k++)
        nums[i] = temp[k];

    free(temp);
}
void merge_Sort(int nums[], int l, int r)
{
    if (l < r)
    {
        int mid = l + (r - l)/2;
        merge_Sort(nums, l, mid);
        merge_Sort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }
}
int main()
{
    int nums[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    merge_Sort(nums, 0, sizeof(nums)/sizeof(int)-1);
    for (int i = 0; i<(int)(sizeof(nums)/sizeof(int)); i++)
        printf("%d ",nums[i]);
    return 0;
}
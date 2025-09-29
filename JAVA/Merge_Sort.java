class Merge_Sort
{
    public void mergeSort(int[] arr, int l, int r)
    {
        if (l < r)
        {
            int mid = l + (r - l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    public void merge(int[] arr, int l, int mid, int r)
    {
        int[] temp = new int[r-l+1];
        int i = l, j = mid+1;
        int k = 0;
        while(i<=mid && j<=r)
            if (arr[i]<=arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        if(i>mid)
            while (j<=r)
                temp[k++]=arr[j++];
        else
            while (i<=mid)
                temp[k++] = arr[i++];

        k = l;
        for(int item : temp)
            arr[k++] = item;
    }
    public static void main(String[] args) {
        Merge_Sort obj = new Merge_Sort();
        int nums[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        obj.mergeSort(nums, 0, nums.length-1);
        for (int item : nums)
            System.out.print(item+" ");
    }
}
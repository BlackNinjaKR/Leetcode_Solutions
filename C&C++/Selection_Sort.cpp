#include<iostream>
using namespace std;

class Selection_Sort
{
    public:
        void selectionSort(int arr[], int size)
        {
            for (int i = 0; i < size; i++)
            {
                int min_idx = i;
                for (int j = i; j < size; j++)
                    if (arr[j]<arr[min_idx])
                        min_idx = j;
                int temp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = temp;
            }
        }
};
int main()
{
    int arr[] = {9,1,2,8,3,7,5,6,3,6,2,4,1,0}, size = sizeof(arr)/sizeof(int);
    Selection_Sort obj;
    obj.selectionSort(arr, size);
    for (int i = 0; i<size; i++)
        cout<<arr[i]<<" ";
}
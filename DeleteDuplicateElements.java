/*
Given an integer array nums sorted in non-decreasing order,remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

Constraints:
1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.


Intuition
The problem involves removing duplicates from a sorted array in-place,
so each unique element appears only once. Since the array is sorted,
all duplicates will appear consecutively, allowing us to track unique elements
by comparing each element with the previous one.

Approach
1. Initialize a pointer, uniqueIndex, to keep track of the position of the next unique element in the array.
2. Iterate through the array starting from the second element.
3. For each element, check if it differs from the previous element
        If so, assign it to nums[uniqueIndex], then increment uniqueIndex.
4. The variable uniqueIndex will ultimately contain the count of unique elements, and the first uniqueIndex positions in nums will contain the unique elements.
Complexity

Time complexity: O(n)
We traverse the array once, so the time complexity is linear in terms of the array length.

Space complexity: O(1)
The solution modifies the array in-place, requiring no additional space beyond a few auxiliary variables.
 */



/* My initial code:

import java.util.Scanner;
class Solution {
    public int[] removeDuplicatesArr(int[] nums) {
        int[] expectedNums = new int[nums.length];
        int temp = nums[0], counter = 0;
        for (int i = 1; i < nums.length; i++)
        {
            temp = nums[i-1];
            if(temp==nums[i])
                continue;
            expectedNums[counter] = temp;
            counter++;
            expectedNums[counter]=nums[i];
        }
        return expectedNums;
    }
    public int removeDuplicates(int[] nums)
    {
        int counter = 0;
        for (int i = 0; i<nums.length-1; i++)
        {
            if(nums[i]<nums[i+1])
                counter++;
        }
        return counter;
    }
    public int[] input()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = in.nextInt();
        if (n<1 || n>3*Math.pow(10,4))
            System.exit(0);
        int[] arr = new int[n];
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++)
        {
            arr[i] = in.nextInt();
            if (arr[i]<-100 || arr[i] > 100)
                System.exit(0);
            if (temp > arr[i])
                System.exit(0);
            temp = arr[i];
        }
        return arr;
    }
    public static void main(String[] args)
    {
        Solution obj = new Solution();
        int[] arr = obj.removeDuplicatesArr(obj.input());
        for (int i = 0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println("/n"+obj.removeDuplicates(arr));
    }
}

And why it's bad:

removeDuplicatesArr(int[] num) Function:
This function should modify the nums array in-place and ensure that
each unique element appears only once in the first k positions. However, it doesn't do this correctly.
Instead of using expectedNums as a separate array, it should operate on nums directly,updating elements in-place.

removeDuplicates(int[] num) Function:
This function should return the number of unique elements in nums.
However, it is currently only counting the transitions between numbers and
doesn’t account for the first unique element.

main(String[] args) Function:
The removeDuplicatesArr function should ideally only need to print nums up to k,
as the remaining elements are not required to be considered.*/


import java.util.Scanner;

class Solution
{
    // This function removes duplicates in-place and returns the count of unique elements
    public int removeDuplicates(int[] nums)
    {
        if (nums.length == 0)
            return 0;
        int uniqueIndex = 1; // Pointer for the next unique element position

        for (int i = 1; i < nums.length; i++)
        {
            // If current element is different from the previous, it's unique
            if (nums[i] != nums[i - 1])
            {
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }
        return uniqueIndex;
    }

    // This function takes input from the user
    public int[] input()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = in.nextInt();
        
        if (n < 1 || n > 3 * (int) Math.pow(10, 4))
        {
            System.out.println("Invalid array size.");
            System.exit(0);
        }
        
        int[] arr = new int[n];
        System.out.print("Enter the elements (sorted, between -100 and 100): ");
        
        for (int i = 0; i < n; i++)
        {
            arr[i] = in.nextInt();
            if (arr[i] < -100 || arr[i] > 100)
            {
                System.out.println("Invalid element range.");
                System.exit(0);
            }
            if (i > 0 && arr[i] < arr[i - 1])
            {
                System.out.println("Array must be sorted in non-decreasing order.");
                System.exit(0);
            }
        }
        
        in.close();
        return arr;
    }

    public static void main(String[] args)
    {
        Solution obj = new Solution();
        int[] nums = obj.input();
        
        // Remove duplicates in-place and get the number of unique elements
        int k = obj.removeDuplicates(nums);
        
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++)
            System.out.print(nums[i] + " ");
        System.out.println("\nNumber of unique elements: " + k);
    }
}
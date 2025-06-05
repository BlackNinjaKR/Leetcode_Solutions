package JAVA;
/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-10^6 <= nums1[i], nums2[i] <= 10^6

Intuition:
To find the median of two sorted arrays in $$𝑂(log(𝑚+𝑛))$$ time,
the binary search approach across two arrays seems ideal.
Rather than merging both arrays, which would take $$𝑂(𝑚+𝑛)$$ time,
we use binary search on the smaller array to divide both arrays into left and right halves
such that elements on the left are less than or equal to elements on the right.
This approach allows us to efficiently determine the median by ensuring
the left and right partitions are correctly aligned.

Approach:

1. Choose the Smaller Array for Binary Search:
    To keep the solution efficient,
    apply binary search on the smaller array (nums1) to reduce the number of comparisons.
    This will minimize the partitioning process.

2. Partitioning Logic:
    1. Define a partitionX in nums1 and compute a corresponding partitionY in nums2 such that the combined left side (all elements before these partitions) has half of the elements.
    2. Calculate the left and right boundary elements of each partition:
        1. maxX and minX from nums1
        2. maxY and minY from nums2

3. Checking Valid Partitions:
    1. Ensure the largest element on the left side of each partition (maxX and maxY) is less than or equal to the smallest element on the right side (minX and minY).
    2. If this condition is met, we have found the correct partition, and we can determine the median:
        1. If the total number of elements is even, the median is the average of the two middle values (max(maxX, maxY) and min(minX, minY)).
        2. If the total number is odd, the median is the largest element on the left (max(maxX, maxY)).
    3. If the condition is not met, adjust the binary search range to find the correct partition.

# Complexity
- Time complexity:
O(log(min(m,n)))

- Space complexity:
O(1)

*/

import java.util.Scanner;
class MedianArraySolution
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        // Ensuring that binary search happens on the smaller array
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        
        while (low <= high)
        {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxX <= minY && maxY <= minX)
                // Found the correct partition
                if ((m + n) % 2 == 0)
                    return ((double)Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                else
                    return (double)Math.max(maxX, maxY);
            else if (maxX > minY)
                high = partitionX - 1;
            else
                low = partitionX + 1;
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public int[] input()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int m = in.nextInt();
        if (m < 0 || m > 1000) {
            System.out.print("Please enter a valid number");
            System.exit(0);
        }
        int[] array = new int[m];

        in.close();

        System.out.print("Enter " + m + " numbers: ");
        for (int i = 0; i < m; i++)
            array[i] = in.nextInt();
        return array;
    }

    public static void main(String[] args) {
        MedianArraySolution solution = new MedianArraySolution();
        int[] nums1 = solution.input();
        int[] nums2 = solution.input();
        
        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("The median is: " + median);
    }
}

/*
 * LeetCode Problem: https://leetcode.com/problems/sqrtx/
 * 
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1
 */

#include<stdio.h>

int mySqrt(int x)
{
        // if (x<2)
        //     return x;

        // for(long i = 1; i<=(x/2)+1; i++)
        //     if ((i*i) == (long)x)
        //         return (int)i;
        //     else if ((i*i)>(long)x)
        //         return (int)i-1;
        // return 0;

        if(x<2) return x;
        // Binary Search Approach
        int i = 0, j = x;
        while (i<=j)
        {
            long mid = (i + j)/2;
            long sq = mid * mid;
            if (sq == x)
                return (int)mid;
            else if (sq<x)
                i = (int)mid+1;
            else
                j = (int)mid-1;
        }
        return (int)j;
}

int main() {
    printf("%d\n", mySqrt(4));  // Output: 2
    printf("%d\n", mySqrt(8));  // Output: 2
    printf("%d\n", mySqrt(0));  // Output: 0
    return 0;
}
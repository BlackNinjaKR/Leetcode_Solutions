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
public class Sqrt_x
{
    public int mySqrt(int x) //O(n)
    {
        if (x<2)
            return x;

        for(long i = 1; i<=(x/2)+1; i++)
        {
            if ((i*i) == (long)x)
                return (int)i;
            else if ((i*i)>(long)x)
                return (int)i-1;
        }
        return 0;
    }
    public static void main(String[] args)
    {
        Sqrt_x obj = new Sqrt_x();
        int x = 8;
        System.out.println(obj.mySqrt(x)); // Output: 2
        x = 4;
        System.out.println(obj.mySqrt(x)); // Output: 2
        x = 0;
        System.out.println(obj.mySqrt(x)); // Output: 0
    }
}

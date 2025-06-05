package JAVA;
/*
Given two integers dividend and divisor,
divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero,
which means losing its fractional part.
For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers
within the 32-bit signed integer range: [−231, 231 − 1].
For this problem, if the quotient is strictly greater than 231 - 1,
then return 231 - 1, and if the quotient is strictly less than -231, then return -231.


Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0

Intuition:

When performing division without using multiplication, division, or modulus operators,
a straightforward approach of repeatedly subtracting the divisor from the dividend is too slow for large values.
However, by leveraging bit-shifting (doubling) to exponentially increase the divisor’s effect,
we can speed up the division process significantly. This approach takes advantage of binary shifts
to achieve the result in fewer steps.

Approach:

1. Handle Edge Cases:
    If the dividend is Integer.MIN_VALUE and the divisor is -1, return Integer.MAX_VALUE to avoid overflow.
    Determine the sign of the result by checking if the dividend and divisor have opposite signs.

2. Convert to Positive Values:
    Convert dividend and divisor to positive values to simplify calculations.
    Use long to avoid overflow when taking the absolute values of Integer.MIN_VALUE.

3.  Repeated Doubling (Bit-Shifting):
    Use a while loop to repeatedly subtract the largest multiple of the divisor that still fits
    in the remaining dividend.
    Inside this loop, use another loop to keep doubling the divisor (using temp <<= 1)
    until it exceeds the remaining dividend. Track the corresponding multiplier (number of times the divisor fits)
    with multiple <<= 1.

4. Accumulate the Quotient:
    After each round of doubling, subtract the largest valid "chunk" of the divisor
    from the dividend and add the corresponding multiple to the quotient.
    Repeat until the dividend is smaller than the divisor.

5. Apply the Sign:
    If the calculated quotient should be negative, negate it.

Complexity:
Time Complexity: O(log(dividend))
Each outer loop iteration subtracts a large "chunk" of the dividend,
reducing it exponentially, which results in logarithmic time complexity.

Space Complexity: O(1)
Only a constant amount of extra space is used for variables like temp and multiple.
 */
import java.util.Scanner;
public class DivisionWithoutDivision
{
    public int divide(int dividend, int divisor)
    {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Determine the sign of the result
        boolean sign = (dividend < 0) ^ (divisor < 0);

        // Use absolute values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Repeated doubling and subtracting
        while (absDividend >= absDivisor)
        {
            long temp = absDivisor;
            int multiple = 1;
            while (absDividend >= (temp << 1))
            {
                temp <<= 1;
                multiple <<= 1;
            }
            absDividend -= temp;
            quotient += multiple;
        }

        // Apply sign to the quotient
        return sign ? -quotient : quotient;
    }

    public int[] input()
    {
        int[] in = new int[2];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dividend: ");
        in[0] = sc.nextInt();
        System.out.print("Enter divisor: ");
        in[1] = sc.nextInt();
        sc.close();
        return in;
    }

    public static void main(String[] args)
    {
        DivisionWithoutDivision in = new DivisionWithoutDivision();
        int[] n = in.input();
        System.out.println(in.divide(n[0], n[1]));
    }
}

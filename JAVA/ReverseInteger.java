/*Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).


Intuition
To reverse an integer, the idea is to pop digits from the input number and push them into a new reversed integer. However, since reversing the integer might exceed the 32-bit signed integer range, we need to check for potential overflow.

Approach
Initialize new_x as 0, which will store the reversed digits.
While x is not zero:
Extract the last digit of x using x % 10.
Before adding this digit to new_x, check if new_x will overflow by verifying that:
For positive values, new_x does not exceed Integer.MAX_VALUE / 10.
For negative values, new_x does not go below Integer.MIN_VALUE / 10.
If overflow is detected, return 0.
Otherwise, update new_x by shifting its digits left by one position and adding the last digit.
Return new_x as the reversed integer.
Complexity
Time complexity:
O(log10(x)), where x is the absolute value of the input, as we process each digit once.

Space complexity:
O(1), since only a constant amount of space is used.
*/

class ReverseIntegerSolution
{
    public int reverse(int x)
    {
        int new_x = 0;
        
        while (x != 0)
        {
            int lastDigit = x % 10;
            
            // Check for overflow before updating new_x
            if (new_x > Integer.MAX_VALUE / 10 || (new_x == Integer.MAX_VALUE / 10 && lastDigit > 7))
                return 0; // Overflow for positive numbers
                
            if (new_x < Integer.MIN_VALUE / 10 || (new_x == Integer.MIN_VALUE / 10 && lastDigit < -8))
                return 0; // Overflow for negative numbers
            
            new_x = new_x * 10 + lastDigit;
            x /= 10;
        }
        
        return new_x;
    }
}

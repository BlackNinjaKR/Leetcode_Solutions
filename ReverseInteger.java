/*Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
*/

class Solution
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

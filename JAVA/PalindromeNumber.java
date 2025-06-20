/*Given an integer x, return true if x is a palindrome, and false otherwise.
 * 
Intuition
A number is considered a palindrome if it reads the same forwards and backwards.
This implies that reversing the digits of the number should yield the original number.

Approach
Reverse the Number: To check if a number is a palindrome, reverse its digits.
Compare Original with Reversed: If the reversed number is the same as the original number, it’s a palindrome.

Complexity
Time complexity:
O(log(x)), as we are iterating over each digit in the number once to reverse it.

Space complexity:
O(1), since we use a constant amount of extra space.
*/

import java.util.Scanner;
class PalindromeNumberSolution
{
    public boolean isPalindrome(long x)
    {
        if (reverse(x)==x)
            return true;
        return false;
    }
    private long reverse(long n)
    {
        long new_n = 0;
        while(n>0)
        {
            new_n+=n%10;
            new_n*=10;
            n/=10;
        }
        new_n/=10;
        return new_n;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        PalindromeNumberSolution obj = new PalindromeNumberSolution();
        System.out.print("Enter a number: ");
        long x = sc.nextLong();
        System.out.print("Input: "+x);
        System.out.print("Output: "+obj.isPalindrome(x));
        sc.close();
    }
}
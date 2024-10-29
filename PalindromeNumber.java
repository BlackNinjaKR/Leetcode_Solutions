/*Given an integer x, return true if x is a palindrome, and false otherwise.*/

import java.util.Scanner;
class Solution
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
        Solution obj = new Solution();
        System.out.print("Enter a number: ");
        long x = sc.nextLong();
        System.out.print("Input: "+x);
        System.out.print("Output: "+obj.isPalindrome(x));
        sc.close();
    }
}
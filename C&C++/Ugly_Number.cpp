/*
    * Leetcode Problem: https://leetcode.com/problems/ugly-number/
An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.

Given an integer n, return true if n is an ugly number.

 

Example 1:

Input: n = 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: n = 1
Output: true
Explanation: 1 has no prime factors.
Example 3:

Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.
 

Constraints:

-231 <= n <= 231 - 1
 */

#include <iostream>
using namespace std;

bool isUgly(int n)
{
    if (n <= 0) return false; // Ugly numbers are positive integers
    while (n % 2 == 0) n /= 2;
    while (n % 3 == 0) n /= 3;
    while (n % 5 == 0) n /= 5;
    return n == 1; // If n is reduced to 1, it is an ugly number
}

int main()
{
    cout << isUgly(6) << endl;   // Output: 1 (true)
    cout << isUgly(8) << endl;   // Output: 1 (true)
    cout << isUgly(14) << endl;  // Output: 0 (false)
    cout << isUgly(1) << endl;   // Output: 1 (true)
    return 0;
}
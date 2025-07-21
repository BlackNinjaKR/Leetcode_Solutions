/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 
Constraints:

1 <= a.length, b.length <= 10^4
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
*/

#include <iostream>
#include <string>
#include <algorithm> //For reverse
using namespace std;

string AddBinary(string a, string b)
{
    string sum = "";
    int i = a.length() - 1, j = b.length() - 1, carry = 0;

    while (i >= 0 || j >= 0 || carry != 0)
    {
        int add = carry;
        if (i >= 0)
            add += a[i--] - '0';
        if (j >= 0)
            add += b[j--] - '0';

        sum += (add%2) + '0';
        carry = add/2;
    }

    reverse(sum.begin(), sum.end());//in-place reverse
    return sum;
}

int main()
{
    string a = "1101";
    string b = "1011";
    cout << "Sum: " << AddBinary(a, b) << endl;
    return 0;
}

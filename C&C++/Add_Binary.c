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

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* reverse(char* str)
{
    int len = strlen(str);
    char* rev = (char*)malloc(len + 1); //+1 for null terminator
    for (int i = 0; i < len; i++)
        rev[i] = str[len - 1 - i];

    rev[len] = '\0';
    return rev;
}

char* addBinary(char* a, char* b)
{
    int i = strlen(a) - 1, j = strlen(b) - 1, carry = 0, k =0, maxLen = (i > j ? i : j) + 3; // +2 for max possible carry + null terminator
    char* result = (char*)malloc(maxLen);

    while (i >= 0 || j >= 0 || carry)
    {
        int sum = carry;
        if (i >= 0) sum += a[i--] - '0';
        if (j >= 0) sum += b[j--] - '0';

        result[k++] = (sum%2) + '0';
        carry = sum/2;
    }

    result[k] = '\0';

    char* finalResult = reverse(result);
    free(result); //clean up memory
    return finalResult;
}

int main() {
    char a[] = "1101";
    char b[] = "1011";
    char* sum = addBinary(a, b);
    printf("Sum: %s\n", sum);
    free(sum); // Free final result
    return 0;
}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* D2B(long s)
{
    if (s == 0) return strdup("0");
    if (s == 1) return strdup("1");

    char temp[65]; // max 64-bit binary digits + null terminator
    int idx = 0;
    long tmp = s;

    while (tmp != 1)
    {
        temp[idx++] = (tmp % 2) + '0';
        tmp /= 2;
    }
    temp[idx++] = '1';
    temp[idx] = '\0';

    // Reverse temp into new string
    char* b = (char*)malloc(idx + 1);
    for (int i = 0; i < idx; i++)
        b[i] = temp[idx - i - 1];
    b[idx] = '\0';

    return b;
}

int main()
{
    long ln = 31232;
    char* bin = D2B(ln);
    printf("Decimal: %ld\nBinary: %s\n", ln, bin);
    free(bin);
    return 0;
}

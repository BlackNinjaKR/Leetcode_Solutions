#include <stdio.h>
#include <string.h>
#include <math.h>

long long B2D(const char *s) {
    long long result = 0;
    int len = strlen(s);
    
    for (int i = 0; i < len; i++)
        result = (result << 1) + (s[i] - '0'); // shift left and add bit

    return result;
}

int main() {
    const char *binary = "1010101001010101010101";
    printf("Binary: %s\nDecimal: %lld\n", binary, B2D(binary));
    return 0;
}

#include<iostream>
#include<string>
using namespace std;

long B2D(string s)
{
    long d = 0;
    int n = s.length();
    for (int i = 0; i < n; i++)
        d += (s[i] - '0') * (1L << (n - 1 - i)); // Bit shift for 2^(n-1-i)
    return d;
}

int main()
{
    string str = "1010101001010101010101";
    cout << "Binary: " << str << "\nDecimal: " << B2D(str) << endl;
}

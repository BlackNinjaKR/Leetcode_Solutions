#include <iostream>
#include <string>
using namespace std;

string D2B(long s)
{
    if (s == 0) return "0";
    if (s == 1) return "1";

    string temp = "";
    long tmp = s;

    while (tmp != 1)
    {
        temp += to_string(tmp % 2);
        tmp /= 2;
    }
    temp += "1";

    // Reverse temp
    string b = "";
    for (int i = temp.length() - 1; i >= 0; i--)
        b += temp[i];

    return b;
}

int main()
{
    long ln = 31232;
    cout << "Decimal: " << ln << "\nBinary: " << D2B(ln) << endl;
    return 0;
}

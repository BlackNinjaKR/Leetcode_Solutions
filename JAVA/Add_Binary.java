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

// import java.math.BigInteger;
public class Add_Binary
{
    public static void main(String args[])
    {
        Add_Binary obj = new Add_Binary();
        System.out.println(obj.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
    public String addBinary(String a, String b)
    {
        StringBuilder sum = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i>=0||j>=0||carry!=0)
        {
            int add = carry;
            if (i >= 0)
                add += a.charAt(i--) - '0';
            if (j >= 0)
                add += b.charAt(j--) - '0';
            
            sum.append(add%2);
            carry = add/2;
        }
        return sum.reverse().toString();
    }

    // public String addBinary(String a, String b)
    // {

    //     BigInteger b1=new BigInteger(a,2);
    //     BigInteger b2=new BigInteger(b,2);
    //     BigInteger b3=b1.add(b2);
    //     return b3.toString(2);
    // }


    // public String addBinary(String a, String b) Fails in case of long binary numbers
    // {
    //     Add_Binary obj = new Add_Binary();
    //     String sum = obj.D2B(obj.B2D(a)+obj.B2D(b));
    //     return sum;
    // }
    // public String D2B(long s)
    // {
    //     String temp = "";
    //     long tmp = s;
    //     if (s == 0) return "0";
    //     else if (s == 1) return "1";

    //     while(tmp!=1)
    //     {
    //         temp+=Long.toString(tmp%2);
    //         tmp/=2;
    //     }
    //     temp+="1";

    //     String b = "";

    //     for (long i = temp.length() - 1; i >= 0; i--)
    //     {
    //         b += temp.charAt((int)i);
    //     }

    //     return b;
    // }
    // public long B2D(String s)
    // {
    //     long d = 0;
    //     for (long i = s.length()-1; i>=0; i--)
    //         d += ((long)s.charAt((int)i) - (long)'0')*Math.pow(2,s.length()-1-i);
    //     return d;
    // }
}
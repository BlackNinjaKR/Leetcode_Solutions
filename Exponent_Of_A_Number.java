/*Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Constraints:

-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
n is an integer.
Either x is not zero or n > 0.
-10^4 <= xn <= 10^4
*/
import java.util.Scanner;
class ExponentOfNumber
{
    private void exit()
    {
        System.out.print("ERROR");
        System.exit(0);
    }
    public double myPow(double x, int n)
    {
        if (x<-100.0 || x>100)
            exit();
        if (x == 0 && n<= 0)
            exit();
        if (Math.pow(x,n) > Math.pow(10,4) || Math.pow(x,n) < -Math.pow(10,4))
            exit();
        return Math.pow(x,n);
    }
    public static void main(String args[])
    {
        ExponentOfNumber obj = new ExponentOfNumber();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double x = in.nextDouble();
        System.out.print("Enter power of the number: ");
        int n = in.nextInt();
        
        if (n>Integer.MAX_VALUE || n<Integer.MIN_VALUE)
            obj.exit();
        in.close();
        System.out.println(obj.myPow(x,n));
    }
}
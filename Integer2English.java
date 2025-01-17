/*Convert a non-negative integer num to its English words representation.

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 

Constraints:

0 <= num <= 2^31 - 1


# Intuition
The problem involves converting a number into its English words representation. The solution can be built by breaking the number into segments (units, thousands, millions, billions) and handling each segment recursively. Numbers under 20 have unique names, while larger numbers can be constructed systematically using the names for tens, hundreds, and scales.

# Approach

1. Base Cases:
    - If the number is `0`, return `"Zero"`.
    - Numbers less than `10` can directly use the `ones` array.
    - Numbers between `10` and `19` can use the `teens` array.

2. Recursive Segmentation:
    - Break the number into smaller parts based on scales: `Billion`, `Million`, `Thousand`, and below.
    - For each segment, recursively determine its English representation using helper logic.

3. Concatenation and Formatting:
    - Combine the recursive results for each segment, ensuring proper spacing and scale names.
    - Use a `StringBuilder` to remove any extra spaces.

4. Edge Cases:
    - Handle numbers with trailing zeros, such as `1000` -> `"One Thousand"` without extra spaces.
    - Handle `Integer.MAX_VALUE`, which is the upper bound of constraints.


# Complexity
- Time complexity:
```O(n)```
Where n is the number of digits in the input. The number of recursive calls is proportional to the number of segments (Billion, Million, Thousand, etc.).

- Space complexity:
```O(n)```
The recursive stack can go as deep as the number of segments in the number, which is at most 4 (Billion, Million, Thousand, Hundred).*/

import java.util.Scanner;
public class Integer2English
{
    private String ones[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String tens[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String teens[] = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public int input()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int n = in.nextInt();
        in.close();
        return n;
    }

    public String numberToWords(int num)
    {
        if (num == 0)
            return "Zero";

        String temp = helper(num).trim();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < temp.length(); i++)
        {
            if (!(i > 0 && temp.charAt(i) == ' ' && temp.charAt(i - 1) == ' '))
                result.append(temp.charAt(i));
        }
        temp = result.toString();

        return temp;
    }

    private String helper(int num)
    {
        if (num < 10)
            return ones[num];
        else if (num < 20)
            return teens[num - 10];
        else if (num < 100)
            return tens[num / 10] + " " + ones[num % 10];
        else if (num < 1000)
            return ones[num / 100] + " Hundred " + helper(num % 100);

        if (num < 1_000_000)
            return helper(num / 1_000) + " Thousand " + helper(num % 1_000);
        else if (num < 1_000_000_000)
            return helper(num / 1_000_000) + " Million " + helper(num % 1_000_000);
        else
            return helper(num / 1_000_000_000) + " Billion " + helper(num % 1_000_000_000);
    }

    public static void main(String args[])
    {
        Integer2English obj = new Integer2English();
        System.out.println(obj.numberToWords(obj.input()));
    }
}
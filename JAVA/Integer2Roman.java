package JAVA;
/*Seven different symbols represent Roman numerals with the following values:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
Roman numerals are formed by appending the conversions of decimal place values from highest to lowest.
Converting a decimal place value into a Roman numeral has the following rules:

If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted
from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted
from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX.
Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10.
You cannot append 5 (V), 50 (L), or 500 (D) multiple times.
If you need to append a symbol 4 times use the subtractive form.
Given an integer, convert it to a Roman numeral.


# Intuition
The problem can be solved by mapping each Roman numeral to its corresponding integer value,
especially with the six subtractive combinations (e.g., 4, 9, 40).
By iterating through the values in descending order, we can build the Roman numeral representation
by subtracting the largest values possible until the input number reaches zero.

# Approach
1. Define Mappings: Start with a list of Roman symbols and their integer values in descending order,
                    including subtractive forms like $$CM$$ (900) and $$IV$$ (4).
2. Iterate and Append: For each symbol-value pair, append the symbol to the result as many times as possible
                       without exceeding the number, then subtract the symbol’s value from the number.
3. Build Output: Continue until the number becomes zero. The result string will then
                 represent the correct Roman numeral.

# Complexity
- Time complexity:
The time complexity is $$O(1)$$ since there is a constant number of symbols,
and we only iterate through them a few times, independent of the input size.

- Space complexity:
The space complexity is $$O(1)$$ as well, since the output string is proportional to the input number,
which has a fixed upper limit (3999).
*/


import java.util.Scanner;

class Integer2RomanSolution
{
    
    public String intToRoman(int num)
    {
        // Define the Roman numeral symbols and their corresponding values in descending order
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder answer = new StringBuilder();
        
        // Loop through each value and symbol
        for (int i = 0; i < values.length; i++)
            while (num >= values[i])
            {
                answer.append(symbols[i]);
                num -= values[i];
            }
        
        return answer.toString();
    }
    
    public int input()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number within 1 to 3999 to be converted to Roman: ");
        int n = in.nextInt();

        if (n < 1 || n > 3999)
        {
            System.out.println("Bad Input! Number should be between 1 and 3999.");
            System.exit(0);
        }
        in.close();
        return n;
    }

    public static void main(String[] args)
    {
        Integer2RomanSolution solution = new Integer2RomanSolution();
        int number = solution.input();
        System.out.println("Roman numeral: " + solution.intToRoman(number));
    }
}

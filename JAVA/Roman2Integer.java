package JAVA;
/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].



Intuition
The Roman numeral system has specific rules for combining characters to represent numbers. Roman numerals generally add values sequentially, but when a smaller numeral appears before a larger one (e.g., IV for 4), it indicates subtraction. Observing this allows us to handle the conversion with minimal complexity by processing each character from right to left and subtracting values when appropriate.

Approach
Start from the end of the Roman numeral string, moving towards the beginning.
For each character, determine its integer value.
Keep track of the previous numeral's value. If the current numeral’s value is less than the previous one, it indicates a subtractive combination (e.g., IV, IX), so we subtract the current value. Otherwise, we add it.
Continue this process until all characters are processed. This method ensures that each Roman numeral character is correctly interpreted according to Roman numeral rules.
Complexity
Time complexity:
O(n) where n is the length of the string. We process each character once.

Space complexity:
O(1) since we use only a few variables to track values and perform calculations, regardless of the input size.
*/
import java.util.Scanner;

public class Roman2Integer {

    public int romanToInt(String s) {
        // Define the values for each Roman numeral character
        int total = 0;
        int prevValue = 0;

        // Loop through each character in the string
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value;

            // Assign the value based on the character
            switch (c) {
                case 'M': value = 1000; break;
                case 'D': value = 500; break;
                case 'C': value = 100; break;
                case 'L': value = 50; break;
                case 'X': value = 10; break;
                case 'V': value = 5; break;
                case 'I': value = 1; break;
                default: value = 0; break; // Invalid character case (should not happen)
            }

            // If the current value is less than the previous value, we subtract it
            if (value < prevValue) {
                total -= value;
            } else {
                total += value;
            }

            prevValue = value; // Update the previous value for the next iteration
        }

        return total;
    }

    public String input() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Roman numeral within 1 to 3999 to be converted: ");
        String n = in.nextLine().trim().toUpperCase(); // Normalize input

        // Validate the input length
        if (n.length() < 1 || n.length() > 15) {
            System.out.println("Bad Input! Number should be between I and MMMCMXCIX.");
            System.exit(0);
        }

        // Check for valid Roman numeral characters and patterns
        if (!n.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
            System.out.println("Bad Input! The input contains invalid Roman numeral characters or patterns.");
            System.exit(0);
        }

        in.close();
        return n;
    }

    public static void main(String[] args) {
        Roman2Integer solution = new Roman2Integer();
        String n = solution.input();
        System.out.println("Number: " + solution.romanToInt(n));
    }
}

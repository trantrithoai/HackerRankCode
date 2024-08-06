public class Solution {
    public static int superDigit(String n, int k) {
        // Calculate the initial sum of the digits in the string n
        long initialSum = 0;
        for (char digit : n.toCharArray()) {
            initialSum += Character.getNumericValue(digit);
        }

        // Multiply the initial sum by k to get the total sum
        long totalSum = initialSum * k;

        // Reduce the total sum to a single digit
        return reduceToSingleDigit(totalSum);
    }

    private static int reduceToSingleDigit(long num) {
        while (num >= 10) {
            num = digitSum(num);
        }
        return (int) num;
    }

    private static long digitSum(long num) {
        long sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(superDigit("148", 3)); // Output: 3
        System.out.println(superDigit("9875", 4)); // Output: 8
        System.out.println(superDigit("123", 3)); // Output: 9
    }
}

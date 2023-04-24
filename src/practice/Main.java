package practice;

// Given two binary strings a and b, return their sum as a binary string.

// Example 1:
// Input: a = "11", b = "1"
// Output: "100"
// Example 2:
// Input: a = "1010", b = "1011"
// Output: "10101"

// Constraints:
// 1 <= a.length, b.length <= 104
// a and b consist only of '0' or '1' characters.
// Each string does not contain leading zeros except for the zero itself.

public class Main {

    public static void main(String[] args) {

        System.out.println(addBinary("11", "11"));
    }

    public static String addBinary(String a, String b) {
        int l = a.length() - b.length();
        if (l > 0) b = String.format("%0" + l + "d%s", 0, b);
        else if (l < 0) a = String.format("%0" + (-l) + "d%s", 0, a);
        int p = a.length() - 1;
        int curr, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p >= 0) {
            int sum = carry;
            sum += (a.charAt(p) - '0') + (b.charAt(p) - '0');
            carry = sum > 1 ? 1 : 0;
            sb.append(sum % 2);
            p -= 1;
        }
        if (carry == 1) sb.append('1');
        return sb.reverse().toString();
    }
}

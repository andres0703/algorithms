package leetcode;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int res = 0, num = 0, sign = 1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+' || c == '-') {
                res += sign * num;
                sign = c == '+' ? 1 : -1;
                num = 0;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += num * sign;
                num = res;
                sign = stack.pop();
                res = stack.pop();
                res += sign * num;
                num = 0;
            }
        }
        res += num * sign;

        return res;
    }

    public static void main(String[] args) {
        String q = "1-(5)";
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate(q));
    }
}

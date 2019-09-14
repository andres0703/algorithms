package leetcode;

public class BasicCalculatorII {

    public int calculate(String s) {
        int n = s.length();
        int num = 0, res = 0, sign = 1, temp = 1;
        boolean flag = true;   // true: multiply, false: divide

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '*' || c == '/') {
                temp = flag ? temp * num : temp / num;
                num = 0;
                flag = c == '*' ? true : false;
            } else if (c == '+' || c == '-') {
                temp = flag ? temp * num : temp / num;
                res += temp * sign;
                temp = 1;
                flag = true;
                sign = c == '+' ? 1 : -1;
                num = 0;
            }
        }
        temp = flag ? temp * num : temp / num;
        res += temp * sign;

        return res;
    }

    public static void main(String[] args) {
        BasicCalculatorII calculatorII = new BasicCalculatorII();
        String q = "12";
        System.out.println(calculatorII.calculate(q));
    }
}


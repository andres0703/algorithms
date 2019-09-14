package leetcode;

import java.util.*;

public class RemoveInvalidParenthesis {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (isValid(s)) {
            res.add(s);
            return res;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.add(s);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValid(cur)) {
                res.add(cur);
                continue;
            }
            int len = cur.length();

            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != ')' && s.charAt(i) != '(') {
                    continue;
                }

                String neighbor = cur.substring(0, i) + cur.substring(i + 1);
                if (set.contains(neighbor)) continue;
                queue.add(neighbor);
                set.add(neighbor);
            }
        }

        return res;
    }

    private boolean isValid(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') {
                if (count == 0) return false;
                count--;
            }
        }

        return count == 0;
    }
}

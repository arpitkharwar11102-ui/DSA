import java.util.*;

class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = solve(expression, 0, expression.length() - 1);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    private Set<String> solve(String s, int left, int right) {

        // This set stores the final result
        Set<String> result = new HashSet<>();

        // Current expression result
        Set<String> current = new HashSet<>();
        current.add("");

        int i = left;

        while (i <= right) {

            // If current character is '{'
            if (s.charAt(i) == '{') {

                int count = 1;
                int j = i + 1;

                // Find matching '}'
                while (count > 0) {
                    if (s.charAt(j) == '{') {
                        count++;
                    } else if (s.charAt(j) == '}') {
                        count--;
                    }
                    j++;
                }

                // j-1 is the position of matching '}'
                Set<String> inside = parseUnion(s, i + 1, j - 2);

                // Concatenate current with inside
                current = concatenate(current, inside);

                i = j;

            } else if (s.charAt(i) == ',') {

                // Union: add current expression to result
                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                i++;

            } else {

                // Single character
                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(s.charAt(i)));

                current = concatenate(current, letter);

                i++;
            }
        }

        result.addAll(current);

        return result;
    }

    // Handles comma-separated expressions inside braces
    private Set<String> parseUnion(String s, int left, int right) {

        Set<String> result = new HashSet<>();

        Set<String> current = new HashSet<>();
        current.add("");

        int i = left;

        while (i <= right) {

            if (s.charAt(i) == '{') {

                int count = 1;
                int j = i + 1;

                while (count > 0) {
                    if (s.charAt(j) == '{') {
                        count++;
                    } else if (s.charAt(j) == '}') {
                        count--;
                    }
                    j++;
                }

                Set<String> inside = parseUnion(s, i + 1, j - 2);

                current = concatenate(current, inside);

                i = j;

            } else if (s.charAt(i) == ',') {

                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                i++;

            } else {

                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(s.charAt(i)));

                current = concatenate(current, letter);

                i++;
            }
        }

        result.addAll(current);

        return result;
    }

    // Cartesian product = concatenation
    private Set<String> concatenate(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}
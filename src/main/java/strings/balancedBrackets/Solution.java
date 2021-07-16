package strings.balancedBrackets;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static final Map<String, String> PAIRS = new HashMap<>() {{
        put("{", "}");
        put("(", ")");
        put("[", "]");
    }};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int amount = scan.nextInt();

        for (int i = 0; i < amount; i++) {
            String data = scan.next();

            System.out.println(isBalanced(data));
        }
        scan.close();


    }

    public static String isBalanced(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")){
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.isEmpty() ? "YES": "NO";
//        while (s.length() > 0) {
//            String first = s.substring(0, 1);
//            if (!PAIRS.containsKey(first)) return "NO";
//            String pairOfFirst = PAIRS.get(first);
//            s = s.substring(1);
//            var indexOfPair = s.indexOf(pairOfFirst);
//
//            if (indexOfPair < 0) return "NO";
//
//            var children = s.substring(0, indexOfPair);
//
//            if("NO".equals(isBalanced(children))){
//                return "NO";
//            }
//            return isBalanced(s.substring(indexOfPair + 1));
//        }
//        return "YES";
    }

}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_Q9012 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();

            for (int i = 0; i < s.length(); i++) {
                char p = s.charAt(i);
                if (p == '(') {
                    stack.push(p);
                } else {
                    if (stack.empty()) {
                        stack.push(p);
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

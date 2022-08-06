package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_Q1874 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean isPossible = true;

        int num = 1;
        for (int i = 1; i <= N; i++) {
            int reqNum = Integer.parseInt(br.readLine());

            if (stack.empty()) {
                stack.push(num++);
                sb.append("+\n");
            }

            if (reqNum < num && stack.peek() > reqNum) {
                isPossible = false;
                break;
            }

            while (stack.peek() < reqNum) {
                stack.push(num++);
                sb.append("+\n");
            }

            while (stack.peek() >= reqNum) {
                stack.pop();
                sb.append("-\n");
                if (stack.empty()) {
                    break;
                }
            }
        }

        if (isPossible) {
            String ans = sb.toString();
            System.out.print(ans);
        } else {
            System.out.println("NO");
        }
    }
}

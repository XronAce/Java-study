package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String postfix = br.readLine();
        int[][] num = new int[N][1];
        for (int i=0; i<N; i++) {
            num[i][0] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (int i=0; i<postfix.length(); i++) {
            if (postfix.charAt(i) == '+') {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.push(num2 + num1);
            } else if (postfix.charAt(i) == '-') {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (postfix.charAt(i) == '*') {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.push(num2 * num1);
            } else if (postfix.charAt(i) == '/') {
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push((double) num[postfix.charAt(i) - 'A'][0]);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}

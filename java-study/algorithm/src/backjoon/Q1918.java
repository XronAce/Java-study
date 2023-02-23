package backjoon;

import java.io.*;
import java.util.Stack;

public class Q1918 {
    static int priority(char temp) {
        if(temp == '(') return 0;
        else if(temp == '+' || temp == '-') return 1;
        else return 2;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        for(int i=0; i<input.length(); i++) {
            char temp = input.charAt(i);
            if('A'<=temp && temp <= 'Z') {
                sb.append(temp);
            }
            else if(temp == '(') {
                stack.add('(');
            }
            else if(temp == ')') {
                while(!stack.isEmpty()) {
                    if(stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    sb.append(stack.pop());
                }
            }
            else {
                while(!stack.isEmpty() && priority(stack.peek()) >= priority(temp)) {
                    sb.append(stack.pop());
                }
                stack.add(temp);
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_Q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        Stack<Character> leftside = new Stack<>();
        Stack<Character> rightside = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            leftside.push(s.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        for (int command_case = 1; command_case <= M; command_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("L") && !leftside.empty()) {
                rightside.push(leftside.pop());
            } else if (command.equals("D") && !rightside.empty()) {
                leftside.push(rightside.pop());
            } else if (command.equals("B") && !leftside.empty()) {
                leftside.pop();
            } else if (command.equals("P")) {
                leftside.push(st.nextToken().charAt(0));
            }
        }

        while (!leftside.empty()) {
            rightside.push(leftside.pop());
        }

        while (!rightside.empty()) {
            bw.write(rightside.pop());
        }

        bw.flush();
        bw.close();
    }
}

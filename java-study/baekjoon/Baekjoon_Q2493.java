package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_Q2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.empty()) {
                if (!stack.empty()) {
                    if (stack.peek()[0] < height) {
                        stack.pop();
                    } else {
                        sb.append(stack.peek()[1]).append(" ");
                        break;
                    }
                }
            }

            if (stack.empty()) {
                sb.append(0).append(" ");
            }
            stack.push(new int[] { height, i + 1 });
        }

        System.out.println(sb);
    }
}

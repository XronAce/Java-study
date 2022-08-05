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

        int[] towers = new int[N];
        Stack<Integer> answer = new Stack<>();
        Stack<Integer> tower = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            tower.push(t);
            towers[i] = t;
        }

        int cnt = 0;
        int num = N;
        int idx = N - 1;
        boolean flag = false;
        while (!tower.empty()) {
            int i = tower.pop();
            idx--;
            if (tower.empty()) {
                answer.push(0);
                break;
            }
            if (tower.peek() < i) {
                for (int index = idx; index >= 0; index--) {
                    if (towers[index] >= i) {
                        answer.push(index);
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    answer.push(0);
                }
            } else {
                answer.push(idx);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!answer.empty()) {
            sb.append(answer.pop());
            sb.append(" ");
        }
        String answer1 = sb.toString();
        System.out.println(answer1);
    }
}

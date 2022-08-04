package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_Q9093 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = new StringBuilder();
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                for (int i = 0; i < s.length(); i++) {
                    stack.push(String.valueOf(s.charAt(i)));
                }

                for (int i = 0; i < s.length(); i++) {
                    sb.append(stack.pop());
                }

                sb.append(" ");
            }
            sb.append("\n");

            String s1 = sb.toString();
            System.out.print(s1);

        }
    }
}

/*
 * System.out.print 가 여러번 호출 될 경우 시간초과가 남.
 * 이런 경우를 대비해서 출력 과정에서 System.out을 많이 써야할 때 StringBuilder로 합쳐놓고 출력하는 방식을 채택하거나
 * BufferedWriter를 채택할 수 있도록 해야함.
 */
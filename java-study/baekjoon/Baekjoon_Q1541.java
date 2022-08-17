package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, "+|-", true);

        int ans = 0;
        String temp = "";
        boolean isParenthesisOpened = false;
        while (st.hasMoreTokens()) {
            temp = st.nextToken();
            if (temp.equals("-")) {
                isParenthesisOpened = true;
                continue;
            } else if (temp.equals("+")) {
                continue;
            }

            if (isParenthesisOpened) {
                ans -= Integer.parseInt(temp);
            } else {
                ans += Integer.parseInt(temp);
            }
        }
        System.out.println(ans);
    }
}

/*
 * -를 만나는 순간부터 모든 숫자를 다 빼면 된다. 그 전 까지는 덧셈을 허용한다.
 */
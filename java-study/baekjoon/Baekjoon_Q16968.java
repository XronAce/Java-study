package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q16968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean isAfterChar = false;
        int ans = 1;

        if (s.charAt(0) == 'c') {
            isAfterChar = false;
        } else {
            isAfterChar = true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isAfterChar && s.charAt(i) == 'c') {
                ans *= 25;
                isAfterChar = true;
            } else if (isAfterChar && s.charAt(i) == 'd') {
                ans *= 10;
                isAfterChar = false;
            } else if (!isAfterChar && s.charAt(i) == 'c') {
                ans *= 26;
                isAfterChar = true;
            } else if (!isAfterChar && s.charAt(i) == 'd') {
                ans *= 9;
                isAfterChar = false;
            }
        }
        System.out.println(ans);
    }
}

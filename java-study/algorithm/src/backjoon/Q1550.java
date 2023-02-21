package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.StrictMath.pow;

public class Q1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hex = br.readLine();
        double answer = 0;

        for (int i=0; i<hex.length(); i++) {
            double pow = pow(16, (hex.length() - i - 1));
            if (hex.charAt(i) == 'A') {
                answer += 10 * pow;
            } else if (hex.charAt(i) == 'B') {
                answer += 11 * pow;
            } else if (hex.charAt(i) == 'C') {
                answer += 12 * pow;
            } else if (hex.charAt(i) == 'D') {
                answer += 13 * pow;
            } else if (hex.charAt(i) == 'E') {
                answer += 14 * pow;
            } else if (hex.charAt(i) == 'F') {
                answer += 15 * pow;
            } else {
                answer += (hex.charAt(i) - '0') * ((int) pow);
            }
        }
        System.out.println((int) answer);
    }
}

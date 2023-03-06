package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (true) {
            if (isPelindrome(N)) {
                if (isPrime(N)) {
                    break;
                }
            }
            N++;
        }

        System.out.println(N);
    }

    public static boolean isPelindrome(int N) {
        String number = String.valueOf(N);

        for (int i=0; i<number.length()/2; i++) {
            if (number.charAt(i) - '0' == number.charAt(number.length() - i - 1) - '0') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int N) {
        if (N <= 1) {
            return false;
        }

        for (int i = 2; i<= ((int) Math.sqrt(N)); i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }
}

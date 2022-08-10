package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q1010 {
    static double factorial(double n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        double n, r, nCr;
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            nCr = factorial(n) / (factorial(r) * factorial(n - r));

            System.out.println(Math.round(nCr));
        }

    }
}

/*
 * factorial 구현할 때 n == 0 기준을 꼭 맞춰주자.
 * 연산 범위를 위해 double로 했을 시 int 로의 명시적 형변환 진행할 때 버림 현상을 반올림 처리할 수 있도록 하자.
 */
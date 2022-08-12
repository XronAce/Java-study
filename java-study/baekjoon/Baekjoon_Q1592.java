package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] ballCnt = new int[N + 1];
        ballCnt[1] = 1;

        int curBall = 1;
        int thr = 0;
        while (true) {
            if (ballCnt[curBall] % 2 == 1) {
                curBall += L;
                thr++;
                if (curBall > N) {
                    curBall -= N;
                }
                ballCnt[curBall]++;
                if (ballCnt[curBall] == M) {
                    break;
                }
            } else {
                curBall -= L;
                thr++;
                if (curBall < 1) {
                    curBall += N;
                }
                ballCnt[curBall]++;
                if (ballCnt[curBall] == M) {
                    break;
                }
            }
        }

        if (M == 1) {
            System.out.println(0);
        } else {
            System.out.println(thr);
        }

    }
}

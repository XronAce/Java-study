package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Customer {
    int r, c;

    public Customer(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class SWEA_Q1247 {
    public static Customer[] customers;
    public static int N, ans, startR, startC, destR, destC;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case < T + 1; test_case++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            startR = Integer.parseInt(st.nextToken());
            startC = Integer.parseInt(st.nextToken());
            destR = Integer.parseInt(st.nextToken());
            destC = Integer.parseInt(st.nextToken());

            customers = new Customer[N];
            for (int i = 0; i < N; i++) {
                customers[i] = new Customer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            ans = Integer.MAX_VALUE;
            permutation(0, new boolean[N], new int[N]);

            System.out.println("#" + test_case + " " + ans);
        }
    }

    public static void permutation(int cnt, boolean[] isSelected, int[] out) {
        if (cnt == N) {
            int distance = 0;
            int tempR = startR;
            int tempC = startC;
            for (int i = 0; i < N; i++) {
                distance += Math.abs(tempR - customers[out[i]].r) + Math.abs(tempC - customers[out[i]].c);
                tempR = customers[out[i]].r;
                tempC = customers[out[i]].c;
            }
            distance += Math.abs(tempR - destR) + Math.abs(tempC - destC);
            ans = Math.min(ans, distance);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                out[cnt] = i;
                permutation(cnt + 1, isSelected, out);
                isSelected[i] = false;
            }
        }
    }
}
/* */
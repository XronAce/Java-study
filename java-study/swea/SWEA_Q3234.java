package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q3234 {
    public static int N, ans;
    public static int[] weights, output;
    public static boolean[] isSelected;
    public static boolean[] isOnLeft;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < T + 1; test_case++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            weights = new int[N];
            output = new int[N];
            isSelected = new boolean[N];
            isOnLeft = new boolean[N];
            ans = 0;
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }

            permutation(0);
            System.out.println("#" + test_case + " " + ans);
        }
    }

    public static void permutation(int cnt) {
        if (cnt == N) {
            check(0, 0, 0);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                output[cnt] = weights[i];
                permutation(cnt + 1);
                isSelected[i] = false;
            }
        }
    }

    public static void check(int cnt, int sumLeft, int sumRight) {
        if (sumLeft < sumRight) {
            return;
        }
        if (cnt == N) {
            if (sumLeft >= sumRight) {
                ans++;
            }
            return;
        }
        isOnLeft[cnt] = true;
        check(cnt + 1, sumLeft + output[cnt], sumRight);
        isOnLeft[cnt] = false;
        check(cnt + 1, sumLeft, sumRight + output[cnt]);
    }
}

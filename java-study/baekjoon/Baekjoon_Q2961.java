package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q2961 {
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[] bitter;
    static int[] sour;
    static boolean[] isSelected;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        bitter = new int[N];
        sour = new int[N];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            bitter[i] = Integer.parseInt(st.nextToken());
            sour[i] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0, 1, 0);

        System.out.println(ans);
    }

    public static void combination(int materialCnt, int cnt, int bitterness, int sourness) {
        if (cnt == N) {
            if (materialCnt != 0) {
                if (bitterness - sourness > 0) {
                    ans = Math.min(bitterness - sourness, ans);
                } else {
                    ans = Math.min(sourness - bitterness, ans);
                }
            }
            return;
        }
        combination(materialCnt + 1, cnt + 1, bitterness * bitter[cnt], sourness + sour[cnt]);
        combination(materialCnt, cnt + 1, bitterness, sourness);
    }
}

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q4012 {
    static int N, idx1, idx2, synergyA, synergyB;
    static int synergyDiff;
    static int[][] synergy;
    static boolean[] isSelected;
    static int[] selected, unselected;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < T + 1; test_case++) {
            synergyDiff = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());

            synergy = new int[N][N];
            isSelected = new boolean[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            selection(0, 0);

            System.out.println("#" + test_case + " " + synergyDiff);

        }
    }

    public static void selection(int cnt, int start) {
        if (cnt == N / 2) {
            idx1 = 0;
            idx2 = 0;
            selected = new int[N / 2];
            unselected = new int[N / 2];
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    selected[idx1++] = i;
                } else {
                    unselected[idx2++] = i;
                }
            }
            synergyA = 0;
            synergyB = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    synergyA += synergy[selected[i]][selected[j]];
                }
            }
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    synergyB += synergy[unselected[i]][unselected[j]];
                }
            }
            if (synergyA - synergyB > 0)
                synergyDiff = Math.min(synergyDiff, synergyA - synergyB);
            else
                synergyDiff = Math.min(synergyDiff, synergyB - synergyA);
        }
        for (int i = start; i < N; i++) {
            isSelected[i] = true;
            selection(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }
}

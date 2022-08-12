package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q3985 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] possibleMax = new int[N];
        for (int i = 0; i < N; i++) {
            possibleMax[i] = arr[i][1] - arr[i][0];
        }

        int[] rollcake = new int[L + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = arr[i - 1][0]; j <= arr[i - 1][1]; j++) {
                if (rollcake[j] == 0)
                    rollcake[j] = i;
            }
        }

        int[] count = new int[N + 1];
        for (int checkno = 1; checkno <= N; checkno++) {
            for (int i = 0; i < rollcake.length; i++) {
                if (rollcake[i] == checkno) {
                    count[checkno]++;
                }
            }
        }

        int maxCount = 0;
        int maxPossible = 0;
        for (int i = 0; i < possibleMax.length; i++) {
            maxPossible = Math.max(maxPossible, possibleMax[i]);
        }

        for (int i = 0; i < possibleMax.length; i++) {
            if (possibleMax[i] == maxPossible) {
                System.out.println(i + 1);
                break;
            }
        }

        for (int i = 0; i < count.length; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount) {
                System.out.println(i);
                break;
            }
        }
    }
}

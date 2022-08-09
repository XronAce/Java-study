package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q6808 {
    static int winCnt = 0;
    static int loseCnt = 0;

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void permutation(int[] player1, int[] arr, int[] out, boolean[] visited, int depth, int r) {
        if (depth == r) {
            int player1Sum = 0;
            int player2Sum = 0;
            for (int i = 0; i < 9; i++) {
                if (player1[i] > out[i]) {
                    player1Sum += player1[i] + out[i];
                } else {
                    player2Sum += player1[i] + out[i];
                }
            }

            if (player1Sum > player2Sum) {
                winCnt++;
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(player1, arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] player1;
        int[] player2;
        boolean isNotInPlayer1 = true;

        for (int test_case = 1; test_case < T + 1; test_case++) {
            int loseCnt = 0;
            st = new StringTokenizer(br.readLine(), " ");

            player1 = new int[9];
            player2 = new int[9];
            int a = 0;
            for (int i = 0; i < 9; i++) {
                player1[i] = Integer.parseInt(st.nextToken());
            }

            // Fill up player2's cards
            for (int i = 1; i < 19; i++) {
                for (int j = 0; j < 9; j++) {
                    if (player1[j] == i) {
                        isNotInPlayer1 = false;
                        break;
                    }
                }
                if (isNotInPlayer1) {
                    player2[a++] = i;
                }
                isNotInPlayer1 = true;
            }

            permutation(player1, player2, new int[9], new boolean[9], 0, 9);

            loseCnt = factorial(9) - winCnt;
            System.out.println("#" + test_case + " " + winCnt + " " + loseCnt);
            winCnt = 0;
        }
    }
}
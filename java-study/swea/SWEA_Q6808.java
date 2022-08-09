package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_Q6808 {
    static int[][] possiblePermOfPlayer2 = new int[factorial(9)][9];
    static int idx = 0;

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++) {
            possiblePermOfPlayer2[idx][i] = arr[i];
        }
        idx++;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] player1;
        int[] player2;
        boolean isNotInPlayer1 = true;

        StringBuilder answer = new StringBuilder();
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

            permutation(player2, 0, 9, 9);

            for (int j = 0; j < possiblePermOfPlayer2.length; j++) {
                int sumPlayer1 = 0;
                int sumPlayer2 = 0;
                for (int i = 0; i < 9; i++) {
                    if (possiblePermOfPlayer2[j][i] > player1[i]) {
                        sumPlayer2 += possiblePermOfPlayer2[j][i] + player1[i];
                    } else {
                        sumPlayer1 += possiblePermOfPlayer2[j][i] + player1[i];
                    }
                }
                if (sumPlayer2 > sumPlayer1) {
                    loseCnt++;
                }
            }
            int winCnt = factorial(9) - loseCnt;
            answer.append("#" + test_case + " " + winCnt + " " + loseCnt + "\n");
            possiblePermOfPlayer2 = new int[factorial(9)][9];
            idx = 0;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = answer.toString();
        bw.write(s);
        bw.flush();
        bw.close();
    }
}

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q6808 {

    static int[] player1, player2, numbers;
    static int win, lose;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            player1 = new int[9];
            for (int i = 0; i < 9; i++) {
                player1[i] = Integer.parseInt(st.nextToken());
            }
            player2 = new int[9];
            int index = 0;
            for (int i = 1; i <= 18; i++) {
                boolean flag = false;
                for (int num : player1) {
                    if (num == i)
                        flag = true;
                }
                if (flag)
                    continue;
                player2[index++] = i;
            }
            numbers = new int[9];
            win = 0;
            lose = 0;
            permu(0, 0);
            sb.append(win).append(" ").append(lose).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static void permu(int cnt, int flag) {
        if (cnt == 9) {
            int player1Sum = 0;
            int player2Sum = 0;
            for (int i = 0; i < 9; i++) {
                if (player1[i] > numbers[i]) {
                    player1Sum += player1[i] + numbers[i];
                } else {
                    player2Sum += player1[i] + numbers[i];
                }
            }
            if (player1Sum > player2Sum) {
                win++;
            } else if (player1Sum < player2Sum) {
                lose++;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if ((flag & 1 << i) != 0)
                continue;
            numbers[cnt] = player2[i];
            permu(cnt + 1, flag | 1 << i);
        }
    }

}
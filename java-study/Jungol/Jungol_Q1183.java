package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jungol_Q1183 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int W = Integer.parseInt(br.readLine());

        int[] coins = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 6; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[6];
        // 1원 처리
        int modulo = W % 10;
        if (modulo <= coins[5]) {
            answer[5] += modulo;
            W -= modulo;
            coins[5] -= modulo;
        } else {
            answer[5] += modulo - 5;
            answer[4] += 1;
            W -= modulo;
            coins[5] -= modulo - 5;
            coins[4] -= 1;
        }

        // 5원 처리
        int share = W / 5;
        if (share <= coins[4]) {
            answer[4] += share;
            W -= share * 5;
            coins[4] -= share;
        } else {
            if (coins[4] % 2 == 0) {
                answer[4] += coins[4];
                W -= coins[4] * 5;
                coins[4] = 0;
            } else {
                answer[4] += coins[4] - 1;
                W -= (coins[4] - 1) * 5;
                coins[4] = 1;
            }
        }

        // 10원 처리
        share = W / 10;
        if (share <= coins[3]) {
            answer[3] += share;
            W -= share * 10;
            coins[3] -= share;
        } else {
            if (coins[3] % 10 == 0) {
                answer[3] += coins[3];
                W -= coins[3] * 10;
                coins[3] = 0;
            } else {

            }
            answer[3] += share;
            W -= share * 10;
            coins[3] -= share;
        }

        // 50원 처리
        share = W / 50;
        if (share <= coins[2]) {
            answer[2] += share;
            W -= share * 50;
            coins[2] -= share;
        } else {
            if (coins[2] % 2 == 0) {
                answer[2] += coins[2];
                W -= coins[2] * 50;
                coins[2] = 0;
            } else {
                answer[2] += coins[2] - 1;
                W -= (coins[2] - 1) * 50;
                coins[2] = 1;
            }
        }

        // 100원 처리
        share = W / 100;
        if (share <= coins[1]) {
            answer[1] += share;
            W -= share * 100;
            coins[1] -= share;
        } else {
            answer[1] += share;
            W -= share * 100;
            coins[1] -= share;
        }

        // 500원 처리
        share = W / 500;
        if (share <= coins[0]) {
            answer[0] += share;
            W -= share * 500;
            coins[0] -= share;
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q2023 {
    static Boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(9);
            if (i == 0)
                sb2.append(1);
            else
                sb2.append(0);
        }

        int maxNum = Integer.valueOf(sb.toString());
        int minNum = Integer.valueOf(sb2.toString());
        boolean flag = false;
        String s = "";

        while (maxNum != minNum) {
            for (int i = 0; i < N; i++) {
                s = String.valueOf(minNum).substring(0, N - i);
                if (isPrime(Integer.valueOf(s))) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.println(minNum);
            }
            flag = false;
            minNum++;
        }

    }
}

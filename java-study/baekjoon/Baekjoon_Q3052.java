package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q3052 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int[] leftover = new int[10];
        for (int i = 0; i < 10; i++) {
            n = Integer.parseInt(br.readLine());
            leftover[i] = n % 42;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i != j) {
                    if (leftover[i] == leftover[j]) {
                        leftover[j] = 42;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (leftover[i] != 42) {
                count++;
            }
        }

        System.out.println(count);
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_Q2309 {
    static int[] dwarf;
    static boolean[] isSelected;
    static int sum;
    static boolean isFound;
    static StringBuilder sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dwarf = new int[9];
        isSelected = new boolean[9];
        sb = new StringBuilder();
        isFound = false;

        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dwarf);
        combination(0, 0);
        System.out.println(sb);
    }

    public static void combination(int cnt, int start) {
        if (cnt == 7) {
            sum = 0;
            for (int i = 0; i < 9; i++) {
                if (isSelected[i]) {
                    sum += dwarf[i];
                }
            }
            if (sum == 100) {
                if (isFound) {
                    return;
                }
                isFound = true;
                for (int i = 0; i < 9; i++) {
                    if (isSelected[i]) {
                        sb.append(dwarf[i]).append("\n");
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                combination(cnt + 1, i + 1);
                isSelected[i] = false;
            }
        }
    }
}

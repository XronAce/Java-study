package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_Q1759 {
    public static int L, C;
    public static String[] letters;
    public static boolean[] isSelected;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        letters = new String[C];
        isSelected = new boolean[C];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken();
        }
        Arrays.sort(letters);

        combination(0, 0);
        System.out.println(sb);

    }

    public static void combination(int cnt, int start) {
        if (cnt == L) {
            int cntVowel = 0;
            int cntNonVowel = 0;
            String res = "";
            for (int i = 0; i < C; i++) {
                if (isSelected[i]) {
                    if (letters[i].equals("a") || letters[i].equals("e") || letters[i].equals("i")
                            || letters[i].equals("o") || letters[i].equals("u")) {
                        cntVowel++;
                    } else {
                        cntNonVowel++;
                    }
                }
            }
            if (cntVowel >= 1 && cntNonVowel >= 2) {
                for (int i = 0; i < C; i++) {
                    if (isSelected[i]) {
                        res += letters[i];
                    }
                }
                sb.append(res).append("\n");
            }
            return;
        }
        for (int i = start; i < C; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                combination(cnt + 1, i + 1);
                isSelected[i] = false;
            }
        }
    }

}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baekjoon_Q10825 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] score = new String[N][4];

        for (int i = 0; i < N; i++) {
            score[i] = br.readLine().split(" ");
        }

        Arrays.sort(score, new Comparator<String[]>() {

            @Override
            public int compare(String[] o1, String[] o2) {
                int kor1 = Integer.valueOf(o1[1]);
                int kor2 = Integer.valueOf(o2[1]);
                int eng1 = Integer.valueOf(o1[2]);
                int eng2 = Integer.valueOf(o2[2]);
                int math1 = Integer.valueOf(o1[3]);
                int math2 = Integer.valueOf(o2[3]);

                if (kor1 == kor2 && eng1 == eng2 && math1 == math2) {
                    return o1[0].compareTo(o2[0]);
                } else if (kor1 == kor2 && eng1 == eng2) {
                    return math2 - math1;
                } else if (kor1 == kor2) {
                    return eng1 - eng2;
                } else {
                    return kor2 - kor1;
                }
            }

        });

        StringBuilder sb = new StringBuilder();

        for (String[] innerArr : score) {
            sb.append(innerArr[0]).append("\n");
        }

        System.out.println(sb);
    }
}

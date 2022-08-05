package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String[] dna = br.readLine().split("");

        st = new StringTokenizer(br.readLine(), " ");
        int reqA = Integer.parseInt(st.nextToken());
        int reqC = Integer.parseInt(st.nextToken());
        int reqG = Integer.parseInt(st.nextToken());
        int reqT = Integer.parseInt(st.nextToken());

        int cntPossiblePw = 0;
        int cntA = 0;
        int cntC = 0;
        int cntG = 0;
        int cntT = 0;

        int maxPossiblePw = S - P + 1;

        for (int i = 0; i < maxPossiblePw; i++) {
            for (int j = i; j < i + P; j++) {
                if (dna[j].equals("A"))
                    cntA++;
                else if (dna[j].equals("C"))
                    cntC++;
                else if (dna[j].equals("G"))
                    cntG++;
                else
                    cntT++;
            }
            if (cntA >= reqA && cntC >= reqC && cntG >= reqG && cntT >= reqT) {
                cntPossiblePw++;
            }
            cntA = 0;
            cntC = 0;
            cntG = 0;
            cntT = 0;
        }

        System.out.println(cntPossiblePw);
    }
}

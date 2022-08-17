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

        int cntA = 0;
        int cntC = 0;
        int cntG = 0;
        int cntT = 0;
        int ans = 0;

        int stIdx = 0;
        int endIdx = stIdx + P;

        for (int i = stIdx; i < endIdx; i++) {
            if (dna[i].equals("A")) {
                cntA++;
            } else if (dna[i].equals("C")) {
                cntC++;
            } else if (dna[i].equals("G")) {
                cntG++;
            } else if (dna[i].equals("T")) {
                cntT++;
            }
        }

        if (cntA >= reqA && cntC >= reqC && cntG >= reqG && cntT >= reqT) {
            ans++;
        }
        endIdx++;
        while (endIdx <= S) {
            if (dna[stIdx].equals("A")) {
                cntA--;
            } else if (dna[stIdx].equals("C")) {
                cntC--;
            } else if (dna[stIdx].equals("G")) {
                cntG--;
            } else if (dna[stIdx].equals("T")) {
                cntT--;
            }

            if (dna[endIdx - 1].equals("A")) {
                cntA++;
            } else if (dna[endIdx - 1].equals("C")) {
                cntC++;
            } else if (dna[endIdx - 1].equals("G")) {
                cntG++;
            } else if (dna[endIdx - 1].equals("T")) {
                cntT++;
            }
            if (cntA >= reqA && cntC >= reqC && cntG >= reqG && cntT >= reqT) {
                ans++;
            }
            stIdx++;
            endIdx++;
        }

        System.out.println(ans);
    }
}

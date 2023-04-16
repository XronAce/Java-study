package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] pillar = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<M; i++) {
            pillar[i] = Integer.parseInt(st.nextToken());
        }

        int height;

        height = pillar[0];
        height = Math.max(N - pillar[M-1], height);

        for (int i=0; i<M-1; i++) {
            if ((pillar[i+1] - pillar[i]) % 2 == 1) {
                height = Math.max((pillar[i+1] - pillar[i])/2+1, height);
            } else {
                height = Math.max((pillar[i+1] - pillar[i])/2, height);
            }
        }

        System.out.println(height);
    }
}

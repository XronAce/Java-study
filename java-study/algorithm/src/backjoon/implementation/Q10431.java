package backjoon.implementation;

import java.io.*;
import java.util.*;

public class Q10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int ans = 0;

        int T = Integer.parseInt(br.readLine());

        int[][] children = new int[T][21];
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 21; j++) {
                children[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<T; i++) {
            for (int j=1; j<21; j++) {
                for (int k=1; k<j; k++) {
                    if (children[i][k] > children[i][j]) {
                        ans++;
                    }
                }
            }
            bw.write(children[i][0]+ " " + ans+"\n");
            ans = 0;
        }


        bw.flush();
        bw.close();
        br.close();
    }
}

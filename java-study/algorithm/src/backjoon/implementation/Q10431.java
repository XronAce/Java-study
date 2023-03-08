package backjoon.implementation;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

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
            for (int j=0; j<21; j++) {
                children[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<T; i++) {
            deque.offerLast(children[i][1]);
            for (int j=2; j<21; j++) {
                if (deque.peekLast() > children[i][j]) {
                    ans += deque.size();
                    deque.offerFirst(children[i][j]);
                } else {
                    deque.offerLast(children[i][j]);
                }
            }
            deque.clear();
            bw.write(i+1 + " " + ans+"\n");
            ans = 0;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

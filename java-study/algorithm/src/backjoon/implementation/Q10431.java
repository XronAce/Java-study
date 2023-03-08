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
            for (int j=0; j<21; j++) {
                children[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        int idx;
        for (int i=0; i<T; i++) {
            list.offer(children[i][1]);
            for (int j=2; j<21; j++) {
                idx = -1;
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(k) > children[i][j]) {
                        idx = k;
                        break;
                    }
                }

                if (idx == -1) {
                    list.offerLast(children[i][j]);
                } else if (idx == 0) {
                    list.offerFirst(children[i][j]);
                    ans += list.size() - 1;
                } else {
                    list.add(idx-1, children[i][j]);
                    ans += list.size() - idx - 1;
                }
//                System.out.println(list);
//                System.out.println(ans);
            }
            bw.write(children[i][0] + " " + ans + "\n");
            ans = 0;
            list.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

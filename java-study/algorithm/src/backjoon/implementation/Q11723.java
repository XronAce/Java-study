package backjoon.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class Q11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCommand = Integer.parseInt(br.readLine());
        boolean[] isNumInS = new boolean[21];

        StringTokenizer st;

        for (int i=0; i<numCommand; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int num = 0;

            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            if (command.equals("add")) {
                isNumInS[num] = true;
            } else if (command.equals("remove")) {
                isNumInS[num] = false;
            } else if (command.equals("check")) {
                if (isNumInS[num]) {
                    bw.write(1+"\n");
                } else {
                    bw.write(0+"\n");
                }
            } else if (command.equals("toggle")) {
                if (isNumInS[num]) {
                    isNumInS[num] = false;
                } else {
                    isNumInS[num] = true;
                }
            } else if (command.equals("all")) {
                for (int j=1; j<=20; j++) {
                    isNumInS[j] = true;
                }
            } else {
                for (int j=1; j<=20; j++) {
                    isNumInS[j] = false;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

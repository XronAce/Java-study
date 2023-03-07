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

            switch (command) {
                case "add":
                    isNumInS[num] = true;
                    break;
                case "remove":
                    isNumInS[num] = false;
                    break;
                case "check":
                    if (isNumInS[num]) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
                case "toggle":
                    if (isNumInS[num]) {
                        isNumInS[num] = false;
                    } else {
                        isNumInS[num] = true;
                    }
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        isNumInS[j] = true;
                    }
                    break;
                default:
                    for (int j = 1; j <= 20; j++) {
                        isNumInS[j] = false;
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

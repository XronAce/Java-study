package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_Q1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            List<Integer> password = new ArrayList<>();
            int s = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < s; i++) {
                password.add(Integer.parseInt(st.nextToken()));
            }

            int commandNum = Integer.parseInt(br.readLine());
            String[] commands = new String[commandNum];

            st = new StringTokenizer(br.readLine(), "I");
            for (int j = 0; j < commandNum; j++) {
                commands[j] = st.nextToken();
            }
            System.out.println();

            for (int j = 0; j < commandNum; j++) {
                st = new StringTokenizer(commands[j], " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                for (int k = 0; k < y; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    password.add(x++, temp);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                sb.append(password.get(i) + " ");
            }

            System.out.print(sb);
        }
    }
}

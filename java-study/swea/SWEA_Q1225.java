package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SWEA_Q1225 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int garb = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            Queue<Integer> password = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                password.add(Integer.parseInt(st.nextToken()));
            }

            Boolean isLastDigitZero = false;

            while (!isLastDigitZero) {
                for (int i = 1; i <= 5; i++) {
                    int num = password.poll() - i;
                    if (num <= 0) {
                        num = 0;
                    }
                    password.add(num);
                    if (num == 0) {
                        isLastDigitZero = true;
                        break;
                    }
                }
            }

            System.out.print("#" + garb + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(password.poll() + " ");
            }
            System.out.println();
        }

    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_Q4153 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] sides = new int[3];
            for (int i = 0; i < 3; i++) {
                sides[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(sides);
            if (sides[0] != 0) {
                if (sides[2] * sides[2] == sides[0] * sides[0] + sides[1] * sides[1])
                    System.out.println("right");
                else
                    System.out.println("wrong");
            } else {
                break;
            }
        }
    }
}

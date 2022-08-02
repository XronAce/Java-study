package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Q1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int locX = Integer.parseInt(st.nextToken());
        int locY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        int min = 1000;
        min = Math.min(min, locX-0);
        min = Math.min(min, endX-locX);
        min = Math.min(min, locY-0);
        min = Math.min(min, endY-locY);

        System.out.println(min);
    }
}

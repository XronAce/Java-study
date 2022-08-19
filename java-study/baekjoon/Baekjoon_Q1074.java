package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q1074 {
    public static int[][] arr;

    public static void fill(int[][] arr, int r, int c, int size) {

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        arr = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];

    }
}

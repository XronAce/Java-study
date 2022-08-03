package baekjoon;

import java.util.Scanner;

public class Baekjoon_Q2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String number = String.valueOf(N);
        String[] digits = number.split("");

        int min = N - digits.length * 9;

        int answer = 0;

        for (int i = min; i < N; i++) {
            int n = i;
            int digitSum = 0;

            while (n != 0) {
                digitSum += n % 10;
                n /= 10;
            }

            if (digitSum + i == N) {
                answer = i;
                break;
            }
        }

        if (answer != 0) {
            System.out.println(answer);
        } else {
            System.out.println("0");
        }
        sc.close();
    }
}

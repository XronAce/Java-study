package baekjoon;

import java.util.Scanner;

public class Baekjoon_Q2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        int dayCount = (V - B) / (A - B);

        if ((V - B) % (A - B) != 0) {
            dayCount++;
        }

        System.out.println(dayCount);
        sc.close();
    }
}

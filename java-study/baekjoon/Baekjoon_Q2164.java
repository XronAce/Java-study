package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_Q2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> card = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            card.add(i);
        }

        while (card.size() != 1) {
            card.poll();
            if (card.size() == 1) {
                break;
            }
            card.add(card.poll());
        }

        System.out.println(card.poll());
        sc.close();
    }
}

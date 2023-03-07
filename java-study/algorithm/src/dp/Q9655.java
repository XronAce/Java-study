package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int leftover = N % 4;

        switch(leftover) {
            case 0:
            case 2:
                System.out.println("CY");
                break;
            case 1:
            case 3:
                System.out.println("SK");
                break;
        }
    }
}

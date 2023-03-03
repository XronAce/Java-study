package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pay = Integer.parseInt(br.readLine());

        int leftover = 1000 - pay;
        int[] coinType = {500, 100, 50, 10, 5, 1};
        int ans = 0;

        for (int i=0; i<coinType.length; i++) {
            while (leftover >= coinType[i]) {
                leftover -= coinType[i];
                ans++;
            }
        }

        System.out.println(ans);
    }
}

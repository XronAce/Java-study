package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q5607 {
    public static long factorial[] = new long[1000001];
    public static int divNum = 1234567891;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        factorial[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            factorial[i] = factorial[i - 1] * i % divNum;
        }

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long c1 = factorial[N];
            long c2 = (factorial[N - R] * factorial[R]) % divNum;
            long c3 = pow(c2, divNum - 2);

            long ans = c1 * c3 % divNum;

            System.out.println("#"+test_case+" "+ans);

        }
    }
    
    public static long pow(long n, long r) {
        if (r == 1) {
            return n;
        }
        
        long x = pow(n, r / 2) % divNum;
        if (r % 2 == 0) {
            return x * x % divNum;
        } else {
            return ((x * x) % divNum * n) % divNum;
        }
    }
    

}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = br.readLine();
            if (Integer.parseInt(s) == 0)
                break;
            
            StringBuilder rev = new StringBuilder();
            rev.append(s);
            rev.reverse();
            String revS = rev.toString();

            if(s.equals(revS))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}


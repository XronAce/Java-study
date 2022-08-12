package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_Q2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");

        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("c")) {
                if (i + 1 < s.length && s[i + 1].equals("=")) {
                    s[i + 1] = "0";
                } else if (i + 1 < s.length && s[i + 1].equals("-")) {
                    s[i + 1] = "0";
                }
            } else if (s[i].equals("d")) {
                if (i + 1 < s.length && s[i + 1].equals("z")) {
                    if (i + 2 < s.length && s[i + 2].equals("=")) {
                        s[i + 1] = "0";
                        s[i + 2] = "0";
                    }
                } else if (i + 1 < s.length && s[i + 1].equals("-")) {
                    s[i + 1] = "0";
                }
            } else if (s[i].equals("l")) {
                if (i + 1 < s.length && s[i + 1].equals("j")) {
                    s[i + 1] = "0";
                }
            } else if (s[i].equals("n")) {
                if (i + 1 < s.length && s[i + 1].equals("j")) {
                    s[i + 1] = "0";
                }
            } else if (s[i].equals("s")) {
                if (i + 1 < s.length && s[i + 1].equals("=")) {
                    s[i + 1] = "0";
                }
            } else if (s[i].equals("z")) {
                if (i + 1 < s.length && s[i + 1].equals("=")) {
                    s[i + 1] = "0";
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("0")) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

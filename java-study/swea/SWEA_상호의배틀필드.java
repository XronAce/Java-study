package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_상호의배틀필드 {
    static int H;
    static int W;
    static int locR;
    static int locC;

    static char[][] map;

    static void up() {
        map[locR][locC] = '^';
        if (locR - 1 >= 0 && map[locR - 1][locC] == '.') {
            map[locR][locC] = '.';
            map[locR - 1][locC] = '^';
            locR--;
        }
    }

    static void down() {
        map[locR][locC] = 'v';
        if (locR + 1 < H && map[locR + 1][locC] == '.') {
            map[locR][locC] = '.';
            map[locR + 1][locC] = 'v';
            locR++;
        }
    }

    static void left() {
        map[locR][locC] = '<';
        if (locC - 1 >= 0 && map[locR][locC - 1] == '.') {
            map[locR][locC] = '.';
            map[locR][locC - 1] = '<';
            locC--;
        }
    }

    static void right() {
        map[locR][locC] = '>';
        if (locC + 1 < W && map[locR][locC + 1] == '.') {
            map[locR][locC] = '.';
            map[locR][locC + 1] = '>';
            locC++;
        }
    }

    static void shoot() {
        int bulletLocR = locR;
        int bulletLocC = locC;

        if (locR - 1 >= 0 && map[locR][locC] == '^') {
            while (bulletLocR != 0) {
                bulletLocR--;
                if (map[bulletLocR][bulletLocC] == '-') {
                    continue;
                } else if (map[bulletLocR][bulletLocC] == '*') {
                    map[bulletLocR][bulletLocC] = '.';
                    break;
                } else if (map[bulletLocR][bulletLocC] == '#') {
                    break;
                }
            }
        } else if (locR + 1 < H && map[locR][locC] == 'v') {
            while (bulletLocR != H - 1) {
                bulletLocR++;
                if (map[bulletLocR][bulletLocC] == '-') {
                    continue;
                } else if (map[bulletLocR][bulletLocC] == '*') {
                    map[bulletLocR][bulletLocC] = '.';
                    break;
                } else if (map[bulletLocR][bulletLocC] == '#') {
                    break;
                }
            }
        } else if (locC - 1 >= 0 && map[locR][locC] == '<') {
            while (bulletLocC != 0) {
                bulletLocC--;
                if (map[bulletLocR][bulletLocC] == '-') {
                    continue;
                } else if (map[bulletLocR][bulletLocC] == '*') {
                    map[bulletLocR][bulletLocC] = '.';
                    break;
                } else if (map[bulletLocR][bulletLocC] == '#') {
                    break;
                }
            }
        } else if (locC + 1 < W && map[locR][locC] == '>') {
            while (bulletLocC != W - 1) {
                bulletLocC++;
                if (map[bulletLocR][bulletLocC] == '-') {
                    continue;
                } else if (map[bulletLocR][bulletLocC] == '*') {
                    map[bulletLocR][bulletLocC] = '.';
                    break;
                } else if (map[bulletLocR][bulletLocC] == '#') {
                    break;
                }
            }
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < T + 1; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                s = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            int N = Integer.parseInt(br.readLine());
            char[] input = new char[N];
            s = br.readLine();
            for (int i = 0; i < N; i++) {
                input[i] = s.charAt(i);
            }

            // current location
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
                        locR = i;
                        locC = j;
                    }
                }
            }

            for (int i = 0; i < input.length; i++) {
                if (input[i] == 'U') {
                    up();
                } else if (input[i] == 'D') {
                    down();
                } else if (input[i] == 'L') {
                    left();
                } else if (input[i] == 'R') {
                    right();
                } else {
                    shoot();
                }
            }

            System.out.print("#" + test_case + " ");
            for (char[] innerArr : map) {
                for (int i = 0; i < innerArr.length; i++) {
                    System.out.print(innerArr[i]);
                }
                System.out.println();
            }
        }
    }
}

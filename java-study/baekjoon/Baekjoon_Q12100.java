package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_Q12100 {
    public static int N;
    public static int[][] arr;
    public static int[][] arrCopy;
    public static int ans;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        arrCopy = new int[N][N];

        StringTokenizer st;
        ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // arrayDeepCopy();
        // int[] temp = { 1 };
        // shift(temp);
        // System.out.println();
        // for (int[] innerArr : arrCopy) {
        //     System.out.println(Arrays.toString(innerArr));
        // }
        // temp[0] = 2;
        // shift(temp);
        // System.out.println();
        // for (int[] innerArr : arrCopy) {
        //     System.out.println(Arrays.toString(innerArr));
        // }
        permutation(0, new int[5]);

        System.out.println(ans);
    }

    public static void permutation(int depth, int[] out) {
        if (depth == 5) {
            arrayDeepCopy();
            shift(out);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ans = Math.max(arrCopy[i][j], ans);
                }
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            out[depth] = i;
            permutation(depth + 1, out);
        }
    }

    // 1:상 2:하 3:좌 4:우
    public static void shift(int[] out) {
        for (int k = 0; k < out.length; k++) {
            if (out[k] == 1) {// 상
                for (int j = 0; j < N; j++) {
                    for (int i = 0; i < N - 1; i++) {
                        if (arrCopy[i][j] == arrCopy[i + 1][j]) {
                            arrCopy[i][j] *= 2;
                            arrCopy[i + 1][j] = 0;
                        }
                    }
                }

                for (int j = 0; j < N; j++) {
                    for (int i = 0; i < N - 1; i++) {
                        if (arrCopy[i][j] == 0) {
                            int m = i + 1;
                            while (m < N) {
                                if (arrCopy[m][j] != 0) {
                                    arrCopy[i][j] = arrCopy[m][j];
                                    arrCopy[m][j] = 0;
                                    break;
                                } else {
                                    m++;
                                }
                            }
                        }
                    }
                }

                for (int j = 0; j < N; j++) {
                    for (int i = 0; i < N - 1; i++) {
                        if (arrCopy[i][j] == arrCopy[i + 1][j]) {
                            arrCopy[i][j] *= 2;
                            arrCopy[i + 1][j] = 0;
                        }
                    }
                }

                for (int j = 0; j < N; j++) {
                    for (int i = 0; i < N - 1; i++) {
                        if (arrCopy[i][j] == 0) {
                            int m = i + 1;
                            while (m < N) {
                                if (arrCopy[m][j] != 0) {
                                    arrCopy[i][j] = arrCopy[m][j];
                                    arrCopy[m][j] = 0;
                                    break;
                                } else {
                                    m++;
                                }
                            }
                        }
                    }
                }
            } else if (out[k] == 2) { // 하
                for (int j = 0; j < N; j++) {
                    for (int i = N - 1; i > 0; i--) {
                        if (arrCopy[i][j] == arrCopy[i - 1][j]) {
                            arrCopy[i][j] *= 2;
                            arrCopy[i - 1][j] = 0;
                        }
                    }
                }

                for (int j = 0; j < N; j++) {
                    for (int i = N - 1; i > 0; i--) {
                        if (arrCopy[i][j] == 0) {
                            int m = i - 1;
                            while (m >= 0) {
                                if (arrCopy[m][j] != 0) {
                                    arrCopy[i][j] = arrCopy[m][j];
                                    arrCopy[m][j] = 0;
                                    break;
                                } else {
                                    m--;
                                }
                            }
                        }
                    }
                }

                for (int j = 0; j < N; j++) {
                    for (int i = N - 1; i > 0; i--) {
                        if (arrCopy[i][j] == arrCopy[i - 1][j]) {
                            arrCopy[i][j] *= 2;
                            arrCopy[i - 1][j] = 0;
                        }
                    }
                }

                for (int j = 0; j < N; j++) {
                    for (int i = N - 1; i > 0; i--) {
                        if (arrCopy[i][j] == 0) {
                            int m = i - 1;
                            while (m >= 0) {
                                if (arrCopy[m][j] != 0) {
                                    arrCopy[i][j] = arrCopy[m][j];
                                    arrCopy[m][j] = 0;
                                    break;
                                } else {
                                    m--;
                                }
                            }
                        }
                    }
                }
            } else if (out[k] == 3) { // 좌
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N - 1; j++) {
                        if (arrCopy[i][j] == arrCopy[i][j + 1]) {
                            arrCopy[i][j] *= 2;
                            arrCopy[i][j + 1] = 0;
                        }
                    }
                }

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N - 1; j++) {
                        if (arrCopy[i][j] == 0) {
                            int m = j + 1;
                            while (m < N) {
                                if (arrCopy[i][m] != 0) {
                                    arrCopy[i][j] = arrCopy[i][m];
                                    arrCopy[i][m] = 0;
                                    break;
                                } else {
                                    m++;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N - 1; j++) {
                        if (arrCopy[i][j] == arrCopy[i][j + 1]) {
                            arrCopy[i][j] *= 2;
                            arrCopy[i][j + 1] = 0;
                        }
                    }
                }

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N - 1; j++) {
                        if (arrCopy[i][j] == 0) {
                            int m = j + 1;
                            while (m < N) {
                                if (arrCopy[i][m] != 0) {
                                    arrCopy[i][j] = arrCopy[i][m];
                                    arrCopy[i][m] = 0;
                                    break;
                                } else {
                                    m++;
                                }
                            }
                        }
                    }
                }
            } else { // 우
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j > 0; j--) {
                        if (arrCopy[i][j] == arrCopy[i][j - 1]) {
                            arrCopy[i][j] *= 2;
                            arrCopy[i][j - 1] = 0;
                        }
                    }
                }
                
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j > 0; j--) {
                        if (arrCopy[i][j] == 0) {
                            int m = j - 1;
                            while (m >= 0) {
                                if (arrCopy[i][m] != 0) {
                                    arrCopy[i][j] = arrCopy[i][m];
                                    arrCopy[i][m] = 0;
                                    break;
                                } else {
                                    m--;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j > 0; j--) {
                        if (arrCopy[i][j] == arrCopy[i][j - 1]) {
                            arrCopy[i][j] *= 2;
                            arrCopy[i][j - 1] = 0;
                        }
                    }
                }
                
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j > 0; j--) {
                        if (arrCopy[i][j] == 0) {
                            int m = j - 1;
                            while (m >= 0) {
                                if (arrCopy[i][m] != 0) {
                                    arrCopy[i][j] = arrCopy[i][m];
                                    arrCopy[i][m] = 0;
                                    break;
                                } else {
                                    m--;
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public static void arrayDeepCopy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arrCopy[i][j] = arr[i][j];
            }
        }
    }
}

/*
 * shifting issue: 
 * 
3
2 0 2
0 2 0
2 0 2
correct: 4
wrong: 8

need to fix this prob.
 */
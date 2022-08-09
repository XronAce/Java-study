package mylib;

// 중복조합 (nHr)
public class DupCombination {
    public static void dupcombination(int[] arr, int[] out, int start, int depth, int r) {
        if (depth == r) {
            // Change code to get required output at here.
            /*
             * for(int num : out) System.out.print(num);
             * System.out.println();
             * return;
             */
        }
        for (int i = start; i < arr.length; i++) {
            out[depth] = arr[i];
            dupcombination(arr, out, i, depth + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int r = 2;
        dupcombination(arr, new int[r], 0, 0, r);
    }
}

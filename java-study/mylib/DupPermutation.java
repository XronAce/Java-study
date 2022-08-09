package mylib;

// 중복순열 (nπr)
public class DupPermutation {
    public static void duppermutation(int[] arr, int[] out, int depth, int r) {
        if (depth == r) {
            // Change code to get required output at here.
            /*
             * This is a simple printing dummy code.
             * for (int num : out)
             * System.out.print(num + " ");
             * System.out.println();
             * return;
             */
        }
        for (int i = 0; i < arr.length; i++) {
            out[depth] = arr[i];
            duppermutation(arr, out, depth + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int r = 2;
        duppermutation(arr, new int[r], 0, r);
    }
}

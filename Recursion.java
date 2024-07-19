public class Recursion {
    public static void main(String[] args) {
        // towerOfHanoi(3, 'A', 'C', 'B');
        // System.out.println(findSum(new int[] { 2, 3, 6, 5, 4, 1 }, 0, 0, 100));
        generateValidParentheses(6, 0, 0, 0, new char[6]);

    }

    static void towerOfHanoi(int n, char from_rod,
            char to_rod, char aux_rod) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod "
                + from_rod + " to rod "
                + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    // O(2^N)
    static boolean findSum(int[] arr, int idx, int sum, int tsum) {

        if (sum == tsum)
            return true;

        if (idx >= arr.length)
            return false;

        return findSum(arr, idx + 1, sum + arr[idx], tsum) || findSum(arr, idx + 1, sum, tsum);
    }

    // O(2^N)
    static void generateValidParentheses(int n, int idx, int oc, int cc, char[] arr) {

        if (idx == n) {
            for (char i : arr)
                System.out.print(i);
            System.out.println();
            return;
        }

        if (oc < n / 2) {
            arr[idx] = '(';
            generateValidParentheses(n, idx + 1, oc + 1, cc, arr);
            arr[idx] = ' ';
        }

        if (cc < oc) {
            arr[idx] = ')';
            generateValidParentheses(n, idx + 1, oc, cc + 1, arr);
            arr[idx] = ' ';
        }

    }

}

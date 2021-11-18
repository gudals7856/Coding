public class Main {

    static boolean[] memo = new boolean[10001];

    public static void main(String[] args) {
        for (int i = 1; i < 10001; i++) {
            d(i, 0);
        }

        for (int i = 1; i < 10001; i++) {
            if (!memo[i]) System.out.println(i);
        }
    }

    public static void d(int i, int depth) {
        if (i > 10000) return;
        if (memo[i]) return;

        if (depth != 0) memo[i] = true;

        if (i >= 1 && i < 10) {
            i *= 2;
        } else {
            int iCpy = i;
            while (iCpy > 0) {
                i += iCpy % 10;
                iCpy /= 10;
            }
        }
        d(i, depth + 1);
    }
}


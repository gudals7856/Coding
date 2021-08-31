import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), "");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.toString(board[i]);
        }
    }

    private static void func(int r, int c, int length) {
        int sum = 0;
        if (length != n) System.out.print("(");

        for (int i = r; i < r + length; i++) {
            for (int j = c; j < c + length; j++) {
                if (board[i][j] == 1) sum++;
            }
        }

        if (sum == length * length) System.out.print(1);
        else if(sum == 0) System.out.println(0);
        else {
            int next = length / 2;
            func(r, c, next);
            func(r, c + next, next);
            func(r + next, c, next);
            func(r + next, c + next, next);
        }

        if (length != n) System.out.print(")");
    }
}

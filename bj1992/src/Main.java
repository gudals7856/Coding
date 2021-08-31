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
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(str[j]);
            }
        }

        func(0, 0, n);
    }

    private static void func(int r, int c, int length) {
        int sum = 0;

        // 현재 확인하는 부분에 있는 수들을 모두 더함
        for (int i = r; i < r + length; i++) {
            for (int j = c; j < c + length; j++) {
                if (board[i][j] == 1) sum++;
            }
        }

        // 합이 확인하는 부분의 크기와 같으면 1출력, 합이 0이면 0출력
        if (sum == length * length) System.out.print(1);
        else if(sum == 0) System.out.print(0);
        else {  // 압축이 되지 않는다면 다시 구간을 나눔
            int next = length / 2;
            System.out.print("(");
            func(r, c, next);
            func(r, c + next, next);
            func(r + next, c, next);
            func(r + next, c + next, next);
            System.out.print(")");
        }
    }
}

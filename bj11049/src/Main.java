import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());    // 5 x 3 중 5
            matrix[i][1] = Integer.parseInt(st.nextToken());    // 5 x 3 중 3
        }
        dp = new int[n][n][3];

        bw.write(getMin(matrix) + "");
        bw.flush();
        bw.close();
    }

    public static int getMin(int[][] matrix) {

        // 연속된 두개의 행렬에 대한 연산값 저장
        for (int i = 0; i < n; i++) {
            dp[i][i][1] = matrix[i][0];
            dp[i][i][2] = matrix[i][1];
            if (i < n - 1) {
                dp[i][i + 1][0] = matrix[i][0] * matrix[i][1] * matrix[i + 1][1];
                dp[i][i + 1][1] = matrix[i][0];
                dp[i][i + 1][2] = matrix[i + 1][1];
            }
        }

        // 몇개의 행렬을 한 그룹으로 볼것인지
        for (int i = 2; i < n; i++) {

            // from ~ to 행렬까지의 최소 값을 구한다
            for (int from = 0; from + i < n; from++) {
                int to = from + i;
                dp[from][to][0] = Integer.MAX_VALUE;

                // from ~ to 사이를 devide 값을 이용해 두 분류로 나누어 계산하면서 가장 작은 값을 구한다.
                for (int devide = from; devide < to; devide++) {
                    dp[from][to][0] = Math.min(dp[from][to][0], dp[from][devide][0] + dp[devide+1][to][0] + dp[from][devide][1] * dp[from][devide][2] * dp[devide+1][to][2]);
                    dp[from][to][1] = matrix[from][0];
                    dp[from][to][2] = matrix[to][1];
                }
            }
        }
        return dp[0][n-1][0];
    }
}

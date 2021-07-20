import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer costStr = new StringTokenizer(br.readLine());
            int[] cost = new int[k];

            for (int j = 0; j < k; j++) {
                cost[j] = Integer.parseInt(costStr.nextToken());
            }
            bw.write(getMinCost(cost)+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int sum(int[] s, int from, int to){
        if(from == 0)
            return s[to];
        else
            return s[to] - s[from-1];
    }

    public static int getMinCost(int[] cost) {
        int size = cost.length;
        int[] s = new int[size];  // cost를 순서대로 더한 합
        int[][] dp = new int[size][size];

        s[0] = cost[0];
        for (int i = 1; i < size; i++) {
            s[i] = s[i - 1] + cost[i];
        }

        for (int i = 0; i < size - 1; i++) {
            dp[i][i + 1] = cost[i] + cost[i + 1];
        }

        // 몇 챕터를 묶어 확인할 것인가
        for (int i = 2; i < size; i++) {

            // from 부터 to 까지의 최소 비용을 구한다.
            for (int from = 0; from + i < size; from++) {
                int to = from + i;
                dp[from][to] = Integer.MAX_VALUE;

                // from ~ to 사이를 모든 경우의 수로 나누어 두가지로 분류하여 비용을 계산하고, 가장 작은 비용을 고름
                for (int devide = from; devide < to; devide++) {
                    dp[from][to] = Math.min(dp[from][to], dp[from][devide] + dp[devide + 1][to] + sum(s, from, to));
                }
            }
        }
        return dp[0][size-1];
    }
}
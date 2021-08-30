import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[31];

        if (n % 2 == 1) dp[n] = 0;
        else {
            dp[2] = 3;

            for (int i = 4; i < n + 1; i += 2) {
                dp[i] = dp[i - 2] * 3;              // 초기
                for (int j = 4; j < i; j += 2) {    // 중간 예외
                    dp[i] += 2 * dp[i - j];
                }
                dp[i] += 2;                         // 자기 자신 예외
            }
        }
        System.out.println(dp[n]);
    }
}

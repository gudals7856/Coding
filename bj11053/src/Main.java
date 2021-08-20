import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[1001];    // 현재 위치에서 가장 긴 부분 수열의 원소 수
    static int[] arr = new int[1001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[n - 1] = 1;  // 마지막 인덱스의 원소 수는 자기 자신 하나이다.

        // 배열의 크기가 1일 땐 예외적으로 처리
        if (n == 1) {
            System.out.println(1);
            return;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 현재 위치의 수보다 크고, 저장된 값이 dp[i]보다 크다면 dp[i]에 복사 (자기 자신도 더해야 하므로 +1)
                if (arr[i] < arr[j] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j];
            }
            dp[i]++;
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}

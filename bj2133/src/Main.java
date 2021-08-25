import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[31];

        if (n / 2 == 1) {
            System.out.println(0);
            return;
        }
        else if (n == 2) dp[n] = 3;
        else if (n == 4) dp[n] = 11;
        else{

        }

        return dp[n];
    }
}

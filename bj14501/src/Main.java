import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] t;
    static int[] p;
    static int[] dp;
    static int n;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        t = new int[n + 1];
        p = new int[n + 1];
        dp = new int[n + 2];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

//        dp로 풀이하는 법
//        for (int i = 1; i < n + 1; i++) {
//            int next = t[i] + i;
//            if (next <= n + 1) {
//                for (int j = next; j < n; j++) {
//                    dp[j] = Math.max(dp[j], dp[i] + p[i]);
//                }
//            }
//        }

        for (int i = 1; i < n + 1; i++)
            dfs(i, 0);

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    public static void dfs(int index, int sum) {

        if (index + t[index] - 1 >= n) {
            if (index + t[index] - 1 == n) sum += p[index];
            max = Math.max(max, sum);
            return;
        }

        sum += p[index];

        for (int i = index + t[index]; i < n + 1; i++) {
            dfs(i, sum);
        }
    }
}

import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] tri;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tri = new int[n][n];
        dp = new int[n][n];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            String[] strArr = str.split(" ");
            for(int j=0; j<i+1; j++) {
                tri[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        for(int i=0; i<n; i++) {
            dp[n-1][i] = tri[n-1][i];
        }

        int max = func(0, 0);

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }

    public static int func(int depth, int i) {
        if(depth == n-1)
            return dp[depth][i];

        if(dp[depth][i] == 0) {
            dp[depth][i] = Math.max(func(depth+1,i), func(depth+1, i+1)) + tri[depth][i];
        }

        return dp[depth][i];
    }
}
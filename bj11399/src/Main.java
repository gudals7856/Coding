import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] cost;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        cost = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            cost[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cost);
        total += cost[0];

        for (int i = 1; i < n; i++) {
            cost[i] = cost[i - 1] + cost[i];
            total += cost[i];
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
    }
}

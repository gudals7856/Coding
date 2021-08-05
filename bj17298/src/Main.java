import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] num;
    static int[] nge;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        nge = new int[n];
        check = new boolean[n];
        Arrays.fill(nge, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());

        num[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < i; j++) {
                if (num[j] < num[i] && !check[j]) {
                    nge[j] = num[i];
                    check[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(nge[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}

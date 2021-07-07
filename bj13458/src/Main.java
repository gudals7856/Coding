import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, b, c;
        int[] a;
        long min = 0;

        n = Integer.parseInt(br.readLine());

        a = new int[n];
        String str_aj = br.readLine();
        StringTokenizer st = new StringTokenizer(str_aj);
        for(int i=0; i<n; i++)
        {
            a[i] = Integer.parseInt(st.nextToken());
        }

        String str_bc = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str_bc);
        b = Integer.parseInt(st2.nextToken());
        c = Integer.parseInt(st2.nextToken());

        for (int i = 0; i < n; i++) {
            a[i] -= b;  // 총감독관 1명
            min += 1;

            if(a[i] > 0) {
                int dev = a[i] / c;
                min += dev;
                if (a[i] % c > 0) {
                    min++;
                } else {
                    continue;
                }
            }
        }

        bw.write(min + "");
        bw.flush();
        bw.close();
    }
}

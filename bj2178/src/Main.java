//

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n;

        String str_mn = br.readLine();
        StringTokenizer st = new StringTokenizer(str_mn);

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] miro = new int[m][n];

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                miro[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(miro[i][j]+"");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}

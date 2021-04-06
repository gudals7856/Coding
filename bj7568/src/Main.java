import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] bulk = new int[n][2];
        int[] rank = new int[n];

        for(int i=0; i<n; i++)
        {
            String info = br.readLine();
            String tall, weight;
            weight = info.split(" ")[0];
            tall = info.split(" ")[1];
            bulk[i][0] = Integer.parseInt(weight);
            bulk[i][1] = Integer.parseInt(tall);
        }

        for(int i=0; i<n; i++)
        {
            rank[i]++;	// rank가 현재 0으로 초기화 되어있으므로 1부터 시작하기 위해서
            for(int j=0; j<n; j++)
            {
                if(i == j)
                    continue;
                else
                {
                    if(bulk[i][0] < bulk[j][0] && bulk[i][1] < bulk[j][1])
                        rank[i]++;
                }
            }
            bw.write(Integer.toString(rank[i]) + " ");
        }
        bw.flush();
        bw.close();
    }
}

import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num = 665;
        int count = 0;
        String numStr = "";

        while(n != count)
        {
            num++;
            numStr = Integer.toString(num);

            if(numStr.contains("666"))
                count++;
            else
                continue;
        }
        bw.write(numStr);
        bw.flush();
        bw.close();
    }
}
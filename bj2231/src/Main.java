import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++)
        {
            // 생성자가 없을 경우
            if(i == n)
            {
                bw.write("0");
                break;
            }
            int sum = i;	// 분해합 sum
            int iCpy = i;	// 자리수를 더하기 위해 만든 변수
            int r;			// 나머지

            while(iCpy != 0)
            {
                r = iCpy % 10;
                sum += r;
                iCpy = iCpy/10;
            }

            // 반복문 진행 중 분해합이 N과 같은 수가 나왔다면 출력하고 반복문 break
            if(sum == n)
            {
                bw.write(Integer.toString(i));
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int area;
    static int[] maxArea;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        maxArea = new int[n];
        int height = 0;
        int width = 0;
        int minHeight = 0;

        // 첫번째 히스토그램에서 가장 큰 넓이는 자기 자신의 크기이다.
        maxArea[0] = Integer.parseInt(br.readLine());
        area = maxArea[0];
        height = maxArea[0];
        width = 1;

        for (int i = 1; i < n; i++) {
            // 현재 히스토그램의 높이
            int histogram = Integer.parseInt(br.readLine());

            height = Math.min(histogram, height);
            width += 1;

            if (height * width >= histogram) {
                maxArea[i] = height * width;
            } else {
                maxArea[i] = histogram;
                width = 1;
                height = histogram;
            }
            area = Math.max(maxArea[i], area);
        }

        bw.write(area + "");
        bw.flush();
        bw.close();
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int area;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        // 첫번째 히스토그램은 그냥 스택에 넣는다
        st.push(Integer.parseInt(br.readLine()));
        int height = st.peek();
        int width = 1;
        area = height * width;

        

        bw.write(area + "");
        bw.flush();
        bw.close();
    }
}

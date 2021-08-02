import java.io.*;


// BufferedWriter는 안되고 StringBuilder 는 된다??????? String은 시간초과.

public class Main {

//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, "1", "3", "2");
        System.out.println(count);
        System.out.println(sb);

//        bw.flush();
//        bw.close();

    }

    public static void hanoi(int n, String start, String dest, String assist) throws IOException {
        if(n==1)
        {
            sb.append(start + " " + dest + "\n");
//            bw.write(start+" "+dest+"\n");
            count++;
            return;
        }
        else
        {
            hanoi(n-1, start, assist, dest);
            sb.append(start + " " + dest + "\n");
//            bw.write(start+" "+dest+"\n");
            count++;
            hanoi(n-1, assist, dest, start);
        }
    }
}
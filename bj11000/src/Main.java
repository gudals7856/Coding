import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    class Lecture {
        private int start;
        private int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int n;
    static ArrayList<Lecture> lecture;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Lecture implements Comparable<Lecture> {
        private int start;
        private int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.end - o.end == 0) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }

        @Override
        public String toString() {
            return "Lecture{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    static int n;
    static ArrayList<ArrayList<Lecture>> list = new ArrayList<>();
    static Lecture[] lecture;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        lecture = new Lecture[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lecture[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 종료 시간 기준 오름차순 정렬
        Arrays.sort(lecture);

        list.add(new ArrayList<>());    // 첫번째 강의실 생성
        list.get(0).add(lecture[0]);    // 첫번째 강의실의 첫번째 수업

        for (int i = 1; i < n; i++) {
            boolean isPossible = false; // 강의실 가능 여부 확인

            // 현재 list에 들어있는 강의실을 모두 돌면서 가능한지 확인
            for (int j = 0; j < list.size(); j++) {
                int lecCount = list.get(j).size();  // 현재 강의실의 강의 개수
                if (lecture[i].start >= list.get(j).get(lecCount - 1).end) {
                    isPossible = true;
                    list.get(j).add(lecture[i]);
                    break;
                }
            }
            // 모든 강의실이 불가능하다면 새 강의실 생성
            if (!isPossible) {
                list.add(new ArrayList<>());
                list.get(list.size() - 1).add(lecture[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j));
                System.out.println("index : " + i);
            }
        }
        bw.write(list.size() + "");
        bw.flush();
        bw.close();
    }
}

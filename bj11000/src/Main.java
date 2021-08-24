import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] lecture = new int[n][2];

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lecture[i][0] = Integer.parseInt(st.nextToken());
            lecture[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lecture, (o1, o2) -> {
            if (o1[0] - o2[0] == 0) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        // 강의가 끝나는 시간을 작은 것부터 넣기 위해서 pq를 사용한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lecture[0][1]);

        // lecture 배열의 강의들을 모두 확인
        for (int i = 1; i < n; i++) {
            // pq의 가장 앞에 들어있는 종료 시간이 현재 강의의 시간이 작거나 같다면 큐에서 제거
            if (!pq.isEmpty() && pq.peek() <= lecture[i][0])
                pq.poll();

            pq.offer(lecture[i][1]);    // 현재 강의의 종료 시간을 pq에 삽입
        }
        System.out.println(pq.size());
    }

//    static class Lecture implements Comparable<Lecture> {
//        private int start;
//        private int end;
//
//        public Lecture(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        public int compareTo(Lecture o) {
//            if (this.end - o.end == 0) {
//                return this.start - o.start;
//            }
//            return this.end - o.end;
//        }
//    }
//
//    static int n;
//    static ArrayList<ArrayList<Lecture>> list = new ArrayList<>();
//    static Lecture[] lecture;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        n = Integer.parseInt(br.readLine());
//        lecture = new Lecture[n];
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            lecture[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//        }
//
//        // 종료 시간 기준 오름차순 정렬
//        Arrays.sort(lecture);
//
//        list.add(new ArrayList<>());    // 첫번째 강의실 생성
//        list.get(0).add(lecture[0]);    // 첫번째 강의실의 첫번째 수업
//
//        for (int i = 1; i < n; i++) {
//            boolean isPossible = false; // 강의실 가능 여부 확인
//
//            // 현재 list에 들어있는 강의실을 모두 돌면서 가능한지 확인
//            for (int j = 0; j < list.size(); j++) {
//                int lecCount = list.get(j).size();  // 현재 강의실의 강의 개수
//                if (lecture[i].start >= list.get(j).get(lecCount - 1).end) {
//                    isPossible = true;
//                    list.get(j).add(lecture[i]);
//                    break;
//                }
//            }
//            // 모든 강의실이 불가능하다면 새 강의실 생성
//            if (!isPossible) {
//                list.add(new ArrayList<>());
//                list.get(list.size() - 1).add(lecture[i]);
//            }
//        }
//        bw.write(list.size() + "");
//        bw.flush();
//        bw.close();
//    }
}

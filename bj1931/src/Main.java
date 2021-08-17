import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Meeting implements Comparable<Meeting> {

        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // Arrays.sort가 일어날 때 간접적으로 불리게 된다.
        // 두 값을 비교하고, 리턴값을 이용해서 정렬이 진행된다.

        // 오름차순
        // 음수 리턴 : 내가 작다 - 그대로
        // 0 리턴 : 둘이 같다 - 그대로
        // 양수 리턴 : 내가 크다 - 서로 위치를 교환

        // 내림차순
        // 음수 리턴 : 내가 작다 - 서로 위치를 교환
        // 0 리턴 : 둘이 같다 - 그대로
        // 양수 리턴 : 내가 크다 - 그대로
        @Override
        public int compareTo(Meeting o) {
            int value = this.end - o.end;   // 나 - 상대

            // 종료 시간이 다를때
            if (value != 0) return value;

            // 종료 시간이 같다면 시작시간이 빠른 순서로 정렬한다.
            return this.start - o.start;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(getSchedule(meetings).size());

    }

    private static ArrayList<Meeting> getSchedule(Meeting[] meetings) {

        ArrayList<Meeting> list = new ArrayList<>();

        Arrays.sort(meetings);  // 종료시간 기준 오름차순 정렬
        list.add(meetings[0]);  // 첫번째 회의는 가장 앞에 있는 회의

        // 두번째 회의부터 앞에 진행한 회의의 종료시간과 현재 회의의 시작시간을 비교하며 겹치지 않으면 리스트에 삽입한다.
        // 종료시간 기준 정렬돼 있으므로 가능한 회의 중 가장 빨리 끝나는 회의가 삽입됨.
        for (int i = 1; i < meetings.length; i++) {
            if (list.get(list.size() - 1).end <= meetings[i].start) {
                list.add(meetings[i]);
            }
        }
        return list;
    }
}

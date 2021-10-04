import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int end, weigth;

        public Edge(int end, int weigth) {
            this.end = end;
            this.weigth = weigth;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weigth - o.weigth;
        }
    }

    static int n, m;
    static ArrayList<Edge>[] edges;
    static boolean[] check;
    static int[] dist;


    public static int dijkstra(int start, int end) {
        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            int vertex = pq.peek().end;
            int weight = pq.peek().weigth;
            pq.poll();

            if (vertex == end) {
                answer = weight;
                break;
            }

            // 이미 확인한 도시라면 다시 반복
            if (check[vertex]) continue;

            // 도시를 확인했다고 체크하고 비용이 더 작으면 업데이트
            check[vertex] = true;
            if (dist[vertex] > weight) dist[vertex] = weight;

            for (int i = 0; i < edges[vertex].size(); i++) {
                Edge edge = edges[vertex].get(i);
                pq.add(new Edge(edge.end, edge.weigth + weight));
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        check = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // edge들을 시작점을 기준으로 list로 모아놓음
        edges = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++)
            edges[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[start].add(new Edge(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(startCity, endCity));
    }
}

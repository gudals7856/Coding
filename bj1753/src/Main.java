import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge>{
        int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static void dijkstra(int start) {
        dist[start] = 0;
        check[start] = true;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            int current = pq.peek().vertex;
            int distance = pq.peek().weight;
            check[current] = true;

            pq.poll();

            // 최단 거리가 아닐 경우 스킵
            if (dist[current] < distance) continue;

            for (int i = 0; i < edges.get(current).size(); i++) {
                // 선택된 노드의 인접 노드
                int next = edges.get(current).get(i).vertex;
                if (check[next]) continue;  // 이미 확인한 노드라면 확인하지 않음

                // 선택된 노드를 인접 노드를 거쳐서 가는 비용
                int nextDistance = distance + edges.get(current).get(i).weight;

                // 기존의 최소 비용보다 저렴하다면 교체
                if (nextDistance < dist[next]) {
                    dist[next] = nextDistance;
                    pq.add(new Edge(next, nextDistance));
                }
            }
        }
    }

    static int V, E, start;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static int[] dist;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        check = new boolean[V + 1];

        // 최소 거리를 저장하는 dist 배열은 처음에 가장 큰 값이 들어있음.
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 각 정점에 해당하는 간선들의 정보를 위한 배열
        for (int i = 0; i < V + 1; i++)
            edges.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.get(s).add(new Edge(e, w));
        }

        dijkstra(start);

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}

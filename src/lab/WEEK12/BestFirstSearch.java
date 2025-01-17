package lab.WEEK12;
//import lab.WEEK8.GFG;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BestFirstSearch {
    static ArrayList<ArrayList<edge>> adj = new ArrayList<>();

    // Function for adding edges to graph
    static class edge implements Comparable<edge> {
        int v, cost;
        edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public BestFirstSearch(int v) {
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Function For Implementing Best First Search
    // Gives output path having lowest cost
    static void best_first_search(int source, int target, int v) {
        // MIN HEAP priority queue
        PriorityQueue<edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v];
        visited[source] = true;

        // sorting in pq gets done by first value of pair
        pq.add(new edge(source, -1));
        while (!pq.isEmpty()) {
            int x = pq.poll().v;

            // Displaying the path having lowest cost
            System.out.print(x + " ");
            if (target == x) {
                break;
            }
            for (edge adjacentNodeEdge : adj.get(x)) {
                if (!visited[adjacentNodeEdge.v]) {
                    visited[adjacentNodeEdge.v] = true;
                    pq.add(adjacentNodeEdge);
                }
            }
        }
    }

    void addEdge(int u, int v, int cost) {
        adj.get(u).add(new edge(v, cost));
        adj.get(v).add(new edge(u, cost));
    }

    // Driver code to test above methods
    public static void main(String args[]) {
        // No. of Nodes
        int v = 14;

        // The nodes shown in above example(by alphabets) are
        // implemented using integers addEdge(x, y, cost);
        BestFirstSearch graph = new BestFirstSearch(v);
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 8);
        graph.addEdge(2, 6, 12);
        graph.addEdge(2, 7, 14);
        graph.addEdge(3, 8, 7);
        graph.addEdge(8, 9, 5);
        graph.addEdge(8, 10, 6);
        graph.addEdge(9, 11, 1);
        graph.addEdge(9, 12, 10);
        graph.addEdge(9, 13, 2);

        int source = 0;
        int target = 9;

        // Function call
        best_first_search(source, target, v);
    }
}

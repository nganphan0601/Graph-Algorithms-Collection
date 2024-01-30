import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class AdjList {
    private ArrayList<ArrayList<Integer>> adj;
    private int order; // number of vertices in the graph
    private int size = 0; // number of edges in the graph

    AdjList(int n) {
        adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        order = n;
    }

    void addEdge(int u, int v) {
        if ((u < -1) || (u > order)) {
            System.out.println("Vertex " + u + " does not exist.");
        } else if ((v < -1) || (v > order)) {
            System.out.println("Vertex " + v + " does not exist.");
        } else {
            // add elements to list for undirected graph
            adj.get(v).add(u);
            adj.get(u).add(v);
            size += 1;
        }
    }

    boolean checkEdge(int u, int v) {
        if ((u < -1) || (u > order)) {
            System.out.println("Vertex " + u + " does not exist.");
            return false;
        } else if ((v < -1) || (v > order)) {
            System.out.println("Vertex " + v + " does not exist.");
            return false;
        } else if (adj.get(v).contains(Integer.valueOf(u))) {
            // check if edge exists in graph
            System.out.println("Edge exists between vertices " + u + " and " + v);
            return true;
        } else {
            System.out.println("Edge does not exist");
            return false;
        }
    }

    void removeEdge(int u, int v) {
        if (checkEdge(u, v)) {
            // remove elements from list of undirected graph
            adj.get(v).remove(Integer.valueOf(u));
            adj.get(u).remove(Integer.valueOf(v));
            size -= 1;
            System.out.println("Edge removed.");
        }
    }

    void print() {
        System.out.println("Vertices: " + order);
        System.out.println("Edges: " + size);

        for (int i = 0; i < order; i++) {
            System.out.print("[" + i + "]: ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    void bfs(int r) {
        boolean visited[] = new boolean[order];
        Queue<Integer> queue = new LinkedList<>();

        if ((r < 0) || (r >= order)) {
            System.out.println("Vertex " + r + " does not exist.");
        } else {
            StringBuilder result = new StringBuilder("BFS Traversal: ");
            queue.add(r);
            visited[r] = true;
            while (queue.size() != 0) {
                r = queue.remove();
                result.append(r).append("\t");
                ArrayList<Integer> child = adj.get(r);
                for (int c : child) {
                    if (!visited[c]) {
                        queue.add(c);
                        visited[c] = true;
                    }
                }
            }
            System.out.println(result);
        }
    }

    void dfs(int r) {
        boolean visited[] = new boolean[order];
        Stack<Integer> stack = new Stack<Integer>();

        if ((r < 0) || (r >= order)) {
            System.out.println("Vertex " + r + " does not exist.");
        } else {
            StringBuilder result = new StringBuilder("DFS Traversal: ");
            stack.push(r);
            visited[r] = true;
            while (stack.size() != 0) {
                r = stack.pop();
                result.append(r).append("\t");
                ArrayList<Integer> child = adj.get(r);
                for (int c : child) {
                    if (!visited[c]) {
                        stack.push(c);
                        visited[c] = true;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
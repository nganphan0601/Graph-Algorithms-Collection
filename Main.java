
class Main {

  public static void main(String[] args) {
    AdjList g = new AdjList(10);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(4, 5);
    g.addEdge(5, 6);
    g.addEdge(6, 7);
    g.addEdge(7, 8);
    g.addEdge(8, 9);
    g.addEdge(9, 0);
    g.print();
    // g.bfs(0);
    g.dfs(0);
    // g.checkEdge(2, 4);
    // g.removeEdge(2, 4);
    // g.removeEdge(2, 3);

  }
}

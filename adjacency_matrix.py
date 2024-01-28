''' This is the development of an adjacency matrix in Python
Adjacency matrix
    - is a square matrix (n x n)
    - where n is the number of vertices in the graph
    - A vertex will be represented by a row and a column
    - the value at matrix[i][j] will be True or 1 if there is an edge from vertex i to vertex j
    - the value at matrix[i][j] will be False or 0 if there is no edge from vertex i to vertex j
    - in this case, we are implementing an undirected graph, so the matrix will be symmetric (i.e. matrix[i][j] == matrix[j][i])

Attributes:
    - A 2-d list with each list inside representing a row
    - The size of the list is the number of vertices in the graph (n)

Methods:
    - __init__(self, num_vertices): creates an adjacency matrix with num_vertices
    - add_edge(self, v1, v2): adds an edge from vertex v1 to vertex v2
    - remove_edge(self, v1, v2): removes an edge from vertex v1 to vertex v2
    - display(self): displays the adjacency matrix
    .
    .
    .

    '''

class Graph:
    def __init__(self, num_vertices):
        self.matrix = [[0 for j in range(num_vertices)] for i in range(num_vertices) ]  # list_comprehension
        self.__size = num_vertices

        # for i in range(num_vertices):
        #     self.matrix.append([0] * num_vertices)

    def add_edge(self, v1, v2):
        if v1 == v2:
            print("Same vertex %d and %d" % (v1, v2))
            return
        self.matrix[v1][v2] = 1
        self.matrix[v2][v1] = 1

    def remove_edge(self, v1, v2):
        if self.matrix[v1][v2] == 0 and self.matrix[v2][v1] == 0:
            print("No edge between {} and {}".format(v1, v2))
            return
        self.matrix[v1][v2] = 0
        self.matrix[v2][v1] = 0

    def display(self):
        for row in self.matrix:
            print(row)

    def checkEdge(self, v1, v2):
        if self.matrix[v1][v2] == 1 and self.matrix[v2][v1] == 1:
            print("Yes there is an edge")
            return
        print("No there is no edge")

    def BFS(self, root):
        # init
        path = []   # queue - order of nodes to visit
        visited = [False] * self.__size     # to keep track of visited node
        # root should be visited and the first node in the path
        visited[root] = True
        path.append(root)
        
        while path:
            current_node = path.pop(0)
            print(current_node, end=" ")

            for i in range(self.__size):
                if self.matrix[current_node][i] == 1 and visited[i] == False:
                    path.append(i)
                    visited[i] = True


        

def main():

    matrix01 = Graph(5)
    matrix01.add_edge(0, 1)
    matrix01.add_edge(0, 2)
    matrix01.add_edge(0, 3)
    matrix01.add_edge(1, 3)
    matrix01.add_edge(2, 4)
    matrix01.display()
    matrix01.BFS(0)
    print("\n")
    matrix01.BFS(1)
    print("\n")
    matrix01.BFS(2)
    print("\n")
    matrix01.BFS(3)
    print("\n")
    matrix01.BFS(4)

    

if __name__ == '__main__':
    main()
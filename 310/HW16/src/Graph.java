
/**
 * A graph whose vertices hold strings.
 *
 * The following methods were added for HW 16:
 *
 * boolean isConnected()
 * Graph bfsTree(String vertex)
 * Graph dfsTree(String vertex)
 * String[] bfsOrder(String vertex)
 * String[] dfsOrder(String vertex)
 *
 * @author Dr. Lillis
 */
public interface Graph {

    /**
     * Determines if the graph is connected.
     *
     * @return true if the graph is connected, false otherwise.
     */
    boolean isConnected();

    /**
     * Performs a Breadth First Search traversal starting at a given vertex.
     * Constructs and returns a BFS spanning tree of the connected component
     * containing the vertex. Adjacent vertices are visited in the lexicographical
     * order of their labels.
     *
     * @param vertex the vertex at which the BFS traversal is started
     * @return a BFS spanning tree of the connected component containing the given
     *         vertex.
     */
    Graph bfsTree(String vertex);

    /**
     * Performs a Depth First Search traversal starting at a given vertex.
     * Constructs and returns a DFS spanning tree of the connected component
     * containing the vertex. Adjacent vertices are visited in the lexicographical
     * order of their labels.
     *
     * @param vertex the vertex at which the DFS traversal is started
     * @return a DFS spanning tree of the connected component containing the given
     *         vertex.
     */
    Graph dfsTree(String vertex);

    /**
     * Performs a Breadth First Search traversal starting at a given vertex. The
     * label of each vertex visited is added to an array of Strings in the order
     * visited.
     *
     * @param vertex the vertex at which the BFS traversal is started
     * @return an array of Strings containing the labels of the vertices visited in
     *         the order that they were visited.
     */
    String[] bfsOrder(String vertex);

    /**
     * Performs a Depth First Search traversal starting at a given vertex. The label
     * of each vertex visited is added to an array of Strings in the order visited.
     *
     * @param vertex the vertex at which the DFS traversal is started
     * @return an array of Strings containing the labels of the vertices visited in
     *         the order that they were visited.
     */
    String[] dfsOrder(String vertex);

    /**
     * Returns the number of vertices in this graph (the "order" of this graph).
     *
     * @return the number of vertices in this graph
     */
    int numberOfVertices();

    /**
     * Returns the number of edges in this graph (the "size" of this graph).
     *
     * @return the number of edges in this graph
     */
    int numberOfEdges();

    /**
     * Returns an array of Strings containing the labels of the vertices.
     *
     * @return a String array containing the vertex labels
     */
    String[] getVertexLabels();

    /**
     * Adds a new vertex to this graph.
     *
     * @param vertex the new vertex to be added
     * @throws RuntimeException if vertex already exists
     */
    void addVertex(String vertex) throws RuntimeException;

    /**
     * Adds one or more vertices to this graph.
     *
     * @param vertices the vertices to be added
     */
    void addVertices(String[] vertices);

    /**
     * Determines if a vertex with the given label exists.
     *
     * @param vertex the label of a vertex.
     * @return true of the vertex exist, false if it does not exist.
     */
    boolean vertexExists(String vertex);

    /**
     * Determines if an edge with the given end vertices exists.
     *
     * @param vertex1 one vertex label
     * @param vertex2 another vertex label
     * @return true this graph contains the edge {vertex1, vertex2}, false of the
     *         edge is not in this graph
     * @throws RuntimeException if either vertex1 or vertex2 is not in this graph
     */
    boolean edgeExists(String vertex1, String vertex2) throws RuntimeException;

    /**
     * Deletes a vertex and all of its incident edges.
     *
     * @param vertex the vertex to be deleted
     * @throws RuntimeException if vertex does not exist
     */
    void deleteVertex(String vertex) throws RuntimeException;

    /**
     * Adds a new edge.
     *
     * @param vertex1 one end vertex of the edge
     * @param vertex2 the other end vertex of the edge
     * @throws RuntimeException if the edge already exists or if either end vertex
     *                          does not exist.
     */
    void addEdge(String vertex1, String vertex2) throws RuntimeException;

    /**
     * Adds one or more edges. Each row i in the edges parameter represents the pair
     * of vertices edges[i][0] and edges[i][1] for a new edge.
     *
     * @param edges a 2 x w array of vertices
     * @throws RuntimeException if, for any pair of vertices v1, v2 in the
     *                          parameter, edge {v1, v2} already exists in this
     *                          graph or if v1 or v2 are not vertices in this graph.
     */
    void addEdges(String[][] edges) throws RuntimeException;

    /**
     * Deletes an edge.
     *
     * @param vertex1 one end vertex of the edge
     * @param vertex2 the other end vertex of the edge
     * @throws RuntimeException if the edge does not exist or if either end vertex
     *                          does not exist.
     */
    void deleteEdge(String vertex1, String vertex2) throws RuntimeException;

    /**
     * Returns the labels of all neighbors of a vertex.
     *
     * @param vertex the vertex of interest
     * @return a String array holding the labels the neighbors.
     * @throws RuntimeException if the vertex does not exist
     */
    String[] getNeighbors(String vertex) throws RuntimeException;

    /**
     * Returns the degree of a vertex.
     *
     * @param vertex the vertex of interest
     * @return the degree of the given vertex
     * @throws RuntimeException if the vertex does not exist.
     */
    int degree(String vertex) throws RuntimeException;

    /**
     * Return the degree sequence for this graph. The degree sequence is a sequence
     * consisting of the degree of each vertex, sorted from largest to smallest.
     *
     * @return an int array containing the degrees of all vertices, sorted from
     *         largest degree to smallest degree.
     */
    public int[] degreeSequence();

    /**
     * Resizes the array of labels and the adjacency matrix to a new capacity. Makes
     * the capacity either larger or smaller, depending on the value of newCapacity.
     *
     * @param newCapacity The new capacity
     * @throws RuntimeException if newCapacity less than number of vertices.
     */
    public void resize(int newCapacity) throws RuntimeException;

    /**
     * Returns the maximum degree of this graph.
     *
     * @return the maximum degree
     */
    int maxDegree();

    /**
     * Returns the minimum degree of this graph.
     *
     * @return the minimum degree
     */
    int minDegree();

    /**
     * Returns the average degree of this graph.
     *
     * @return the average degree
     */
    double averageDegree();

    /**
     * Returns a string representation of this graph.
     *
     * @return a string representation of this graph.
     */
    @Override
    String toString();
}
import jdk.jshell.spi.ExecutionControl;

import java.util.Arrays;

public class StringGraph implements Graph {
    protected int capacity;
    protected boolean[][] edgeMatrix;
    String[] labels;
    protected int numEdges;
    protected int numVertices;

    public StringGraph() {
        this(1);
    }

    public StringGraph(int initCapacity) {
        this.capacity = initCapacity;
        this.labels = new String[initCapacity];
        this.edgeMatrix = new boolean[initCapacity][initCapacity];
    }

    public StringGraph(String[] initVertices) {
        this(initVertices.length);
        this.labels = initVertices;
    }

    public StringGraph(String[] initVertices, String[][] initEdges) {
        this(initVertices);
        addEdges(initEdges);
    }
    /**
     * Determines if the graph is connected.
     *
     * @return true if the graph is connected, false otherwise.
     */


    /**
     * Returns the number of vertices in this graph (the "order" of this graph).
     *
     * @return the number of vertices in this graph
     */
    @Override
    public int numberOfVertices() {
        return numVertices;
    }

    /**
     * Returns the number of edges in this graph (the "size" of this graph).
     *
     * @return the number of edges in this graph
     */
    @Override
    public int numberOfEdges() {
        return numEdges;
    }

    /**
     * Returns an array of Strings containing the labels of the vertices.
     *
     * @return a String array containing the vertex labels
     */
    @Override
    public String[] getVertexLabels() {
        String[] vLabels = new String[numVertices];
        int c = 0;
        for (String v : labels) {
            if (v!= null) {
                vLabels[c++] = v;
            }
        } return vLabels;
    }

    /**
     * Adds a new vertex to this graph.
     *
     * @param vertex the new vertex to be added
     * @throws RuntimeException if vertex already exists
     */
    @Override
    public void addVertex(String vertex) throws RuntimeException {
        if (vertexExists(vertex)) throw new RuntimeException();
        if (numVertices == capacity) {
            resize(capacity*2);
        }
        labels[numVertices] = vertex;
        numVertices++;
    }

    /**
     * Adds one or more vertices to this graph.
     *
     * @param vertices the vertices to be added
     */
    @Override
    public void addVertices(String[] vertices) {
        for (int i = 0; i < vertices.length; i++) {
            addVertex(vertices[i]);
        }
    }

    /**
     * Determines if a vertex with the given label exists.
     *
     * @param vertex the label of a vertex.
     * @return true of the vertex exist, false if it does not exist.
     */
    @Override
    public boolean vertexExists(String vertex) {
        for (int i = 0; i < labels.length; i++) {
            if (labels[i] != null && labels[i].equals(vertex)) {
                return true;
            }
        } return false;
    }

    private int getIndex(String v) {
        for (int i = 0; i < labels.length; i++) {
            if (labels[i] != null && labels[i].equals(v)) {
                return i;
            }
        } return -1;
    }

    /**
     * Determines if an edge with the given end vertices exists.
     *
     * @param vertex1 one vertex label
     * @param vertex2 another vertex label
     * @return true this graph contains the edge {vertex1, vertex2}, false of the
     * edge is not in this graph
     * @throws RuntimeException if either vertex1 or vertex2 is not in this graph
     */
    @Override
    public boolean edgeExists(String vertex1, String vertex2) throws RuntimeException {
        int i1 = getIndex(vertex1);
        int i2 = getIndex(vertex2);
        if (i1==-1||i2==-1) throw new RuntimeException();
        return edgeMatrix[i1][i2];
    }

    /**
     * Deletes a vertex and all of its incident edges.
     *
     * @param vertex the vertex to be deleted
     * @throws RuntimeException if vertex does not exist
     */
    @Override
    public void deleteVertex(String vertex) throws RuntimeException {
        if (!vertexExists(vertex)) throw new RuntimeException();
        int lastIndex = numVertices-1;
        int delIndex = getIndex(vertex);
        labels[delIndex] = labels[lastIndex];
        labels[lastIndex] = null;

        for (int i = 0; i <= lastIndex; i++){
            if (edgeMatrix[delIndex][i]) {
                numEdges--;
            }
            if (i!= delIndex && i != lastIndex) {
                edgeMatrix[i][delIndex] = edgeMatrix[i][lastIndex];
                edgeMatrix[delIndex][i] = edgeMatrix[lastIndex][i];
            }
        }
        for (int i = 0; i < numVertices; i++) {
            edgeMatrix[numVertices-1][i] = false;
            edgeMatrix[i][numVertices-1] = false;
        }
        numVertices--;
    }

    /**
     * Adds a new edge.
     *
     * @param vertex1 one end vertex of the edge
     * @param vertex2 the other end vertex of the edge
     * @throws RuntimeException if the edge already exists or if either end vertex
     *                          does not exist.
     */
    @Override
    public void addEdge(String vertex1, String vertex2) throws RuntimeException {
        if (!vertexExists(vertex1)||!vertexExists(vertex2)||edgeExists(vertex1, vertex2)) throw new RuntimeException();
        int i1 = getIndex(vertex1);
        int i2 = getIndex(vertex2);
        edgeMatrix[i1][i2] = true;
        edgeMatrix[i2][i1] = true;
        numEdges++;
    }

    /**
     * Adds one or more edges. Each row i in the edges parameter represents the pair
     * of vertices edges[i][0] and edges[i][1] for a new edge.
     *
     * @param edges a 2 x w array of vertices
     * @throws RuntimeException if, for any pair of vertices v1, v2 in the
     *                          parameter, edge {v1, v2} already exists in this
     *                          graph or if v1 or v2 are not vertices in this graph.
     */
    @Override
    public void addEdges(String[][] edges) throws RuntimeException {
        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1]);
        }
    }

    /**
     * Deletes an edge.
     *
     * @param vertex1 one end vertex of the edge
     * @param vertex2 the other end vertex of the edge
     * @throws RuntimeException if the edge does not exist or if either end vertex
     *                          does not exist.
     */
    @Override
    public void deleteEdge(String vertex1, String vertex2) throws RuntimeException {
        if (!edgeExists(vertex1, vertex2)
                || getIndex(vertex1)==-1
                || getIndex(vertex2)==-1) throw new RuntimeException();
        edgeMatrix[getIndex(vertex1)][getIndex(vertex2)] = false;
        edgeMatrix[getIndex(vertex2)][getIndex(vertex1)] = false;
        numEdges--;
    }

    /**
     * Returns the labels of all neighbors of a vertex.
     *
     * @param vertex the vertex of interest
     * @return a String array holding the labels the neighbors.
     * @throws RuntimeException if the vertex does not exist
     */
    @Override
    public String[] getNeighbors(String vertex) throws RuntimeException {
        if (!vertexExists(vertex)) throw new RuntimeException();
        return new String[0];
    }

    /**
     * Returns the degree of a vertex.
     *
     * @param vertex the vertex of interest
     * @return the degree of the given vertex
     * @throws RuntimeException if the vertex does not exist.
     */
    @Override
    public int degree(String vertex) throws RuntimeException {
        if (!vertexExists(vertex)) throw new RuntimeException();
        return degreeSequence()[getIndex(vertex)];
    }

    /**
     * Return the degree sequence for this graph. The degree sequence is a sequence
     * consisting of the degree of each vertex, sorted from largest to smallest.
     *
     * @return an int array containing the degrees of all vertices, sorted from
     * largest degree to smallest degree.
     */
    @Override
    public int[] degreeSequence() {
        int[] degrees = new int[numberOfVertices()];
        for (int i = 0; i < edgeMatrix.length; i++) {
            for (int j = 0; j < edgeMatrix[i].length; j++) {
                if (edgeMatrix[i][j]) {
                    degrees[i]++;
                }
            }
        }
        Arrays.sort(degrees);
        return degrees;
    }

    /**
     * Resizes the array of labels and the adjacency matrix to a new capacity. Makes
     * the capacity either larger or smaller, depending on the value of newCapacity.
     *
     * @param newCapacity The new capacity
     * @throws RuntimeException if newCapacity less than number of vertices.
     */
    @Override
    public void resize(int newCapacity) throws RuntimeException {
        if (newCapacity < numberOfVertices()) throw new RuntimeException();
        if (newCapacity > capacity) {
            increaseSize(newCapacity);
        }
    }

    private void increaseSize(int newCapacity) {
        String temp[] = new String[newCapacity];
        System.arraycopy(labels, 0, temp, 0, labels.length);
        labels = temp;
    }

    /**
     * Returns the maximum degree of this graph.
     *
     * @return the maximum degree
     */
    @Override
    public int maxDegree() {
        return degreeSequence()[0];
    }

    /**
     * Returns the minimum degree of this graph.
     *
     * @return the minimum degree
     */
    @Override
    public int minDegree() {
        return degreeSequence()[degreeSequence().length];
    }

    /**
     * Returns the average degree of this graph.
     *
     * @return the average degree
     */
    @Override
    public double averageDegree() {
        int[] arr = degreeSequence();
        int sum = 0;
        for (int degree : arr) {
            sum+= degree;
        } return sum/arr.length;
    }
}

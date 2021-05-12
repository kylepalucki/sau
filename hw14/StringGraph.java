
import java.util.Stack;

/*
CSCI 310 - Data Structures
HW 14 - Implement Graph ADT
Jonathan Dose
 */

public class StringGraph implements Graph{
    
    // Instance Variables
    protected static int capacity;
    protected boolean[][] edgeMatrix;
    protected String[] labels;
    protected int numEdges;
    protected int numVertices;

    // Constructors
    public StringGraph(){
        this.capacity = 1;
        labels = new String[capacity];
        edgeMatrix = new boolean[capacity][capacity];
    }
    
    public StringGraph(int initCapacity){
        this.capacity = initCapacity;
        labels = new String[capacity];
        edgeMatrix = new boolean[capacity][capacity];
        // use init capacity instead?
    }
    
    public StringGraph(String[] initVertices){
        this(capacity);
        addVertices(initVertices);
    }
    
    public StringGraph(String[] initVertices, String[][] initEdges){
        this(capacity);
        addVertices(initVertices);
        addEdges(initEdges);
        
    }
    
    // Methods
    @Override
    public boolean isConnected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Graph bfsTree(String vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
    @Override
    public Graph dfsTree(String vertex) {
        Graph result = new StringGraph();
        Stack S = new Stack();
        
        S.push(vertex);
        
        boolean[] visited = new boolean[S.size()];
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        //String[] unvisited = getNeighbors(vertex);
        
        visited[0] = true;
        result.addVertex(vertex);
        
        while(!S.isEmpty()){
            String u = (String) S.pop();
            String[] neighbors = getNeighbors(u);
            // check if next vertex has been visited
            for(int i = 1; i < visited.length; i++){
                if(visited[i] = true){
                    S.pop();
                }
                else{
                    //select u, an unvisited neighbor
                    //put this next to while loop
                    //visit u
                    visited[i] = true;
                    //push u to stack
                    S.push(u);
                    result.addVertex(u);    
                    result.addEdge(u, neighbors[i-1]);// not right
                }
            }
        }
        return result;
    }

    @Override
    public String[] bfsOrder(String vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Performs a Depth First Search traversal starting at a given vertex. The label
     * of each vertex visited is added to an array of Strings in the order visited.
     * 
     * @param vertex the vertex at which the DFS traversal is started
     * @return an array of Strings containing the labels of the vertices visited in
     *         the order that they were visited.
     */
    @Override
    public String[] dfsOrder(String vertex) {
        Stack S = new Stack();
        String[] vertices = new String[labels.length];
        
        return vertices;
    }
    
    
    @Override
    public int numberOfVertices() {
        return numVertices;
    }

    @Override
    public int numberOfEdges() {
        return numEdges;
    }

    
    @Override
    public String[] getVertexLabels() {
        // create temporary array, copy into it the correct number of items
        // for each label thats actually a vertex. return reference of that copy
        String[] temp = new String[numVertices];
        System.arraycopy(labels, 0, temp, 0, numVertices);
        return temp;
    }

    @Override
    public void addVertex(String vertex) throws RuntimeException {
        int i1 = getIndex(vertex);
        if(i1 != -1){
            throw new RuntimeException("Given vertex does not exists");
        }
        
        resize(capacity++);
        labels[numVertices] = vertex;
        numVertices++;
    }

    @Override
    public void addVertices(String[] vertices) {
        for(String v: vertices){
            addVertex(v);
        }
    }

    @Override
    public boolean vertexExists(String vertex) {
        return getIndex(vertex) != -1;
    }

    @Override
    public boolean edgeExists(String vertex1, String vertex2) throws RuntimeException {
        int i1 = getIndex(vertex1);
        int i2 = getIndex(vertex2);
        if(i1 == -1 || i2 == -1){
            throw new RuntimeException("One or both of the vertices do not exists");
        }
        return edgeMatrix[i1][i2];
    }

    @Override
    public void deleteVertex(String vertex) throws RuntimeException {
        int delIndex = getIndex(vertex);
        if(delIndex == -1){
            throw new RuntimeException("Vertex does not exist");
        }
        int lastIndex = numVertices - 1;
        //copy last index to new spot
        labels[delIndex] = labels[lastIndex];
        //get rid of the vertex we want to delete
        labels[lastIndex] = null;
        
        
        for(int i = 0; i <= lastIndex; i++){
            if(edgeMatrix[delIndex][i]){
                numEdges--;
            }
            
            if(i != delIndex && i != lastIndex){
                edgeMatrix[i][delIndex] = edgeMatrix[i][lastIndex];
                edgeMatrix[delIndex][i] = edgeMatrix[lastIndex][i];
            }
        }
        
        //delete last row of matrix
        for(int i = 0; i < numVertices; i++){
            edgeMatrix[numVertices-1][i] = false;
            edgeMatrix[i][numVertices-1] = false;
        }
        
        numVertices--;
    }

    @Override
    public void addEdge(String vertex1, String vertex2) throws RuntimeException {
        int i1 = getIndex(vertex1);
        int i2 = getIndex(vertex2);
        if(i1 == -1 || i2 == -1){
            throw new RuntimeException("One or both vertices do not exist.");
        }
        if(edgeMatrix[i1][i2] == true){
            throw new RuntimeException("Edge already exists");
        }
        edgeMatrix[i1][i2] = true;
        edgeMatrix[i2][i1] = true;
        numEdges++;
    }
    
    
    
    /**
     * Adds one or more edges. Each row i in the edges parameter represents
     * the pair of vertices edges[i][0] and edges[i][1] for a new edge.
     * @param edges a 2 x w array of vertices
     * @throws RuntimeException if, for any pair of vertices v1, v2 in the 
     * parameter, edge {v1, v2} already exists in this graph or if v1 or v2
     * are not vertices in this graph.
     */

    @Override
    public void addEdges(String[][] edges) throws RuntimeException {
        for(String[] edge: edges){
            for(int i = 0; i < edges.length; i++){
                int v1 = getIndex(edges[i][0]);
                int v2 = getIndex(edges[i][1]);
                if(edgeMatrix[v1][v2] == true){
                    throw new RuntimeException("Edge aleady exists");
                }
                if(v1 == -1 || v2 == -1){
                    throw new RuntimeException("Vertices do not exist");
                }
            }
        }
        
        for(String[] edge: edges){
            addEdge(edge[0],edge[1]);
        }
        
    }

    @Override
    public void deleteEdge(String vertex1, String vertex2) throws RuntimeException {
        int i1 = getIndex(vertex1);
        int i2 = getIndex(vertex2);
        if(i1 == -1 ||  i2 == -1){
            throw new RuntimeException("One or both vertices do not exist");
        }
        edgeMatrix[i1][i2] = false;
        edgeMatrix[i2][i1] = false;
        numEdges--;
    }

    @Override
    public String[] getNeighbors(String vertex) throws RuntimeException {
        int v = getIndex(vertex);
        if(v == -1){
            throw new RuntimeException("Vertex does not exist");
        }
        
        String[] neighbors = getVertexLabels();
        int size = degree(vertex);
        String[] temp = new String[size];
        int position = 0;
     
        while(position < size){
            for(int i = 0; i < neighbors.length; i++){
                if(edgeExists(vertex, neighbors[i])){
                    temp[position] = neighbors[i];
                    position++;
                }
            }
        }
        return temp;
    }

    @Override
    public int degree(String vertex) throws RuntimeException {
        int vIndex = getIndex(vertex);
        int degree = 0;
        
        if(vIndex == -1){
            throw new RuntimeException("Vertex does not exist");
        }
        
        String[] temp = getVertexLabels();
        
        for(int i = 0; i < temp.length; i++){
            if(edgeExists(vertex, temp[i])){
                degree++;
            }
        }
        return degree;
    }

    
    @Override
    public int[] degreeSequence() {
        int[] sequence = new int[numVertices];
        String[] temp = getVertexLabels();
        int tempNum;
        
        for(int i = 0; i < numVertices; i++){
            sequence[i] = degree(temp[i]);
        }
        
        for(int i = 0; i < sequence.length; i++){
            for(int j = i + 1; j < sequence.length; j++){
                if(sequence[i] < sequence[j]){
                    tempNum = sequence[i];
                    sequence[i] = sequence[j];
                    sequence[j] = tempNum;
                }
            }
        }
        return sequence;
    }

    @Override
    public void resize(int newCapacity) throws RuntimeException {
        if(newCapacity < numVertices){
            throw new RuntimeException("New Capacity is less than the number of vertices");
        }

        String[] temp = new String[newCapacity];
        System.arraycopy(labels, 0, temp, 0, numVertices);
        labels = temp;

        boolean[][] temp2 = new boolean[newCapacity][newCapacity];
        for(int i = 0; i < numVertices; i++){
            System.arraycopy(edgeMatrix[i], 0, temp2[i], 0, numVertices);
        }
        edgeMatrix = temp2;
    }
            

    @Override
    public int maxDegree() {
        int[] degreeSeq = degreeSequence();
        return degreeSeq[0];   
    }

    @Override
    public int minDegree() {
        int[] degreeSeq = degreeSequence();
        return degreeSeq[degreeSeq.length-1];
    }

    @Override
    public double averageDegree() {
        int[] degreeSeq = degreeSequence();
        String[] temp = getVertexLabels();
        int sum = 0;
        for(int i = 0; i < degreeSeq.length; i++){
            sum += degree(temp[i]);
        }
        int average = sum / numVertices;
        return average;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < numVertices; i++){
            s += "    " + labels[i] + "    ";     
        }
        s += "\n";
        
        for(int j = 0; j < numVertices; j++){
            s += "    " + j + "    ";
        }
        s += "\n";
        s += "\n";
        
        for(int i = 0; i < numVertices; i++){
            s += labels[i] + " " + i;
            for(int j = 0; j < numVertices; j++){
                if(edgeMatrix[i][j] == true){
                    s += " T       ";
                }
                else{
                    s += " -       ";
                }
            }
            s += "\n";
        }
        s += "\n";

        return s;
    }

    
    // private method to get index of given vertex
    private int getIndex(String vertex){
        for(int i = 0; i < labels.length; i++){
            if(vertex == labels[i]){
                return i;
            }
        }
        return -1;
    }

}

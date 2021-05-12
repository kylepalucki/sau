
import java.util.*;

/**
 * Kyle Palucki
 */

public class StringGraph implements Graph{

    protected static int capacity;
    protected boolean[][] edgeMatrix;
    protected String[] labels;
    protected int numEdges;
    protected int numVertices;

    public StringGraph(){
        this(1);
    }

    public StringGraph(int initCapacity){
        this.capacity = initCapacity;
        labels = new String[capacity];
        edgeMatrix = new boolean[capacity][capacity];
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

    @Override
    public boolean isConnected() {
        String[] newLabels = dfsOrder(labels[0]);
        return newLabels.length == getVertexLabels().length;
    }

    @Override
    public Graph bfsTree(String vertex) {
        String[] bfs = bfsOrder(vertex);
        Graph result = new StringGraph(bfs);
        return result;
    }

    @Override
    public Graph dfsTree(String vertex) {
        String[] dfs = dfsOrder(vertex);
        Graph result = new StringGraph(dfs);
        return result;
    }

    @Override
    public String[] bfsOrder(String vertex) {
        //PriorityQueue<String> q = new PriorityQueue<>();
        Queue<String> q = new Queue<>();
        ArrayList<String> visited = new ArrayList<>();
        visited.add(vertex);
        q.enqueue(vertex);
        while (!q.isEmpty()) {
            String u = q.dequeue();
            String[] neighbors = getNeighbors(u);
            for (String w : neighbors) {
                if (!visited.contains(w)) {
                    visited.add(w);
                    q.enqueue(w);
                }
            }
        }
        String[] vertices = new String[visited.size()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = visited.get(i);
        }
        return vertices;
    }

    @Override
    public String[] dfsOrder(String vertex) {
        Stack<String> s = new Stack<>();
        ArrayList<String> visited = new ArrayList<>();
        int x = 0;
        visited.add(vertex);
        s.push(vertex);
        while (!s.isEmpty()) {
            String[] neighbors = getNeighbors(s.peek());
            Arrays.sort(neighbors);
            int tosNeighbors = neighbors.length;
            int c = 0;
            for (String n : neighbors) {
                if (visited.contains(n)) c++;
            }
            if (tosNeighbors==c) {
                s.pop();
            } else {
                for (String u : neighbors) {
                    Arrays.sort(neighbors);
                    if (!visited.contains(u)) {
                        s.push(u);
                        visited.add(u);
                        break;
                    }
                }
            }
        }
        String[] vertices = new String[visited.size()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = visited.get(i);
        }
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
        String[] temp = new String[numVertices];
        System.arraycopy(labels, 0, temp, 0, numVertices);
        return temp;
    }

    @Override
    public void addVertex(String vertex) throws RuntimeException {
        int i1 = getIndex(vertex);
        if(i1 != -1){
            throw new RuntimeException();
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
            throw new RuntimeException();
        }
        return edgeMatrix[i1][i2];
    }

    @Override
    public void deleteVertex(String vertex) throws RuntimeException {
        int delIndex = getIndex(vertex);
        if(delIndex == -1){
            throw new RuntimeException();
        }
        int lastIndex = numVertices - 1;
        labels[delIndex] = labels[lastIndex];
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
            throw new RuntimeException();
        }
        if(edgeMatrix[i1][i2] == true){
            throw new RuntimeException();
        }
        edgeMatrix[i1][i2] = true;
        edgeMatrix[i2][i1] = true;
        numEdges++;
    }

    @Override
    public void addEdges(String[][] edges) throws RuntimeException {
        for(String[] edge: edges){
            for(int i = 0; i < edges.length; i++){
                int v1 = getIndex(edges[i][0]);
                int v2 = getIndex(edges[i][1]);
                if(edgeMatrix[v1][v2] == true){
                    throw new RuntimeException();
                }
                if(v1 == -1 || v2 == -1){
                    throw new RuntimeException();
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
            throw new RuntimeException();
        }
        edgeMatrix[i1][i2] = false;
        edgeMatrix[i2][i1] = false;
        numEdges--;
    }

    @Override
    public String[] getNeighbors(String vertex) throws RuntimeException {
        int index = getIndex(vertex);
        if(index == -1){
            throw new RuntimeException();
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
            throw new RuntimeException();
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
            throw new RuntimeException();
        }
        String[] temp = new String[newCapacity];
        System.arraycopy(labels, 0, temp, 0, numVertices);
        labels = temp;
        boolean[][] tempMatrix = new boolean[newCapacity][newCapacity];
        for(int i = 0; i < numVertices; i++){
            System.arraycopy(edgeMatrix[i], 0, tempMatrix[i], 0, numVertices);
        }
        edgeMatrix = tempMatrix;
    }


    @Override
    public int maxDegree() {
        int[] degree = degreeSequence();
        return degree[0];
    }

    @Override
    public int minDegree() {
        int[] degree = degreeSequence();
        return degree[degree.length-1];
    }

    @Override
    public double averageDegree() {
        int[] degree = degreeSequence();
        String[] vertices = getVertexLabels();
        int sum = 0;
        for(int i = 0; i < degree.length; i++){
            sum += degree(vertices[i]);
        }
        int average = sum / numVertices;
        return average;
    }

    @Override
    public String toString(){
        String s = "   ";
        for(int i = 0; i < numVertices; i++){
            s += String.format("%3s", labels[i]);
        }
        s += "\n   ";
        for(int j = 0; j < numVertices; j++){
            s += String.format("%3s", j);
        }
        s += "\n";
        for(int i = 0; i < numVertices; i++){
            s += String.format("%3s",labels[i] + " " + i);
            for(int j = 0; j < numVertices; j++){
                if(edgeMatrix[i][j] == true){
                    s += String.format("%3s", "T");
                }
                else{
                    s += String.format("%3s", "-");
                }
            }
            s += "\n";
        }
        s += "\n";
        return s;
    }

    private int getIndex(String vertex){
        for(int i = 0; i < labels.length; i++){
            if(vertex == labels[i]){
                return i;
            }
        }
        return -1;
    }

}

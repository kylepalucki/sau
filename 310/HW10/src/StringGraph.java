
import java.util.Arrays;

public class StringGraph implements Graph {

    protected String[] labels;
    protected boolean[][] edgeMatrix;
    protected int numVertices;
    protected int numEdges;
    protected int capacity;

    public StringGraph() {
        this.capacity = 0;
        this.numVertices = 0;
        this.numEdges = 0;
        labels = new String[capacity];
        edgeMatrix = new boolean[capacity][capacity];
    }

    public StringGraph(int initCapacity) {
        this.capacity = initCapacity;
    }

    public StringGraph(String[] initVertices) {

    }

    public StringGraph(String[] initVertices, String[][] initEdges) {

    }

    @Override
    public int numberOfVertices() {
        return this.numVertices;
    }

    @Override
    public int numberOfEdges() {
        return this.numEdges;
    }

    @Override
    public String[] getVertexLabels() {
        return this.labels;
    }

    @Override
    public void addVertex(String vertex) {
        this.numVertices++;
        String[] tempLabels = this.labels;
        boolean[][] tempMatrix = this.edgeMatrix;
        resize(++this.capacity);
        int c=0;
        for (String label : tempLabels) {
            labels[c++] = label;
        }
        labels[this.labels.length-1] = vertex;
        

    }

    private String[] create(String newVertex) {
        capacity++;
        String[] s = new String[capacity];
        int c = 0;
        for (String l : labels) {
            s[c++] = l;
        }
        s[s.length - 1] = newVertex;
        return s;
    }

    private String[] destroy(String vertex) {
        capacity--;
        if (vertexExists(vertex)) {
            String[] s = new String[capacity];
            int c = 0;
            for (int i = 0; i < labels.length; i++) {
                if (labels[i].equals(vertex)) {
                    labels[i] = null;
                } else {
                    s[c++] = labels[i];
                }
            }
            return s;
        }
        return null;
    }

    @Override
    public void addVertices(String[] vertices) {
        for (String v : vertices) {
            addVertex(v);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(labels);
    }

    @Override
    public boolean vertexExists(String vertex) {
        for (String l : labels) {
            if (l.equals(vertex)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean edgeExists(String vertex1, String vertex2) {
        if (vertexExists(vertex1) && vertexExists(vertex2)) {
            int i1 = -1, i2 = -1;
            for (int i = 0; i < labels.length; i++) {
                if (labels[i].equals(vertex1)) {
                    i1 = i;
                }
                if (labels[i].equals(vertex2)) {
                    i2 = i;
                }
            }
            return edgeMatrix[i1][i2] && edgeMatrix[i2][i1];
        }
        return false;
    }

    @Override
    public void deleteVertex(String vertex) {
        if (vertexExists(vertex)) {
            this.numVertices--;
            labels = destroy(vertex);
        }
    }

    @Override
    public void addEdge(String vertex1, String vertex2) {
        if (vertexExists(vertex1) && vertexExists(vertex2)) {
            numEdges++;
            int i1 = -1, i2 = -1;
            for (int i = 0; i < labels.length; i++) {
                if (labels[i].equals(vertex1)) {
                    i1 = i;
                }
                if (labels[i].equals(vertex2)) {
                    i2 = i;
                }
            }
            edgeMatrix[i1][i2] = true;
            edgeMatrix[i2][i1] = true;
        }
    }

    @Override
    public void addEdges(String[][] edges) {

    }

    @Override
    public void deleteEdge(String vertex1, String vertex2) {
        if (vertexExists(vertex1) && vertexExists(vertex2)) {
            numEdges--;
            int i1 = -1, i2 = -1;
            for (int i = 0; i < labels.length; i++) {
                if (labels[i].equals(vertex1)) {
                    i1 = i;
                }
                if (labels[i].equals(vertex2)) {
                    i2 = i;
                }
            }
            edgeMatrix[i1][i2] = false;
            edgeMatrix[i2][i1] = false;
        }
    }

    @Override
    public String[] getNeighbors(String vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int degree(String vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resize(int newCapacity) {
        this.capacity = newCapacity;
        String[] s = new String[newCapacity];
        boolean[][] e = new boolean[newCapacity][newCapacity];
        this.labels = s;
        this.edgeMatrix = e;
        
    }

    @Override
    public int maxDegree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int minDegree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double averageDegree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isConnected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Graph bfsTree(String vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Graph dfsTree(String vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] bfsOrder(String vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] dfsOrder(String vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] shortestPath(String s, String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] bfsSSSP(String v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

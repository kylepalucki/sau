

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
        this.numVertices = 0;
        this.numEdges = 0;
        labels = new String[capacity];
        edgeMatrix = new boolean[capacity][capacity];
    }

    public StringGraph(String[] initVertices) {
        this.capacity = initVertices.length;
        this.numVertices = initVertices.length;
        this.numEdges = 0;
        labels = new String[capacity];
        edgeMatrix = new boolean[capacity][capacity];
        addVertices(initVertices);

    }

    public StringGraph(String[] initVertices, String[][] initEdges) {
        this.capacity = initVertices.length;
        this.numVertices = initVertices.length;
        this.numEdges = initEdges.length;
        labels = new String[capacity];
        edgeMatrix = new boolean[capacity][capacity];
        addVertices(initVertices);
        addEdges(initEdges);

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
        if (!vertexExists(vertex)) {
            this.numVertices++;
            String[] tempLabels = this.labels;
            boolean[][] tempMatrix = this.edgeMatrix;
            resize(++this.capacity);
            int c = 0;
            for (String label : tempLabels) {
                labels[c++] = label;
            }
            labels[this.labels.length - 1] = vertex;
            for (int i = 0; i < tempMatrix.length; i++) {
                System.arraycopy(tempMatrix[i], 0, edgeMatrix[i], 0, tempMatrix[i].length);
            }
        }
    }

    @Override
    public void addVertices(String[] vertices) {
        for (String v : vertices) {
            addVertex(v);
        }
    }

    @Override
    public String toString() {
        String f = "";
        f += String.format("%4s", " ");
        for (int i = 0; i < capacity; i++) {
            f += String.format("%3s", labels[i]);
        }
        f += "\n";
        f += String.format("%4s", " ");
        for (int i = 0; i < capacity; i++) {
            f += String.format("%3s", i);
        }
        f += "\n";
        for (int i = 0; i < capacity; i++) {
            f += String.format("%2s", labels[i]);
            f += String.format("%2s", i);
            for (int j = 0; j < capacity; j++) {
                if (edgeMatrix[i][j]) {
                    f += String.format("%3s", "T");
                } else {
                    f += String.format("%3s", "-");
                }
            }
            f += "\n";
        }
        return f;
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
            String[] tempLabels = this.labels;
            
            for (String label : labels) {
                if (edgeExists(vertex, label)) {
                    deleteEdge(vertex, label);
                }
            }
            boolean[][] tempMatrix = this.edgeMatrix;
            resize(--this.capacity);
            int c = 0;
            for (int i = 0; i < tempLabels.length-1; i++) {
                if (tempLabels[i].equals(vertex)){
                    labels[c++] = tempLabels[tempLabels.length-1];
                }
                if (!tempLabels[i].equals(vertex)) {
                    labels[c++] = tempLabels[i];
                }
            }
            for (int i = 0; i < tempMatrix.length-1; i++) {
                for (int j = 0; j < tempMatrix[i].length-1; j++) {
                    edgeMatrix[i][j] = tempMatrix[i][j];
                }
            }

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
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                addEdge(edges[i][j], edges[j][i]);
            }
        }
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

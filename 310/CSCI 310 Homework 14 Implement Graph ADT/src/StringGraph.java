import java.util.*;

/**
 *
 * @author Elena Muhs
 * CSCI 310 Data Structures
 * Homework 14 Implement Graph ADT
 */
public class StringGraph implements Graph{
    protected int capacity;
    protected boolean[][] edgeMatrix;
    protected String[] labels;
    protected int numEdges;
    protected int numVertices;
    
    public StringGraph (){
        capacity = 1;
    }
    
    public StringGraph (int initCap){
        capacity = initCap;
        labels = new String[initCap];
        edgeMatrix = new boolean[initCap][initCap];
    }
    
    public StringGraph (int initCap, String[] initVert){
        this(initCap);
        this.addVertices(initVert);
    }
    
    public StringGraph (int initCap, String[] initVert, String[][] initEdges){
        this(initCap);
        this.addVertices(initVert);
        this.addEdges(initEdges);
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
        temp = labels;
        return temp;
    }

    @Override
    public void addVertex(String vertex) throws RuntimeException {
        if(vertexExists(vertex)){
            throw new RuntimeException("Vertex already exists");
        }
        if(numVertices == labels.length){
            resize(capacity = capacity + 1);
        }
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
        if(i1 == -1){
            throw new RuntimeException("Method edgeExists failed: Vertex \"" + vertex1 + "\" does not exist.");
        }
        int i2 = getIndex(vertex2);
        if(i2 == -1){
            throw new RuntimeException("Method edgeExists failed: Vertex \"" + vertex2 + "\" does not exist.");
        }
        return edgeMatrix[i1][i2];
    }

    @Override
    public void deleteVertex(String vertex) throws RuntimeException {
        int deleteIndex = getIndex(vertex);
        if(deleteIndex == -1){
            throw new RuntimeException("Method deleteVertex(v) failed: Vertex \"" + vertex + "\" does not exist.");
        }
        
        int lastIndex = numVertices - 1;
        labels[deleteIndex] = labels[lastIndex];
        labels[lastIndex] = null;
        
        for(int i = 0; i <= lastIndex; i++){
            if(edgeMatrix[deleteIndex][i]){
                numEdges--;
            }
            if(i != deleteIndex && i != lastIndex){
                edgeMatrix[i][deleteIndex] = edgeMatrix[i][lastIndex];
                edgeMatrix[deleteIndex][i] = edgeMatrix[lastIndex][i];
            }
        }
        
        for(int j = 0; j < numVertices; j++){
            edgeMatrix[numVertices - 1][j] = false;
            edgeMatrix[j][numVertices - 1] = false;
        }
        
        numVertices++;
    }
    
    public int getIndex(String vertex){
        for(int i = 0; i < labels.length; i++){
            if(labels[i] == vertex){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addEdge(String vertex1, String vertex2) throws RuntimeException {
        int i1 = getIndex(vertex1);
        if(i1 == -1){
            throw new RuntimeException("Method addEdge failed: Vertex \"" + vertex1 + "\" does not exist.");
        }
        int i2 = getIndex(vertex2);
        if(i2 == -1){
            throw new RuntimeException("Method addEdge failed: Vertex \"" + vertex2 + "\" does not exist.");
        }
        edgeMatrix[i1][i2] = true;
        edgeMatrix[i2][i1] = true;
        numEdges++;
    }

    @Override
    public void addEdges(String[][] edges) throws RuntimeException {
        for(int i = 0; i< edges.length; i++){
            String u = edges[i][0];
            int uae = getIndex(u);
            if(uae == -1){
                throw new RuntimeException("Method addEdges failed: Vertex \"" + u + "\" does not exist.");
            }
            String v = edges[0][i];
            int vae = getIndex(v);
            if(vae == -1){
                throw new RuntimeException("Method addEdges failed: Vertex \"" + v + "\" does not exist.");
            }
            addEdge(u,v);
        }
    }

    @Override
    public void deleteEdge(String vertex1, String vertex2) throws RuntimeException {
        int i1 = getIndex(vertex1);
        if(i1 == -1){
            throw new RuntimeException("Method addEdge failed: Vertex \"" + vertex1 + "\" does not exist.");
        }
        int i2 = getIndex(vertex2);
        if(i2 == -1){
            throw new RuntimeException("Method addEdge failed: Vertex \"" + vertex2 + "\" does not exist.");
        }
        edgeMatrix[i1][i2] = false;
        edgeMatrix[i2][i1] = false;
        numEdges--;
    }

    @Override
    public String[] getNeighbors(String vertex) throws RuntimeException {
        int g = getIndex(vertex);
        if(g == -1){
            throw new RuntimeException("Method getNeighbors failed: Vertex \"" + vertex + "\" does not exist.");
        }  
        String[] neighbors = new String[numVertices];
        for(int i = 0; i < numVertices; i++){
            int counter = 0;
            if(edgeMatrix[g][i] = true){
                neighbors[counter] = labels[i];
                counter++;
            }
        }
        return neighbors;
    }

    @Override
    public int degree(String vertex) throws RuntimeException {
        int count = 0;
        int g = getIndex(vertex);
        if(g == -1){
            throw new RuntimeException("Method degree failed: Vertex \"" + vertex + "\" does not exist.");
        }  
        for(int i = 0; i < numVertices; i++){
            if(edgeMatrix[g][i] = true){
                count++;
            }
        }
        return count;
    }

    @Override
    public int[] degreeSequence() {
        int[] sequence = new int[numVertices];
        for(int i = 0; i < numVertices; i++){
            int deg = degree(labels[i]);
            sequence[i] = deg;
        }
        Sorting.sort(sequence, Sorting.Algorithm.MERGE_SORT);
        return sequence;
    }

    @Override
    public void resize(int newCapacity) throws RuntimeException {
        if(newCapacity == capacity){
            throw new RuntimeException("Method resize failed: newCapacity equals capacity");
        } 
        if(newCapacity < numVertices){
            throw new RuntimeException("Method resize failed: newCapacity less that numVertices");
        } 
        if(newCapacity > capacity){
            increaseCap(newCapacity);
        }
        if(newCapacity > capacity){
            decreaseCap(newCapacity);
        }
    }

    public void increaseCap(int newCap){
        String[] icl = Arrays.copyOf(labels, newCap);
        capacity = newCap;
        boolean[][] icm = Arrays.copyOf(edgeMatrix, newCap);
    }
    
    public void decreaseCap(int newCap){
        String[] dcl = Arrays.copyOf(labels, newCap);
        capacity = newCap;
        boolean[][] dcm = Arrays.copyOf(edgeMatrix, newCap);
    }
    
    @Override
    public int maxDegree() {
        int max = -1;
        for(int i = 0; i < numVertices; i++){
            int deg = degree(labels[i]);
            if(deg > max){
                max = deg;
            }
        }
        return max;
    }

    @Override
    public int minDegree() {
        int min = numVertices;
        for(int i = 0; i < numVertices; i++){
            int deg = degree(labels[i]);
            if(deg < min){
                min = deg;
            }
        }
        return min;    
    }

    @Override
    public double averageDegree() {
        int temp = 0;
        for(int i = 0; i < numVertices; i++){
            int deg = degree(labels[i]);
            temp = temp + deg;
        }
        int avg = temp/numVertices;
        return avg;  
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.labels.length != 0){
            sb.append("\t");
            for(String str : this.labels){
                if(str != null){
                    sb.append(str).append(" ");
                }
            }
           sb.append("\n\n");
           for(int i=0; i<this.labels.length; i++){
               if(this.labels[i] != null){
                   sb.append(i).append(" ");
               }
           }
           sb.append("\n\n");
           
           for(int i = 0; i< this.edgeMatrix.length; i++){
               if(labels[i] != null){
                   sb.append(labels[i]).append(" ").append(i)            ;
                   boolean[] row = edgeMatrix[i];
                   for(int j=0; j<this.numVertices; j++){
                       boolean value = row[j];
                       if(value){
                           sb.append("T").append(" ");
                       }
                       else{
                           sb.append("-").append(" ");
                       }
                   }
                   sb.append("\n");
               }
           }
           sb.append("\n");
        }
        sb.append("vertices: ").append(this.numVertices).append("\tedges: ").append(this.numEdges);
        sb.append("\n\n");
        return sb.toString();
    }
}

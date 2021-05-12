
import java.util.*;

/**
 *
 * @author Elena Muhs
 * CSCI 310 Data Structures
 * Homework 14 Implement Graph ADT
 */
public class SGTester{
    public static void main(String[] str) {
       StringGraph SG = new StringGraph();
        SG.addVertex("A");
        SG.addVertex("B");
        SG.addVertex("C");
        System.out.println(SG);
        
        String[] items = {"E","F"};
        SG.addVertices(items);
        System.out.println(SG);
        
        SG.deleteVertex("B");
        System.out.println(SG);
        
        SG.addEdge("A", "C");
        SG.addEdge("A", "D");
        SG.addEdge("C", "E");
        System.out.println(SG);
        
        String[][] items2 = {{"F","A"},{"F","E"}};
        SG.addEdges(items2);
        System.out.println(SG);
        
        SG.deleteVertex("A");
        System.out.println(SG);
        
        SG.deleteEdge("E", "C");
        System.out.println(SG);
    }
}
    
   
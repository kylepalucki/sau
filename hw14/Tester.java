
import java.util.Arrays;


/*
CSCI 310
HW14 - Tester Program
Jonathan Dose
 */

public class Tester {
    public static void main(String[] args) {
        //1. add three vertices labeled "A", "B", and "C" by calling the addVertex
        StringGraph sg = new StringGraph(3);
        sg.addVertex("A");
        sg.addVertex("B");
        sg.addVertex("C");
        System.out.println("====");
        System.out.println("Step 1");
        System.out.println(sg.toString());
        
        
        //2. add vertices D, E, and F using addVertices
        String[] str = {"D", "E", "F"};
        sg.addVertices(str);
        System.out.println("====");
        System.out.println("Step 2");
        System.out.println(sg.toString());
        
        //3. Remove Vertex B
        sg.deleteVertex("B");
        System.out.println("====");
        System.out.println("Step 3");
        System.out.println(sg.toString());
        
        //4. use addEdge three times
        sg.addEdge("A", "C");
        sg.addEdge("A", "D");
        sg.addEdge("C", "E");
        System.out.println("====");
        System.out.println("Step 4");
        System.out.println(sg.toString());
        
        
        //5. add Edges
        String[][] str2 = {{"F","A"},{"F","D"},{"F","E"}};
        sg.addEdges(str2);
        System.out.println("====");
        System.out.println("Step 5");
        System.out.println(sg.toString());

        
        //6. Remove vertex A
        sg.deleteVertex("A");
        System.out.println("====");
        System.out.println("Step 6");
        System.out.println(sg.toString());
        
        //7. Remove Edge E,C
        sg.deleteEdge("E", "C");
        System.out.println("====");
        System.out.println("Step 7");
        System.out.println(sg.toString());
        
    }
}

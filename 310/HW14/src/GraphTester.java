/**
 * Kyle Palucki
 */

public class GraphTester {
    public static void main(String[] args) {
        StringGraph sg = new StringGraph(3);
        sg.addVertex("A");
        sg.addVertex("B");
        sg.addVertex("C");
        System.out.println();
        System.out.println(sg.toString());

        String[] vertices = {"D", "E", "F"};
        sg.addVertices(vertices);
        System.out.println();
        System.out.println(sg.toString());

        sg.deleteVertex("B");
        System.out.println();
        System.out.println(sg.toString());

        sg.addEdge("A", "C");
        sg.addEdge("A", "D");
        sg.addEdge("C", "E");

        String[][] edges = {{"F","A"},{"F","D"},{"F","E"}};
        sg.addEdges(edges);
        System.out.println();
        System.out.println(sg.toString());

        sg.deleteVertex("A");
        System.out.println();
        System.out.println(sg.toString());

        sg.deleteEdge("E", "C");
        System.out.println();
        System.out.println(sg.toString());
    }
}

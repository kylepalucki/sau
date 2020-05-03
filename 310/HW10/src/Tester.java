


public class Tester {
    public static void main(String[] args) {
        StringGraph sg = new StringGraph();
        sg.addVertex("A");
        sg.addVertex("B");
        sg.addVertex("C");
        System.out.println(sg);
        System.out.println("=================================");
        System.out.println();
        
        String[] vertices = {"D", "E", "F"};
        sg.addVertices(vertices);
        System.out.println(sg);
        System.out.println("=================================");
        
        sg.deleteVertex("B");
        sg.addVertices(vertices);
        System.out.println(sg);
        System.out.println("=================================");
        
        sg.addEdge("A","C");
        sg.addEdge("A","D");
        sg.addEdge("C","E");
        System.out.println(sg);
        System.out.println("=================================");
        
        String[][] edges = {
            {"F","A"}, //0,0 0,1
            {"F","D"}, //1,0 1,1
            {"F","E"}, //2,0 2,1
        };
        //sg.addEdges(edges);
        System.out.println(sg);
        System.out.println("=================================");
        
        sg.deleteVertex("A");
        System.out.println(sg);
        System.out.println("=================================");
        
        sg.deleteEdge("E","C");
        System.out.println(sg);
        System.out.println("=================================");
        
        
    }
}

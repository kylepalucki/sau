
import java.util.Arrays;


public class Tester {
    public static void main(String[] args) {
        StringGraph sg = new StringGraph();
        sg.addVertex("a");
        sg.addVertex("b");
        sg.addVertex("c");
        sg.addVertex("d");
        
        String[] l = sg.getVertexLabels();
                
        System.out.println(sg.numberOfVertices());
        System.out.println(l[1]);
        System.out.println(sg.vertexExists("b"));
        sg.deleteVertex("b");
        System.out.println(sg.numberOfVertices());
        System.out.println(sg.vertexExists("b"));
        System.out.println(Arrays.toString(l));
    }
}

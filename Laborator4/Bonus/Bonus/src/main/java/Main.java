import com.github.javafaker.Faker;
import org.example.Problem;
import org.example.Project;
import org.example.Student;
import org.graph4j.GraphBuilder;
import org.graph4j.alg.matching.HopcroftKarpMaximumMatching;
import org.graph4j.util.StableSet;
import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.MatchingAlgorithm;
import org.jgrapht.alg.matching.DenseEdmondsMaximumCardinalityMatching;
import org.jgrapht.alg.matching.HopcroftKarpMaximumCardinalityBipartiteMatching;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static int maxNum = 3_000;
    static int studLimit = (int) (Math.random() * maxNum);
    static int projLimit = (int) (Math.random() * maxNum);

    public static void main(String[] args) {

        var S = IntStream.rangeClosed(0, studLimit)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);

        var P = IntStream.rangeClosed(0, projLimit)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);

        Problem problem = new Problem();
        Random random = new Random();

        Graph<String, DefaultEdge> theGraph = new DefaultUndirectedGraph<>(DefaultEdge.class);

        org.graph4j.Graph<String, String> theGraph2 =
                GraphBuilder.empty().estimatedNumVertices(S.length + P.length).buildGraph();

        for(Student s: S){
            theGraph.addVertex(s.getName());
            theGraph2.addVertex(s.getName());
            problem.addInstance(s, Arrays.stream(P).filter(project -> random.nextBoolean()).toList());
        }
        for(Project p: P){
            theGraph.addVertex(p.getName());
            theGraph2.addVertex(p.getName());
        }
        // Adaugarea Muchiilor
        Arrays.stream(S).forEach(student -> problem.getPrefProjects().get(student)
                .forEach(project -> theGraph.addEdge(student.getName(),project.getName())));
        Arrays.stream(S).forEach(student -> problem.getPrefProjects().get(student)
                .forEach(project -> theGraph2.addEdge(student.getName(),project.getName())));

        long time = System.nanoTime();

        MatchingAlgorithm<String, DefaultEdge> grafMatch =
            new HopcroftKarpMaximumCardinalityBipartiteMatching<>(theGraph,
                Set.copyOf(Arrays.stream(S).map(Student::getName).toList()),
                Set.copyOf(Arrays.stream(P).map(Project::getName).toList()));

        System.out.println("Maxium cardinality matching: " + grafMatch.getMatching().getEdges().size());
        System.out.println("Timpul pentru algoritmul Hopcroft Karp cu JGraphT: " + (System.nanoTime() - time)/1_000_000_000d + " secunde");

        time = System.nanoTime();
        HopcroftKarpMaximumMatching grafMatch2 = new HopcroftKarpMaximumMatching(theGraph2);

        System.out.println("Maxium cardinality matching: " + grafMatch2.getMatching().size());
        System.out.println("Timpul pentru algoritmul Hopcroft Karp cu Graph4J: " + (System.nanoTime() - time)/1_000_000_000d + " secunde");

        time = System.nanoTime();
        Greedy.greedyChoice(problem);
        System.out.println("Timpul pentru algoritmul Greedy: " + (System.nanoTime() - time)/1_000_000_000d + " secunde");

        //Minimum vertex cover
//        int size = grafMatch.getMatching().getEdges().size();
//        if(S.length==size){
//            if(size <= (theGraph.vertexSet().size())/2)
//                System.out.println("Minimum vertex cover: " + S.length);
//            else
//                System.out.println("Minimum vertex cover: " + (theGraph.vertexSet().size() - size));
//        }
//        else {
//            if(size <= (theGraph.vertexSet().size())/2)
//                System.out.println("Minimum vertex cover: " + P.length);
//            else
//                System.out.println("Minimum vertex cover: "+ (theGraph.vertexSet().size() - size));
//        }
//
//        //Maximum stable set
//        System.out.println("Maximum stable set: " + ((theGraph.vertexSet().size()) - size));

        System.out.println("Minimum vertex cover: " + grafMatch2.getMinimumVertexCover().size());
        System.out.println("Maximum stable set: " + grafMatch2.getMaximumStableSet().size());
    }

}
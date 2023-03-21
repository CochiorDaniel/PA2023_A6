import com.github.javafaker.Faker;
import org.example.Problem;
import org.example.Project;
import org.example.Student;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Faker javaFaker = Faker.instance(new Locale("en-GB"));

        var S = Stream.generate(() -> new Student(javaFaker.name().firstName())).distinct()
                        .limit(10).toArray(Student[]::new);


        var P = Stream.generate(() -> new Project(javaFaker.app().name())).distinct()
                .limit(10).toArray(Project[]::new);

        Problem problem = new Problem();

        problem.addInstance(S[2],  Arrays.asList(P[0],P[6],P[4],P[3]));
        problem.addInstance(S[5],  Arrays.asList(P[0],P[5],P[3]));
        problem.addInstance(S[1],  Arrays.asList(P[0],P[5],P[3],P[1],P[8],P[9]));
        problem.addInstance(S[0],  Arrays.asList(P[0],P[5],P[3],P[1],P[9],P[8]));
        problem.addInstance(S[6],  Arrays.asList(P[7]));
        problem.addInstance(S[3],  Arrays.asList(P[7]));
        problem.addInstance(S[8],  Arrays.asList(P[7], P[6]));

        double average = problem.getPrefProjects().values()
                .stream()
                .mapToInt(List::size)
                .average()
                .orElse(0.0);

        problem.getPrefProjects().entrySet().stream()
                .filter(stud -> stud.getValue().size() < average)
                .forEach(stud -> System.out.println(stud.getKey()+ ": " + stud.getValue()));

        System.out.println(average);
        Greedy.greedyChoice(problem);


    }

}
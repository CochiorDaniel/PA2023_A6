import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.Set;
public class Main {
    public static void main(String[] args) {

        LinkedList<Student> students = new LinkedList<>();
        Set<Project> projects = new TreeSet<>();

        var arrayOfStudents = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);

        students.addAll(Arrays.asList(arrayOfStudents));
        Collections.sort(students);

        var arrayOfProjects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);

        projects.addAll(Arrays.asList(arrayOfProjects));

        for(Student s: students)
            System.out.println(s);

        for(Project p: projects)
            System.out.println(p);

    }

}
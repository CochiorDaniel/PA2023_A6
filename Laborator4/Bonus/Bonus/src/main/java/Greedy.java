import org.example.Problem;
import org.example.Project;
import org.example.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Greedy {
    static int cnt = 0;

    public static void greedyChoice(Problem problem){
        Map<Student, List<Project>> prefProjects = problem.getPrefProjects();
        Map<Project, Boolean> availability = problem.getAvailability();

        List<Map.Entry<Student, List<Project>>> sortedStuds = prefProjects.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(stud -> stud.getValue().size()))
                .toList();

        for (Map.Entry<Student, List<Project>> stud : sortedStuds){
            List<Project> projects = stud.getValue();
            int fl = 0;
            for (Project p : projects){
                if(availability.get(p)){
                    //System.out.println(stud.getKey() + " - " + p);
                    availability.put(p , false);
                    fl = 1;
                    cnt++;
                    break;
                }
            }
            //if(fl == 0)
                //System.out.println(stud.getKey() + " - all projects from his list are taken.");
        }
        System.out.println("Maximum cardinality matching: " + cnt);
    }

}

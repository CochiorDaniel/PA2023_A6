package org.example;
import org.example.Project;
import java.util.*;

public class Problem {
    private Map<Student, List<Project>> prefProjects = new HashMap<>();
    private Map<Project, Boolean> availability = new HashMap<>();
    private void addProjects(Project project){
        if(availability.containsKey(project))
            return;
        else
            availability.put(project, true);
    }
    public void addInstance(Student student, List<Project> wantedProjects){
        if(prefProjects.containsKey(student))
            return;
        else {
            prefProjects.put(student, wantedProjects);
            for (Project proj : wantedProjects)
                addProjects(proj);
        }
    }
    public Map<Student, List<Project>> getPrefProjects() {
        return prefProjects;
    }
    public Map<Project, Boolean> getAvailability() {
        return availability;
    }


}

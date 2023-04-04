import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Date implements Serializable {
    protected List<Linie> linies;

    public Date(List<Linie> l){
        linies = l;
    }
    public Date(){}

    public List<Linie> getLinies() {
        return linies;
    }

    public void setLinies(List<Linie> linies) {
        this.linies = linies;
    }
    public void save() throws IOException {
        ObjectMapper savedList = new ObjectMapper();
        savedList.writeValue(new File("C:\\Users\\Daniel\\Desktop\\Programare Avansata\\Laborator6\\Homework\\joc.json"),this);

    }

    public Date load() throws IOException {
        ObjectMapper loadedList = new ObjectMapper();
        Date d = loadedList.readValue(new File("C:\\Users\\Daniel\\Desktop\\Programare Avansata\\Laborator6\\Homework\\joc.json"),Date.class);
        return d;
    }
}

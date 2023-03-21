import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String title;
    private String location; //file name or Web page
    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }
    public Document(){ }
    private Map<String, Object> tags = new HashMap<>();
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getLocation() {
        return location;
    }
    public Map<String, Object> getTags() {
        return tags;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}

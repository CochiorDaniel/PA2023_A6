import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }

    public Catalog(){ }
    public void add(Document doc) {
        docs.add(doc);
    }
    public Document findById(String id) {
        for (var doc : docs) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Catalogul " + this.name + " are " + this.docs.size() + " articole.";
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocs() {
        return docs;
    }

    public String getName() {
        return name;
    }
}

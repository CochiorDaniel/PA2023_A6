import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }
    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("1","article1", "Bucuresti") ;
        var article = new Document("3","book1", "Iasi");
        catalog.add(book);
        catalog.add(article);
        CatalogUtil.save(catalog, "C:\\Users\\Daniel\\Desktop\\Programare Avansata\\Laborator5\\Compulsory\\file.json");
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("C:\\Users\\Daniel\\Desktop\\Programare Avansata\\Laborator5\\Compulsory\\file.json");

    }

}



import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import javax.print.Doc;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException, TikaException, SAXException {
        Main app = new Main();
        app.testInfo();

    }
    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("C:\\Users\\Daniel\\Desktop\\Programare Avansata\\Laborator5\\Compulsory\\file.json");

    }
    private void testInfo() throws IOException, TikaException, SAXException {
        Catalog catalog = new Catalog("MyDocuments", "C:\\Users\\Daniel\\Desktop\\Programare Avansata\\Laborator5\\Compulsory\\file.json");
        var book = new Document("1","article1", "C:\\Users\\Daniel\\Desktop\\Programare Avansata\\Laborator5\\Bonus\\book1.txt") ;
        var article = new Document("3","book1", "C:\\Users\\Daniel\\Desktop\\Programare Avansata\\Laborator5\\Bonus\\book2.txt");

        catalog.add(book);
        catalog.add(article);
        CatalogUtil.save(catalog);
        Info info = new Info();
        info.info(catalog);

    }
}



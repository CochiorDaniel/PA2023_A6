import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Info {
    public Info() {}

    public void info(Catalog c) throws IOException, TikaException, SAXException {
        Parser parse = new AutoDetectParser();
        Metadata metadata = new Metadata();
        BodyContentHandler handler = new BodyContentHandler(-1);
        for (Document d : c.getDocs()) {
            System.out.println(d.getTitle());
            FileInputStream file = new FileInputStream(d.getLocation());
            parse.parse(file, handler, metadata, new ParseContext());
            for (String s : metadata.names()) {
                System.out.println(s + ":\t" + metadata.get(s));
            }
            System.out.println();
        }

        System.out.println(c.getName());
        BodyContentHandler body = new BodyContentHandler();
        Metadata meta = new Metadata();
        FileInputStream file = new FileInputStream(c.getPath());
        parse.parse(file, body, meta, new ParseContext());
        for (String s : metadata.names()) {
            System.out.println(s + ":\t" + meta.get(s));
        }
    }

}

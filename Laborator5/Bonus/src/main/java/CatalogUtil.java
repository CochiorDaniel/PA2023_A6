import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InvalidClassException;
public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(catalog.getPath()), catalog);
    }
    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), Catalog.class);
        }

    }


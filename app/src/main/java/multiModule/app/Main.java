package multiModule.app;


import interfaces.DocumentService;
import interfaces.XmlParser;
import models.Catalog;
import models.Category;
import multiModule.app.services.DataGeneratorImpl;
import multiModule.app.services.DocumentServiceImpl;
import multiModule.app.services.XmlParserImpl;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        try (final InputStream configInputStream = Main.class.getClassLoader().getResourceAsStream("gradle.properties");
             final BufferedReader br = new BufferedReader(new InputStreamReader(configInputStream));) {
            props.load(br);
        }
        final String XML_PATH = props.getProperty("PATH_TO_XML");
        // имя тэга для остановки при обходе StAX
        DocumentService documentService = new DocumentServiceImpl();
        XmlParser parser = new XmlParserImpl();
        // Создание объекта Catalog, и его заполнение
        Catalog catalog = new DataGeneratorImpl().generateCatalog();
        try {
            // Создание и парсинг xml
            File xmlFile = documentService.createDocument(XML_PATH, catalog);
            documentService.printXMLFile(xmlFile);
            // JSON
            String json = parser.convertXMLToJSON(xmlFile);
            System.out.println(json);
            Catalog catalog1 = (Catalog) parser.convertJSONtoXML(json, Catalog.class);
            System.out.println(catalog1);
            // Достаем подкатегории StAX`ом
            Category catalog2 = documentService.getSubCategoryByStAX(xmlFile);
            catalog2.getSubCategory().forEach(System.out::println);
        } catch (SAXException | IOException | JAXBException | XMLStreamException e) {
            e.printStackTrace();
        }

    }
}
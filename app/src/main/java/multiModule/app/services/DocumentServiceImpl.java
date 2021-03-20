package multiModule.app.services;

import interfaces.DocumentService;
import interfaces.XmlParser;

import models.Catalog;
import models.Category;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class DocumentServiceImpl implements DocumentService {
    XmlParser parser;
    private static final String TAG_NAME = "category";
    public DocumentServiceImpl() {
        parser = new XmlParserImpl();
    }
    @Override
    public File createDocument(String fileName, Object catalog) throws SAXException, IOException, JAXBException {
        // Создание объекта Schema из xsd файла
        Schema schema = new SchemaGeneratorImpl().generateSchema();
        XmlParser parser = new XmlParserImpl();
        return parser.convertObjectToXml(catalog, fileName, schema);
    }

    @Override
    public void printXMLFile(File xmlFile) throws JAXBException, SAXException, IOException {
        Catalog unmarshalCatalog = parser.fromXmlToObject(xmlFile.getPath());
        if (unmarshalCatalog != null) {
            List<Category> categoryList = unmarshalCatalog.getCategories();
            categoryList.forEach(System.out::println);
        }
    }

    @Override
    public Category getSubCategoryByStAX(File xmlFile) throws XMLStreamException, JAXBException {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource(xmlFile);
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);
        xsr.nextTag();
        while(!xsr.getLocalName().equals(TAG_NAME)) {
            xsr.nextTag();
        }
        // Выводим в консоль
        JAXBContext jc = JAXBContext.newInstance(Category.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<Category> jb = unmarshaller.unmarshal(xsr, Category.class);
        xsr.close();
        return jb.getValue();
    }
}

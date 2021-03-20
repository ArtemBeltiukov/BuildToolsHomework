package interfaces;

import models.Category;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

public interface DocumentService {
    File createDocument(String fileName, Object catalog) throws SAXException, IOException, JAXBException;
    void printXMLFile(File xmlFile) throws JAXBException, SAXException, IOException;
    Category getSubCategoryByStAX(File xmlFile) throws XMLStreamException, JAXBException;
}

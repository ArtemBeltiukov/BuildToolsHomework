package interfaces;


import models.Catalog;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.validation.Schema;
import java.io.File;
import java.io.IOException;

public interface XmlParser {
    File convertObjectToXml(Object catalog, String filePath, Schema schema) throws JAXBException;
    Catalog fromXmlToObject(String filePath) throws IOException, SAXException, JAXBException;
    String convertXMLToJSON(File xmlFile) throws JAXBException, SAXException, IOException;
    Object convertJSONtoXML(String json, Class XMLClass);
}

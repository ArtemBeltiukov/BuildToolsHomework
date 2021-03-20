package multiModule.app.services;

import interfaces.SchemaGenerator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.net.URL;

public class SchemaGeneratorImpl implements SchemaGenerator {
    private final String pathToSchema = "schemas/catalog.xsd";
    @Override
    public Schema generateSchema() throws SAXException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        URL schemaURL = this.getClass().getClassLoader().getResource(pathToSchema);
        return schemaFactory.newSchema(schemaURL);
    }
}

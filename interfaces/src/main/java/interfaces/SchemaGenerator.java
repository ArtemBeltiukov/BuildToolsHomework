package interfaces;

import org.xml.sax.SAXException;

import javax.xml.validation.Schema;

public interface SchemaGenerator {
    Schema generateSchema() throws SAXException;
}

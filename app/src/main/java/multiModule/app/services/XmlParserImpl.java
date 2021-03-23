package multiModule.app.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import interfaces.XmlParser;
import models.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import java.io.*;
import java.net.URL;


public class XmlParserImpl implements XmlParser {
    private final String SCHEMA_LOCATION = "/resources/schemas/catalog.xsd";
    @Override
    public File convertObjectToXml(Object catalog, String filePath, Schema schema) throws JAXBException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
        File xmlFile = new File("catalog.xml");
        byte[] buffer = new byte[0];
        try {
            buffer = new byte[is.available()];
            is.read(buffer);
            OutputStream outStream = new FileOutputStream(xmlFile);
            outStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }


        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setSchema(schema);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,SCHEMA_LOCATION);
        marshaller.marshal(catalog, xmlFile);
        return xmlFile;
    }
    @Override
    public Catalog fromXmlToObject(String filePath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
        Unmarshaller un = jaxbContext.createUnmarshaller();
        return (Catalog) un.unmarshal(new File(filePath));
    }
    @Override
    public String convertXMLToJSON(File xmlFile) throws JAXBException {
        Catalog unmarshalCatalog = fromXmlToObject(xmlFile.getPath());
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(unmarshalCatalog);
    }
    @Override
    public  Object convertJSONtoXML(String json, Class XMLClass){
        return new Gson().fromJson(json, XMLClass);
    }
}

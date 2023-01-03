package dev.mestizos.signer;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Signer {

    void sign(String pathDigitalCertificate,
              String password,
              String pathXmlFile,
              String pathXmlFileSigned) throws IOException {

        var signerXml = new SignerXml();

        byte[] certificate = Files.readAllBytes(Paths.get(pathDigitalCertificate));
        byte[] xmlFile = Files.readAllBytes(Paths.get(pathXmlFile));

        Document documentSigned = signerXml.sign(certificate, password, xmlFile);
        saveSignedDocument(documentSigned, pathXmlFileSigned);
    }

    void saveSignedDocument(Document document, String path) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);

            FileWriter writer = new FileWriter(path);
            StreamResult result = new StreamResult(writer);

            transformer.setOutputProperty("encoding", "UTF-8");
            transformer.transform(source, result);

        } catch (IOException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
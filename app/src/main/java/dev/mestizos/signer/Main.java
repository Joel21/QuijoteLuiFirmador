package dev.mestizos.signer;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws RuntimeException {
        System.out.println("QuijoteLui Firmador");

        ClassLoader classLoader = Main.class.getClassLoader();

        var pathDigitalCertificate = classLoader.getResource("Hacker.p12").getPath();
        var password = "No_Piratear";
        var pathXmlFile = classLoader
                .getResource("0301202301123456789000110010030000000071234567811.xml").getPath();

        var fileXml = new File(pathXmlFile);

        var signer = new Signer();

        try {
            var pathOutPutFile = fileXml.getParent() + File.separator +
                    getNameFileWithOutExtension(fileXml.getName()) +"-signed" + ".xml";

            signer.sign(pathDigitalCertificate,
                    password,
                    pathXmlFile,
                    pathOutPutFile);

            System.out.println("Document signed saved in " + pathOutPutFile);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getNameFileWithOutExtension(String fileName) {
        int indexOf = fileName.indexOf(".");
        if (indexOf == -1)
            return fileName;
        return fileName.substring(0, indexOf);
    }
}

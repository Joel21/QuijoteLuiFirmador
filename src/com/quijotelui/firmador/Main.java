package com.quijotelui.firmador;

import java.io.File;
import java.util.Scanner;
import java.io.Console;

/**
 *
 * @author jorgequiguango
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        System.out.println("QuijoteLui Firmador");
        XAdESBESSignature xadesBesFirma = new XAdESBESSignature();
        
        File archivo = new File("/app/Quijotelui/comprobante/generado/"
                + "2805201801100995697000120010990000000011234567816.xml");
        String urlOutArchivo = "/tmp";
        String PKCS12_RESOURCE = "/data/BCE";
        String PKCS12_PASSWORD;

        String nombreP12 = "certificado.p12";
        PKCS12_RESOURCE = PKCS12_RESOURCE + File.separatorChar + nombreP12;
        System.out.println("Archivo Firma P12: " + PKCS12_RESOURCE);
        
        PKCS12_PASSWORD = "clave_certificado";

        /*
        Para firmar con un certificado emitido por el BCE
         */
        xadesBesFirma.sign(archivo,
                urlOutArchivo,
                PKCS12_RESOURCE,
                PKCS12_PASSWORD,
                TokensAvailables.BCE_IKEY2032);

        /*
        Para firmar con un certificado emitido por Security Data
         */
        xadesBesFirma.sign(archivo,
                urlOutArchivo,
                PKCS12_RESOURCE,
                PKCS12_PASSWORD,
                TokensAvailables.SD_EPASS3000);

        /*
        Para firmar con un certificado emitido por el Consejo de la Judicatura
        */
        xadesBesFirma.sign(archivo,
                urlOutArchivo,
                PKCS12_RESOURCE,
                PKCS12_PASSWORD,
                TokensAvailables.KEY4_CONSEJO_JUDICATURA);

        /*
        Para firmar con un certificado emitido por Uanataca Ecuador S.A.
        */
        xadesBesFirma.sign(archivo,
                urlOutArchivo,
                PKCS12_RESOURCE,
                PKCS12_PASSWORD,
                TokensAvailables.TOKENME_UANATACA);

        /*
        Para firmar con un certificado emitido por Eclipsoft
        */
        xadesBesFirma.sign(archivo,
                urlOutArchivo,
                PKCS12_RESOURCE,
                PKCS12_PASSWORD,
                TokensAvailables.Eclipsoft);

        /*
        Para firmar con un certificado emitido por Datilmedia S.A.
        */
        xadesBesFirma.sign(archivo,
                urlOutArchivo,
                PKCS12_RESOURCE,
                PKCS12_PASSWORD,
                TokensAvailables.DATILMEDIA);

        /*
        Para firmar con un certificado emitido por ANFAC Autoridad de Certificación Ecuador C.A.
        */
        xadesBesFirma.sign(archivo,
                urlOutArchivo,
                PKCS12_RESOURCE,
                PKCS12_PASSWORD,
                TokensAvailables.ANF1);
    }
}

package dev.mestizos.signer.provider;

import dev.mestizos.signer.exception.InvalidCertificateException;
import xades4j.providers.impl.KeyStoreKeyingDataProvider;

import java.security.cert.X509Certificate;
import java.util.List;

public class CertificateLocalProvider implements KeyStoreKeyingDataProvider.SigningCertSelector {

    /**
     * This method is used for return the local certificate provider,
     * this method no validate the local provider
     */
    public X509Certificate selectCertificate(List<X509Certificate> availableCertificates) {
        if (availableCertificates != null)
            for (X509Certificate x509Certificate : availableCertificates) {
                if (x509Certificate.getKeyUsage()[0])
                    return x509Certificate;
            }
        throw new InvalidCertificateException("No existe un proveedor local del certificado");
    }
}

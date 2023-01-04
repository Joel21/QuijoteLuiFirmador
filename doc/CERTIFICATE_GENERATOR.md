# Generate and export certificates - Linux (strongSwan).

## Requirements
Ubuntu Operating System

## Attention is only for test.
For generate your own certificate, you have the following next steps.

## Install strongSwan.
```
sudo apt install strongswan
```
```
sudo apt install strongswan-pki
```
```
sudo apt install libstrongswan-extra-plugins
```

## Linux CLI instructions (strongSwan).
### Generate the CA certificate.
```
ipsec pki --gen --outform pem > caKey.pem
ipsec pki --self --in caKey.pem --dn "CN=Jorge Luis" --ca --outform pem > caCert.pem
```
### Print the CA certificate in base64 format.
```
openssl x509 -in caCert.pem -outform der | base64 -w0 ; echo
```
### Generate the user certificate.
```
export PASSWORD="No_Piratear"
export USER_CERTIFICATE="Hacker"

ipsec pki --gen --outform pem > "${USER_CERTIFICATE}Key.pem"
ipsec pki --pub --in "${USER_CERTIFICATE}Key.pem" | ipsec pki --issue --cacert caCert.pem --cakey caKey.pem --dn "CN=${USER_CERTIFICATE}" --san "${USER_CERTIFICATE}" --flag clientAuth --outform pem > "${USER_CERTIFICATE}Cert.pem"
```
### Generate a p12 bundle containing the user certificate.
```
openssl pkcs12 -in "${USER_CERTIFICATE}Cert.pem" -inkey "${USER_CERTIFICATE}Key.pem" -certfile caCert.pem -export -out "${USER_CERTIFICATE}.p12" -password "pass:${PASSWORD}"
```
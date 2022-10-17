# QuijoteLuiFirmador
Aplicación para firmar un archivo XML ( Comprobante Electrónico - SRI Ecuador)

Aplica para firmar facturas, comprobantes de retención, guías de remisión, notas
de crédito y notas de débito de Ecuador.


### Para compilar y generar el archivo QuijoteLuiFirmador-2.4.jar
```
ant

```
### Comando en terminal para subir al repositorio Maven Local (Linux\Mac)
```
mvn install:install-file -Dfile=./dist/QuijoteLuiFirmador-2.4.jar -DgroupId=com.quijotelui.firmador -DartifactId=QuijoteLuiFirmador -Dversion=2.4 -Dpackaging=jar
```
### Comando en terminal para subir al repositorio Maven Local (Windows)
```
cd .\dist\
mvn install:install-file "-Dfile=QuijoteLuiFirmador-2.4.jar" "-DgroupId=com.quijotelui.firmador" "-DartifactId=QuijoteLuiFirmador" "-Dversion=2.4" "-Dpackaging=jar"
```

#### Documentación
https://mestizos.dev/firmar-un-comprobante-electronico-segun-los-parametros-del-sri-en-ecuador/

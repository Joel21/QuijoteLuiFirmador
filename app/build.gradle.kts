plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.googlecode.xades4j:xades4j:1.7.0")
    testImplementation("junit:junit:4.13.2")
}

application {
    mainClass.set("dev.mestizos.signer.Main")

}

